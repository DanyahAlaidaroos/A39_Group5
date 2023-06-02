
import java.util.Scanner;

public class Person {
// -----------------------------{Data Fields}--------------------------------
    private String name;
    private long phoneNo;
    private String Email;
    private int age;
    private String gender;
    private String username;
    private String password;
    
//-----------------------------{Constructor}---------------------------------
    public Person(String name, long phoneNo, String Email, int age, String gender, String username, String password) {
        this.name = name;
        this.Email = Email;
        this.phoneNo = phoneNo;
        this.age = age;
        this.gender = gender;
        this.username = username;
        this.password = password;
    }
//----------------------------{Getter and Setter}-------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//**************************************************************************
    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
//**************************************************************************
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
//**************************************************************************
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
//**************************************************************************
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
//**************************************************************************
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
//**************************************************************************
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
//**************************************************************************
//---------------------------------{Methods}------------------------------------
    public void editAccount(Scanner input) {
        System.out.println("Edit your Account information/n");
        System.out.println("1- Edit Name......................");
        System.out.println("2- Edit Phone number..............");
        System.out.println("3- Edit Age.......................");
        System.out.println("4- Edit password..................");
        System.out.println("5- Edit Username..................");
        System.out.println("6- Edit Email.....................");
        System.out.println("7- Exit");
        System.out.println("/nEnter the number of the option you want to change:");
        System.out.println("Enter: ");
        int n = input.nextInt();     
        switch(n){
            case 1 : System.out.println("Edit Name: ");
            setName(input.next());
            break;
            case 2: System.out.println("Edit Phone number: ");
            setPhoneNo(input.nextLong());
            break;
            case 3: System.out.println("Edit Age: ");
            setAge(input.nextInt());
            break;
            case 4: System.out.println("Edit Password: ");
            setPassword(input.next());
            break;
            case 5: System.out.println("Edit Username: ");
            setUsername(input.next());
            break;
            case 6: System.out.println("Edit Email: ");
            setEmail(input.next());
            break;
            case 7: break;
    }
        System.out.println("Account details updated successfully!");
    }
//**************************************************************************
    public void login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password!");
        }
    }
//**************************************************************************
    public void logout() {
        System.out.println("Logged out successfully!");
    }
}