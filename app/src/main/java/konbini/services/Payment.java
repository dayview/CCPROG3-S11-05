public class Payment {
    private double amountDue;
    private double amountPaid;
    private PaymentMethod method;

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

    public double getAmountDue() {
        return amountDue;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setAmountPaid(double amountPaid) {
        if (amountPaid < 0) {
            amountPaid = 0;
        }
        this.amountPaid = round2(amountPaid);
    }

    public void setMethod(PaymentMethod method) {
        if (method != null) {
            this.method = method;
        }
    }

    public double calculateChange() {
        double change = amountPaid - amountDue;
        if (change < 0) {
            change = 0;
        }
        return round2(change);
    }

    public boolean validatePayment() {
        return amountPaid + 1e-9 >= amountDue;
    }

    private static double round2(double v) {
        return Math.round(v * 100.0) / 100.0;
    }

}
