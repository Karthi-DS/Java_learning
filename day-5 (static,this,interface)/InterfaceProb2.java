interface B{
    float pie = 3.14f;

    default void show(){}

}

public class InterfaceProb2 implements B{

    public static void main(String args[]){
        System.out.println(pie);
    }
}