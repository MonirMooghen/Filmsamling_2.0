package ui;
public class UserInterface {

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

}
