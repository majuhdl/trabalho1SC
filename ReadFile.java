import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadFile{
  
  public static File createFile() {
    try {
      File file = new File("output.txt");
      if (file.createNewFile()) {
        System.out.println("Arquivo criado: " + file.getName());
      } else {
        System.out.println("Arquivo já existe.");
      }
      return file;    
    } catch (IOException e) {
      System.out.println("ERRO!");
      e.printStackTrace();
    }
    return null;
  }


  public static String readFile (String entrada) throws IOException{

      String str = "";
      
      try {
        str = new String(Files.readAllBytes(Paths.get(entrada)));
      } catch (IOException e) {
        e.printStackTrace();
      }

      try {
        FileWriter fw = new FileWriter("output.txt");
        fw.append(str);
        fw.close();
      } catch (IOException e) {
          // TODO Auto-generated catch block
        e.printStackTrace();
      }

        return str;
      }




    //try {
    //  String content = Files.readString(entrada, StandardCharsets.UTF_8);
    //  File newFile = createFile();
      //FileOutputStream fos = new FileOutputStream(newFile);
      //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
      //File file = new File(filename);
      //Scanner myReader = new Scanner(file);
      //while (myReader.hasNextLine()) {
      //  String data = myReader.nextLine();
      //  try {
      //    FileWriter fw = new FileWriter("output.txt");
      //    fw.append(data);
      //    fw.close();
      //  } catch (IOException e) {
          // TODO Auto-generated catch block
      //    e.printStackTrace();
      //  }
      //  System.out.println(data);
      //}
    //  myReader.close();
    //} catch (FileNotFoundException e) {
    //  System.out.println("An error occurred.");
    //  e.printStackTrace();
    //}
  //}
}