import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.Arrays;

class ResourceException{
    String[] lines = new String[10];
    ResourceException(){
        try(BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            int i=0;
            while((line=br.readLine())!=null){
                lines[i] = line;
                i++;
            }
            System.out.println(Arrays.toString(lines));
        } catch (IOException e) {
            System.out.println("File not found....");
        }
    }

    public static void main(String[] args) {
        ResourceException r = new ResourceException();
    }
}