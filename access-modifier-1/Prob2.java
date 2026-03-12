class util {
    private String name;
    private int marks;

    void setMarks(int marks){
        this.marks = marks;
    }

    void setName(String name){
        this.name = name;
    }

    void getInfo(){
        System.out.println(name+" got "+marks);
    }
}

class Prob2{
    public static void main(String[] args) {
        util u1 = new util();
        u1.setName("kartheesvaran");
        u1.setMarks(100);
        u1.getInfo();
    }
}
