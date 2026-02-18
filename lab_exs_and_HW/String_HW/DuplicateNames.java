package lab_exs_and_HW.String_HW;

class DuplicateNames {
    public static void main(String[] args) {
        String[] names = {"A", "B", "A"};

        for (int i = 0; i < names.length; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (names[i].equals(names[j])) {
                    System.out.println("Duplicate: " + names[i]);
                }
            }
        }
    }
}

