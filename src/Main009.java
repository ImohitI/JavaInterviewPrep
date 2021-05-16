import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main009 {
    public static void main(String[] args) {
        InputStream geek = null;
        try{
            geek = new FileInputStream("ABC.txt");

            System.out.println("> "+geek.read(new byte[4]));
            System.out.println("> "+geek.read(new byte[4]));
            System.out.println("> "+geek.read(new byte[4]));
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
