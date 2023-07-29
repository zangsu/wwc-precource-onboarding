package onboarding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem4 {
    public static String solution(String word) {
        HashMap<Character, Character> encoding = new HashMap();

        IntStream lowerCase = IntStream.iterate('a', a -> a <= 'z', a -> a+1);
        lowerCase.forEach(a -> {
            char goal = (char)(('z'+'a') - a);
            encoding.put((char)a, goal);
        });
        IntStream upperCase = IntStream.iterate('A', a -> a <= 'Z', a -> a+1);
        upperCase.forEach(a -> {
            char goal = (char)(('Z'+'A') - a);
            encoding.put((char)a, goal);
        });
        encoding.put(' ', ' ');

        StringBuilder sb = new StringBuilder();
        Stream<String> tokens = Arrays.stream(word.split(""));
        tokens.forEach(s -> {
            char c = s.charAt(0);
            sb.append(encoding.get(c));
        });


        return sb.toString();
    }
}
