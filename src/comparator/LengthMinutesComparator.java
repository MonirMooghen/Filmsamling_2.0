package comparator;

import domain_model.Movie;

import java.util.Comparator;

public class LengthMinutesComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie m1, Movie m2) {
        return Integer.compare(m1.getLengthMinutes(), m2.getLengthMinutes());
    }
}
