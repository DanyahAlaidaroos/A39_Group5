/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Recipe {
    
    // -----------------------------{Data Fields}--------------------------------
    private String Recipe_Name;
    private int RecipeNO;
    private String ingredients;
    private String Cook_Time;
    private int number_of_people_to_Serve;
    private String Type;
    private String Health_Info;
    private double Price;

//-----------------------------{Constructor}---------------------------------
    public Recipe(String Recipe_Name, int RecipeNO, String ingredients, String Cook_Time, int number_of_people_to_Serve, String Type, String Health_Info, double Price) {
        this.Recipe_Name = Recipe_Name;
        this.RecipeNO = RecipeNO;
        this.ingredients = ingredients;
        this.Cook_Time = Cook_Time;
        this.number_of_people_to_Serve = number_of_people_to_Serve;
        this.Type = Type;
        this.Health_Info = Health_Info;
        this.Price = Price;
    }
    
//----------------------------{Getter and Setter}-------------------------------
    public String getRecipe_Name() {
        return Recipe_Name;
    }

    public void setRecipe_Name(String Recipe_Name) {
        this.Recipe_Name = Recipe_Name;
    }
//**************************************************************************
    public int getRecipeNO() {
        return RecipeNO;
    }

    public void setRecipeNO(int RecipeNO) {
        this.RecipeNO = RecipeNO;
    }
//**************************************************************************
    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
//**************************************************************************
    public String getCook_Time() {
        return Cook_Time;
    }

    public void setCook_Time(String Cook_Time) {
        this.Cook_Time = Cook_Time;
    }
//**************************************************************************
    public int getNumber_of_people_to_Serve() {
        return number_of_people_to_Serve;
    }

    public void setNumber_of_people_to_Serve(int number_of_people_to_Serve) {
        this.number_of_people_to_Serve = number_of_people_to_Serve;
    }
//**************************************************************************
    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
//**************************************************************************
    public String getHealth_Info() {
        return Health_Info;
    }

    public void setHealth_Info(String Health_Info) {
        this.Health_Info = Health_Info;
    }
//**************************************************************************
    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
//**************************************************************************
    @Override
    public String toString() {
        return Recipe_Name + ", cooking time: " + Cook_Time + " Minutes "+", number of people to serve: " + number_of_people_to_Serve + ", price:" + Price+"SAR";
    }
}

