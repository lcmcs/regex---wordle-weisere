package edu.touro.cs.mcon364;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExMethods {

    public static boolean properName(String s) {
        Pattern properName = Pattern.compile("^[A-Z][a-z]{2,}$");
        Matcher mat = properName.matcher(s);
        return mat.matches();
    }


    public static boolean integer(String s) {
        Pattern properName = Pattern.compile("^[+-]?((?!0\\d)\\d*|[1-9]\\d*)(\\.\\d+)?$");
        Matcher mat = properName.matcher(s);
        return mat.matches();
    }


    public static boolean ancestor(String s) {
        Pattern properName = Pattern.compile("^(?:(?:great-)*grand)?(father|mother)$");
        Matcher mat = properName.matcher(s);
        return mat.matches();
    }

    public static boolean palindrome(String s) {
        String regex = palindromeRegexGenerator(s.length());
        Pattern properName = Pattern.compile(regex);
        Matcher mat = properName.matcher(s);
        return mat.matches();
    }

    public static String palindromeRegexGenerator(int length) {
        StringBuilder regex = new StringBuilder("^");
        for (int i = 0; i < length / 2; i++) {
            regex.append("(\\w)");
        }
        if (length % 2 == 1) {
            regex.append("(\\w)");
        }
        for (int i = (length / 2) - 1; i >= 0; i--) {
            regex.append("\\").append(i + 1);
        }
        regex.append("$");
        return regex.toString();
    }

    static class WordleResponse {
        char c;
        int index;
        LetterResponse resp;

        public WordleResponse(char c, int index, LetterResponse resp){
            this.c = c;
            this.index = index;
            this.resp = resp;
        }

        public char getC() {return c;}

        public int getIndex() {return index;}

        public LetterResponse getResp() {return resp;}
    }


    enum LetterResponse {
        CORRECT_LOCATION, // Green
        WRONG_LOCATION,   // Yellow
        WRONG_LETTER
    }    // Gray

    public static List<String> wordleMatches(List<List<WordleResponse>> responses) throws IOException {
        List<String> matches = new ArrayList<>();
        String wordleRegEx = wordleRegExGenerator(responses);
        Pattern pattern = Pattern.compile(wordleRegEx);

        ArrayList strings = (ArrayList) getWordleWords();
        for (Object string : strings) {
            Matcher matcher = pattern.matcher((String) string);
            while (matcher.find()) {
                matches.add(matcher.group());
            }
        }

        return matches;
    }


    public static String wordleRegExGenerator(List<List<WordleResponse>> responses){
        StringBuilder regexBuilder = new StringBuilder("^");
        for (int i = 0; i < responses.size(); i++) {
            regexBuilder.append("[^");
            List<WordleResponse> wordleResponse = responses.get(i);
            for (int j = 0; j < wordleResponse.size(); j++) {
                WordleResponse response = wordleResponse.get(j);
                switch (response.getResp()) {
                    case CORRECT_LOCATION:
                        regexBuilder.append(response.getC());
                        break;
                    case WRONG_LOCATION:
                        regexBuilder.append(String.format("(?!.*^%s)", response.getC()));
                        break;
                    case WRONG_LETTER:
                        regexBuilder.append(String.format("(?!.*%s)", response.getC()));
                        break;
                }
            }
            regexBuilder.append("]");
        }
        regexBuilder.append("$");
        return regexBuilder.toString();
    }

    public static List<String> getWordleWords() throws IOException {
        InputStream inputStream = RegExMethods.class.getResourceAsStream("valid-wordle-words.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        List<String> wordleWords = new ArrayList<String>();
        String line;
        while ((line = reader.readLine()) != null) {
            wordleWords.add(line);
        }

        reader.close();
        return wordleWords;
    }

}
