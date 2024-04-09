package domain_model;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieCollection {
    private ArrayList<Movie> movieList = new ArrayList<Movie>();
    static Scanner scannerObject = new Scanner(System.in);
    private Movie movie;

    public void addToList(Movie movie) {
        movieList.add(movie);
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void showListItems() {
        for (Movie items : movieList) {
            items.movieInfo();
        }
    }

    public ArrayList<Movie> searchMovie(String movieName) {

        var foundMovies = new ArrayList<Movie>();
        for (Movie items : movieList) {
            if (items.getTitle().toLowerCase().contains(movieName.toLowerCase())) {
                foundMovies.add(items);
            }

        }


        return foundMovies;

    }


}



