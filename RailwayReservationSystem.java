import java.util.ArrayList;
import java.util.Scanner;

// Passenger class
class Passenger {
    int id;
    String name;
    int seatNo;

    Passenger(int id, String name, int seatNo) {
        this.id = id;
        this.name = name;
        this.seatNo = seatNo;
    }
}

// Main Railway Reservation System
class RailwayReservationSystem {

    static final int TOTAL_SEATS = 5;
    static ArrayList<Passenger> passengers = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int passengerId = 1;

    // Login method
    static boolean login() {
        String username = "admin";
        String password = "1234";

        System.out.print("Enter Username: ");
        String u = sc.next();
        System.out.print("Enter Password: ");
        String p = sc.next();

        if (u.equals(username) && p.equals(password)) {
            System.out.println("Login Successful!\n");
            return true;
        } else {
            System.out.println("Invalid Credentials!");
            return false;
        }
    }

    // Show available seats
    static void viewSeats() {
        System.out.println("Available Seats: " + (TOTAL_SEATS - passengers.size()));
    }

    // Book ticket
    static void bookTicket() {
        if (passengers.size() >= TOTAL_SEATS) {
            System.out.println("No seats available!");
            return;
        }

        System.out.print("Enter Passenger Name: ");
        sc.nextLine(); // clear buffer
        String name = sc.nextLine();

        int seatNo = passengers.size() + 1;
        Passenger p = new Passenger(passengerId++, name, seatNo);
        passengers.add(p);

        System.out.println("Ticket Booked Successfully!");
        System.out.println("Seat Number: " + seatNo);
    }

    // Cancel ticket
    static void cancelTicket() {
        System.out.print("Enter Passenger ID to Cancel: ");
        int id = sc.nextInt();

        boolean found = false;
        for (Passenger p : passengers) {
            if (p.id == id) {
                passengers.remove(p);
                System.out.println("Ticket Cancelled Successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Passenger ID not found!");
        }
    }

    // Display menu
    static void menu() {
        while (true) {
            System.out.println("\n--- Railway Reservation System ---");
            System.out.println("1. View Available Seats");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> viewSeats();
                case 2 -> bookTicket();
                case 3 -> cancelTicket();
                case 4 -> {
                    System.out.println("Thank you for using the system!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Choice!");
            }
        }
    }

    public static void main(String[] args) {
        if (login()) {
            menu();
        }
    }
}

    
