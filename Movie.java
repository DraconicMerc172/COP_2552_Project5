// Class representing a Movie
class Movie extends MovieDirector {
    
    private String title;
    private int yearReleased;
    private String rating;

    // Constructor
    public Movie(String directorName, String composerName, String title, int yearReleased, String genre, String rating) {
        super(directorName, composerName);
        this.title = title;
        this.yearReleased = yearReleased;
        this.rating = rating;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public String getRating() {
        return rating;
    }
}