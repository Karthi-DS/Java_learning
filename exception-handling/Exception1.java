import java.lang.Exception;
import java.lang.Thread;

class Exception1{
    Exception1(int a,int b){
        try{
            int c = a/b;
        }catch(Exception e){
            System.out.println("message "+ e.getMessage());
            System.out.println("cause "+e.getCause());
            System.out.println("toString "+e.toString());
            e.printStackTrace();
        }
        finally{
            System.out.println("I'm finally block. i always execute");
        }
    }

    public static void main(String[] args){
        Exception1 ex = new Exception1(2,2);
    }
}