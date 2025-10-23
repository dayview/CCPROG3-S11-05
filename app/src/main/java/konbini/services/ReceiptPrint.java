package konbini.services;

/**
 * Responsible for outputting and saving receipts in the Konbini system
 * Provides utilities to print receipts on-screen or save them to a file for recordkeeping
 * Serves as an interface between receipt data and physical or digital output devices in the application workflow
 * @author Massi Colcol
 * @version 1.0
 */
public class ReceiptPrint {
    public void printOnDevice(Receipt r) {
        if (r == null) {
            System.out.println("No Receipt to print.");
            return;
        }
        System.out.print(r.toDevice());
    }

    public void writeOnDevice(Receipt r, String path) {
        if (r == null) {
            System.out.println("No Receipt to save.");
            return;
        }
        try {
            r.saveFile(path);
            System.out.println("Receipt saved to: " + path);
        } catch (Exception e) {
            System.out.println("Failed to write receipt: " + e.getMessage());
        }

    }
}
