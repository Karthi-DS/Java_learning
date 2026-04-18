import java.util.*;

class BrowserNavigator {

    String[] urls = {"google","youtube","yahoo","gmail","facebook"};
    Stack<String> back = new Stack<>();
    Stack<String> forward = new Stack<>();
    String current = null;

    Scanner sc = new Scanner(System.in); 

    public void visit(String url){
        if(current != null){
            back.push(current);
        }
        current = url;
        forward.clear();
        System.out.println("Visited: " + current);
    }

    public void goBack(){
        if(back.isEmpty()){
            System.out.println("No pages to go back");
            return;
        }
        forward.push(current);
        current = back.pop();
        System.out.println("Back to: " + current);
    }

    public void goForward(){
        if(forward.isEmpty()){
            System.out.println("No pages to go forward");
            return;
        }
        back.push(current);
        current = forward.pop();
        System.out.println("Forward to: " + current);
    }

    public void menu(){
        for(int i=0;i<urls.length;i++){
            System.out.println((i+1)+" : "+urls[i]);
        }
        System.out.println((urls.length+1)+" : Back");
        System.out.println((urls.length+2)+" : Forward");
        System.out.println((urls.length+3)+" : Exit");
    }

    public int choice(){

        if(!sc.hasNextInt()){ 
            System.out.println("Invalid input");
            sc.next(); 
            return 0;
        }

        int ch = sc.nextInt();

        if(ch>=1 && ch<=urls.length){
            visit(urls[ch-1]);
        }
        else if(ch == urls.length+1){
            goBack();
        }
        else if(ch == urls.length+2){
            goForward();
        }
        else if(ch == urls.length+3){
            return -1;
        }
        else{
            System.out.println("Invalid choice");
        }

        return 0;
    }

    public static void main(String[] args){
        BrowserNavigator b = new BrowserNavigator();
        int c=0;

        while(c!=-1){
            b.menu();
            c = b.choice();
        }
    }
}
