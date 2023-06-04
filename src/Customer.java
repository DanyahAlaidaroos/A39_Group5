import java.util.*;

public class Customer extends Person {
// -----------------------------{Data Fields}--------------------------------

    private String healthStatus;
    private String address;
    protected List<Order> allOrders;

//-----------------------------{Constructor}---------------------------------
    public Customer(String name, long phoneNo, String Email, int age, String gender, String address, String username, String password) {
        super(name, phoneNo, Email, age, gender, username, password);
        this.address = address;
    }

//---------------------------{Getter and Setter}--------------------------------
    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }
//**************************************************************************

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
//**************************************************************************

    public List<Order> getAllOrders(int index) {
        return (List<Order>) allOrders.get(index);
    }

    public void setAllOrders(Order newOrder) {
        this.allOrders.add(newOrder);
    }
//**************************************************************************
//---------------------------------{Methods}------------------------------------

    public Recipe Add_Recipes_To_Order(Order order, ArrayList<Recipe> Menu, String wantedRecipe) {
        for (Recipe recipe : Menu) {
            if (recipe.getRecipe_Name().equalsIgnoreCase(wantedRecipe)) {
                return recipe;
            } else {
                return null;
            }
        }
        return null;
    }
//**************************************************************************

    public Order Place_Order(Order newOrder, Customer customer) {
        long orderNo = System.currentTimeMillis();
        Date Orderdate = new Date();
        String state = "Ongoing";
        newOrder = new Order(orderNo, Orderdate, state, customer);
        return newOrder;
    }

//**************************************************************************
    public Payment Pay_For_Order(String payMethod, Order order, String numOfCard, Payment pay) {
        long Bill_num = System.currentTimeMillis();
        pay = new Payment(Bill_num, payMethod, numOfCard, order);
        return pay;
    }

}