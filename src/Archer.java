import java.util.Random;

public class Archer extends Character {

    // subclass specific attributes -----------------------------------------

    private Random random = new Random();
    private int marksmanship;
    private int agility;
    private boolean criticalHit;


    // subclass constructor -------------------------------------------------

    public Archer(String name) {
        super(name, 100, 5, 10);
        this.marksmanship = 30;
        this.agility = 10;
        this.criticalHit = random.nextBoolean();
    }


    // subclass specific combat methods -------------------------------------

    @Override
    public void attack(Character target) {
        int archerDamage;
        this.criticalHit = random.nextBoolean();
        if (criticalHit) {
            System.out.println("Bullseye! " + this.getName() + " does a critical hit on " + target.getName() + "!");
            archerDamage = this.getAttackPower() + this.marksmanship;
            target.takeDamage(archerDamage);
        } else {
            System.out.println(this.getName() + " aims and hits " + target.getName() + "!");
            archerDamage = this.getAttackPower();
            target.takeDamage(archerDamage);
        }
    }

    @Override
    public void takeDamage(int damage) {
        if (agility > 2) {
            System.out.println(this.getName() + " swiftly dodges and only gets " + damage + " damage!");
            this.setHealthPoints(this.getHealthPoints() - damage / 3);
            agility--;
        } else {
            System.out.println(this.getName() + " is too hurt to dodge and takes the full " + damage + " damage!");
            this.setHealthPoints(this.getHealthPoints() - damage);
        }
    }
}