package edu.touro.cs.mcon364;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    public MainTest() {
        ArrayList train = new ArrayList<RegExMethods.WordleResponse>();
        train.add(new RegExMethods.WordleResponse('t', 0, RegExMethods.LetterResponse.WRONG_LETTER));
        train.add(new RegExMethods.WordleResponse('r', 1, RegExMethods.LetterResponse.WRONG_LETTER));
        train.add(new RegExMethods.WordleResponse('a', 2, RegExMethods.LetterResponse.WRONG_LETTER));
        train.add(new RegExMethods.WordleResponse('i', 3, RegExMethods.LetterResponse.WRONG_LETTER));
        train.add(new RegExMethods.WordleResponse('n', 4, RegExMethods.LetterResponse.WRONG_LETTER));

        ArrayList cough = new ArrayList<RegExMethods.WordleResponse>();
        cough.add(new RegExMethods.WordleResponse('c', 0, RegExMethods.LetterResponse.WRONG_LOCATION));
        cough.add(new RegExMethods.WordleResponse('o', 1, RegExMethods.LetterResponse.WRONG_LOCATION));
        cough.add(new RegExMethods.WordleResponse('u', 2, RegExMethods.LetterResponse.WRONG_LOCATION));
        cough.add(new RegExMethods.WordleResponse('g', 3, RegExMethods.LetterResponse.WRONG_LOCATION));
        cough.add(new RegExMethods.WordleResponse('h', 4, RegExMethods.LetterResponse.WRONG_LOCATION));

        ArrayList trainAndCough = new ArrayList<ArrayList<RegExMethods.WordleResponse>>();
        trainAndCough.add(train);
        trainAndCough.add(cough);
    }

    @Test
    void properNames() {
        String properNames[] = {"Bob", "Smith", "Joey"};
        for (int i = 0; i < properNames.length; i++) {
            assertTrue(RegExMethods.properName(properNames[i]));
        }

        String notProperNames[] = {"hello", "world", "park"};
        for (int i = 0; i < notProperNames.length; i++) {
            assertFalse(RegExMethods.properName(notProperNames[i]));
        }

    }

    @Test
    void integer() {
        String integerList[] = {"12", "43.23", "-34.5", "98.7", "0"};
        for (int i = 0; i < integerList.length; i++) {
            assertTrue(RegExMethods.integer(integerList[i]));
        }

        String notIntegerList[] = {"hello", "world", "park", "023"};
        for (int i = 0; i < notIntegerList.length; i++) {
            assertFalse(RegExMethods.integer(notIntegerList[i]));
        }
    }

    @Test
    void ancestor() {
        String ancestor[] = {"father", "mother", "grandfather", "grandmother", "great-grandfather", "great-grandmother", "great-great-great-great-great-great-great-great-great-grandfather"};
        for (int i = 0; i < ancestor.length; i++) {
            assertTrue(RegExMethods.ancestor(ancestor[i]));
        }

        String notAncestor[] = {"hello", "world", "park", "Bob", "Smith", "Joey"};
        for (int i = 0; i < notAncestor.length; i++) {
            assertFalse(RegExMethods.ancestor(notAncestor[i]));
        }
    }

    @Test
    void palindrome() {
        String palindrome[] = {"level", "deified", "rotator", "civic", "radar"};
        for (int i = 0; i < palindrome.length; i++) {
            assertTrue(RegExMethods.palindrome(palindrome[i]));
        }

        String notPalindrome[] = {"hello", "world", "park", "Bob", "Smith", "Joey", "father", "mother", "grandfather", "grandmother", "great-grandfather", "great-grandmother", "great-great-great-great-great-great-great-great-great-grandfather"};
        for (int i = 0; i < notPalindrome.length; i++) {
            assertFalse(RegExMethods.palindrome(notPalindrome[i]));
        }
    }

    @Test
    void wordle() throws IOException {
        ArrayList train = new ArrayList<RegExMethods.WordleResponse>();
        train.add(new RegExMethods.WordleResponse('t', 0, RegExMethods.LetterResponse.WRONG_LETTER));
        train.add(new RegExMethods.WordleResponse('r', 1, RegExMethods.LetterResponse.WRONG_LETTER));
        train.add(new RegExMethods.WordleResponse('a', 2, RegExMethods.LetterResponse.WRONG_LETTER));
        train.add(new RegExMethods.WordleResponse('i', 3, RegExMethods.LetterResponse.WRONG_LETTER));
        train.add(new RegExMethods.WordleResponse('n', 4, RegExMethods.LetterResponse.WRONG_LETTER));

        ArrayList cough = new ArrayList<RegExMethods.WordleResponse>();
        cough.add(new RegExMethods.WordleResponse('c', 0, RegExMethods.LetterResponse.WRONG_LOCATION));
        cough.add(new RegExMethods.WordleResponse('o', 1, RegExMethods.LetterResponse.WRONG_LOCATION));
        cough.add(new RegExMethods.WordleResponse('u', 2, RegExMethods.LetterResponse.WRONG_LOCATION));
        cough.add(new RegExMethods.WordleResponse('g', 3, RegExMethods.LetterResponse.WRONG_LOCATION));
        cough.add(new RegExMethods.WordleResponse('h', 4, RegExMethods.LetterResponse.WRONG_LOCATION));

        ArrayList trainAndCough = new ArrayList<ArrayList<RegExMethods.WordleResponse>>();
        trainAndCough.add(train);
        trainAndCough.add(cough);
        //System.out.println(RegExMethods.getWordleWords());
        System.out.println(RegExMethods.wordleRegExGenerator(trainAndCough));
        System.out.println(RegExMethods.wordleMatches(trainAndCough));
    }




}