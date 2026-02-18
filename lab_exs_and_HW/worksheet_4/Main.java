package lab_exs_and_HW.worksheet_4;

import java.util.Scanner;
import java.util.Arrays;

public class Main
{
    String name,title;
    StringBuilder comments = new StringBuilder();
    int ratings[] = new int[4];
    Scanner sc = new Scanner(System.in);
    
    Main(String name, String title,String comments){
        this.name = name;
        this.title = title;
        this.comments.append(comments);
    }
    
    public void rate(){
        System.out.println("Enter rating for content, language, presentation, and overall entertainment: ");
        for(int i=0; i<ratings.length; i++){
            System.out.println("Enter value: ");
            ratings[i] = sc.nextInt();
        }
    }
    
    public void display(){
        System.out.println(Arrays.toString(ratings));
    }
    
	public static void main(String[] args) {
	    Main m = new Main("karthi","Philosophy of life","its wonderfull");
	    m.rate();
	    m.display();
	}

    public void summary() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'summary'");
    }
}



