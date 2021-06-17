public class Wizard extends Human {
    int intelligence = 8;

    int health = 50;

    public void heal(Human h) {
        h.health += this.intelligence;
        System.out.println("Healed " + this.strength + " with healing spell.");
    }

    public void fireball(Human h) {
        h.health -= this.intelligence * 3;
        System.out.println("Inflicted " + (this.intelligence * 3) + "with fireball spell.");
    }
}