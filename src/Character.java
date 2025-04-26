abstract public class Character {

    // class attributes --------------------------------------------

    private String name;
    private int healthPoints;
    private int attackPower;
    private int blockPower;


    // superclass constructors -------------------------------------

    public Character(String name, int healthPoints, int attackPower, int blockPower) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.attackPower = attackPower;
        this.blockPower = blockPower;
    }

    public Character(String name) {   // just for the enemies!
        this.name = name;
    }


    // getters and setters -----------------------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getBlockPower() {
        return blockPower;
    }

    public void setBlockPower(int blockPower) {
        this.blockPower = blockPower;
    }


    // combat methods ----------------------------------------------

    public abstract void attack(Character target);
    public abstract void takeDamage(int damage);

    public boolean isDead() {
        return this.healthPoints <= 0;
    }

}
