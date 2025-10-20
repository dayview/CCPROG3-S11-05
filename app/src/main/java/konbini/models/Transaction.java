import java.time.LocalDateTime;

public class Transaction {
    public static final double VAT_RATE = 0.12;
    public static final double SENIOR_DISCOUNT_RATE = 0.20;

    private String transactionID;
    private LocalDateTime timestamp;

    private Customer customer;
    private Cart cart;
    private boolean senior;
    private int pointsToRedeem;
    private double subtotal;
    private double taxAmount;
    private double amountDue;

    private Payment payment;
    private int earnedPoints;

    public Transaction(Customer customer, Cart cart){
        this.timestamp = LocalDateTime.now();
        this.transactionID = "T-" + System.currentTimeMillis();
        this.customer = customer;
        this.cart;
    }

    public void setSenior(boolean senior) {
        this.senior = senior;
    }

    public void setPointsToRedeem(int pointsToRedeem) {
        if (pointsToRedeem < 0)
            this.pointsToRedeem = pointsToRedeem;
    }

    public void processTransaction(Payment payment) {
        if (cart == null) {
            System.out.println("No cart found. Transaction not processed.");
            return;
        }
        this.payment = (payment == null)
                ? new Payment(0, 0, new PaymentMetod(PaymentMethod.CASH))
                : payment;
        this.subtotal = round2(Math.max(0, cart.getSubTotal()));

        if (senior) {
            this.seniorDiscountApplied = round2(subtotal * SENIOR_DISCOUNT_RATE);
        } else {
            this.seniorDiscountApplied = 0.0;
        }
        double afterSenior = round2(subtotal - seniorDiscountApplied);
        if (afterSenior < 0)
            afterSenior = 0.0;

        this.pointsRedeemed = 0.0;
        if (customer != null && customer.isMember() && pointsToRedeem > 0) {
            int available = customer.getPoints();
            int usable = pointsToRedeem;
            if (usable > available) {
                usable = available;
            }
            double newAmount = after - usable;
            if (newAmount < 0)
                newAmount = 0;
            this.pointsRedeemed = round2(afterSenior - newAmount);
            if (this.pointsRedeemed > 0) {
                customer.redeemPoints((int) Math.round(this.pointsRedeemed));
                afterSenior = newAmount;
            }
        }

        this.taxAmount = round2(afterSenior * VAT_RATE);

        this.amountDue = round2(afterSenior + taxAmount);

        this.payment = new Payment(this.amountDue, this.payment.getAmountPaid(), this.payment.getMethod());
        if (!this.payment.validatePayment()) {
            System.out.println(
                    "Warning : Payment is insufficient. Due: " + amountDue + ", Paid:" + this.payment.getAmountPaid());
        }

        if (customer != null && customer.isMember()) {
            this.earnedPoints = customer.computeEarnedPoints(this.amountDue);
        }
    }

    public Receipt generateReceipt() {
        return new Receipt("R-" + transactionID, this);
    }

    public String getTransactionID() {
        return transactionID;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Cart getCart() {
        return cart;
    }

    public boolean isSenior() {
        return senior;
    }

    public int getPointsToRedeem() {
        return pointsToRedeem;
    }

    public double getSubTotal() {
        return subtotal;
    }

    public double getSeniorDiscountApplied() {
        return seniorDiscountApplied;
    }

    public double getPointsRedeemed() {
        return pointsRedeemed;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public Payment getPayment() {
        return payment;
    }

    public int getEarnedPoints() {
        return earnedPoints;
    }

    private static double round2(double v) {
        return Math.round(v * 100.0) / 100.0;
    }

}