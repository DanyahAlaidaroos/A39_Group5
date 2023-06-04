
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danya
 */
public class main {

     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Declear All the system objects 
        Chef chef = null;
        Customer customer = null;
        Order neworder = null;
        Recipe newrecipe = null;
        Payment newpay = null;

        //Array of Recipe for the Menu
        ArrayList<Recipe> Menu = new ArrayList();

        System.out.println("-------------------- Welcome To Home Chef System Application--------------------\n");

//-------------------------------{CHEF PART}------------------------------------
        System.out.println("to create chef account enter the following information: ");
        chef = Creat_Chef_ACC(input, chef);
        
//**************************************************************************{Add Recipe}
        String choose;
        do {
            System.out.println("\nAdd new Recipe to the menu: \n");
            System.out.println("Enter Recipe Name");
            String Recipe_Name = input.next();
            int RecipeNO = 10000 + (int) (Math.random() * 99999);
            System.out.println("Enter ingredients");
            String ingredients = input.next();
            System.out.println("Enter Cook Time");
            String Cook_Time = input.next();
            System.out.println("Enter number of people to Serve");
            int number_of_people_to_Serve = input.nextInt();
            System.out.println("Enter Type");
            String Type = input.next();
            System.out.println("Enter Health Info");
            String Health_Info = input.next();
            System.out.println("Enter Price");
            double Price = input.nextDouble();
            newrecipe = chef.Add_recipe(newrecipe, Recipe_Name, RecipeNO, ingredients, Cook_Time, number_of_people_to_Serve, Type, Health_Info, Price);
            Menu.add(newrecipe);
            System.out.println("if you want to add more recipes then enter continue else enter exit");
            choose = input.next();
        } while (choose.equalsIgnoreCase("continue"));

//-----------------------------{CUSTOMER PART}----------------------------------
        System.out.println("to create customer account enter the following information: ");
        customer = Create_customer_ACC(input, customer);
        
//**************************************************************************{View Menu}        
        //Menu should display the recipes that match the Customer's health status
        System.out.print("Enter the health condition th search for suitable recipes: ");
        String health_info = input.next();
        String m = null;
        do {
            System.out.println("**************************MENU**************************");
           System.out.println(view_menu(health_info, Menu));
            System.out.println("if you want to see the menu again more then enter Menu else enter exit");
            m = input.next();
        } while (!m.equalsIgnoreCase("exit"));
        
//**************************************************************************{Place order}        
        System.out.println("If you want to Make an Order enter Order If not enter exit: ");
        String Make = input.next();
        if (Make.equalsIgnoreCase("Order")) {
            neworder = customer.Place_Order(neworder, customer);
            String po = null;
            do {
                System.out.println("Enter the name of the Recipe you want to order from the Menu: ");
                String recipeName = input.next();
                Recipe wantrecipe = customer.Add_Recipes_To_Order(neworder, Menu, recipeName);
                if (wantrecipe == null) {
                    System.out.println("Sorry, there is no Recipe in the menu match this name. ");
                } else {
                    neworder.setRecipes(wantrecipe);
                }
               
                System.out.println("If you don not want to add another Recipe to your order enter Pay, or If you want to add another Recipe enter Add: ");
                po = input.next();
            } while (!po.equalsIgnoreCase("Pay"));
        } else if (Make.equalsIgnoreCase("exit")) {
           System.out.println(view_menu(health_info, Menu));
        }
        System.out.println("Would you like to confirm your order and pay? (yes/no)");
        String confirmation = input.next();
        if (confirmation.equalsIgnoreCase("yes")) {
            System.out.println("Choose How you want to pay: ");
            System.out.println("1- Cach");
            System.out.println("2- online");
            String pm = input.next();
            String numOfCards = null;
            if (pm.equalsIgnoreCase("Cach")) {
                System.out.println("Pay when you recive the Order. ");
                numOfCards = null;
            } else if (pm.equalsIgnoreCase("online")) {
                System.out.println("Enter your Card number: ");
                numOfCards = input.next();
            }
            newpay = customer.Pay_For_Order(pm, neworder, numOfCards, newpay);
            System.out.println("Do you have a discount code? ");
            String di = input.next();
            if (di.equalsIgnoreCase("yes")) {
                System.out.println("Enter discount percentage: ");
                double disPercentage = input.nextDouble();
                neworder.CalculateCost();
                double discountPrice = newpay.add_discount(neworder.getTotal(), disPercentage);
                neworder.setTotal(discountPrice);
                System.out.println("--------------------Payment has been confirmed--------------------");
            } else {
                System.out.println("--------------------Payment has been confirmed--------------------");
            }
            System.out.println(newpay.payment_details(customer, neworder, newpay));
        } else {
            newpay.cancel_payment();
        }
    }
//-------------------------------{Methods}--------------------------------------
    
    //******************************{Add Chef}**********************************
    public static Chef Creat_Chef_ACC(Scanner input, Chef chef) {
        int employeeID = 10000 + (int) (Math.random() * 99999);
        double salary = 1000;
        System.out.println("Enter name");
        String name = input.next();
        System.out.println("Enter phoneNo");
        long phoneNo = input.nextLong();
        System.out.println("Enter Email");
        String Email = input.next();
        System.out.println("Enter age");
        int age = input.nextInt();
        System.out.println("Enter gender");
        String gender = input.next();
        System.out.println("Enter username");
        String username = input.next();
        System.out.println("Enter password");
        String password = input.next();

        chef = new Chef(employeeID, salary, name, phoneNo, Email, age, gender, username, password);
        return chef;
    }

    //****************************{Add Customer}********************************
    public static Customer Create_customer_ACC(Scanner input, Customer customer) {
        System.out.println("Enter Name: ");
        String name = input.next();
        System.out.println("Enter Phone number");
        long PhoneNum = input.nextLong();
        System.out.println("Enter Email: ");
        String email = input.next();
        System.out.println("Enter Age: ");
        int age = input.nextInt();
        System.out.println("Enter Gender: ");
        String gender = input.next();
        System.out.println("Enter Address: ");
        String Address = input.next();
        System.out.println("Enter Username: ");
        String username = input.next();
        System.out.println("Enter Password: ");
        String password = input.next();

        customer = new Customer(name, PhoneNum, email, age, gender, Address, username, password);
        return customer;
    }

    //****************************{view the Menu}*******************************
    public static String view_menu(String healthstatus,  ArrayList<Recipe>Menu) {
        
        for (Recipe recipe :  Menu) {
            if (recipe.getHealth_Info().equalsIgnoreCase(healthstatus)) {
                return recipe.toString();
            } else {
                return "Sorry, There is no recipes match your health condition";
            }
        }return "Enjoy";
}}
        
        
        


