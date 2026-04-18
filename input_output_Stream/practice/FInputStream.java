import java.io.FileInputStream;

class FInputStream{
    FileInputStream fi;
    FInputStream(){
        try {
            fi = new FileInputStream("students.txt");
        } catch (Exception e) {
            System.out.println("Failed to open file");
        }
    }

    public void readAndRetrieve(){
        byte[] arr = new byte[100];
        try {
            int i;
            while((i=fi.read(arr))!=-1){
                System.out.print(new String(arr));
            }
        } catch (Exception e) {
            System.out.println("Error occured..");
        }
    }

    public static void main(String[] args) {
        FInputStream f = new FInputStream();
        f.readAndRetrieve();
    }
}