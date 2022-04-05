package dice;

public class Dice {

    static void printDice(int dice) {

        switch (dice) {
            case 1:
                System.out.println("""
                        +---------+
                        |         |
                        |   #     |
                        |         |
                        +---------+
                        """);
                break;
            case 2:
                System.out.println("""
                        +---------+
                        |         |
                        | #   #   |
                        |         |
                        +---------+
                        """);
                break;
            case 3:
                System.out.println("""
                        +---------+
                        |  #  #   |
                        |         |
                        |   #     |
                        +---------+
                        """);
                break;
            case 4:
                System.out.println("""
                        +---------+
                        | #    #  |
                        |         |
                        | #    #  |
                        +---------+
                        """);
                break;
            case 5:
                System.out.println("""
                        +---------+
                        | #    #  |
                        |    #    |
                        | #    #  |
                        +---------+
                        """);
                break;
            case 6:
                System.out.println("""
                        +---------+
                        | #    #  |
                        | #    #  |
                        | #    #  |
                        +---------+
                        """);
                break;
            default:
        }
    }
}
