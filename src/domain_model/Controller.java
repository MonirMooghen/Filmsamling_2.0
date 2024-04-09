package domain_model;

import java.util.ArrayList;
public class Controller {

    //***OBJECTS***-----------------------------------------------------------------------------------------------------
    private MovieCollection collection;
    private Movie movie;

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

    public Movie editMovie(String title) {
        return collection.editMovie(title);
    }

    public ArrayList<Movie> getMovieCollection(){
        return collection.getMovieList();
    }

    //------------------------------------------------------------------------------------------------------------------
}