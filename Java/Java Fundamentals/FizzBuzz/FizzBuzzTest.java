public class FizzBuzzTest {
    public static void main(String[] args) {
        FizzBuzz  fB = new FizzBuzz();

        String result1 = fB.fizzBuzz(3);
        String result2 = fB.fizzBuzz(5);
        String result3 = fB.fizzBuzz(15);
        String result4 = fB.fizzBuzz(2);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }
}