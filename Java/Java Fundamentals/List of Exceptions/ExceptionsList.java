import java.util.*;

class TestException extends Exception{}
class TestProgram {
    public boolean testTry() throws TestException{
        System.out.println("Index: " + i + " Value: " + myList.get(i));
        throw new TestException();
    }
}

public class ExceptionsList {
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        try {
            for(int i = 0; i < myList.size(); i++) {
                Integer castedValue = (Integer) myList.get(i);
            }
        } catch (TestException e) {

        }
    }
}

