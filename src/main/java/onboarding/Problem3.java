package onboarding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {

        LinkedList<String> tokens = new LinkedList<>();
        for (int i = 1; i <= number; i++) {
            String[] token = Integer.toString(i).split("");
            for(String t : token)
                tokens.add(t);
        }

        long result = tokens.stream().filter((String s) ->
                        (s.equals("3") || s.equals("6") || s.equals("9")))
                .count();

        return (int) result;
    }
}
