package ua.ithllel.homework;

public class Homework {

    public int findSymbolOccurance(String str, char ch) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                result++;
            }
        }
        return result;
    }

    public int findWordPosition (String source, String target) {
        return source.indexOf(target);
    }

    public String stringReverse(String str) {
        char[] array = str.toCharArray();
        for (int i = 0, y = array.length - 1; i < array.length / 2; i++, y--) {
            char temp = 0;
            temp = array[i];
            array[i] = array[y];
            array[y] = temp;
        }
        return new String(array);
    }

    public  boolean isPalindrome(String str) {
        for (int i = 0, y = str.length() - 1; i < str.length() / 2; i++, y--) {
            if (str.charAt(i) != str.charAt(y)) {
                return false;
            }
        }
        return true;
    }
}
