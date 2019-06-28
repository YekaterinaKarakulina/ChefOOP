package epam.InterfaceWithImplimentations;

import epam.Exceptions.EmptySaladException;
import epam.Exceptions.IncorrectRangeException;
import epam.Exceptions.NoSearchResultsException;
import epam.Exceptions.NoSuchSortParameterException;

public interface Eatable {

    double calculateCalories() throws EmptySaladException;

    void sort(String parameter) throws EmptySaladException, NoSuchSortParameterException;

    void findIngredientByCalories() throws NoSearchResultsException, EmptySaladException, IncorrectRangeException;

}
