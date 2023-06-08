import java.io.*;

public class SecretMessage {

  @SuppressWarnings("null")
public static void encrypt(String inputFilem, String outputFile, int key) throws IOException, FileNotFoundException {
	  InputStreamReader input = null;
      OutputStreamWriter out = null;
      try {
          input= new InputStreamReader(new FileInputStream(inputFilem));
          out= new OutputStreamWriter(new FileOutputStream(outputFile));
          int lecture;
          while ((lecture=input.read())!=-1) {
              out.write(lecture+key);
          }}
       catch (FileNotFoundException e) {
          System.out.println("Le fichier est introuvable");
      } catch(IOException E){
          System.out.println("Erreur");}
     
         
          out.close();
          input.close();
      
	    }

  public static void decrypt(String inputFilem, String outputFile, int key) throws IOException, FileNotFoundException {
	  OutputStreamWriter out= null;
	  InputStreamReader input=null;
      
      try{
          
          out=new OutputStreamWriter(new FileOutputStream(outputFile));
          input= new InputStreamReader(new FileInputStream(inputFilem));
          int lecture;
          while((lecture=input.read())!=-1){
              out.write((char)(lecture-key));
          }
      }
      catch (FileNotFoundException e) {
          System.err.println("Le fichier est introuvable");
      } catch(IOException E){
          System.err.println("Erreur");
      } 
          input.close();
          out.close();
      
  }

  public static void main(String[] args) {

    if (args.length != 4) {
      System.out.println("Usage: java SecretMessage [encrypt|decrypt] inputFile OutputFile key");
      System.exit(0);
    }

    if (args[0].equals("encrypt")) {
      try {
        encrypt(args[1],args[2], Integer.parseInt(args[3]));
      } catch (FileNotFoundException e) {
        System.err.println("File not found: "+e.getMessage());
      } catch (IOException e) {
        System.err.println("Cannot read/write file: "+e.getMessage());
      }
    } else if (args[0].equals("decrypt")) {
      try {
        decrypt(args[1],args[2], Integer.parseInt(args[3]));
      } catch (FileNotFoundException e) {
        System.err.println("File not found: "+e.getMessage());
      } catch (IOException e) {
        System.err.println("Cannot read/write file: "+e.getMessage());
      }
    } else{
      System.out.println("Usage: java SecretMessage [encrypt|decrypt] inputFile OutputFile key");
      System.exit(0);
    }
  }
}