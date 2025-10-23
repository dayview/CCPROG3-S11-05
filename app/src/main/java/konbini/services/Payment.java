package konbini.services;

/**
 * Handles payment-related computations in the Konbini system
 * Manages amounts due, payments received, change calculation, and method validation during transactions
 * Ensures correct rounding and validation of payment data for receipt and balance generation
 * @author Massi Colcol
 * @version 1.1
 */
public class Payment {
    private double amountDue;
    private double amountPaid;
    private PaymentMethod method;


    /**
     * Construct Payment instance with amount due, amount paid, and method
     * also makes sure that amount due and amount paid are not negative value and
     * amounts are round off to 2 decimal places4
     *
     * @param amountDue total amount that the customer must pay
     * @param amountPaid amount paid by the customer
     * @param method Payment method used
     */
    public Payment(double amountDue, double amountPaid, PaymentMethod method) {
        if (amountDue < 0) {
            amountDue = 0;
        }
        if (amountPaid < 0) {
            amountPaid = 0;
        }
        /* round 2 for rounding off decimals */
        this.amountDue = round2(amountDue);
        this.amountPaid = round2(amountPaid);
        this.method = (method == null) ? new PaymentMethod(PaymentMethod.CASH) : method;
    }


    /**
     * Gets the amount due for transaction
     * @return amount due
     */
    public double getAmountDue() {
        return amountDue;
    }

    /**
     * Get the amount paid by the customer 
     * @return amount paid
     */
    public double getAmountPaid() {
        return amountPaid;
    }
    
    /**
     * Get payment method used
     * @return payment method
     */

    public PaymentMethod getMethod() {
        return method;
    }

    /**
     *  updates amount paid, and rounds off 2 decimal places 
     *  @param amountpaid new payment amount
     */
    public void setAmountPaid(double amountPaid) {
        if (amountPaid < 0) {
            amountPaid = 0;
        }
        this.amountPaid = round2(amountPaid);
    }

    /**
     *  updates payment method if provided and is valid
     *  @param method payment method was set
     */
    public void setMethod(PaymentMethod method) {
        if (method != null) {
            this.method = method;
        }
    }

    /**
     *  Calculate for the change if customer did not give exact amount 
     *  if paid amount is less than due amount, change set to zero
     *  @return computed change amount
     */
    public double calculateChange() {
        double change = amountPaid - amountDue;
        if (change < 0) {
            change = 0;
        }
        return round2(change);
    }

    /**
     *  Validate if payment is sufficient 
     *    @return true if payment covers or exceeds the amountDue, false otherwise
     */

    public boolean validatePayment() {
        return amountPaid + 1e-9 >= amountDue;
    }

    /**
     * Rounds a value to 2 decimal places
     * @param v value to round
     * @return rounded value 
     */
    private static double round2(double v) {
        return Math.round(v * 100.0) / 100.0;
    }

}
