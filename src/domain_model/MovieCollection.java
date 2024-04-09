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

    public Movie editMovie(String title) {
        Movie targetMovie = null;
        for (Movie movieToEdit : movieList) {
            if (movieToEdit.getTitle().equalsIgnoreCase(title)) {
                targetMovie = movieToEdit;
            }
//            if (targetMovie == null) {
//                return null;
//
            String partToEdit= "-1";
            Scanner sc = new Scanner(System.in);

            String newValue = sc.nextLine();
            switch (partToEdit) {
                case "1": //title
                    targetMovie.setTitle(newValue);
                    break;

                case "2": //director
                    targetMovie.setDirector(newValue);
                    break;

                case "3": //genre
                    targetMovie.setGenre(newValue);
                    break;

                case "4": //year
                    targetMovie.setYearCreated(Integer.parseInt(newValue));
                    break;

                case "5": //length in minutes
                    targetMovie.setLengthMinutes(Integer.parseInt(newValue));
                    break;

                case "6": //colour
                    boolean coloredMovie = (newValue.toLowerCase() == "yes") ? true : false; //? = hvis, : = else
                    targetMovie.setInColor(coloredMovie);
                    break;

                case "0": //exit
                    break;
            }
        } return targetMovie;
    }


        //------------------------------------------------------------------------------------------------------------------
    }
