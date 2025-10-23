package konbini.services;

/**
 * Responsible for outputting and saving receipts in the Konbini system
 * Provides utilities to print receipts on-screen or save them to a file for recordkeeping
 * Serves as an interface between receipt data and physical or digital output devices in the application workflow
 * @author Massi Colcol
 * @version 1.1
 */
public class ReceiptPrint {
    /**
     * Prints the given receipt to the system output device.
     * Displays the receipt contents
     * If the receipt is null, a message is printed instead.
     *
     * @param r the Receipt object to be printed on the device
     */
    
    public void printOnDevice(Receipt r) {
        if (r == null) {
            System.out.println("No Receipt to print.");
            return;
        }
        System.out.print(r.toDevice());
    }
    /**
     * Saves the receipt to specified file path.
     * Calls saveFile from the receipt class and the output if pass or fail message
     * If the receipt is null, a message is printed instead.
     *
     * @param r the Receipt object to be saved
     * @param path file path where the receipt is gonna be written
     */
    
    
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

