import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class MealPlanner 
{

    private Random rand;
    private ArrayList<String> meals, beefMeals, chickenMeals, porkMeals, meatlessMeals;


    public MealPlanner()
    {
        meals = new ArrayList<>();
        beefMeals = new ArrayList<>();
        chickenMeals = new ArrayList<>();
        porkMeals = new ArrayList<>();
        meatlessMeals = new ArrayList<>();
        rand = new Random();
        createMeals();

    }

    public ArrayList<String> getMeal(int numBeef, int numChicken, int numPork, int numMeatless)
    {   

        createMealList(numBeef, numChicken, numPork, numMeatless);
        Collections.shuffle(meals);
        return meals;
    }

    public int getBeefMealSize()
    {
        return beefMeals.size();
    }

    public int getChickenMealSize()
    {
        return chickenMeals.size();
    }

    public int getPorkMealSize()
    {
        return porkMeals.size();
    }

    public int getMeatlessMealSize()
    {
        return meatlessMeals.size();
    }

    public void reset()
    {
        beefMeals.clear();
        chickenMeals.clear();
        porkMeals.clear();
        meatlessMeals.clear();
        meals.clear();
        createMeals();
    }

    private void createMeals()
    {
        Collections.addAll(beefMeals, "burgers", "tacos", "chili",  
                           "beef pasta",  "korean beef");

        Collections.addAll(chickenMeals, "chicken pasta", "korean chicken", "whole chicken", 
                           "baked chicken thighs", "wings");

        Collections.addAll(porkMeals, "sausages", "pork tacos", "korean pork", "pork chili");

        Collections.addAll(meatlessMeals, "pizza", "mac&cheese", "garlic&parm pasta", "fish");
    }

    private void createMealList(int numBeef, int numChicken, int numPork, int numMeatless)
    {
        for(int i = 0; i < numBeef; i++){
            int randomNum = rand.nextInt(beefMeals.size());
            String meal = beefMeals.get(randomNum);
            beefMeals.remove(randomNum);
            meals.add(meal);
        }

        for(int i = 0; i < numChicken; i++){
            int randomNum = rand.nextInt(chickenMeals.size());
            String meal = chickenMeals.get(randomNum);
            chickenMeals.remove(randomNum);
            meals.add(meal);
        }

        for(int i = 0; i < numPork; i++){
            int randomNum = rand.nextInt(porkMeals.size());
            String meal = porkMeals.get(randomNum);
            porkMeals.remove(randomNum);
            meals.add(meal);
        }

        for(int i = 0; i < numMeatless; i++){
            int randomNum = rand.nextInt(meatlessMeals.size());
            String meal = meatlessMeals.get(randomNum);
            meatlessMeals.remove(randomNum);
            meals.add(meal);
        }
    }
    
}
