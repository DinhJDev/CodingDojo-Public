public class Samurai extends Human {
    int health = 200;

    static int samuraiCount = 0;

    public Samurai() {
        samuraiCount++;
    }

    public void deathBlow(Human h) {
        h.health = 0;
        this.health = this.health / 2;
    }

    public void meditate() {
        this.health += this.health / 2;
    }

    public static int howMany() {
        return samuraiCount;
    }
}