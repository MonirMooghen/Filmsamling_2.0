package domain_model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    File moviesFile = new File("moviesList.csv");
    ArrayList<Movie> movies = new ArrayList<Movie>();
    Scanner sc =new Scanner(System.in);

    public ArrayList<Movie> getMovies() {
        try {
            sc = new Scanner(moviesFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (sc.hasNextLine()) {
            String movie = sc.nextLine();
            String[] attributes = movie.split(",");
            String title = attributes[0];
            String genre = attributes[1];
            String year = attributes[2];
            String director = attributes[3];


        }
    }
}
