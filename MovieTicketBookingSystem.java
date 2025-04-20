import java.util.*;

class Movie {
    String title;
    int availableSeats;

    Movie(String title, int availableSeats) {
        this.title = title;
        this.availableSeats = availableSeats;
    }

    void bookTickets(int number) {
        this.availableSeats -= number;
    }
}

public class MovieTicketBookingSystem {
    static Scanner scanner = new Scanner(System.in);
    static Map<Integer, Movie> movies = new HashMap<>();

    public static void main(String[] args) {
        // Initial movie list
        movies.put(1, new Movie("Inception", 50));
        movies.put(2, new Movie("The Matrix", 30));
        movies.put(3, new Movie("Interstellar", 40));

        System.out.println("🎬 Welcome to Movie Ticket Booking System 🎫\n");

        while (true) {
            showMovies();
            System.out.print("\nEnter movie number to book (or 0 to exit): ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Thanks for visiting. Goodbye!");
                break;
            }

            if (!movies.containsKey(choice)) {
                System.out.println("Invalid movie selection. Try again.");
                continue;
            }

            Movie selectedMovie = movies.get(choice);
            System.out.print("Enter number of tickets: ");
            int tickets = scanner.nextInt();

            if (tickets <= 0) {
                System.out.println("Invalid number of tickets.");
            } else if (tickets > selectedMovie.availableSeats) {
                System.out.println("Not enough seats available. Only " + selectedMovie.availableSeats + " left.");
            } else {
                selectedMovie.bookTickets(tickets);
                System.out.println("Successfully booked " + tickets + " tickets for \"" + selectedMovie.title + "\"!");
            }
        }
    }

    static void showMovies() {
        System.out.println("\nAvailable Movies:");
        for (Map.Entry<Integer, Movie> entry : movies.entrySet()) {
            int id = entry.getKey();
            Movie movie = entry.getValue();
            System.out.println(id + ". " + movie.title + " (" + movie.availableSeats + " seats left)");
        }
    }
}
