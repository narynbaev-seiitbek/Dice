package dice;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

          GameDice.game();
          boolean b = true;
            do {
                System.out.println("------------------------------------------");
                System.out.println("Do you want to play one more time? (Y/N)");
                String str = scanner.nextLine();
                if (str.equals("Y")) {
                    GameDice.game();
                } else if (str.equals("N")) {
                    System.out.println("Bye Bye!!!");
                    b=false;
                }
            }while (b);
    }

}
