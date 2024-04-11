package comparator;

import domain_model.Movie;

import java.util.Comparator;

public class DirectorComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie m1, Movie m2) {
        return m1.getDirector().compareTo(m2.getDirector());
    }
}
