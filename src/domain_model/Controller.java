
import java.util.ArrayList;

public class Controller {
    private ArrayList<Movie> movieList;


    MovieCollection movieCollection = new MovieCollection();


    public void setMovieList() {
        this.movieList = movieCollection.getMovieList();
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }


    public void addMovie(Movie film) {
        setMovieList();
        movieList.add(film);
    }

    public void showList() {
        movieCollection.showListItems();
    }

    public ArrayList<Movie> searchMovie(String movieName) {
        return movieCollection.searchMovie(movieName);

    }


}



