package dice;

import exception.InvalidNumberException;

import java.util.*;


public class GameDice {

    static Random rand = new Random();
    static Scanner scanner = new Scanner(System.in);

    public GameDice() {

    }

    static List<Integer> predicateForUser = new ArrayList<>();
    static List<Integer> diceForUser = new ArrayList<>();
    static List<Integer> resultForUser = new ArrayList<>();

    static List<Integer> diceForComp = new ArrayList<>();
    static List<Integer> predicateForCom = new ArrayList<>();
    static List<Integer> resultForComp = new ArrayList<>();

    static void game() {
        int input = 0;
        int count = 0;
        int count2 = 3;
        boolean bol = true;
        int userSum = 0;
        int compSum = 0;
        do {
            try {
                System.out.println("---------- Start game ----------");

                System.out.println("Predict amount of points (2...12) ");

                input = scanner.nextInt();
                predicateForUser.add(input);
                if (input < 2 | input > 12) {
                    throw new InvalidNumberException("You enter invalid number: " + input);
                }

                int roll1 = rollTheDice();
                int roll2 = rollTheDice();
                int sum = roll1 + roll2;

                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Do you want to cheat? (Y/N)");
                System.out.println("If you fail, you will lost 10 points");
                String str = scanner1.nextLine();
                if (str.equals("N")) {
                    System.out.println("User don't cheated");
                } else if (str.equals("Y")) {
                    System.out.println("User tried to cheat ");
                    bol=getChanceFirstRound(count2);
                    if (bol) {
                        sum=input;
                        System.out.println("User successfully cheated");
                    }else {
                        userSum+=10;
                        System.out.println("User lost 10 points");
                    }
                }

                System.out.println("User rolls the dices...");

                diceForUser.add(sum);

                Dice.printDice(roll1);
                Dice.printDice(roll2);
                System.out.println("On the dice fell " + sum + " points");

                int point1 = amountSum(sum, input);
                resultForUser.add(point1);

                System.out.println("Result is " + sum + " -abc(" + sum + "-" + input + ")*2: " + point1 + " points");
//                if (point1 > 0) {
//                    System.out.println("User wins");
//                } else {
//                    System.out.println("User lose");
//                }
                System.out.println("------------------------------------");

                int compNum = computerNumber();
                predicateForCom.add(compNum);
                int roll3 = rollTheDice();
                int roll4 = rollTheDice();
                int sum3 = roll3 + roll4;


                int num = rand.nextInt(1,3);
                if (num==1) {
                    System.out.println("Computer don't cheated");
                } else if (num==2) {
                    System.out.println("Computer tried to cheat ");
                    bol=getChanceFirstRound(count2);
                    if (bol) {
                        sum3=input;
                        System.out.println("Computer successfully cheated");
                    }else {
                        compSum+=10;
                        System.out.println("Computer lost 10 points");
                    }
                }
                System.out.println("Computer rolls the dices...");

                diceForComp.add(sum3);

                Dice.printDice(roll3);
                Dice.printDice(roll4);
                System.out.println("On the dice fell " + sum3 + " points");

                int point2 = amountSum(sum3, compNum);
                resultForComp.add(point2);
                System.out.println("Result is " + sum3 + " -abc(" + sum3 + "-" + compNum + ")*2: " + point2 + " points");
//                if (point2 > 0) {
//                    System.out.println("Computer wins");
//                } else {
//                    System.out.println("Computer lose");
//                }
                System.out.println();

                System.out.println("-----------Current score------------- \n" +
                        "User: " + point1 + " points \n" +
                        "Computer " + point2 + " points ");
                if (point1 > point2) {
                    int resUser = point1 - point2;
                    System.out.println("User is ahead by " + resUser + " points!");
                } else {
                    int resComp = point2 - point1;
                    System.out.println("Computer is ahead by " + resComp + " points!");
                }
                System.out.println();

            } catch (InvalidNumberException e) {
                System.err.println(e.getMessage());
            }

            count++;
            count2+=2;

        } while (count < 3);{

        }
        int userTotalPoint=totalPoint(resultForUser)-userSum;
        int compTotalPoint=totalPoint(resultForComp)-compSum;

        printTotalResult();
        System.out.println("---------Lost points during cheating------- \n"+
                "User: "+userSum+"\n"+
                "Computer: "+compSum);
        if (userTotalPoint > compTotalPoint) {
            System.out.println("User win " + userTotalPoint + " points more. Congratulations!");
        } else {
            System.out.println("Computer win " + compTotalPoint + " points more. Congratulations!");
        }
    }

    static void printTotalResult() {

        System.out.println("--------------------Finish game--------------" + "\n" +
                " Round    |          User     |     Computer" + "\n" +
                "----------+-------------------+--------------" + "\n" +
                "          | Predicated: " + predicateForUser.get(0) + "     | Predicated: " + predicateForCom.get(0) + "\n" +
                "   -1-    | Dice: " + diceForUser.get(0) + "           | Dice: " + diceForComp.get(0) + "\n" +
                "          | Result: " + resultForUser.get(0) + "         | Result: " + resultForComp.get(0) + "\n" +
                "----------+------------------+--------------" + "\n" +
                "          | Predicated: " + predicateForUser.get(1) + "     | Predicated: " + predicateForCom.get(1) + "\n" +
                "   -2-    | Dice: " + diceForUser.get(1) + "           | Dice: " + diceForComp.get(1) + "\n" +
                "          | Result: " + resultForUser.get(1) + "         | Result: " + resultForComp.get(1) + "\n" +
                "----------+------------------+--------------" + "\n" +
                "          | Predicated: " + predicateForUser.get(2) + "     | Predicated: " + predicateForCom.get(2) + "\n" +
                "   -3-    | Dice: " + diceForUser.get(2) + "           | Dice: " + diceForComp.get(2) + "\n" +
                "          | Result: " + resultForUser.get(2) + "         | Result: " + resultForComp.get(2) + "\n" +
                "----------+------------------+--------------" + "\n" +
                "          |       Points: " + totalPoint(resultForUser) + "   |     Points: " + totalPoint(resultForComp) + "\n");
    }

    static int totalPoint(List<Integer> point) {
        int sum = 0;
        for (int i = 0; i < point.size(); i++) {
            sum = sum + point.get(i);
        }
        return sum;
    }

    static int amountSum(int sum, int input) {
        int res = sum - Math.abs(sum - input) * 2;
        return res;
    }

    static int rollTheDice() {
        return rand.nextInt(1, 7);
    }

    static int computerNumber() {
        return rand.nextInt(2, 13);
    }

    public static boolean getChanceFirstRound(int count) {
        int n = rand.nextInt(1,count);
        int n1 = rand.nextInt(1,count);
        System.out.println("First number: "+n+" "+"Second number: "+n1);
        return n == n1;
    }

}
