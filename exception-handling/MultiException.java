class MultiException{
    int c;
    MultiException(int a,int b){
        try {
            if(b==0)throw new ArithmeticException("Exception thrown");
        }catch (ArithmeticException e){
            System.out.println(e.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MultiException m = new MultiException(10,0);
    }
}