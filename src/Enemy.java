import java.util.Random;

public class Enemy extends Character {

    private Random random = new Random();

    // subclass constructor -------------------------------------------------

    public Enemy(String name) {
        super(name);
        this.setHealthPoints(random.nextInt(50, 150));
        this.setAttackPower(random.nextInt(3, 20));
        this.setBlockPower(random.nextInt(3, 20));
    }


    // subclass specific combat methods -------------------------------------

    @Override
    public void attack(Character target) {
        System.out.println(this.getName() + " hits " + target.getName() + "!");
        int enemyDamage = this.getAttackPower();
        target.takeDamage(enemyDamage);
    }

    @Override
    public void takeDamage(int damage) {
        System.out.println(this.getName() + " takes " + damage + " damage!");
        this.setHealthPoints(this.getHealthPoints() - damage);
        }
    }

