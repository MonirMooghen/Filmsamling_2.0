package domain_model;

import comparator.*;
import data_source.FileHandler;
import data_source.FileHandlerInterface;

import java.util.ArrayList;

public class
MovieCollection {

    //***OBJECTS***--------------------------------------------------------------------------------------------------
    private ArrayList<Movie> movieList = new ArrayList<>();
    private FileHandlerInterface fileHandler = new FileHandler();

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public MovieCollection(FileHandlerInterface fileHandler) {
        this.fileHandler = fileHandler;
        this.movieList = fileHandler.loadMovieDataToFile();
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public void addMovie(Movie movie) {
        movieList.add(movie);
        fileHandler.saveMovieToFile(movieList);
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

    public Movie findSpecificMovie(String movieTitle) {
        Movie targetMovie = null;
        for (Movie movieToEdit : movieList) {
            if (movieToEdit.getTitle().equalsIgnoreCase(movieTitle)) {
                targetMovie = movieToEdit;
                return targetMovie;
            }
        }
        return targetMovie;
    }

    public boolean deleteMovie(String movieTitle) {
        Movie tagetMovie = findSpecificMovie(movieTitle);
        if (tagetMovie != null) {
            movieList.remove(tagetMovie);
            fileHandler.saveMovieToFile(movieList);
            return true;
        } else {
            return false;
        }
    }


    public void sortTitle() {
        movieList.sort(Movie.title_comparator);

    }

    public void sortDirector() {
        movieList.sort(Movie.director_comparator);
    }

    public void sortYearCreated() {
        movieList.sort(Movie.year_comparator);
    }

    public void sortIsInColor() {
        movieList.sort(new IsInColorComparator());
    }

    public void sortLenghtMinutes() {
        movieList.sort(Movie.length_minutes_comparator);
    }

    public void sortGenre() {
        movieList.sort(Movie.genre_comparator);
    }


    public void secondarySort(int chosenOption) {

        switch (chosenOption) {
            case 1 -> movieList.sort(new TitleComparator().thenComparing(new YearCreatedComparator()));
            case 2 -> movieList.sort(new TitleComparator().thenComparing(new DirectorComparator()));
            case 3 -> movieList.sort(new TitleComparator().thenComparing(new LengthMinutesComparator()));
            case 4 -> movieList.sort(new TitleComparator().thenComparing(new GenreComparator()));
        }


    }


}
