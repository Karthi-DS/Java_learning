package lab_exs.array_exs1;

import pk.Array;

public class Prob5 {
    public static boolean isVowel(char a){
        char vowel[] = {'a','e','i','o','u'};
        for(char x: vowel){
            if(x==a){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        char arr[] = Array.get1DArray(true);
        int vowelCount=0, consonantCount=0;

        for(int i=0; i<arr.length;i++){
            if(isVowel(arr[i])){
                vowelCount++;
            }else{
                consonantCount++;
            }
        }

        System.out.println("Vowel Count: "+ vowelCount + " Cononant Count: "+consonantCount);
    }
}
