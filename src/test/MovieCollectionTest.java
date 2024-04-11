package test;

import data_source.FileHandlerMock;
import domain_model.Movie;
import domain_model.MovieCollection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MovieCollectionTest {
    private MovieCollection movieCollection;
    private Movie testMovie;

    @Test
    public void testAddMovie() {

        // Create new movie list and new movie object
        movieCollection = new MovieCollection(new FileHandlerMock());
        testMovie = new Movie("Example Movie", "Director Name", 2024, true, 90, "Genre");

        // Add the movie to the list
        movieCollection.addMovie(testMovie);

        // Verify that the movie has been added to the list
        assertTrue(movieCollection.getMovieList().contains(testMovie));
    }


    @Test
    public void testEditMovie() {

        // Create new movie list and new movie object
        movieCollection = new MovieCollection(new FileHandlerMock());
        testMovie = new Movie("Example Movie", "Director Name", 2024, true, 90, "Genre");

        // Edit the movie in the list
        movieCollection.editMovie(testMovie, 1, "New Title");

        // Verify that the movie has been edited
        assertEquals("New Title", testMovie.getTitle());
    }

    @Test
    public void testSearchMovie() {

        // Create new movie list and new movie object and add new movie object to list
        movieCollection = new MovieCollection(new FileHandlerMock());
        testMovie = new Movie("Example Movie", "Director Name", 2024, true, 90, "Genre");
        movieCollection.addMovie(testMovie);

        // Search for a movie that exists in the list
        ArrayList<Movie> foundMovies = movieCollection.searchMovie(testMovie.getTitle());

        // Verify that the movie is found in the search result
        assertEquals(1, foundMovies.size());
        assertTrue(foundMovies.contains(testMovie));
    }

    @Test
    public void testDeleteMovie() {

        // Create new movie list and new movie object
        movieCollection = new MovieCollection(new FileHandlerMock());
        testMovie = new Movie("Example Movie", "Director Name", 2024, true, 90, "Genre");

        // Delete the movie from the list
        movieCollection.deleteMovie(testMovie.getTitle());

        // Verify that the movie has been deleted from the list
        assertFalse(movieCollection.getMovieList().contains(testMovie));
    }

    @Test
    public void testSortMovies() {

        // Create new movie list
        movieCollection = new MovieCollection(new FileHandlerMock());

        // Sort the list according to the input


        // Verify that the list has been sorted
    }


}
