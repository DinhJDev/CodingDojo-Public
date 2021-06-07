import java.lang.*;
public class StringManipulator {
    public String trimAndConcat(String firstWord, String secondWord) {
        String str = firstWord.trim().concat(secondWord.trim());
        return str;
    }

    public Integer getIndexOrNull(String str, char letter) {
        Integer ind = str.indexOf(letter);
        return ((ind >=0) ? ind : null);
    }

    public Integer getIndexOrNull(String str1, String str2) {
        Integer ind = str1.indexOf(str2);
        return ((ind >=0) ? ind : null);
    }

    public String concatSubstring(String substr, int bInd, int eInd, String str) {
        String result = substr.substring(bInd, eInd);
        return result.concat(str);
    }
}