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

        int k = 0, l, m;
        int[] freq = new int[linNum];
        for(k=0; k<colNum; k++){
            char[] columnStr = new char[linNum];
            for(int i = 1; i < linNum-1; i++){
                for(int j = 0; j < colNum; j++){
                    if(j == k) {
                        columnStr[k] = matrix[i][j];
                    }
                }
            }
            for(l = 0; l<columnStr.length; l++){
                freq[l] = 1;
                for(m = l+1; m < columnStr.length; m++) {
                    if(columnStr[l] == columnStr[m]) {
                        freq[l]++;
                        columnStr[m]= '0';
                    }
                }
            }

            for(int i=0; i<columnStr.length; i++){
                if(columnStr[i] != ' ' && columnStr[i] != '0'){
                    System.out.println(columnStr[i]+freq[i]);
                }
            }

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

    public Map<Character, Double> createsListsFreq(int language) {

        int ingles = 1;

        final Map<Character, Double> freq = new HashMap<>();
        if (language == ingles) {
            freq.put('a', 0.08167);
            freq.put('b', 0.01492);
            freq.put('c', 0.02782);
            freq.put('d', 0.04253);
            freq.put('e', 0.12702);
            freq.put('f', 0.02228);
            freq.put('g', 0.02015);
            freq.put('h', 0.06094);
            freq.put('i', 0.06966);
            freq.put('j', 0.00153);
            freq.put('k', 0.00772);
            freq.put('l', 0.04025);
            freq.put('m', 0.02406);
            freq.put('n', 0.06749);
            freq.put('o', 0.07507);
            freq.put('p', 0.01929);
            freq.put('q', 0.00095);
            freq.put('r', 0.05987);
            freq.put('s', 0.06327);
            freq.put('t', 0.09056);
            freq.put('u', 0.02758);
            freq.put('v', 0.00978);
            freq.put('w', 0.02360);
            freq.put('x', 0.00150);
            freq.put('y', 0.01974);
            freq.put('z', 0.00074);

            return freq;
        } else {
            freq.put('a', 0.1463);
            freq.put('b', 0.0104);
            freq.put('c', 0.0388);
            freq.put('d', 0.0499);
            freq.put('e', 0.1257);
            freq.put('f', 0.0102);
            freq.put('g', 0.0130);
            freq.put('h', 0.0128);
            freq.put('i', 0.0618);
            freq.put('j', 0.0040);
            freq.put('k', 0.0002);
            freq.put('l', 0.0278);
            freq.put('m', 0.0474);
            freq.put('n', 0.0505);
            freq.put('o', 0.1073);
            freq.put('p', 0.0252);
            freq.put('q', 0.0120);
            freq.put('r', 0.0653);
            freq.put('s', 0.0781);
            freq.put('t', 0.0434);
            freq.put('u', 0.0463);
            freq.put('v', 0.0167);
            freq.put('w', 0.0001);
            freq.put('x', 0.0021);
            freq.put('y', 0.0001);
            freq.put('z', 0.0047);

            return freq;
        }
    
    }


}
