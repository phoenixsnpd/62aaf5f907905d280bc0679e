package ua.ithllel.homework;

import java.util.Scanner;

public class GuessTheWord {
    String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public String chooseWord() {
        String word = words[(int) (Math.random() * words.length)];
        return word;
    }

    public void startGame() {
        String secretWord = chooseWord();
        char[] hiddenString = {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'};
        Scanner scan = new Scanner(System.in);
        System.out.println("The word is guessed, try to guess =)");

        while (true) {
            String answer = scan.nextLine();
            if (answer.equals(secretWord)) {
                System.out.println("You guessed it!");
                break;
            }
            if (!answer.equals(secretWord)) {
                System.out.println("The word is wrong(((");
                for (int i = 0; i < secretWord.length() && i < answer.length(); i++) {
                    if (answer.charAt(i) == secretWord.charAt(i)) {
                        hiddenString[i] = answer.charAt(i);
                    }
                }
            }
            System.out.println("matching letters: " + String.valueOf(hiddenString));
            System.out.println("Try again!");
        }
    }
}
