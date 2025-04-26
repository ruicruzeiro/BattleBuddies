import java.util.Random;

public class Knight extends Character {

    // subclass specific attributes -----------------------------------------

    private Random random = new Random();
    private int rage;
    private int stamina;
    private boolean shieldBlock;


    // subclass constructor -------------------------------------------------

    public Knight(String name) {
        super(name, 150, 15, 20);
        this.rage = 10;
        this.stamina = 3;
        this.shieldBlock = random.nextBoolean();
    }


    // subclass specific combat methods -------------------------------------

    @Override
    public void attack(Character target) {
        int knightDamage;
        if (rage >= 60) {
            System.out.println(this.getName() + " is enraged and strikes " + target.getName() + " twice!");
            knightDamage = this.getAttackPower() * 2;
            target.takeDamage(knightDamage);
            rage -= 20;
        } else {
            System.out.println(this.getName() + " strikes " + target.getName() + "!");
            knightDamage = this.getAttackPower();
            target.takeDamage(knightDamage);
            rage += 10;
        }
    }

    @Override
    public void takeDamage(int damage) {
        this.shieldBlock = random.nextBoolean();
        if (stamina > 0 && shieldBlock) {
            System.out.println(this.getName() + "'s shield blocks all " + damage + " damage!");
            stamina--;
        } else {
            System.out.println(this.getName() + " takes " + damage + " damage!");
            this.setHealthPoints(this.getHealthPoints() - damage);
        }
    }
}
