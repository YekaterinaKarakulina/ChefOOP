package epam.InterfaceWithImplimentations;

import epam.Exceptions.*;

import epam.ProductsHierarchy.Vegetables;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Salad implements Eatable {
    public static Logger loggerSalad = LogManager.getLogger(Salad.class);

    private String name;

    private int index;

    private double addRemoveWeight;

    private ArrayList<Vegetables> list;
    private ArrayList<Double> listOfWeight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getAddWeight() {
        return addRemoveWeight;
    }

    public void setAddWeight(double addWeight) {
        this.addRemoveWeight = addWeight;
    }

    public ArrayList<Vegetables> getList() {
        return list;
    }

    public void setList(ArrayList<Vegetables> list) {
        this.list = list;
    }

    public Salad(String name) {
        this.name = name;
        list = new ArrayList<Vegetables>();
        listOfWeight = new ArrayList<Double>();
    }

    public void addIngredient(Vegetables vegetable, double weight) {
        for (int index = 0; index < list.size(); index++) {
            if (list.contains(vegetable)) {
                addRemoveWeight = listOfWeight.get(index) + weight;
                listOfWeight.set(index, addRemoveWeight);
            }
        }
        list.add(vegetable);
        listOfWeight.add(weight);
        loggerSalad.info("Ingredient was added to salad");
    }

    public void removeIngredient(Vegetables vegetable, double weight) throws EmptySaladException, CannotRemoveMoreThanItIsException, NoSuchRemoveIngredientInSaladException {
        boolean ingredientinSaladFlag = false;
        if (list.isEmpty()) {
            loggerSalad.error("EmptySaladException");
            throw new EmptySaladException();
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(vegetable)) {
                    index = i;
                    ingredientinSaladFlag = true;
                }
            }
            if (ingredientinSaladFlag == false) {
                loggerSalad.error("NoSuchRemoveIngredientInSaladException");
                throw new NoSuchRemoveIngredientInSaladException();
            }
            if (listOfWeight.get(index) == weight) {
                list.remove(index);
                listOfWeight.remove(index);
                loggerSalad.info("Ingredient was removed from salad");
            } else if (weight < listOfWeight.get(index)) {
                addRemoveWeight = listOfWeight.get(index) - weight;
                listOfWeight.set(index, addRemoveWeight);
                loggerSalad.info("Ingredient was removed from salad");
            } else if (weight > listOfWeight.get(index)) {
                loggerSalad.error("CannotRemoveMoreThanItIsException");
                throw new CannotRemoveMoreThanItIsException();
            }
        }
    }

    @Override
    public String toString() {
        return "Salad" +
                "\nlist=" + list +
                ", \nlistOfWeight=" + listOfWeight +
                " ";
    }

    public double calculateCalories() throws EmptySaladException {
        if (list.size() == 0) {
            loggerSalad.error("EmptySaladCalculateCaloriesException");
            throw new EmptySaladCalculateCaloriesException();
        }
        double saladCalories = 0;
        for (int i = 0; i < list.size(); i++) {

            saladCalories = saladCalories + list.get(i).getCalorie() * listOfWeight.get(i) / 100;
        }
        return saladCalories;
    }

    public void sort(String parameter) throws EmptySaladException, NoSuchSortParameterException {
        if (list.size() == 0) {
            loggerSalad.error("EmptySaladSortException");
            throw new EmptySaladSortException();
        }
        ArrayList<Vegetables> listCopy = new ArrayList<Vegetables>();
        ArrayList<Vegetables> sortedList = new ArrayList<Vegetables>();
        for (int i = 0; i < list.size(); i++) {
            listCopy.add(list.get(i));
        }
        sortedList.clear();
        if (parameter.equals("calories")) {
            for (int j = 0; j < listCopy.size() + sortedList.size(); j++) {
                double minCaloriesIngredient = listCopy.get(0).getCalorie();
                int minCaloriesIngredientIndex = 0;
                for (int i = 0; i < listCopy.size(); i++) {
                    if (listCopy.get(i).getCalorie() < minCaloriesIngredient) {
                        minCaloriesIngredient = listCopy.get(i).getCalorie();
                        minCaloriesIngredientIndex = i;
                    }
                }
                sortedList.add(listCopy.get(minCaloriesIngredientIndex));
                listCopy.remove(listCopy.get(minCaloriesIngredientIndex));
            }
            System.out.println("Salad sorted by " + parameter);
            System.out.println(sortedList.toString());
        } else if (parameter.equals("proteins")) {
            for (int j = 0; j < listCopy.size() + sortedList.size(); j++) {
                double minProteinsIngredient = listCopy.get(0).getProteins();
                int minProteinsIngredientIndex = 0;
                for (int i = 0; i < listCopy.size(); i++) {
                    if (listCopy.get(i).getProteins() < minProteinsIngredient) {
                        minProteinsIngredient = listCopy.get(i).getProteins();
                        minProteinsIngredientIndex = i;
                    }
                }
                sortedList.add(listCopy.get(minProteinsIngredientIndex));
                listCopy.remove(listCopy.get(minProteinsIngredientIndex));
            }
            System.out.println("Salad sorted by " + parameter);
            System.out.println(sortedList.toString());
        } else {
            loggerSalad.error("NoSuchSortParametrException");
            throw new NoSuchSortParameterException();
        }
    }

    public void findIngredientByCalories() throws NoSearchResultsException, EmptySaladException, IncorrectRangeException {
        double minValue = 0;
        double maxValue = 0;
        System.out.println("Let`s find ingredient in a salad by calories. \nPrint min and max range");
        boolean printFlag = true;
        Scanner scanner = new Scanner(System.in);
        while (printFlag) {
            minValue = scanner.nextInt();
            maxValue = scanner.nextInt();
            printFlag = false;
        }
        if (minValue > 0 && maxValue > 0) {
            System.out.println("Search in progress");
            if (list.size() == 0) {
                loggerSalad.error("EmptySaladFindException");
                throw new EmptySaladFindExseption();
            }
            ArrayList<Vegetables> findList = new ArrayList<Vegetables>();
            int findAmount = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getCalorie() > minValue && list.get(i).getCalorie() < maxValue) {
                    findList.add(list.get(i));
                    findAmount++;
                }
            }
            if (findAmount == 0) {
                loggerSalad.error("NoSearchResultsException");
                throw new NoSearchResultsException();
            }
            System.out.println("Found " + findAmount + " vegetables");
            System.out.println("Search results: \n");
            System.out.println(findList.toString());
        } else {
            loggerSalad.error("IncorrectRangeException");
            throw new IncorrectRangeException();
        }
    }
}
