public class Employee extends Person {
// -----------------------------{Data Fields}--------------------------------
    private int employeeID;
    private double salary;

//-----------------------------{Constructor}---------------------------------
    public Employee(int employeeID, double salary, String name, long phoneNo, String Email, int age, String gender, String username, String password) {
        super(name, phoneNo, Email, age, gender, username, password);
        this.employeeID = employeeID;
        this.salary = salary;
    }

//----------------------------{Getter and Setter}-------------------------------
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
//**************************************************************************
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}