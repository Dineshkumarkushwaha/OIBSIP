import java.util.Scanner;
import java.util.Random;

public class OnlineReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String validLoginId = "Dineshkumar2023";
        String validPassword = "dinesh1234";

        System.out.print("Enter login id: ");
        String loginId = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (loginId.equals(validLoginId) && password.equals(validPassword)) {
            System.out.println("Login successful!");

            boolean exit = false;
            while (!exit) {

                System.out.println("\nOptions :");
                System.out.println("1. Make a reservation");
                System.out.println("2. Cancel your reservation");
                System.out.println("3. Exit");

                System.out.print("Enter option: ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        makeReservation(scanner);
                        break;
                    case 2:
                        cancelReservation(scanner);
                        break;
                    case 3:
                        exit = true;
                        System.out.println("Exiting the system...");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        } else {
            System.out.println("Invalid login id or password. Access denied.");
        }
    }

    private static void makeReservation(Scanner scanner) {

        System.out.println("\n Welcome in Railway Reservation System");
        System.out.println("---------------------------------------");

        String name;
        do {
            System.out.print("Enter your name : ");
            name = scanner.nextLine();
        } while (!name.matches("[a-zA-Z ]+"));

        String Age;
        do {
            System.out.print("Enter Your Age : ");
            Age = scanner.nextLine();
        } while (!Age.matches("\\d{2}"));

        String Gender;
        do {
            System.out.print("Enter Your Gender : ");
            Gender = scanner.nextLine();
        } while (!Gender.matches("^(Male|Female|m|M|F|f|MALE|FEMALE|male|female)$"));

        String trainNumber;
        do {
            System.out.print("Enter Train number : ");
            trainNumber = scanner.nextLine();
        } while (!trainNumber.matches("\\d{5}"));

        String trainName;
        do {
            System.out.print("Enter Train name : ");
            trainName = scanner.nextLine();
        } while (!trainName.matches("[a-zA-Z ]+"));

        String classType;
        do {
            System.out.print("Enter class type (e.g., Sleeper, Second Class, AC First, AC Second, AC Third): ");
            classType = scanner.nextLine();
        } while (!classType.matches("^(Sleeper|Second Class|AC First|AC Second|AC Third)$"));

        String dateOfJourney;
        do {
            System.out.print("Enter date of journey (dd/mm/yyyy): ");
            dateOfJourney = scanner.nextLine();
        } while (!dateOfJourney.matches("^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4}$"));

        System.out.print("Enter source Station : ");
        String source = scanner.nextLine();

        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();

        System.out.print("Press 'Submit' button to confirm reservation: ");
        String insertButton = scanner.nextLine();

        if (insertButton.equalsIgnoreCase("Submit")) {
            Random random = new Random();
            int pnrNumber = random.nextInt(90000000) + 10000000;
            System.out.println("Reservation successful! Your PNR number is: " + pnrNumber);
        } else {
            System.out.println("Reservation canceled.");
        }
    }

    private static void cancelReservation(Scanner scanner) {

        System.out.println("\nCancellation Form");
        System.out.println("-----------------");

        String pnrNumber;
        do {
            System.out.print("Enter your PNR number: ");
            pnrNumber = scanner.nextLine();
        } while (!pnrNumber.matches("\\d{8}"));

        System.out.println("Ticket information for PNR number: " + pnrNumber);

        System.out.print("Press 'OK' button to confirm cancellation: ");
        String cancelButton = scanner.nextLine();

        if (cancelButton.equalsIgnoreCase("ok")) {
            System.out.println("Ticket successfully cancelled!");
        } else {
            System.out.println("Cancellation cancelled.");
        }
    }
}