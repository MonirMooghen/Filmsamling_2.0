
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    // menu controller variable
    private static int menuController;
    static Scanner scannerObject = new Scanner(System.in);
    static Controller listOfMovies = new Controller();

    public void startProgram() {
        System.out.println("Welcome to the film Collection you have few options: ");
        setMenuController();
        while (menuController != 5) {
            menuList(menuController);
            setMenuController();
        }

    }

    public static int setMenuController() {
        System.out.println("Choose 1 to add a new movie to the list. ");
        System.out.println("Choose 2 to see the movies in the list.");
        System.out.println("Choose 3 to search for a movies in the list.");
        System.out.println("Choose 4 to edit an existing movie.");
        System.out.println("Choose 5 to exit the program.");
        return menuController = scannerObject.nextInt();

    }


    public static void menuList(int menuOption) {
        switch (menuOption) {
            case 1:
                listOfMovies.addMovie(createNewMovie());
                break;
            case 2:
                listOfMovies.showList();
                break;

            case 3:
                searchForMovie();
                break;

            case 4:
                movieEditor();
                break;


        }
    }


    public static int getMenuController() {
        return menuController;
    }

    public static Movie createNewMovie() {
        var movieToAdd = new Movie();
        System.out.println("Please add the title of the movie: ");
        String title = getUserString();
        movieToAdd.setTitle(title);
        System.out.println("Please add the genre of the movie: ");
        String genre = getUserString();
        movieToAdd.setGenre(genre);
        System.out.println("Please add the Director of the movie: ");
        String director = getUserString();
        movieToAdd.setDirector(director);
        System.out.println("Please add the year in which the movie published: ");
        int yearCreated = getUserInteger();
        movieToAdd.setYearCreated(yearCreated);
        System.out.println("Please add the length of the movie in minutes: ");
        int lengthInMinutes = getUserInteger();
        movieToAdd.setLengthInMinutes(lengthInMinutes);
        System.out.println("If it is a colored movie type true else type false : ");
        boolean isInColor = scannerObject.nextBoolean();
        movieToAdd.setInColor(isInColor);
        int movieId = (listOfMovies.getMovieList() == null) ? 1 : listOfMovies.getMovieList().size();
        movieToAdd.setMovieId(movieId);
        return movieToAdd;
    }


    public static void searchForMovie() {

        ArrayList<Movie> searchResult;
        System.out.println("Please type name of the movie: ");
        String searchQuery = getUserString();
        searchResult = listOfMovies.searchMovie(searchQuery);
        if (searchResult.isEmpty()) {
            System.out.println("Could not find this movie, try again ");
        } else {
            for (Movie items : searchResult) {
                items.movieInfo();
            }
        }

    }


    public static void movieEditor() {

        System.out.println("Please type name of the movie: ");
        String searchQuery = scannerObject.nextLine();
        ArrayList<Movie> foundedMovies = listOfMovies.searchMovie(searchQuery);

        for (Movie items : foundedMovies) {
            items.movieInfo();
        }

        System.out.println("Please choose id of the movie to edit: ");
        int movieToEdit = scannerObject.nextInt();

        for (Movie items : foundedMovies) {
            if (items.getMovieId() == movieToEdit) {
                Movie targetMovie = items;

                String partToEdit = "";
                while (!partToEdit.equals("exit")) {
                    System.out.println("type title to  edit title " + "\n" +
                            "type director to edit director" + "\n" +
                            "type genre to edit genre" + "\n" +
                            "type yearPublished to edit published date" + "\n" +
                            "type lengthInMinutes to edit the duration" + "\n" +
                            "type isInColor to edit movie color info " + "\n" +
                            "type exit to go to the menu :" + "\n");

                    partToEdit = scannerObject.nextLine();
                    switch (partToEdit) {
                        case "title":
                            System.out.println("Please add the title of the movie: ");
                            String title = getUserString();
                            targetMovie.setTitle(title);
                            break;
                        case "director":
                            System.out.println("Please add the Director of the movie: ");
                            String director = getUserString();
                            targetMovie.setDirector(director);
                            break;
                        case "genre":
                            System.out.println("Please add the genre of the movie: ");
                            String genre = getUserString();
                            targetMovie.setGenre(genre);
                            break;
                        case "yearPublished":
                            System.out.println("Please add the year in which the movie published: ");
                            int yearCreated = getUserInteger();
                            targetMovie.setYearCreated(yearCreated);
                            break;
                        case "lengthInMinutes":
                            System.out.println("Please add the length of the movie in minutes: ");
                            int lengthInMinutes = getUserInteger();
                            targetMovie.setLengthInMinutes(lengthInMinutes);
                            break;
                        case "isInColor":
                            System.out.println("If it is a colored movie type true else type false : ");
                            boolean isInColor = scannerObject.nextBoolean();
                            targetMovie.setInColor(isInColor);
                            break;
                        case "exit":
                            break;
                    }
                }
            }
        }


    }


    public static String getUserString() {

        String userInput;
        do {
            userInput = scannerObject.nextLine();
            if (userInput.trim().isEmpty()) {
                System.out.println("Wrong input try again:");
            }

        } while (userInput.trim().isEmpty());

        return userInput;
    }

    public static int getUserInteger() {

        int userInput;
        do {
            userInput = scannerObject.nextInt();
            if (userInput <= 0) {
                System.out.println("Wrong input try again:");
            }

        } while (userInput <= 0);

        return userInput;

    }


}


