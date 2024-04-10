package domain_model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    //***OBJECTS***-----------------------------------------------------------------------------------------------------
    File file = new File("moviesList.csv");
    private ArrayList<Movie> movieListFile = new ArrayList<>();

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public ArrayList<Movie> loadMovieDataToFile() {

        Scanner sc = null;
        try {
            sc = new Scanner(file);
            sc.nextLine(); //skip første linje

        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
            throw new RuntimeException(e);
        }

        Movie movieList = null;
        while(sc.hasNext()) {
            String line = sc.nextLine(); //Split linje og læg tokens i attributes
            String[] attributes = line.split(",");
            Movie movie = new Movie(
                                        attributes[0],   // title (String)
                                             attributes[1],   // director (String)
                    (Integer.parseInt(    attributes[2])), // yearCreated (int)
                    (Boolean.parseBoolean(attributes[3])), // isinColor (boolean)
                    (Double.parseDouble(  attributes[4])), // lengthMinutes (double)
                                             attributes[5]    // genre (String)
            );

            movieListFile.add(movie);
          //System.out.println(movie.toString());
        }
        sc.close();
        return movieListFile;
    }

    public void saveMovieToFile(ArrayList<Movie> movieList){
        PrintStream saveFile = null;
        try {
            saveFile = new PrintStream("moviesList.csv");
            for (Movie movie : movieList) {
                saveFile.println(movie);
            }
            saveFile.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //------------------------------------------------------------------------------------------------------------------
}
