import java.util.Random;

public class Mage extends Character {

    // subclass specific attributes -----------------------------------------

    private Random random = new Random();
    private int mana;
    private final int spellPower;
    private boolean magicShield;


    // subclass constructor -------------------------------------------------

    public Mage(String name) {
        super(name, 80, 20, 5);
        this.mana = 100;
        this.spellPower = 10;
        this.magicShield = random.nextBoolean();
    }


    // subclass specific combat methods -------------------------------------

    @Override
    public void attack(Character target) {
        int mageDamage;
        if (mana >= 20) {
            System.out.println(this.getName() + " uses up mana to cast fireball! Burn, " + target.getName() + ", burn!");
            mageDamage = this.getAttackPower() + spellPower;
            target.takeDamage(mageDamage);
            mana -= 20;
        } else {
            System.out.println(this.getName() + " is low on mana and hits " + target.getName() + " with some weak-ass sparks!");
            mageDamage = this.getAttackPower() / 2;
            target.takeDamage(mageDamage);
        }
    }

    @Override
    public void takeDamage(int damage) {
        this.magicShield = random.nextBoolean();
        if (mana >= 10 && magicShield) {
            System.out.println(this.getName() + " manages to cast up a magic shield and blocks " + damage / 2 + " damage!");
            this.setHealthPoints(this.getHealthPoints() - damage / 2);
        } else {
            System.out.println(this.getName() + " takes " + damage + " damage!");
            this.setHealthPoints(this.getHealthPoints() - damage);
        }
    }
}

