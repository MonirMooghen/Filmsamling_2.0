package ui;

import domain_model.Controller;
import domain_model.Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    //***OBJECTS***-----------------------------------------------------------------------------------------------------
    Scanner input = new Scanner(System.in);
    Controller controller = new Controller();

    //***START-PROGRAM***-----------------------------------------------------------------------------------------------
    public void startProgram() {

        int userChoice = -1;

        while (userChoice != 5) {
            menu();
            userChoice = input.nextInt();
            switch (userChoice) {
                case 0 -> {
                    menu();
                }
                case 1 -> {
                    addMovie();
                }
                case 2 -> {
                    searchMovie();
                }
                case 3 -> {
                    printMovieCollection();
                }
                case 4 -> {
                    editMovie();
                }
                case 5 -> {
                    System.exit(0);
                }
                default -> System.out.println("Invalid input");

            }
        }
    }

    //***STARTPROGRAM METHODS***----------------------------------------------------------------------------------------
    public static void menu() {
        System.out.println("Welcome to your movie collection");
        System.out.println("********************************");
        System.out.println("Type '0' to see menu options");
        System.out.println("Type '1' to add a movie");
        System.out.println("Type '2' to search for a movie");
        System.out.println("Type '3' to see your movie collection as a list");
        System.out.println("Type '4' to edit a movie");
        System.out.println("Type '5' to exit the program");
    }


    public void addMovie() {
        //1. Bruger input - Filmens detaljer
        input.nextLine();
        System.out.println("Enter movie title");
        String title = input.nextLine();
        System.out.println(title);
        System.out.println();

        System.out.println("Enter movie director");
        String director = input.nextLine();
        System.out.println();

        System.out.println("Enter year created");
        int yearCreated = input.nextInt();
        input.nextLine(); //Scanner bug solution

        System.out.println("Is the movie in colour? ('Yes' or 'no)");
        String color = input.next();
        boolean isInColor = color.equals("yes");


        System.out.println("Enter length in minutes");
        int lengthMinute = input.nextInt();
        input.nextLine(); //Scanner bug solution


        System.out.println("Enter movie genre");
        String genre = input.nextLine();

        controller.addMovie(new Movie(title, director, yearCreated, isInColor, lengthMinute, genre));
        controller.saveListToFile();

        System.out.println("The movie has now been added to your movie collection");
        System.out.println("Movie details:");
        System.out.println("Title: " + title);
        System.out.println("Director: " + director);
        System.out.println("Year created: " + yearCreated);
        System.out.println("Is the movie in colour?: " + color);
        System.out.println("Length: " + lengthMinute);
        System.out.println("Genre: " + genre);
        System.out.println("...................................");

    }

    public void searchMovie() {
        //2. Søge efter film
        System.out.println("Search movie");
        String search = input.next();
        ArrayList<Movie> printMovieCollection = controller.searchMovies(search);
        for (Movie movie : printMovieCollection) {
            System.out.println(movie.toString());
        }

        System.out.println(printMovieCollection);
    }

    public void printMovieCollection() {
        //3. Overblik over hele filmsamlingen
        System.out.println("Overview of your Movie Collection");
        for (Movie movie : controller.getMovieCollection()) {
            System.out.println(movie.toString());
        }
    }

    public void editMovie() {
        String menuOption = "-1";
        System.out.println("Type the movie name to edit : ");

        String movieName = getUserString();
        Movie targetMovie = controller.findMovieToEdit(movieName);

        if (targetMovie != null) {
            System.out.println(targetMovie.toString());
        } else {
            System.out.println("Movie not found!!");
            return;
        }

        while (menuOption != "0") {
            System.out.println("type 1 to  edit title " + "\n" +
                    "type 2 to edit director" + "\n" +
                    "type 3 to edit genre" + "\n" +
                    "type 4 to edit published date" + "\n" +
                    "type 5 to edit the duration" + "\n" +
                    "type 6 to edit movie color info " + "\n" +
                    "type 0 to exit from edit menu :" + "\n");

            menuOption = input.nextLine();
            if (menuOption.equals("0")) break;
            System.out.println("Type the new value: ");

            String newValue = input.nextLine();
            Movie editedMovie = controller.movieEditor(targetMovie, menuOption, newValue);
            System.out.println(editedMovie.toString());

        }

    }


    //***OTHER METHODS***-----------------------------------------------------------------------------------------------

    public String getUserString() {


        String userInput;
        do {

            userInput = input.nextLine();
            input.nextLine();
            if (userInput.trim().isEmpty()) {
                System.out.println("Wrong input try again:");
            }

        } while (userInput.trim().isEmpty());

        return userInput;
    }

    public int getUserInteger() {
        int userInput;
        do {
            userInput = input.nextInt();
            input.nextLine();
            if (userInput <= 0) {
                System.out.println("Wrong input try again:");
            }

        } while (userInput <= 0);

        return userInput;

    }
    //------------------------------------------------------------------------------------------------------------------
}


