import java.util.Scanner;

public class Quiz_Game {
    public static void main(String[] args) {

        String[] questions = {"What is the main function of a rauter?",
                            "Which part of the computer is considered the brain?",
                            "What year whas facebook founded?",
                            "Who is known as the father of computer?",
                            "What was the first programing language?"};

        String[][] options = {{"1. Storing files", "2.Encrypting data", "3.Directing internet data", "4.Managing passwords"},
                             {"1.CPU", "2.HardDrive", "3.RAM", "4.GPU"},
                             {"1.2000", "2.2004", "3.2006", "4.2008"},
                             {"1.steve jobs", "2.bill gates", "3.alan turning", "4.charles babbage"},
                             {"1.coobold", "2.c", "3.fortran", "4.assambly"}};

        int[] key = {3, 1, 2, 4, 3};
        int score = 0;
        int guess;

        Scanner scanner = new Scanner(System.in);

        System.out.println("******************************");
        System.out.println("Welcome to the Java Quiz Game!");
        System.out.println("******************************");

        for(int i = 0; i < questions.length; i++){
            System.out.println(questions[i]);

            for(String option : options[i]){
                System.out.println(option);
            }

            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();

            if(guess == key[i]){
                System.out.println("*******");
                System.out.println("Correct");
                System.out.println("*******");
                score++;
            }else{
                System.out.println("*****");
                System.out.println("Wrong");
                System.out.println("*****");
            }
        }

        System.out.println("Your final score is: " + score + " out of " + questions.length);

        scanner.close();
    }
}