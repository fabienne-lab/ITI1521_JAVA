import java.io.*;

/**
 * Utils
 */
public class Utils {
    public static PlayList getSong(String fileName){
        PlayList playList= new PlayList();
        BufferedReader in=null;
        String line="";
        String [] s=null;
        try {
           in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            while((line=in.readLine())!=null){
                s= line.split(":");
                Song song= new Song(s[0],s[1],s[2]);
                playList.addSong(song);
            }

            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            if(in!=null){
                try{
                    in.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return playList;
    }
   
}