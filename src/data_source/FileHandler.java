package data_source;

import domain_model.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler implements FileHandlerInterface {

    //***OBJECTS***-----------------------------------------------------------------------------------------------------
    File file = new File("moviesList.csv");
    public ArrayList<Movie> movieListFile = new ArrayList<>();
    Scanner sc;

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public ArrayList<Movie> loadMovieDataToFile() {


        try {
            sc = new Scanner(file);

                sc.nextLine();//skip første linj-

        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
            throw new RuntimeException(e);
        }


        while (sc.hasNext()) {
            String line = sc.nextLine(); //Split linje og læg tokens i attributes
            String[] attributes = line.split(",");
            String title = attributes[0];
            String director = attributes[1];
            int yearCreated = Integer.parseInt(attributes[2]);
            boolean isInColor = attributes[3].equalsIgnoreCase("yes");
            int lengthMinutes = Integer.parseInt(attributes[4]);
            String genre = attributes[5];
            var movie = new Movie(title, director, yearCreated, isInColor, lengthMinutes, genre);

            movieListFile.add(movie);

        }
        sc.close();
        return movieListFile;
    }

    public void saveMovieToFile(ArrayList<Movie> movieList) {
        PrintStream saveFile = null;
        try {
            saveFile = new PrintStream("moviesList.csv");
            saveFile.println("Title,Director,YearCreated,IsInColor,LengthMinutes,Genre");

            for (Movie movie : movieList) {
                String isColoredMovie = (movie.getIsInColor()) ? "yes" : "no";
                String csvLine = String.format("%s,%s,%d,%s,%d,%s",
                        movie.getTitle(),
                        movie.getDirector(),
                        movie.getYearCreated(),
                        isColoredMovie,
                        movie.getLengthMinutes(),
                        movie.getGenre());
                saveFile.println(csvLine);
            }
            saveFile.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //------------------------------------------------------------------------------------------------------------------
}

