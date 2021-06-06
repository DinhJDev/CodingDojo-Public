public class PythagoreanTest {
    public static void main(String[] args) {
        Pythagorean p = new Pythagorean();

        double hypotenuse = p.calculateHypotenuse(2,3);
        System.out.println("The hypotenuse is " + hypotenuse);
    }
}