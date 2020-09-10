import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class detectAndReplace {

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);

        String detectWord = src.nextLine();

        String setence = src.nextLine();

        String replaced = src.nextLine();


        detetctAndReplace(detectWord, setence, replaced);






    }

    public static void detetctAndReplace(String word, String sentence, String replaced) {
        int wordLength = word.length();

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < wordLength; i++){
            map.put(word.charAt(i), i);
        }

        String[] words = sentence.split(" ");

        for(int i = 0; i < words.length; i++) {
            int count = 0;
            for(int j = 0; j < wordLength; j++) {
                //如果单词中含有，则继续拆分

                if (words[i].length() >= wordLength && map.get(words[i].charAt(j)) != null) {
                    count++;
                }

                if(count == wordLength){
                    words[i] = replaced;
                }
            }

        }

        StringBuilder st = new StringBuilder();

        for (int i = 0; i < words.length; i++){
            if(i == words.length - 1) {
                st.append(words[i]);
            }else{
                st.append(words[i]).append(" ");
            }
        }

        System.out.println(st.toString());
    }
}
