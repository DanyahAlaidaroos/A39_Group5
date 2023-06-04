/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Chef extends Employee{
    // -----------------------------{Data Fields}--------------------------------

    private Recipe recipe;

//-----------------------------{Constructor}---------------------------------
    public Chef(int employeeID, double salary, String name, long phoneNo, String Email, int age, String gender, String username, String password) {
        super(employeeID, salary, name, phoneNo, Email, age, gender, username, password);
    }

//---------------------------{Getter and Setter}--------------------------------
    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
//**************************************************************************
//---------------------------------{Methods}------------------------------------    

    public Recipe Add_recipe(Recipe newRecipe, String Recipe_Name, int RecipeNO, String ingredients, String Cook_Time, int number_of_people_to_Serve, String Type, String Health_Info, double Price) {
        newRecipe = new Recipe(Recipe_Name, RecipeNO, ingredients, Cook_Time, number_of_people_to_Serve, Type, Health_Info, Price);
        return newRecipe;
    }
}


