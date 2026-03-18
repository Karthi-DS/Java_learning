class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String m) {
        super(m);
    }
}

public class RunTimeException1 {
    int age;
    
    //throws optional
    RunTimeException1(int age) {
        this.age = age;
        validateAge();
    }
    
    public void validateAge() {
        if (this.age < 18) {
            throw new InvalidAgeException("Age should be >= 18");
        }
    }

    public static void main(String[] args) {
        // try-catch block is optional
        RunTimeException1 c = new RunTimeException1(17);
    }
}