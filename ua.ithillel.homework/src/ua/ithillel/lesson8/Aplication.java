package ua.ithillel.lesson8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Aplication {

    public static void main(String[] args) {
        Integer[] arrayInt = {1, 2, 3, 4, 5};

        List<String> listString = new ArrayList<>();
        Collections.addAll(listString, "sun", "dog", "bat", "food", "sky", "sun", "cat", "bat", "sky", "fish", "sun", "sun", "sun");
        List<Integer> listNumber = new ArrayList<>();
        Collections.addAll(listNumber, 1, 5, 110, 4, 11, 7, 574, 3, 3, 110, 34, 54, 1, 1, 7);
        Integer[] array = {1, 2, 3};

        System.out.println(countOccurance(listString, "sun"));

        toList(array);

        System.out.println(findUnique(listNumber));

        calcOccurance(listString);

        List<String> testList = new ArrayList<>(findOccurance(listString));

        testList.forEach(x -> System.out.println(x));
    }

    public static int countOccurance(List <String> list, String str) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (str.equals(list.get(i))) {
                count++;
            }
        }
        return count;
    }

    public static List<Integer> toList(Integer[] array) {
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        return list;
    }

    public static List<Integer> findUnique(List<Integer> list) {
        List<Integer> uniqueList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!uniqueList.contains(list.get(i))) {
                uniqueList.add(list.get(i));
            }
        }
        return uniqueList;
    }

    public static void calcOccurance(List<String> list) {
        List<String> controlList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (controlList.contains(list.get(i))) {
                continue;
            }
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    controlList.add(list.get(i));
                    count++;
                }
            }
            System.out.println(list.get(i) + " : " + count);

        }
    }

    public static List<String> findOccurance(List<String> list) {
        List<String> newList = new ArrayList<>();
        List<String> controlList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            StringBuilder strBuild = new StringBuilder();
            if (controlList.contains(list.get(i))) {
                continue;
            }
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    count++;
                }
            }
            controlList.add(list.get(i));
            newList.add(strBuild.append("{name: \"").append(list.get(i)).append("\", occurrence: ").append(count).append("}").toString());
        }
        return newList;
    }
}
