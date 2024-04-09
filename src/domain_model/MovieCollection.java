package domain_model;

import java.util.ArrayList;
import java.util.Scanner;

public class
MovieCollection {

    //***OBJECTS***--------------------------------------------------------------------------------------------------
    private ArrayList<Movie> movieList = new ArrayList<>();

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

//    public void editMovie(String title, String newTitle, String newDirector, int newYearCreated,
//                                       boolean newInColor, double newLengthMinute, String newGenre) {
//        for(Movie movie : movieList){
//            if(movie.getTitle().equalsIgnoreCase(title)) {
//                movie.setTitle(newTitle);
//                movie.setDirector(newDirector);
//                movie.setYearCreated(newYearCreated);
//                movie.setInColor(newInColor);
//                movie.setLengthMinutes(newLengthMinute);
//                movie.setGenre(newGenre);
//            }
//        }
//
//    }

    public Movie editMovie(Movie movieToEdit, String partToEdit, String newValue) {

            switch (partToEdit) {
                case "1": //title
                    movieToEdit.setTitle(newValue);
                    break;

                case "2": //director
                    movieToEdit.setDirector(newValue);
                    break;

                case "3": //genre
                    movieToEdit.setGenre(newValue);
                    break;

                case "4": //year
                    movieToEdit.setYearCreated(Integer.parseInt(newValue));
                    break;

                case "5": //length in minutes
                    movieToEdit.setLengthMinutes(Integer.parseInt(newValue));
                    break;

                case "6": //colour
                    boolean coloredMovie = (newValue.toLowerCase() == "yes") ? true : false; //? = hvis, : = else
                    movieToEdit.setInColor(coloredMovie);
                    break;

                case "0": //exit
                    break;
            }
         return movieToEdit;
    }


        //------------------------------------------------------------------------------------------------------------------
    }
