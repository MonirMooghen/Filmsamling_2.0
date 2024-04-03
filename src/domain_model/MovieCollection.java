package domain_model;

import java.util.ArrayList;
public class MovieCollection {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private ArrayList<Movie> movieList = new ArrayList<>();


    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public void addMovie(Movie plusMovie) {
        movieList.add(plusMovie);
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

    public void editMovieMethod(String title, String newTitle, String newDirector, int newYearCreated,
                                       boolean newInColor, double newLengthMinute, String newGenre) {
        for(Movie movie : movieList){
            if(movie.getTitle().equalsIgnoreCase(title)) {
                movie.setTitle(newTitle);
                movie.setDirector(newDirector);
                movie.setYearCreated(newYearCreated);
                movie.setInColor(newInColor);
                movie.setLengthMinutes(newLengthMinute);
                movie.setGenre(newGenre);
            }
        }

    }

    //------------------------------------------------------------------------------------------------------------------
}
