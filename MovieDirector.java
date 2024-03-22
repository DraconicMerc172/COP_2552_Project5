
public class MovieDirector {
    
    private String directorName;
    private String composerName;

    public MovieDirector(String directorName, String composerName) {

        this.directorName = directorName;
        this.composerName = composerName;
    }

    public String getDirectorName() {

        return directorName;
    }

    public void setDirectorName(String directorName) {

        this.directorName = directorName;
    }

    public String getComposerName() {

        return composerName;
    }

    public void setComposerName(String composerName) {

        this.composerName = composerName;
    }
}
