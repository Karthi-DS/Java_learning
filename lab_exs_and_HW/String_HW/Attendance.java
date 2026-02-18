package lab_exs_and_HW.String_HW;

class Attendance {
    public static void main(String[] args) {

        boolean[] att = new boolean[30];

        // sample marking (normally teacher/software sets this)
        for (int i = 0; i < 25; i++) {
            att[i] = true;
        }

        int present = 0, absent = 0;

        for (boolean status : att) {
            if (status) present++;
            else absent++;
        }

        System.out.println("Present=" + present + " Absent=" + absent);
    }
}
