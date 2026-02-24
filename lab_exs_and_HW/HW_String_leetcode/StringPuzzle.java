package lab_exs_and_HW.HW_String_leetcode;

import java.util.Arrays;

public class StringPuzzle {

    private String myString;
    private int sno;
    private static int count = 0;

    public StringPuzzle() {
        this.myString = "";
        count++;
        this.sno = count;
    }

    public StringPuzzle(String myString) {
        this.myString = myString;
        count++;
        this.sno = count;
    }

    public String sort(String s) {
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public String[][] myAnagrams() {
        String words[] = myString.split(" ");
        String res[][] = new String[words.length][words.length];

        for (String s : words) {
            for (String arr[] : res) {
                if (arr[0] == null) {
                    arr[0] = s;
                    break;
                }
                if (sort(arr[0]).equals(sort(s))) {
                    int i;
                    for (i = 0; i < arr.length; i++) {
                        if (arr[i] == null) {
                            break;
                        }
                    }
                    arr[i] = s;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        StringPuzzle sp = new StringPuzzle("cat tac god dog act");
        String res[][] = sp.myAnagrams();
        System.out.println(Arrays.deepToString(res));
    }
}