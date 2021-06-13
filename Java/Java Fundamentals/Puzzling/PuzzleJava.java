import java.util.*;

public class PuzzleJava {
    public ArrayList<Integer> greaterThan10() {
        int[] arr = {3,5,1,2,7,9,8,13,25,32};
        int sum = 0;
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (arr[i] > 10) {
                numbers.add(arr[i]);
            }
        }
        System.out.println("Sum of numbers: " + sum);
        System.out.println("Numbers above 10: " + numbers);

        return numbers;
    }

    public ArrayList<String> shuffleNames() {
        List<String> namesList = Arrays.asList("Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa");
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> namesLonger = new ArrayList<>();

        names.addAll(namesList);

        Collections.shuffle(names);
        System.out.println("Names shuffled: " + names);

        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).length() > 5) {
                namesLonger.add(names.get(i));
            }
        }

        System.out.println("Names longer than 5 characters: " + namesLonger);
        return namesLonger;
    } 

    public void shuffleAlpha() {
        String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");

        List<String> alphaList = Arrays.asList(alphabet);

        Collections.shuffle(alphaList);
        System.out.println("The last alphabet is: " + alphaList.get(alphaList.size()-1));
        System.out.println("The first alphabet is: " + alphaList.get(0));

        if (alphaList.get(0).equals("a") || alphaList.get(0).equals("e") || alphaList.get(0).equals("i") || alphaList.get(0).equals("o") || alphaList.get(0).equals("u") ) {
            System.out.println("The first alphabet is a vowel.");
        }
    }

    public void random10() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        Random ran = new Random();

        for (int i = 0; i < 10; i++){
            numbers.add(ran.nextInt(100 - 55 + 1) + 55);
        }

        System.out.println(numbers);
    }
}