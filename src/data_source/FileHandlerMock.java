package data_source;

import domain_model.Movie;
import java.util.ArrayList;

public class FileHandlerMock implements FileHandlerInterface {

    ArrayList<Movie> mockMovieList;

    Movie movieTest1 = new Movie("V Test Title", "A Test Director", 5999, false, 28, "F Test Genre");
    Movie movieTest2 = new Movie("A Test Title", "C Test Director", 7000, false, 84, "E Test Genre");
    Movie movieTest3 = new Movie("N Test Title", "E Test Director", 2001, false, 45, "D Test Genre");
    Movie movieTest4 = new Movie("O Test Title", "B Test Director", 3002, true, 76, "C Test Genre");
    Movie movieTest5 = new Movie("G Test Title", "D Test Director", 5003, true, 12, "B Test Genre");
    Movie movieTest6 = new Movie("P Test Title", "F Test Director", 6004, true, 45, "A Test Genre");

    public FileHandlerMock() {
        mockMovieList = new ArrayList<>();
        mockMovieList.add(movieTest1);
        mockMovieList.add(movieTest2);
        mockMovieList.add(movieTest3);
        mockMovieList.add(movieTest4);
        mockMovieList.add(movieTest5);
        mockMovieList.add(movieTest6);
    }

    @Override
    public ArrayList<Movie> loadMovieDataToFile() {
        return mockMovieList;
    }

    @Override
    public void saveMovieToFile(ArrayList<Movie> movieList) {

    }

}
