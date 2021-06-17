public class Ninja extends Human {
    int stealth = 10;

    public void steal(Human h) {
        h.health -= this.stealth;
        this.health += this.stealth;
    }

    public void runAway() {
        this.health -= 10;
    }
}