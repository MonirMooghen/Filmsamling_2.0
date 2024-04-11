package comparator;

import domain_model.Movie;

import java.util.Comparator;

public class GenreComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie m1, Movie m2) {
        return m1.getGenre().compareTo(m2.getGenre());
    }
}
