class MultiException{
    int c;
    MultiException(int a,int b){
        try {
            c = a/b;
        } catch (Exception e) {
            e.printStackTrace();
        }catch (ArithmeticException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MultiException m = new MultiException(10,0);
    }
}