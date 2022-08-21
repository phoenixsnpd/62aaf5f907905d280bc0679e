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
        StringBuilder strReverse = new StringBuilder(str);
        return strReverse.reverse().toString();
    }

    public  boolean isPalindrome(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        return str.equals(stringBuilder.reverse().toString());
    }
}
