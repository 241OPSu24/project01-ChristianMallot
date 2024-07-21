
import java.util.Scanner;


/**
 *
 * @author
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] smithVotes = new int[3];
        int[] pewterschmidtVotes = new int[3];
        
        System.out.println("Enter your votes for each candidate by precinct");
            System.out.println();

        // Input votes for each candidate by precinct
        for (int i = 0; i < 3; i++) {
            System.out.println("Precinct " + (i + 1) + " votes:");
            System.out.print("Mr. Smith votes: ");
            smithVotes[i] = scanner.nextInt();
            System.out.print("Carter Pewterschmidt votes: ");
            pewterschmidtVotes[i] = scanner.nextInt();
            System.out.println();
        }

        // Calculate total votes for each candidate
        int totalSmithVotes = findTotalVotes(smithVotes);
        int totalPewterschmidtVotes = findTotalVotes(pewterschmidtVotes);

        // Display the votes for each candidate
        System.out.println("The votes for each candidate are:");
        System.out.println("Mr. Smith: " + totalSmithVotes);
        System.out.println("Carter Pewterschmidt: " + totalPewterschmidtVotes);

        System.out.println();
        
        // Determine and display the winner
        displayWinner(totalSmithVotes, totalPewterschmidtVotes);

        System.out.println();
        
        // Allow for recounts
        while (true) {
            System.out.print("Do you have any recounts? 1 for Yes, 2 for No: ");
            int recount = scanner.nextInt();
            if (recount == 2) {
                break;
            }

            System.out.println();
            
            System.out.println("Select the appropriate candidate number below.");
            System.out.println("1. Mr. Smith");
            System.out.println("2. Carter Pewterschmidt");
            System.out.print("Candidate number: ");
            int candidateNumber = scanner.nextInt();

            System.out.println();
            
            System.out.println("Please select a precinct to change");
            System.out.println("1. Precinct 1");
            System.out.println("2. Precinct 2");
            System.out.println("3. Precinct 3");
            System.out.print("Precinct number: ");
            int precinctNumber = scanner.nextInt();

            System.out.println();
            
            System.out.print("Please enter the number of votes: ");
            int newVotes = scanner.nextInt();

            System.out.println();
            
            if (candidateNumber == 1) {
                smithVotes[precinctNumber - 1] = newVotes;
            } else if (candidateNumber == 2) {
                pewterschmidtVotes[precinctNumber - 1] = newVotes;
            }

            System.out.println();
            
            // Recalculate total votes
            totalSmithVotes = findTotalVotes(smithVotes);
            totalPewterschmidtVotes = findTotalVotes(pewterschmidtVotes);

            // Display the votes for each candidate
            System.out.println("The votes for each candidate are:");
            System.out.println("Mr. Smith: " + totalSmithVotes);
            System.out.println("Carter Pewterschmidt: " + totalPewterschmidtVotes);

            System.out.println();
            
            // Determine and display the winner
            displayWinner(totalSmithVotes, totalPewterschmidtVotes);
        }

        scanner.close();
    }

    public static int findTotalVotes(int[] votes) {
        int total = 0;
        for (int vote : votes) {
            total += vote;
        }
        return total;
    }

    public static void displayWinner(int firstCandidate, int secondCandidate) {
        if (firstCandidate > secondCandidate) {
            System.out.println("Mr. Smith with " + firstCandidate + " votes is the winner");
        } else if (secondCandidate > firstCandidate) {
            System.out.println("Carter Pewterschmidt with " + secondCandidate + " votes is the winner");
        } else {
            System.out.println("It is a tie!");
        }
    }
}
