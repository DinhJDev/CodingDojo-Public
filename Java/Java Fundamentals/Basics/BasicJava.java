import java.util.ArrayList;
import java.lang.Math;

public class BasicJava {
    public void print1To255() {
        for (int i = 1; i <= 255; i++){
            System.out.println(i);
        }
    }

    public void printOddTo255() {
        for (int i = 1; i <= 255; i++){
            if (i % 2 != 0){
                System.out.println(i);
            }
        }
    }

    public void printSum() {
        int sum = 0;

        for (int i = 0; i <= 255; i++){
            sum += i;
            System.out.println("New number: " + i + " Sum: " + sum);
        }
    }

    public void iterateArray() {
        int[] X = {1,3,5,7,9,13};

        for (int i = 0; i < X.length; i++) {
            System.out.println(X[i]);
        }
    }

    public void findMax() {
        int max = -2147483648;
        int[] arr = {-2, 12, 4};

        for (int i = 0; i < arr.length; i++) {
            if (max<arr[i]) {
                max = arr[i];
            }
        }

        System.out.println("The max is: " + max);
    }

    public void getAverage() {
        int sum = 0;
        int[] arr = {-2, 12, 4};

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int average = sum/arr.length;
        System.out.println("The average is: " + average);
    }

    public void arrOddNum() {
        ArrayList<Object> y = new ArrayList<Object>();
        for (int i = 1; i <= 255; i++) {
            if (i%2 != 0) {
                y.add(i);
            }
        }
        System.out.println(y);
    }

    public void greaterThanY() {
        int[] arr = {1,3,5,7};
        int y = 3;
        int greater = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > y) {
                greater++;
            }
        }

        System.out.println("The number if values in the array greater than y is " + greater);
    }

    public void squareValues() {
        int[] arr = {1,5,10,-2};

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i]*arr[i];
        }

        System.out.println(java.util.Arrays.toString(arr));
    }

    public void elimNegatives() {
        int[] arr = {1,5,10,-2};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = 0;
            }
        }
        System.out.println(java.util.Arrays.toString(arr));
    }
    
    public void maxMinAvg() {
        int[] arr = {1,5,10,-2};
        int max = -2147483648;
        int min = 2147483647;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int average = sum/arr.length;

        int[] result = {max, min, average};
        System.out.println(java.util.Arrays.toString(result));
    }

    public void shiftValue() {
        int[] arr = {1,5,10,7,-2};

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                arr[i] = 0;
            } else {
                arr[i] = arr[i+1];
            }
        }

        System.out.println(java.util.Arrays.toString(arr));
    }
}