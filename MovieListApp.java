import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

// Class to manage the movie list application
class MovieListApp {
    
    // Method to start the application
    public static void start() {
        Map<String, ArrayList<Movie>> moviesByGenre = readMoviesFromFile(); // Read movies from file and categorize by genre
        displayMoviesByGenre(moviesByGenre); // Display movies by genre
    }

    // Method to read movies from file and categorize them by genre
    private static Map<String, ArrayList<Movie>> readMoviesFromFile() {
        Map<String, ArrayList<Movie>> moviesByGenre = new HashMap<>(); // Map to store movies by genre

        try (BufferedReader br = new BufferedReader(new FileReader("MovieLIsting.txt"))) {
            String line;
            String directorName = br.readLine(); // First line contains director's name
            String composerName = br.readLine(); // Second line contains composer's name

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String genre = data[2].trim().toUpperCase(); // Capitalize genre

                Movie movie = new Movie(directorName, composerName, data[0], Integer.parseInt(data[1].trim()), genre, data[3].trim());

                moviesByGenre.computeIfAbsent(genre, k -> new ArrayList<>()).add(movie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        moviesByGenre.values().forEach(MovieListApp::sortMoviesByYear); // Sort movies by year
        return moviesByGenre;
    }

    // Method to sort movies by year
    private static void sortMoviesByYear(ArrayList<Movie> movies) {
        movies.sort(Comparator.comparingInt(Movie::getYearReleased));
    }

    // Method to display movies by genre
    private static void displayMoviesByGenre(Map<String, ArrayList<Movie>> moviesByGenre) {
        moviesByGenre.forEach((genre, movies) -> {
            StringBuilder message = new StringBuilder();
            message.append("<html><h2>").append(genre).append("</h2>")
                    .append("<p>Director: ").append(movies.get(0).getDirectorName()).append("</p>")
                    .append("<p>Composer: ").append(movies.get(0).getComposerName()).append("</p>")
                    .append("<table>")
                    .append("<tr><th>Movie Title</th><th>Year Released</th><th>Rating</th></tr>");
    
            movies.forEach(movie ->
                    message.append("<tr><td>").append(movie.getTitle()).append("</td><td>")
                            .append(movie.getYearReleased()).append("</td><td>")
                            .append(movie.getRating()).append("</td></tr>")
            );
    
            message.append("</table></html>");
            JOptionPane.showMessageDialog(null, new JLabel(message.toString()), "Movies of " + genre, JOptionPane.PLAIN_MESSAGE);
        });
    }    
}
