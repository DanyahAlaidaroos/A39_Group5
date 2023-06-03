import java.util.*;

public class Order {
// ------------------------------{Data Fields}----------------------------------
    private long OrderNo;
    private Date Orderdate;
    private String OrderState;
    private Customer customer;
    private double total;
    private ArrayList<Recipe> Recipes;

//-----------------------------{Constructor}---------------------------------
    public Order(){
        
    }
    
    public Order(long OrderNo, Date Orderdate, String OrderState, Customer customer) {
        this.Recipes = new ArrayList();
        this.OrderNo = OrderNo;
        this.Orderdate = Orderdate;
        this.OrderState = OrderState;
        this.customer = customer;
    }
   
//----------------------------{Getter and Setter}-------------------------------
    public long getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(long OrderNo) {
        this.OrderNo = OrderNo;
    }
//**************************************************************************
    public Date getOrderdate() {
        return Orderdate;
    }

    public void setOrderdate(Date Orderdate) {
        this.Orderdate = Orderdate;
    }
//**************************************************************************
    public String getOrderState() {
        return OrderState;
    }

    public void setOrderState(String OrderState) {
        this.OrderState = OrderState;
    }
//**************************************************************************
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
//**************************************************************************
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
//**************************************************************************
    public Recipe getRecipes(int index) {
        return Recipes.get(index);
    }

    public void setRecipes(Recipe newRecipe) {
        this.Recipes.add(newRecipe);
    }
//**************************************************************************
//---------------------------------{Methods}------------------------------------
    public int Order_contents() {
        return Recipes.size();
    }
//**************************************************************************
    public void CalculateCost() {
        total = 0;
        for (int i = 0; i < Recipes.size(); i++) {
            total += Recipes.get(i).getPrice();
        }
        setTotal(total);
    }   
    
}
