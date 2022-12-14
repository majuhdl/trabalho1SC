import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Collectors.*;

public class Attack {

    public static String removeSimbolos (String texto) {
        String textoSemEspaco = texto.replaceAll("\\s", "").replaceAll("\\.", "").replaceAll(",", "");
        System.out.println(textoSemEspaco);
        return textoSemEspaco;
    }

    public static List<ListType> split(String s) {
        String sub, subTest;

        int i, j, k, flag = 0, repeat, num;
        List<ListType> substrings = new ArrayList<ListType>();

        for(i = 0; i<s.length()-2; i++){
            repeat = 0;
            flag = 0;
            List<Integer> ints = new ArrayList<Integer>();

            sub = s.substring(i, i+3);
            for(k=0; k<substrings.size(); k++){
                if(substrings.get(k).getKey().equals(sub)){
                    flag = 1;
                    System.out.println(sub);
                }
            }

            if(flag == 0){
                for(j = 0; j<s.length()-2; j++){
                    subTest = s.substring(j, j+3);
                    if (sub.equals(subTest)) {
                        repeat++;
                        num = j-i+2;
                        if(num == 2){
                            ints.add(0);
                        } else {
                            ints.add(num);
                        }
                    }
                }

                substrings.add(new ListType(sub, repeat, ints));
            }

        }
        
        for(i=0; i<substrings.size(); i++){
            System.out.println(substrings.get(i).getKey()+ "  "+ substrings.get(i).getRepeat()+ "  " + substrings.get(i).getDistances()+ "  ");
        }

        return substrings;
        
    }

    public static int possibleKeySizes(List<ListType> list){
        int i, j;

        List<Integer> all = new ArrayList<>();
        for(i=0; i<list.size(); i++){
            List<Integer> ints = list.get(i).getDistances();
            if(ints.size()>1){
                for (j=0; j<ints.size()-1; j++){
                    all.add(ints.get(j+1)-ints.get(j));
                }
            }

        }

        System.out.println(all);

        final Map<Integer, Integer> result = new HashMap<>();
        all.forEach(in -> result.merge(in, 1, Integer::sum));

        List<Integer> mapKeys = new ArrayList<>(result.values());
        Collections.sort(mapKeys);

        System.out.println(result);
        System.out.println(mapKeys);
        
        for(int key: result.keySet()) {
            if(result.get(key).equals(mapKeys.get(mapKeys.size()-1))) {
                return(key); 
            }
        }    

        return 0;

    }

    public static void createTable(int keySize, String text){

        int colNum = keySize;
        int linNum;

        if((text.length() % keySize) == 0){
            linNum = text.length() / keySize;
        } else {
            linNum = (text.length() / keySize) + 1;
        }

        char[] ch = text.toCharArray();

        char[][] matrix = new char[linNum][colNum];
        for(int i = 1; i < linNum-1; i++){
            for(int j = 0; j < colNum; j++){
                matrix[i][j] = text.charAt(((i-1)*keySize)+j);
            }
        }

        for(int i = 1; i < linNum-1; i++){
            for(int j = 0; j < colNum; j++){
                System.out.println(matrix[i][j] + " ");
            }
            System.out.println("\n");
        }


    }

    static void mostFrequentWord(List<String> list, int n) {
        int freq = 0;
        String res = "";
        
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).equals(list.get(i))) {
                    count++;
                }
            }
            if (count >= freq) {
                res = list.get(i);
                freq = count;
            }
        }
        
        System.out.println("The word that occurs most is : " + res);
        System.out.println("No of times: " + freq);
    }

    public void result(String texto, String chave) {
        System.out.println("Chave: " + chave);
        System.out.println("Texto: \n" + Cifrar.Decriptar(texto, chave));
    }
    
}
