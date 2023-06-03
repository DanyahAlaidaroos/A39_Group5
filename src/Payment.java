
public class Payment {
// -----------------------------{Data Fields}--------------------------------
    private long bill_number;
    private String payment_method;
    private String card_number;
    private Order order_info;

//-----------------------------{Constructor}---------------------------------
    public Payment(long bill_number, String payment_method, String card_number, Order order_info) {
        this.bill_number = bill_number;
        this.payment_method = payment_method;
        this.card_number = card_number;
        this.order_info = order_info;
    }

//----------------------------{Getter and Setter}-------------------------------
    public long getBill_number() {
        return bill_number;
    }

    public void setBill_number(long bill_number) {
        this.bill_number = bill_number;
    }
//**************************************************************************
    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }
//**************************************************************************
    public String getCard_number() {
        return card_number;
    }

    public void setCard_info(String card_number) {
        this.card_number = card_number;
    }
//**************************************************************************
    public Order getOrder_info() {
        return order_info;
    }

    public void setOrder_info(Order order_info) {
        this.order_info = order_info;
    }
//**************************************************************************
//---------------------------------{Methods}------------------------------------
    public double add_discount(double price, double discountCoupon) {
        double disPrice = 0;
        if (discountCoupon == 15) {
            disPrice = price - (0.15 * price);
            System.out.println("Discounted price is -" + (0.15 * price));
        } else if (discountCoupon == 25) {
            disPrice = price - (0.25 * price);
            System.out.println("Discounted price is -" + (0.25 * price));
        } else if (discountCoupon == 10) {
            disPrice = price - (0.10 * price);
            System.out.println("Discounted price is -" + (0.10 * price));
        } else {
            System.out.println("Invalide Code");
        }
        return disPrice;
    }
//**************************************************************************
    public void cancel_payment() {
        System.out.println("--------------------Payment is cancelled. Thank you for using Home Chef System!--------------------");
    }
//**************************************************************************
    public void delete_bill() {
        setBill_number(0);
        System.out.println("--------------------Bill has been deleted--------------------");
    }
//**************************************************************************
    public String payment_details(Customer customer, Order order, Payment pay) {
        order.CalculateCost();
       return ("--------------------Thank you for shopping from Home Chef System!--------------------\n"+
        "--------------------           PRINTING RECEIPT DETAILS          --------------------\n"+
        "--------------------           Customer's Information            --------------------\n"+
        "Customer's Name: " + customer.getName()+"\n"+
        "Customer's phone number: " + customer.getPhoneNo()+"\n"+
        "Address: " + customer.getAddress()+"\n"+
        "--------------------               Order Details                 --------------------\n"+
        "Order number: " + order.getOrderNo()+"\n"+
        "Order Date: " + order.getOrderdate()+"\n"+
        "Total Price: " + order.getTotal() +"SAR\n"+
        "Payment Method: " + pay.getPayment_method()+"\n"+
        "Bill number: " + pay.getBill_number()+"\n"+
        "--------------------                 Bon Appetit!                --------------------");
    }
}
