package TutorialOOP;

class Player{
    private String name;
    private int baseHealth;
    private int level;
    private int increamenHealth;
    private int baseAttack;
    private int incrementAttack;


    private Armor armor;
    private Weapon weapon;

    public Player(String name){
        this.name = name;
        this.baseHealth = 100;
        this.baseAttack = 30;
        this.level = 1;
        this.increamenHealth = 20;
        this.incrementAttack = 20;

    }
    public void display(){
        System.out.println("Player Name : "+ this.name);
        System.out.println("Level : "+ this.level);
        System.out.println("MaxHealth : "+ this.maxHealth());
        System.out.println("Attack : "+ this.getAttackPower() + "\n");


    }
    public void setArmor(Armor armor){
        this.armor = armor;
    }
    public void setWeapon(Weapon weapon){
        this.weapon = weapon;

    }

    public void levelUp(){
        this.level++;

    }
    public int maxHealth(){
        return this.baseHealth + this.increamenHealth * this.level + this.armor.getaddHealth();
    }
    public int getAttackPower(){
        return this.baseAttack + this.level*this.incrementAttack + this.weapon.getAttack();
    }
}

class Weapon{
    private String name;
    private int attack;
    public Weapon(String name, int attack){
        this.name = name;
        this.attack= attack;
    }
    public int getAttack(){
        return this.attack;
    }
}

class Armor{
   private String name;
   private int strength;
   private int health;
    public Armor(String name, int health, int strength){
        this.name = name;
        this.strength = strength;
        this.health = health;
    }
    public int getaddHealth(){

        return this.strength * 10 + this.health;
    }


}

public class TutorialOOP {

    public static void main(String[] args) {
        System.out.println("=== Pertempuran Dimulai ===");
        //PLayer 1
        Player player1 = new Player("Ucup");
        Armor armor1 = new Armor("Baju Besi",100,40);
        Weapon weapon1 = new Weapon("Keris Gandung",20);

        player1.setArmor(armor1);
        player1.setWeapon(weapon1);

        //PLayer 2
        Player player2 = new Player("Isabella");
        Armor armor2 = new Armor("Baju PLatstik",50,20);
        Weapon weapon2 = new Weapon("Pentung Pak Satpam",5);

        player2.setArmor(armor2);
        player2.setWeapon(weapon2);

        //Display Match Player
        System.out.println("=== Session 1 ===");
        player1.display();
        player2.display();
        //player 1 increament levelUpgrade
        System.out.println("=== Session 2 ===");
        player1.levelUp();
        player1.display();
        player2.display();


    }
}
