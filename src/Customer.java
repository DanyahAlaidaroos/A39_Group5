
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
    public void Add_Recipes_To_Order(Order order, ArrayList<Recipe> Menu, Scanner input) {
        String enter = null;
        do {
            System.out.println("Enter the name of the Recipe you want to order from the Menu: ");
            String wantedRecipe = input.next();
            for (Recipe recipe : Menu) {
                if (recipe.getRecipe_Name().equalsIgnoreCase(wantedRecipe)) {
                    System.out.println(recipe.toString());
                   order.setRecipes(recipe);
                } else {
                    System.out.println("Sorry, There is no Recipe with this name in the menu. ");
                }
            }
            System.out.println("If you don not want to add another Recipe to your order enter Pay, or If you want to add another Recipe enter Add: ");
            enter = input.next();
        } while (!enter.equalsIgnoreCase("Pay"));

    }
//**************************************************************************
    public Order Place_Order(Scanner input, Order newOrder, Customer customer) {
        long orderNo = System.currentTimeMillis();
        Date Orderdate = new Date();
        String state = "Ongoing";
        newOrder = new Order(orderNo, Orderdate, state, customer);
        return newOrder;
    }

//**************************************************************************
    public Payment Pay_For_Order(Payment pay, Scanner input, Order order) {
        long Bill_num = System.currentTimeMillis();
        System.out.println("Choose How you want to pay: ");
        System.out.println("1- Cach");
        System.out.println("2- online");
        int p = input.nextInt();
        String payment_method = null;
        String numOfCards = null;
        if (p == 1) {
            System.out.println("Pay when you recive the Order. ");
            payment_method = "Cach";
            numOfCards = null;
        } else if (p == 2) {
            System.out.println("Enter your Card number: ");
            numOfCards = input.next();
            payment_method = "online";
        }
        System.out.println("do you have a discount code (yes/no) ");
        String Enter = input.next();
        if (Enter.equalsIgnoreCase("yes")) {
            System.out.println("Enter discount percentage: ");
            double disPercentage = input.nextDouble();
            double discountPrice = pay.add_discount(order.getTotal(), disPercentage);
            order.setTotal(discountPrice);
            System.out.println("--------------------Payment has been confirmed--------------------");
        } else {
            System.out.println("--------------------Payment has been confirmed--------------------");
        }

        pay = new Payment(Bill_num, payment_method, numOfCards, order);
        return pay;
    }

}