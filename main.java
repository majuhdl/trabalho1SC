import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite a chave: ");
        String chave = scan.nextLine();
        System.out.println("Digite o nome do arquivo: ");
        String entrada = scan.nextLine();

        System.out.println(chave);

        List<String> words = Cifrar.TrataChaveEntrada(entrada, chave);
            
        String entradaT = words.get(0);
        String chaveT = words.get(1);

        String chaveGerada = Cifrar.geraChave(entradaT, chaveT);
        String textoCifrado = Cifrar.cifraTexto(entradaT, chaveGerada);

        System.out.println("Ciphertext : " + textoCifrado + "\n");
        System.out.println("Original/Decrypted Text : " + Cifrar.Decriptar(textoCifrado, chaveGerada) + "\n");

        List<ListType> test = Attack.split(Attack.removeSimbolos(Cifrar.cifraTexto(entradaT, chaveGerada)));
        int size = Attack.possibleKeySizes(test);
        System.out.println(size);

        Attack.createTable(size, Attack.removeSimbolos(Cifrar.cifraTexto(entradaT, chaveGerada)));

    }
    
}
