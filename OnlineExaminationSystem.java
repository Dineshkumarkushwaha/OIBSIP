import java.util.Scanner;

public class OnlineExaminationSystem {

    private static final int MAX_QUESTIONS = 5;

    public static void main(String[] args) {
        // Create a new scanner object
        Scanner scanner = new Scanner(System.in);

        // Initialize the variables
        String username = "dsk", password = "1234";
        int subject = 0;
        int[] questions = new int[MAX_QUESTIONS];
        int[] answers = new int[MAX_QUESTIONS];
        long time = 15;

        // Login
        System.out.println("Enter your username: ");
        username = scanner.nextLine();
        System.out.println("Enter your password: ");
        password = scanner.nextLine();

        // Update profile and password
        System.out.println("Do you want to update your profile? (Y/N)");
        String choice = scanner.nextLine();
        if (choice.equals("Y")) {
            System.out.println("Enter your new username: ");
            username = scanner.nextLine();
            System.out.println("Enter your new password: ");
            password = scanner.nextLine();
        }

        // Select subject
        System.out.println("Select the subject for the exam: ");
        System.out.println("1. Hindi");
        System.out.println("2. English");
        System.out.println("3. Math");
        System.out.println("4. Science");
        subject = scanner.nextInt();

        // Create the questions
        if (subject == 1) {
            questions[0] = 1;
            questions[1] = 2;
            questions[2] = 3;
            questions[3] = 4;
            questions[4] = 5;
        } else if (subject == 2) {
            questions[0] = 6;
            questions[1] = 7;
            questions[2] = 8;
            questions[3] = 9;
            questions[4] = 10;
        } else if (subject == 3) {
            questions[0] = 11;
            questions[1] = 12;
            questions[2] = 13;
            questions[3] = 14;
            questions[4] = 15;
        } else if (subject == 4) {
            questions[0] = 16;
            questions[1] = 17;
            questions[2] = 18;
            questions[3] = 19;
            questions[4] = 20;
        }

        // Start the timer
        time = System.currentTimeMillis();

        // Display the questions
        for (int i = 0; i < MAX_QUESTIONS; i++) {
            System.out.println("Question " + (i + 1) + ": ");
            for (int j = 0; j < 4; j++) {
                System.out.println((j + 1) + ". " + questions[i] + ". " + (j + 1));
            }
            System.out.println("Enter your answer: ");
            answers[i] = scanner.nextInt();
        }

        // Auto submit the exam
        System.out.println("Auto submitting the exam...");
        try {
            Thread.sleep(2000); // 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display the results
        int correctAnswers = 0;
        for (int i = 0; i < MAX_QUESTIONS; i++) {
            if (answers[i] == questions[i]) {
                correctAnswers++;
            }
        }
        System.out.println("Your score is " + correctAnswers + "/" + MAX_QUESTIONS);

        // Close the session and logout
        System.out.println("Closing session...");
        System.out.println("Logging out...");

        // Close the scanner
        scanner.close();
    }
}
