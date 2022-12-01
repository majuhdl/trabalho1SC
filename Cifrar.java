import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cifrar {

    static String geraChave(String str, String key) {
   
        for (int i = 0; i<str.length() ; i++) {
            key+=(key.charAt(i));
        }

        return key;
        
    }

    static String cifraTexto(String str, String key) {
        String cipher_text="";

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ' '){
            int x = (str.charAt(i) + key.charAt(i)) %26;
            x += 'A';
            cipher_text+=(char)(x);
            } else {
                cipher_text+=(char)(' ');
            }
        }
        
        return cipher_text;
    }

    static String Decriptar(String texto, String chave) {
        String decriptado="";

        for (int i = 0 ; i < texto.length() && i < chave.length(); i++) {
            if(texto.charAt(i) != ' '){
            int x = (texto.charAt(i) - chave.charAt(i) + 26) %26;
            x += 'A';
            decriptado+=(char)(x);
            } else {
                decriptado+=(char)(' ');
            }
        }

        return decriptado;
    }

    static String TratamentoDaString(String string) {

        //String str = string.replaceAll("\\s+","");
        //System.out.println("string"+str);
        
        String StrUp = string.toUpperCase();
        System.out.println("str:" + StrUp);
        return StrUp;
    }

    static List<String> TrataChaveEntrada (String filename, String chave) {
        String str;
        try {
            str = ReadFile.readFile(filename);
            System.out.println(str);
        
            String string  = Cifrar.TratamentoDaString(str);
            String keyword = Cifrar.TratamentoDaString(chave);

            List<String> words = new ArrayList<>();
            words.add(string);
            words.add(keyword);
            return words;
        }
         catch (IOException e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
}
