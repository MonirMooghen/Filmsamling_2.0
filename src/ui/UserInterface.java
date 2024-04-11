package ui;

import comparator.DirectorComparator;
import comparator.TitleComparator;
import domain_model.Controller;
import domain_model.FileHandler;
import domain_model.Movie;
import domain_model.MovieCollection;

import java.util.*;

public class UserInterface {

    //***OBJECTS***-----------------------------------------------------------------------------------------------------
    Scanner input = new Scanner(System.in);
    Controller controller = new Controller();

    //***START-PROGRAM***-----------------------------------------------------------------------------------------------

    int userChoice = Integer.parseInt("-1");

    public void startProgram() {

            while (userChoice != 6) {
                menu();
                userChoice = getUserInteger(-1,7);

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
                        controller.sortTitle();
                        printMovieCollection();
                    }
                    case 4 -> {
                        editMovie();
                    }
                    case 5 -> {
                       deleteMovie();
                    }
                    case 6 -> {
                        sortMovies();
                    }
                    case 7 -> {
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
        System.out.println("Type '5' to delete a movie");
        System.out.println("Type '6' to sort your movie collection");
        System.out.println("Type '7' to exit the program");
    }


        public void addMovie () {
            //1. Bruger input - Filmens detaljer
            System.out.println("Enter movie title");
            String title = getUserString();
            System.out.println(title);

            System.out.println("Enter movie director");
            String director = getUserString();
            System.out.println(director);

            System.out.println("Enter year created");
            int yearCreated = getUserInteger(1900, 2024);

            System.out.println("Is the movie in colour? ('Yes' or 'no)");
            String color = getUserString();
            boolean isInColor = color.equals("yes");


            System.out.println("Enter length in minutes");
            int lengthMinute = getUserInteger(0,800);


            System.out.println("Enter movie genre");
            String genre = getUserString();


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

        public void searchMovie () {
            //2. Søge efter film
            System.out.println("Search movie");
            String search = getUserString();
            ArrayList<Movie> printMovieCollection = controller.searchMovies(search);
            for (Movie movie : printMovieCollection) {
                System.out.println(movie.toString());
            }

        }

        public void printMovieCollection () {
            //3. Overblik over hele filmsamlingen
            System.out.println("Overview of your Movie Collection");
            //controller.sortTitle();
            for (Movie movie : controller.getMovieCollection()) {
                System.out.println(movie.toString());
            }
        }

        public void editMovie() {
            int menuOption = -1;
            System.out.println("Type the movie name to edit : ");

            String movieName = getUserString();
            Movie targetMovie = controller.findSpecificMovie(movieName);

            if (targetMovie != null) {
                System.out.println(targetMovie.toString());
            } else {
                System.out.println("Movie not found!!");
                editMovie();
            }

            while (menuOption != 0) {
                System.out.println("type 1 to  edit title " + "\n" +
                        "type 2 to edit director" + "\n" +
                        "type 3 to edit genre" + "\n" +
                        "type 4 to edit published date" + "\n" +
                        "type 5 to edit the duration" + "\n" +
                        "type 6 to edit movie color info " + "\n" +
                        "type 0 to exit from edit menu :" + "\n");

                menuOption = getUserInteger(-1,7);
                if (menuOption == 0) break;
                System.out.println("Type the new value: ");
                String newValue = getUserString();
                Movie editedMovie = controller.movieEditor(targetMovie, menuOption, newValue);
                System.out.println(editedMovie.toString());
            }
        }

        public void deleteMovie() {
            System.out.println("Which movie would you like to delete? \nSearch movie by title (ex. 'Batman')");
            String userInput = input.nextLine();

            boolean output = controller.deleteMovie(userInput);

            if (!output) {
                System.out.println("No movie by that name exists in the collection.\n");
            } else {
                System.out.println("The movie was successfully deleted.\n");
            }

        }

        public void sortMovies() {
            System.out.println("");
            System.out.println("Type '1' to sort title\n" +
                    "Type '2' to sort director\n" +
                    "Type '3' to sort year created\n" +
                    "Type '4' to sort color\n" +
                    "Type '5' to sort duration in minutes\n" +
                    "Type '6' to sort genre\n");

            userChoice = Integer.parseInt(input.next());

                switch (userChoice){
                    case 1 -> {
                          System.out.println("Do you want to add a secondary sorting option?");
                          System.out.println("Type '1' for yes\nType '2' for no");
                          int extraSort = getUserInteger(0, 3);
                          if (extraSort == 1){
                              secondarySortOption(userChoice);
                              controller.sortTitle();

                          } else{
                              controller.sortTitle();
                              printMovieCollection();
                          }

                    }
                    case 2 -> {
                          System.out.println("Do you want to add a secondary sorting option?");
                          System.out.println("Type '1' for yes\nType '2' for no");
                        int extraSort = getUserInteger(0, 3);
                        if (extraSort == 1){
                            secondarySortOption(userChoice);
                            controller.sortDirector();


                        } else{
                            controller.sortDirector();
                            printMovieCollection();
                        }
                    }
                    case 3 -> {
                        System.out.println("Do you want to add a secondary sorting option?");
                        System.out.println("Type '1' for yes\nType '2' for no");
                        int extraSort = getUserInteger(0, 3);
                        if (extraSort == 1){
                            secondarySortOption(userChoice);
                            controller.sortYearCreated();


                        } else{
                            controller.sortYearCreated();
                            printMovieCollection();
                        }
                    }
                    case 4 -> {
                        System.out.println("Do you want to add a secondary sorting option?");
                        System.out.println("Type '1' for yes\nType '2' for no");

                        int extraSort = getUserInteger(0, 3);
                        if (extraSort == 1){
                            secondarySortOption(userChoice);
                            controller.sortIsInColor();


                        } else{
                            controller.sortIsInColor();
                            printMovieCollection();
                        }

                    }
                    case 5 -> {
                        System.out.println("Do you want to add a secondary sorting option?");
                        System.out.println("Type '1' for yes\nType '2' for no");
                        int extraSort = getUserInteger(0, 3);
                        if (extraSort == 1){
                            secondarySortOption(userChoice);
                            controller.sortLengthInMinutes();


                        } else{
                            controller.sortLengthInMinutes();
                            printMovieCollection();
                        }
                    }
                    case 6 -> {
                        System.out.println("Do you want to add a secondary sorting option?");
                        System.out.println("Type '1' for yes\nType '2' for no");
                        int extraSort = getUserInteger(0, 3);
                        if (extraSort == 1){
                            secondarySortOption(userChoice);
                            controller.sortGenre();


                        } else{
                            controller.sortGenre();
                            printMovieCollection();
                        }
                    }
                    default -> System.out.println("Invalid input");
                }
        }

        public void secondarySortOption(int primarySort) {
            System.out.println("Type '1' to sort title\n" +
                    "Type '2' to sort director\n" +
                    "Type '3' to sort year created\n" +
                    "Type '4' to sort color\n" +
                    "Type '5' to sort duration in minutes\n" +
                    "Type '6' to sort genre\n");

            //ArrayList<MovieCollection> data = fh.loadData();
            int secondarySortChoice ;

            secondarySortChoice = getUserInteger(primarySort,6);
            switch (secondarySortChoice) {
                case 1 -> {
                    Collections.sort(controller.getMovieCollection(), new TitleComparator().
                            thenComparing(new DirectorComparator()));
                    controller.sortTitle();
                    printMovieCollection();
                }
                case 2 -> {
                    controller.sortDirector();
                    printMovieCollection();
                }
                case 3 -> {
                    controller.sortYearCreated();
                    printMovieCollection();
                }
                case 4 -> {
                    controller.sortIsInColor();
                    printMovieCollection();
                }
                case 5 -> {
                    controller.sortLengthInMinutes();
                    printMovieCollection();
                }
                case 6 -> {
                    controller.sortGenre();
                    printMovieCollection();
                }
            }
        }


    //***OTHER METHODS***-------------------------------------------------------------------------------------------

        public String getUserString () {


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

        public int getUserInteger (int exempt, int range ){
            int userInput;
            do {
                userInput = input.nextInt();
                input.nextLine();
                if (userInput == exempt ||  userInput > range) {
                    System.out.println("Wrong input try again:");
                }

            } while (userInput < 0);

            return userInput;
        }
        //------------------------------------------------------------------------------------------------------------------
    }


