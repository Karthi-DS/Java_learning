interface prob{
    void print(); //default public abstract will be added
}

class Prob2 implements prob{

    @Override
    public void print(){
        System.out.println("overided");
    }
    public static void main(String[] args){
        System.out.println("Hello... ");
    }
}