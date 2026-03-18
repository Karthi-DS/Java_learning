import java.lang.Exception;

class InvalidAgeException extends Exception{
    public InvalidAgeException(String m){
        super(m);
    }
}

class CustomException{

    int age;

    CustomException(int age) throws InvalidAgeException{
        this.age = age;
        validateAge();
    }
    
    public void validateAge() throws InvalidAgeException{
            if(this.age<18){
                throw new InvalidAgeException("age should be >=18");
            }
        }


    public static void main(String[] args) {
        try {
        CustomException c = new CustomException(17);
            
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }

    }

}