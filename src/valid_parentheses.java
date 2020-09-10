import java.util.*;

public class valid_parentheses {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String s = input.nextLine();

        System.out.println(solution(s));

    }


    public static boolean solution (String s) {

//        //法1：暴力求解，即遇到左右括号匹配就进行replace
//
//        while (s.indexOf("()") > -1 || s.indexOf("{}") > -1 || s.indexOf("[]") > -1) {
//            s = s.replace("()", "")
//                    .replace("{}","")
//                    .replace("[]","");
//
//            System.out.println("此时的字符串为: "+s);
//        }
//
//        return s.length() == 0;
        //法2：栈（最近相关性）,每次找到左括号的最近右括号进行匹配

        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};

        Deque<Character> queue = new ArrayDeque<>();

        for (Character c:
             s.toCharArray()) {
            //如果是左括号则入栈
            if (map.containsKey(c)) {
                queue.addFirst(c);
            }else if (queue.isEmpty() || map.get(queue.removeFirst()) != c) {
                //为空时说明第一个字母为右括号元素无法入栈
                //否则说明 c字符是其它位置的右括号，且与栈顶元素不匹配
                return false;
            }
        }

        return queue.isEmpty();
    }

}
