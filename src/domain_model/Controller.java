package domain_model;

import data_source.FileHandler;

import java.util.ArrayList;

public class Controller {

    //***OBJECTS***-----------------------------------------------------------------------------------------------------
    private MovieCollection collection;
    private Movie movie;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Controller() {
        collection = new MovieCollection(new FileHandler());
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public void addMovie(Movie movie) {
        collection.addMovie(movie);
    }

    public ArrayList<Movie> searchMovies(String input) {
        return collection.searchMovie(input);
    }


    public Movie movieEditor(Movie movieToEdit, int partToEdit, String newValue) {
        return collection.editMovie(movieToEdit, partToEdit, newValue);
    }

    public ArrayList<Movie> getMovieCollection() {
        return collection.getMovieList();
    }


    public boolean deleteMovie(String movieTitle) {
        return collection.deleteMovie(movieTitle);
    }

    public Movie findSpecificMovie(String movieTitle) {
        return collection.findSpecificMovie(movieTitle);
    }

    public void sortTitle() {
        collection.sortTitle();
//       collection.naturalOrderSort();

    }

    public void sortDirector() {
        collection.sortDirector();
    }

    public void sortYearCreated() {
        collection.sortYearCreated();
    }

    public void sortIsInColor() {
        collection.sortIsInColor();
    }

    public void sortLengthInMinutes() {
        collection.sortLenghtMinutes();
    }

    public void sortGenre() {
        collection.sortGenre();
    }

    public void secondarySort(int chosenOption) {
        collection.secondarySort(chosenOption);
    }


    //------------------------------------------------------------------------------------------------------------------
}