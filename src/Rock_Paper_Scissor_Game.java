import java.util.Random;
import java.util.Scanner;

public class Rock_Paper_Scissor_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        String[] choice = {"rock", "paper", "scissors"};
        String playChoice;
        String computerChoice;
        String playAgain = "yes";

        do{System.out.print("Enter your move: ");
            playChoice = scanner.nextLine().toLowerCase();

            if(!playChoice.equals("rock") && !playChoice.equals("paper") && !playChoice.equals("scissors")){
                System.out.println("Not a valid chooice!");
                continue;
            }

            computerChoice = choice[random.nextInt(3)];
            System.out.println("Computer chooice: " + computerChoice);

            if(playChoice.equals(computerChoice)){
                System.out.println("It's a tie!");
            }else if((playChoice.equals("rock") && computerChoice.equals("scissors")) || (playChoice.equals("paper") && computerChoice.equals("rock")) || playChoice.equals("scissors") && computerChoice.equals("paper")){
                System.out.println("You win!");
            }else{
                System.out.println("You loose!");
            }

            System.out.print("Play again: ");
            playAgain = scanner.nextLine().toLowerCase();

        }while(playAgain.equals("yes"));
    
        System.out.println("Thanks for playing!");

        scanner.close();
    }
}