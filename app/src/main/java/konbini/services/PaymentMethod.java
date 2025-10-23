package konbini.services;

/**
 * Represents a payment method used in the Konbini system
 * Supports cash, card, and mobile transactions and stores reference details such as transaction numbers
 * Provides validation for payment mode input and ensures standardized names for consistency across the system
 * @author Massi Colcol
 * @version 1.0
 */
public class PaymentMethod {
    public static final String CASH = "CASH";
    public static final String CARD = "CARD";
    public static final String MOBILE = "MOBILE";

    private String modeOfPayment = CASH; /* Default */
    private String details = "";

    public PaymentMethod(String modeOfPayment) {
        setModeName(modeOfPayment);
    }

    public PaymentMethod(String modeOfPayment, String details) {
        setModeName(modeOfPayment);
        this.details = details == null ? "" : details;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public String getDetail() {
        return details;
    }

    public void setDetails(String detail) { /* DETAILS SUCH AS REFERENCE NUMBER */
        this.details = detail == null ? "" : detail;
    }

    public void setModeName(String name) {
        if (name == null)
            return;
        String u = name.trim().toUpperCase();
        if (u.equals(CASH) || u.equals(CARD) || u.equals(MOBILE)) {
            modeOfPayment = u;
        } else {
            System.out.println("Invalid payment mode: " + name + " (using " + modeOfPayment + ")");
        }
    }
}