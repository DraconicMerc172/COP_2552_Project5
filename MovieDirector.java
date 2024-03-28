// Class representing a Movie Director
class MovieDirector {
    
    private String directorName;
    private String composerName;

    // Constructor
    public MovieDirector(String directorName, String composerName) {
        this.directorName = directorName;
        this.composerName = composerName;
    }

    // Getters
    public String getDirectorName() {
        return directorName;
    }

    public String getComposerName() {
        return composerName;
    }
}