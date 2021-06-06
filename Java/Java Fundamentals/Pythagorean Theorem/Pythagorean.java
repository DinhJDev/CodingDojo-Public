import static java.lang.Math.sqrt;
public class Pythagorean {
    public double calculateHypotenuse(double legA, double legB) {
        double hypotenuse = Math.sqrt(legA) + Math.sqrt(legB);
        return hypotenuse;
    }
} 