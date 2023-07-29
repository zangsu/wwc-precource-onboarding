package onboarding;

import java.util.Deque;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {

        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            char peek;
            try{
                peek = deque.peekLast();
            }catch (NullPointerException e){
                deque.addLast(cryptogram.charAt(i));
                continue;
            }

            if(peek == cryptogram.charAt(i))
                deque.removeLast();
            else
                deque.addLast(cryptogram.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }

        return sb.toString();
    }
}