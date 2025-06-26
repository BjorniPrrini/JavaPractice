import java.util.Random;
import java.util.Scanner;

public class Slot_Machine {
    public static void main(String[] arvs) {

        Scanner scanner = new Scanner(System.in);

        int balance = 100;
        int bet;
        int payout;
        String[] row;
        String playAgain;

        System.out.println("*****************************");
        System.out.println("Welcome to Java Slot Machine!");
        System.out.println("Symbols: 🍒 🍉 🍋 🔔 ⭐");
        System.out.println("*****************************");

        while(balance > 0){
            System.out.println("Current balance: $" + balance);
            System.out.print("Place your bet ammount: ");
            bet = scanner.nextInt();
            scanner.nextLine();

            if(bet > balance){
                System.out.println("Insuficient funds!");
                continue;
            }else if(bet <= 0){
                System.out.println("Bet must be greater than 0!");
                continue;
            }else{
                balance -= bet;
            }

            System.out.println("Spining....");
            row = spinRow();
            printRow(row);
            payout = getPayout(row, bet);

            if(payout > 0){
                System.out.println("You won $" + payout);
                balance += payout;
            }else{
                System.out.println("You lost. Try Again!");
            }

            System.out.println("Do you want to play again? [Y/N]: ");
            playAgain = scanner.nextLine().toUpperCase();

            if(!playAgain.equals("Y")){
                break;
            }
        }

        System.out.println("*******************");
        System.out.println("Thanks for playing!");
        System.out.println("*******************");

        scanner.close();
    }

    static String[] spinRow(){

        String[] symbols = {"🍒", "🍉", "🍋", "🔔", "⭐"};
        String[] row = new String[3];
        Random random = new Random();

        for(int i = 0; i < 3; i++){
            row[i] = symbols[random.nextInt(symbols.length)];
        }

        return row;
    }

    static void printRow(String[] row){

        System.out.println("**************");
        System.out.println(" " + String.join(" | ", row));
        System.out.println("**************");
    }

    static int getPayout(String[] row, int bet){
        
        if(row[0].equals(row[1]) && row[1].equals(row[2])){
            return switch(row[0]){
                case "🍒" -> bet * 2;
                case "🍉" -> bet * 3;
                case "🍋" -> bet * 4;
                case "🔔" -> bet * 5;
                case "⭐" -> bet * 10;
                default -> 0;
            };
        }else if(row[0].equals(row[1])){
            return switch(row[0]){
                case "🍒" -> bet * 1;
                case "🍉" -> bet * 1;
                case "🍋" -> bet * 1;
                case "🔔" -> bet * 1;
                case "⭐" -> bet * 2;
                default -> 0;
            };
        }else if(row[1].equals(row[2])){
            return switch(row[1]){
                case "🍒" -> bet * 1;
                case "🍉" -> bet * 1;
                case "🍋" -> bet * 1;
                case "🔔" -> bet * 1;
                case "⭐" -> bet * 2;
                default -> 0;
            };
        }

        return 0;
    }
}