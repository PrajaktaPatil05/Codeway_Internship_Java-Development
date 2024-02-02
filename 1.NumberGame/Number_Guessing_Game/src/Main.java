import java.util.Scanner;

public class Main {

    //create a method to generate the random number
    public static int randomNumber(){

        return (int)(Math.random() * 100) + 1;
    }

    //banner
    public static void printBanner(String message) {
        int width = message.length() + 6;
        String border = "+-" + "-".repeat(width) + "-+";
        String padding = "| " + message + " |";

        System.out.println(border);
        System.out.println(padding);
        System.out.println(border);
    }

    //main method
    public static void main(String[] args) {
        printBanner("\t\tWelcome to Guessing Number Game  \t");

        System.out.println("\nInstructions:");
        System.out.println("You have 5 attempts to guess the number between 1 and 100.");
        System.out.println("Let's begin!\n");
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;

        while(playAgain){
            int random = randomNumber();
            int attempts = 6;
            boolean guessCorrectly = false;
            System.out.println("----------------------------------------------");
            for(int i = 1; i <= attempts; i++) {

                System.out.print("Enter you guess: ");
                int guess = sc.nextInt();

                if(guess == random){
                    System.out.println("Congratulations! You guessed the correct number!!");
                    guessCorrectly = true;
                    break;
                } else if (guess < random) {
                    System.out.println("Too low! Try a higher number.");
                }else{
                    System.out.println("Too high! Try a lower number.");
                }

            }//end for

            System.out.println("----------------------------------------------");

            if(guessCorrectly){
                System.out.println();
               printBanner("\t\tYou won the game!!!  ");
            }else {
                System.out.println();
                System.out.println("Sorry, you've used all your attempts. The correct number was " + random + ".");
            }


            System.out.println("\n\nDo you want to play again? (yes/no): ");
            String response = sc.next();
            playAgain = response.equalsIgnoreCase("yes");

        }

        System.out.print("Thank you for playing :) "); // Print the message
        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(800);
                System.out.print(".");

            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted while waiting for dots to print.");
        }

        sc.close();


    }
}