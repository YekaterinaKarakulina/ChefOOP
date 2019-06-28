package epam;

import epam.Exceptions.*;
import epam.InterfaceWithImplimentations.Salad;
import epam.ProductsHierarchy.FreshVegetables;
import epam.ProductsHierarchy.ImportedVegetables;
import epam.ProductsHierarchy.LocalVegetables;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;

public class Main {
    public static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        FreshVegetables cauliflower = new FreshVegetables("cauliflower", 29, 2.5, 0, 4.9, "white", "middleSaturated", "flavorless");
        FreshVegetables radish = new FreshVegetables("radish", 20, 1.2, 0, 4.1, "pink", "middleSaturated", "gaudy");
        FreshVegetables onion = new FreshVegetables("onion", 43, 1.7, 0, 9.5, "white", "Saturated", "middle");

        LocalVegetables tomatoGround = new LocalVegetables("tomatoGround", 19, 0.6, 0, 4.2, "red", "saturated", "gaudy", "ground");
        LocalVegetables tomatoGreenhouse = new LocalVegetables("tomatoGreenhouse", 19, 0.6, 0, 4.2, "red", "saturated", "gaudy", "greenhouse");
        LocalVegetables cucumberGreenhouse = new LocalVegetables("cucmberGreenhouse", 10, 0.7, 0, 1.8, "green", "saturated", "middleGaudy", "greenhouse");
        LocalVegetables peperRed = new LocalVegetables("peperRed", 23, 1.3, 0, 4.7, "green", "saturated", "gaudy", "greenhouse");
        LocalVegetables peperGreen = new LocalVegetables("peperRed", 27, 1.3, 0, 5.7, "red", "saturated", "gaudy", "greenhouse");

        ImportedVegetables spinach = new ImportedVegetables("spinach", 21, 2.9, 0, 2.3, "green", "", "", "Russia");


        try {
            Salad salad1 = new Salad("mySalad");
            logger.info("Salad was created");
            salad1.addIngredient(tomatoGreenhouse, 500);
            salad1.addIngredient(peperRed, 200);
            salad1.addIngredient(cucumberGreenhouse, 200);
            salad1.removeIngredient(tomatoGreenhouse, 100);
            System.out.println(salad1.toString());
            System.out.println("calories of salad " + salad1.calculateCalories());
            salad1.sort("calories");
            salad1.sort("proteins");
            salad1.findIngredientByCalories();
            printToFile("firstSalad", salad1);

            Salad salad2 = new Salad("mySecondSalad");
            logger.info("Salad was created");
            salad2.addIngredient(tomatoGround, 500);
            salad2.addIngredient(peperGreen, 200);
            salad2.addIngredient(cucumberGreenhouse, 200);
            salad2.addIngredient(spinach, 100);
            // salad2.removeIngredient(spinach, 200);
            System.out.println(salad2.toString());
            System.out.println("calories of salad " + salad2.calculateCalories());
            // salad2.sort("rt");
            // salad2.findIngredientByCalories(24, 25);
            printToFile("secondSalad", salad2);

        } catch (NoSearchResultsException e) {
            System.out.println("No search results for the specified range.\nTry another range");
        } catch (CannotRemoveMoreThanItIsException e) {
            System.out.println("Weight of ingredient to remove more than it has");
        } catch (NoSuchSortParameterException e) {
            System.out.println("No such sort parameter. Program can sort salad`s ingredients by: calories, proteins");
        } catch (EmptySaladFindExseption e) {
            System.out.println("Salad is empty. Add some ingredients to salad to find them");
        } catch (EmptySaladSortException e) {
            System.out.println("Salad is empty. Add some ingredients to salad to sort them");
        } catch (EmptySaladCalculateCaloriesException e) {
            System.out.println("Salad is empty. Add some ingredients to salad to calculate calories of salad");
        } catch (EmptySaladException e) {
            System.out.println("Salad is empty");
        } catch (IOException e) {
            logger.error("IOException");
            System.out.println("IOException");
        } catch (NoSuchRemoveIngredientInSaladException e) {
            System.out.println("NoSuchRemoveIngredientInSalad. Add this ingredient to remove it");
        } catch (IncorrectRangeException e) {
            System.out.println("IncorrectRange. Type correct range - just positive numbers");
        } catch (InputMismatchException e) {
            logger.error("InputMismatchException. Invalid range. Try one more time and type positive numbers");
            System.out.println("InputMismatchException");
        }
    }


    public static void printToFile(String fileName, Salad salad) throws IOException {
        String absolutePathDir = System.getProperty("user.dir");
        fileName = fileName + ".txt";
        absolutePathDir = absolutePathDir + "\\src\\main\\java\\epam\\" + fileName;
        System.out.println("Salad was printed to file: " + absolutePathDir);

        File file = new File(absolutePathDir);
        file.createNewFile();

        FileWriter writer = new FileWriter(absolutePathDir);
        writer.write(salad.toString());
        writer.close();
    }
}
