package data_source;

import domain_model.Movie;

import java.util.ArrayList;

public interface FileHandlerInterface {

    public ArrayList<Movie> loadMovieDataToFile();

    public void saveMovieToFile(ArrayList<Movie> movieList);


}
