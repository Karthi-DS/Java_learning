package lab_exs_and_HW.ex8;

public interface Header {
    default void headPrint(){
        System.out.println("------------PSG COLLEGE OF TECHNOLOGY------------");
        System.out.println("------------MCA DEGREE PROGRAMME     ------------");
        System.out.println("------------MARK STATEMENT           ------------");
        System.out.println("------------ACADEMIC YEAR 2025-26    ------------");
    }

    void printGrade();
}
