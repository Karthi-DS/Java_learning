
class ReverseString extends Thread{
    String s;
    ReverseString(String s){
        this.s = s;
    }
    void reverse(){
        System.out.println("reversed: "+ new StringBuilder(s).reverse());
    }

    public void run(){
        reverse();
    }
}

class VowelCount extends Thread{
    String s;
    int n;
    VowelCount(String s){
        this.s = s;
    }

    boolean isVowel(char x){
        boolean res = false;

        char vowel[] = {'a','e','i','o','u'};

        for(char v: vowel){
            if(x==v){
                res = true;
            }
        }

        return res;
    }

    void count(){
        int n =0;
        for(char x: s.toCharArray()){
            if (isVowel(x) ) n++;
        }
        System.out.println("vowel count: "+ n);
    }

    public void run(){
        count();
    }

}

public class VowelCountReverse {
    public static void main(String[] args) {
        ReverseString rev = new ReverseString("hello");
        VowelCount count = new VowelCount("Iamkarthi");

        rev.run();
        count.run();
    }
}
