package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        /*
        Ожидаемый вывод:
        home - (5, 3) - (2, 0)
        same - (1, 1) - (4, 1)
* */
        List<Word> myList = detectAllWords(crossword, "home", "same");
        for (Word w : myList) System.out.println(w);
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        int xMax = crossword[0].length - 1;
        int yMax = crossword.length - 1;

        List<Word> listOfDetectedWords = new ArrayList<>();

        for (String word : words) {
            for (int y = 0; y <= yMax; y++) {
                for (int x = 0; x <= xMax; x++) {
                    Word result = search(x, y, word, crossword);
                    if (result != null) listOfDetectedWords.add(result);
                }
            }
        }
        return listOfDetectedWords;
    }


    public static Word search(int posX, int posY, String word, int[][] crossword) {
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) continue;
                Coordinate end = scanDirection(posX, posY, x, y, word.toCharArray(), crossword);
                if (end != null) {
                    Word detectedWord = new Word(word);
                    detectedWord.setStartPoint(posX, posY);
                    detectedWord.setEndPoint(end.x, end.y);
                    return detectedWord;
                }
            }
        }
        return null;
    }

    public static Coordinate scanDirection(int posX, int posY, int dirX, int dirY, char[] word, int[][] crossword) {
        int currentX = posX;
        int currentY = posY;
        int size = word.length;

        for (int i = 0; i < size; i++) {
            try {
                if (word[i] == crossword[currentY][currentX]) {
                    if (i == size - 1) return new Coordinate(currentX, currentY);
                    currentX += dirX;
                    currentY += dirY;
                } else return null;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return null;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }

    public static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}