package domain_model;


import java.util.Scanner;

public class Movie {
    private String title;
    private String director;
    private String genre;
    private int yearCreated;
    private int lengthInMinutes;
    private boolean isInColor;
    private int movieId;



    public void setTitle(String title) {

        this.title = title;
    }


    public void setDirector(String director) {

        this.director = director;
    }


    public void setGenre(String genre) {

        this.genre = genre;
    }


    public void setYearCreated(int yearCreated) {

        this.yearCreated = yearCreated;
    }


    public void setLengthInMinutes(int lengthInMinutes) {

        this.lengthInMinutes = lengthInMinutes;
    }


    public void setInColor(boolean isInColor) {

        this.isInColor = isInColor;

    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }


    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public boolean isInColor() {
        return isInColor;
    }

    public int getMovieId() {
        return movieId;
    }

    public void movieInfo() {
        String coloredMovie = (isInColor) ? "Yes" : "No";
        System.out.println(
                "MovieId: " + movieId + "\n" +
                        "Movie Title: " + title + "\n" +
                        "Movie Director: " + director + "\n" +
                        "Year of Publish: " + yearCreated + "\n" +
                        "Colored Movie: " + coloredMovie + "\n" +
                        "Length in minutes: " + lengthInMinutes + "\n" +
                        "Genre: " + genre + "\n"
        );
    }


}


