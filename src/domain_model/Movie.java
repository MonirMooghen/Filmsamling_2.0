package domain_model;

public class Movie {

    //***ATTRIBUTES***---------------------------------------------------------------------------------------------------
    private String title;
    private String director;
    private int yearCreated;
    private boolean isInColor;
    private int lengthMinutes;
    private String genre;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Movie(String title, String director, int yearCreated,
                 boolean isInColor, int lengthMinutes, String genre) {
        this.title = title;
        this.director = director;
        this.yearCreated = yearCreated;
        this.isInColor = isInColor;
        this.lengthMinutes = lengthMinutes;
        this.genre = genre;
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public boolean getIsInColor() {
        return isInColor;
    }

    public int getLengthMinutes() {
        return lengthMinutes;
    }

    public String getGenre() {
        return genre;
    }


    //***SETTER METHODS***----------------------------------------------------------------------------------------------
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    public void setInColor(boolean inColor) {
        isInColor = inColor;
    }

    public void setLengthMinutes(int lengthMinutes) {
        this.lengthMinutes = lengthMinutes;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    //***OTHER METHODS***-----------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        String result = "";
        result += "Title: " + title + "\n" + "Director: " + director + "\n" + "Year: " + yearCreated + "\n"
                + "Length in minutes: " + lengthMinutes + "\n" + "Genre: " + genre;
        if (isInColor) {
            result += "\n" + "Is in color: Yes";
        } else {
            result += "\n" + "Is in color: No";
        }
        return result + "\n";
    }

    //------------------------------------------------------------------------------------------------------------------
}
