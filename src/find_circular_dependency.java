import java.util.*;

public class find_circular_dependency {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String s = input.nextLine();

        String[] works = s.split(" ");

        for(int i = 0; i < works.length; i++) {
            System.out.println(works[i]);
        }

        findWorkDependency(works);
    }

    public static void findWorkDependency(String[] works)  {
        List<List<String>> result = new ArrayList<>();

        for (int i = 0, j = i + 1; i < works.length; i = i + 2) {
            if(j < works.length){
                result.add(merge(works[i], works[j]));
            }else{
                char[] tmp = works[j].toCharArray();
                List<String> s = new ArrayList<>();
                for (char c:
                     tmp) {
                    s.add(String.valueOf(c));
                }

                result.add(s);

            }

        }

        System.out.println(result);
    }


    public static List<String> merge(String s1, String s2) {
        List<String> r = new ArrayList<>();
        for(int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                r.add(new StringBuilder(s1.charAt(i) + s2.charAt(j)).toString());
            }
        }

        System.out.println(r);
        return new ArrayList<>(r);
    }
}
