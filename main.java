import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite a chave: ");
        String chave = scan.nextLine();
        System.out.println("Digite o nome do arquivo: ");
        String entrada = scan.nextLine();

        System.out.println(chave);
        try {
            String str = ReadFile.readFile(entrada);
            System.out.println(str);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }
    
}
