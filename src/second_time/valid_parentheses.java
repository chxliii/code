package second_time;

import java.util.*;

public class valid_parentheses {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String s = input.nextLine();

        System.out.println(isValid(s));
    }


    public static boolean isValid(String s) {
        //法1：利用map进行匹配

        Map<Character, Character> map = new HashMap<Character, Character>(){{
            put('[',']');
            put('{','}');
            put('(',')');
        }};


        Deque<Character> deque = new ArrayDeque<>();

        for (char c:
             s.toCharArray()) {
            //如果是左括号则进行入栈
            if (map.containsKey(c)) {
                deque.addFirst(c);
            }else if(deque.isEmpty()|| map.get(deque.removeFirst()) != c){
                return false;
            }
        }

        return deque.isEmpty();
    }

}
