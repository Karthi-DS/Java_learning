class helperClass{
    private class PrivateClass{
        static void main(){
            System.out.println("Hello from private class..");
        }
    }
    static void help(){
        PrivateClass.main();
        System.out.println("hello");
    }
}

class PrivateClass{
    public static void main(String[] args){
        helperClass.help();
    }
}

