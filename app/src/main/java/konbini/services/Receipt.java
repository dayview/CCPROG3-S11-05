package konbini.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Represents a payment receipt generated after a completed transaction
 * Compiles purchase details, totals, discounts, and timestamp into a formatted text output for printing or saving
 * Handles receipt rendering for both console view and file persistence within the Konbini system's services layer
 * @author Massi Colcol
 * @version 1.0
 */
public class Receipt {
    private String receiptID;
    private Transaction transaction;

    public Receipt(String receiptID, Transaction transaction) {
        if (receiptID == null || receiptID.isEmpty()) {
            receiptID = "Receipt not Available";
        }
        this.receiptID = receiptID;
        this.transaction = transaction;
    }

    public String getReceiptID() {
        return receiptID;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    /*
     * will only print a receipt if a transaction exist and
     * amount due <= 0 or payment exist and amountPaid >= amountDue
     */
    public boolean canGenerateReceipt(){
        if(transaction == null){
            return false;
        }
        double amountDue = transaction.getAmountDue();

        if(Double.compare(amountDue, 0.0) <= 0){
            return true;
        }

        if(transaction.getPayment() == null){
            return false;
        }

        double amountPaid = transaction.getPayment().getAmountPaid();
        return Double.compare(amountPaid, amountDue) >= 0;
    }

    public String toDevice() {
        if(!canGenerateReceipt()){
            return "";
        }

        DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String text = "";

        text += "==== Konbini's Convenience Store Receipt ===\n";
        text += " Receipt ID : " + receiptID + "\n";
        text += "Date/Time : " + transaction.getTimestamp().format(d) + "\n";

        if (transaction.getCart() != null) {
            text += transaction.getCart().toString() + "\n";
        }
        text += String.format("Subtotal : %.2f%n", transaction.getSubTotal());
        if (transaction.getSeniorDiscountApplied() > 0) {
            text += String.format("Senior Discount(20%%): -%.2f%n", transaction.getSeniorDiscountApplied());
        }
        if (transaction.getPointsRedeemed() > 0) {
            text += String.format("Points Redeemed : -%.2f (%d points)%n", transaction.getPointsRedeemed(),
                    (int) Math.round(transaction.getPointsRedeemed()));
        }
        text += String.format("VAT 12%% : %.2f%n", transaction.getTaxAmount());
        text += "------------------------------\n";
        text += String.format("TOTAL DUE : %.2f%n", transaction.getAmountDue());

        if (transaction.getPayment() != null) {
            text += String.format("PAID   : %.2f (%s) %n", transaction.getPayment().getAmountPaid(),
                    transaction.getPayment().getMethod().getModeOfPayment());
            text += String.format("CHANGE : %.2f%n", transaction.getPayment().calculateChange());
        } else {
            text += "PAID   : 0.00 (N/A)\n";
            text += "CHANGE : 0.00\n";
        }

        if (transaction.getCustomer() != null) {
            text += "------------------------------\n";
            text += "Member  : " + (transaction.getCustomer().isMember() ? "Yes" : "No") + "\n";
            text += "Earned Points : " + transaction.getEarnedPoints() + "\n";
        }

        text += "Thank you for Shopping! \n";
        text += "=============================\n";
        return text;
    }

    public void saveFile(String path) throws IOException {
        if (!canGenerateReceipt()) return;

        String output = toDevice();
        if (output.isEmpty()) return;

        Path p = Paths.get(path);
        Path parent = p.getParent();
        if (parent != null && !Files.exists(parent)) {
            Files.createDirectories(parent);
        }

        try (var writer = Files.newBufferedWriter(p, StandardCharsets.UTF_8)) {
            writer.write(output);
        }
    }
}