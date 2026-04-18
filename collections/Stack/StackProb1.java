import java.util.Scanner;
import java.util.Stack;

class StackProb1{
    Stack<Character> s = new Stack<>();
    char[] arr = {'}',')',']'};

    public int isContinue(char c){
        for(int i=0; i<arr.length; i++){
            if(arr[i]==c) return i;
        }

        return -1;
    }

    public void checkReliable(String ch){
        for(char x: ch.toCharArray()){
            int result = isContinue(x);
            if(result==-1){
                s.add(x);
            }else{
                if(arr[result]==x) { 
                    s.pop();
                    continue;}

                System.out.println("Invalid parentheis...");
                break;
            }
        }
        if(s.empty()) System.out.println("Valid paranthesis");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackProb1 s = new StackProb1();

        System.out.println("Enter the string for parenthesis checker");
        String p = sc.next();
        s.checkReliable(p);
        
    }
}
