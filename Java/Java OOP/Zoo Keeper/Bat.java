public class Bat extends Mammal {
    public int energyLevel = 300;

    public void fly() {
        System.out.println("Woosh!");
        energyLevel -= 50;
    }
    
    public void eatHumans() {
        energyLevel += 25;
    }

    public void attackTown() {
        System.out.println("AAAAAH!");
        energyLevel -= 100;
    }

    public void displayEnergy() {
        System.out.println(energyLevel);
    }
}