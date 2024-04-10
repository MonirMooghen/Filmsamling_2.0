package domain_model;

import java.util.ArrayList;

public class Controller {

    //***OBJECTS***-----------------------------------------------------------------------------------------------------
    private MovieCollection collection;
    private Movie movie;
    private FileHandler dbManager = new FileHandler();

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Controller() {
        collection = new MovieCollection();
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public void addMovie(Movie movie) {
        collection.addMovie(movie);
    }

    public ArrayList<Movie> searchMovies(String input) {
        return collection.searchMovie(input);
    }


    public Movie findMovieToEdit(String movieTitle) {
        Movie targetMovie = null;
        ArrayList<Movie> movieList = getMovieCollection();
        for (Movie movieToEdit : movieList) {
            if (movieToEdit.getTitle().equalsIgnoreCase(movieTitle)) {
                targetMovie = movieToEdit;
                break;
            }

        }
        return targetMovie;
    }

    public Movie movieEditor(Movie movieToEdit, String partToEdit, String newValue) {
        return collection.editMovie(movieToEdit, partToEdit, newValue);
    }

    public ArrayList<Movie> getMovieCollection() {
        return collection.getMovieList();
    }

    public void saveListToFile() {
        dbManager.saveMovieToFile(getMovieCollection());
    }
    //------------------------------------------------------------------------------------------------------------------
}