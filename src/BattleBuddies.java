//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.Random;

public class BattleBuddies {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        // choose your character -------------------------------------

        int[] validChoices = {1, 2, 3};
        boolean isValid = false;
        int characterChoice = -1;

        while (!isValid) {
            System.out.println("Choose your character:");
            System.out.println("1. Knight\n2. Mage\n3. Archer");
            characterChoice = scanner.nextInt();
            scanner.nextLine();
            for (int value : validChoices) {
                if (characterChoice == value) {
                    isValid = true;
                    break;
                }
            }
            if (!isValid) {
                System.out.println("Invalid character choice. Try again.");
            }
        }

        Character player = null;
        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();

        switch (characterChoice) {
            case 1:
                player = new Knight(name);
                break;
            case 2:
                player = new Mage(name);
                break;
            case 3:
                player = new Archer(name);
                break;
        }


        // create your enemy -------------------------------------

        Character enemy = new Enemy("Goblin");


        // combat begins -------------------------------------

        System.out.println("\nCombat begins between " + player.getName() + " and " + enemy.getName() + "!\n");
        System.out.println(player.getName() + " HP: " + player.getHealthPoints());
        System.out.println(enemy.getName() + " HP: " + enemy.getHealthPoints());
        System.out.println("Press Enter to continue...");
        scanner.nextLine();

        int turn = 1;
        while (!player.isDead() && !enemy.isDead()) {
            System.out.println("********* Turn " + turn + " *********");
            System.out.println();

            // player attack
            player.attack(enemy);
            if (enemy.isDead()) {
                System.out.println(enemy.getName() + " has been defeated!");
                break;
            }

            System.out.println();

            // enemy attack
            enemy.attack(player);
            if (player.isDead()) {
                System.out.println(player.getName() + " has been defeated!");
                break;
            }

            // print combat stats
            System.out.println();
            System.out.println(player.getName() + " HP: " + player.getHealthPoints());
            System.out.println(enemy.getName() + " HP: " + enemy.getHealthPoints());
            System.out.println("Press Enter to continue...");
            scanner.nextLine();

            turn++;
        }

        System.out.println("*** Battle Over ***");
        System.out.println();
        if (!player.isDead()) {
            System.out.println(player.getName() + " wins!");
        } else {
            System.out.println(enemy.getName() + " wins!");
        }

        scanner.close();
    }
}
