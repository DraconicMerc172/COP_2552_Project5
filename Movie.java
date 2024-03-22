

class Movie extends MovieDirector {
    
    private String title;
    private int yearReleased;
    private String genre;
    private String rating;

    public Movie(String directorName, String composerName, String title, int yearReleased, String genre, String rating) {

        super(directorName, composerName);
        this.title = title;
        this.yearReleased = yearReleased;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public int yearReleased() {

        return yearReleased;
    }

    public int getYearReleased() {

        return yearReleased;
    }

    public void setYearReleased(int yearReleased) {

        this.yearReleased = yearReleased;
    }

    public String getGenre() {

        return genre;
    }

    public void setGenre(String genre) {

        this.genre = genre;
    }

    public String getRating() {

        return rating;
    }

    public void setRating(String rating) {

        this.rating = rating;
    }
}
