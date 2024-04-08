package domain_model;

import java.util.ArrayList;
public class Controller {

    MovieCollection collection;
    public Controller() {
        collection = new MovieCollection();
    }
    public void addMovie(Movie movie) {
        collection.addMovie(movie);
    }

    public ArrayList<Movie> searchMovies(String input) {
        return collection.searchMovie(input);
    }

    public void editMovie(
            String title, String fieldToEdit, String newValue) {
        collection.editMovie(title, fieldToEdit, newValue);
    }

}