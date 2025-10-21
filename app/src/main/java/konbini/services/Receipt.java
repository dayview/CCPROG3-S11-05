import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;

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

    public String toDevice() {
        DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String text = "";

        text += "==== Convenience Store Receipt ===\n";
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
        FileWriter fw = new FileWriter(path);
        fw.write(toDevice());
        fw.close();
    }
}