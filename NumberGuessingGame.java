import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args){

        int Choice;
        do {
            showLevel();
            Choice = Main.getIntegerInput("Choose Between: ");
            switch (Choice){
                case 1:
                    EasyLevel();
                    break;
                case 2:
                    MediumLevel();
                    break;
                case 3:
                    HardLevel();
                    break;
                default:
                    System.out.println("Invalid Option Entered");
            }
        } while (Choice !=3);

    }
    public static void showLevel() {
        System.out.println("1. Easy Level");
        System.out.println("2. Medium Level");
        System.out.println("3. Hard Level");
    }

    public static void EasyLevel(){
        System.out.println("You have Choose the Level Easy 1-10");
        Random random = new Random();
        int EasyLevel = random.nextInt(10)+1;


        Scanner scanner = new Scanner(System.in);
        boolean youWon = false;

        int maxAttempt = 3;

        for (int i = 1; i<=maxAttempt; i++) {
            System.out.print("Attempt " + i + " Enter you Guess: ");

            int guess = scanner.nextInt();

            if (guess < EasyLevel){
                System.out.println("Guess is too low");
            }
            else if (guess > EasyLevel) {
                System.out.println("Guess is too high");
            } else {
                System.out.println("You are correct");
                youWon = true;
                break;
            }

            if (i < maxAttempt){
                System.out.println(STR." \{maxAttempt - i} Attempts left");
            }
        }
        scanner.close();
    }

    public static void MediumLevel(){
        System.out.println("You have Choose the Medium Level 1-50");
        Random random = new Random();
        int MediumLevel = random.nextInt(50)+1;


        Scanner scanner = new Scanner(System.in);
        boolean youWon = false;

        int maxAttempt = 3;

        for (int i = 1; i<=maxAttempt; i++) {
            System.out.println("Attempt " + i + " Enter you Guess: ");

            int guess = scanner.nextInt();

            if (guess < MediumLevel){
                System.out.println("Guess is too low");
            }
            else if (guess > MediumLevel) {
                System.out.println("Guess is too high");
            } else {
                System.out.println("You are correct");
                youWon = true;
                break;
            }

            if (i < maxAttempt){
                System.out.println(STR." \{maxAttempt - i}  Attempts left");
            }
        }
        scanner.close();
    }

    public static void HardLevel(){
        System.out.println("You have Choose the Hard Level 1-100");
        Random random = new Random();
        int HardLevel = random.nextInt(100)+1;


        Scanner scanner = new Scanner(System.in);
        boolean youWon = false;

        int maxAttempt = 3;

        for (int i = 1; i<=maxAttempt; i++) {
            System.out.println("Attempt " + i + " Enter you Guess: ");

            int guess = scanner.nextInt();

            if (guess < HardLevel){
                System.out.println("Guess is too low");
            }
            else if (guess > HardLevel) {
                System.out.println("Guess is too high");
            } else {
                System.out.println("You are correct");
                youWon = true;
                break;
            }

            if (i < maxAttempt){
                System.out.println(STR." \{maxAttempt - i} Attempts left");
            }
        }
        scanner.close();
    }
}





