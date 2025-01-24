import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String answer = "";
        for (int i = 0; i < a.length(); i++) {
            char temp = a.charAt(i);
            if (Character.isLowerCase(temp)) {
                answer += Character.toString(temp).toUpperCase();
            } else {
                answer += Character.toString(temp).toLowerCase();
            }
        }
        System.out.println(answer);
    }
}