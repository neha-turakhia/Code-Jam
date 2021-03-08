import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NestingDepth {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testcase = scan.nextInt();
        for(int i=0;i<testcase;++i) {
            String input = scan.next();
            String soln = nestingDepth(input);
            System.out.println("Case #"+(i+1)+": "+soln);
        }
    }

    private static String nestingDepth(String s) {
        List<Character> list = new ArrayList<>();
        int open = 0;

        for(int i=0;i<s.length();++i){
            char c = s.charAt(i);
            int val = Integer.valueOf(Character.toString(c));
            if(val == 0 || val < open) {
                while(open > 0 && val != open) {
                    list.add(')');
                    open--;
                }
                list.add(c);
            }else {
                while(val!=open){
                    list.add('(');
                    //val--;
                    open++;
                }
                list.add(c);
            }
        }

        while(open-- > 0) {
            list.add(')');
        }

        StringBuilder sb = new StringBuilder();
        for(char c:list) {
            sb.append(c);
        }
        return (list.size() == 0) ? s : sb.toString();
    }
}