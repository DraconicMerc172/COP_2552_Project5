import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MovieListApp {
    
    public static void start() {

        ArrayList<Movie> sciFiMovies = new ArrayList<>();
        ArrayList<Movie> adventureMovies = new ArrayList<>();
        ArrayList<Movie> dramaMovies = new ArrayList<>();
        ArrayList<Movie> warMovies = new ArrayList<>();
        ArrayList<Movie> romanceMovies = new ArrayList<>();
        ArrayList<Movie> thrillerMovies = new ArrayList<>();
        ArrayList<Movie> fantasyMovies = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("MovieLIsting.txt"))) {

            String line;
            String directorName = br.readLine();
            String composerName = br.readLine();

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");
                String title = data[0];
                int yearReleased = Integer.parseInt(data[1].trim());
                String genre = data[2].trim();
                String rating = data[3].trim();

                Movie movie = new Movie(directorName, composerName, title, yearReleased, genre, rating);

                switch (genre.toLowerCase()) {

                    case "sci fi":
                        sciFiMovies.add(movie);
                        break;

                    case "adventure":
                        adventureMovies.add(movie);
                        break;

                    case "drama":
                        dramaMovies.add(movie);
                        break;

                    case "war":
                        warMovies.add(movie);
                        break;

                    case "romance":
                        romanceMovies.add(movie);
                        break;

                    case "thriller":
                        thrillerMovies.add(movie);
                        break;

                    case "fantasy":
                        fantasyMovies.add(movie);
                        break;

                    default:
                        System.out.println("Unknown genre: " + genre);
                        break;
                }
            }
        }

        catch (IOException e) {

            e.printStackTrace();
        }

        sortMoviesByYear(sciFiMovies);
        sortMoviesByYear(adventureMovies);
        sortMoviesByYear(dramaMovies);
        sortMoviesByYear(warMovies);
        sortMoviesByYear(romanceMovies);
        sortMoviesByYear(thrillerMovies);
        sortMoviesByYear(fantasyMovies);

        displayMoviesByGenre("Sci Fi", sciFiMovies);
        displayMoviesByGenre("Adventure", adventureMovies);
        displayMoviesByGenre("Drama", dramaMovies);
        displayMoviesByGenre("War", warMovies);
        displayMoviesByGenre("Romance", romanceMovies);
        displayMoviesByGenre("Thriller", thrillerMovies);
        displayMoviesByGenre("Fantasy", fantasyMovies);
    }

    private static void sortMoviesByYear(ArrayList<Movie> movies) {

        Collections.sort(movies, (m1, m2) -> m1.getYearReleased() - m2.getYearReleased());
    }

    private static void displayMoviesByGenre(String genre, ArrayList<Movie> movies) {

        StringBuilder message = new StringBuilder();

        message.append("<html>");
        message.append("<h2>").append(genre).append("</h2>");
        message.append("<table>");
        message.append("<tr><th>Movie Title</th><th>Year Released</th><th>Rating</th></tr>");

        for (Movie movie : movies) {

            message.append("<tr><td>").append(movie.getTitle()).append("</td><td>")
                .append(movie.getYearReleased()).append("</td><td>")
                .append(movie.getRating()).append("</td></tr>");
        }

        message.append("</table></html>");

        JOptionPane.showMessageDialog(null, new JLabel(message.toString()), "Movies of " + genre, JOptionPane.PLAIN_MESSAGE);
    }
}
