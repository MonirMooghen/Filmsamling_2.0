package domain_model;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class
MovieCollection {

    //***OBJECTS***--------------------------------------------------------------------------------------------------
    private ArrayList<Movie> movieList = new ArrayList<>();
    private FileHandler fileHandler = new FileHandler();

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public MovieCollection(){
        this.movieList = fileHandler.loadMovieDataToFile();

    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

    public ArrayList<Movie> searchMovie(String movieName) {
        var foundMovies = new ArrayList<Movie>(); //var kalder variablen, som er defineret efter new
        for (Movie items : movieList) {
            if (items.getTitle().toLowerCase().contains(movieName.toLowerCase())) {
                foundMovies.add(items);
            }
        }
        return foundMovies;
    }


    public Movie editMovie(Movie movieToEdit, int partToEdit, String newValue) {

        switch (partToEdit) {
            case 1: //title
                movieToEdit.setTitle(newValue);
                break;

            case 2: //director
                movieToEdit.setDirector(newValue);
                break;

            case 3: //genre
                movieToEdit.setGenre(newValue);
                break;

            case 4: //year
                movieToEdit.setYearCreated(Integer.parseInt(newValue));
                break;

            case 5: //length in minutes
                movieToEdit.setLengthMinutes(Integer.parseInt(newValue));
                break;

            case 6: //colour
                boolean coloredMovie = newValue.equalsIgnoreCase("yes");
                movieToEdit.setInColor(coloredMovie);
                break;

            case 0: //exit
                break;
        }
        return movieToEdit;
    }

    public void deleteMovie(Movie movieToDelete) {
        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = movieList.get(i);
            if (movie.equals(movieToDelete)) {
                movieList.remove(i);
                break;
            }
        }
        fileHandler.saveMovieToFile(movieList);
    }
}
