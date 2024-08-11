import java.util.Scanner;
import java.util.Random;

public class Randomnum {
    public static void main(String[] args) {

        Random num= new Random();
        int random=num.nextInt(5);
        int input=0;

        while(random!=input)
        {
            System.out.println("---------------------------------------------");
            Scanner sc = new Scanner(System.in);
            System.out.print("Guess any number between the 1 to 100 : ");
            input = sc.nextInt();
            System.out.println("---------------------------------------------");

            if (random == input)
            {
                System.out.println("Congratulations! you guess the correct number.");
            }
            else if (random < input)
            {
                System.out.println("Sorry! Your guessed number is too high.");
            } else
            {
                System.out.println("Sorry! Your guessed number is too low.");
            }
        }
    }
}
