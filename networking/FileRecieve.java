package lanchat.networking;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileRecieve extends Thread{
     ServerSocket sr;
     File file;
     
    public FileRecieve(File f, String hostname,int port)
    {
        this.file=f;
         try {
             sr=new ServerSocket(port);
         } catch(IOException ex) {
             Logger.getLogger(FileSend.class.getName()).log(Level.SEVERE, null, ex);
         }
    }     
     @Override
      public void run(){
          Socket soc=null;
          InputStream in=null;
          OutputStream ou = null;
          try{
              soc= sr.accept();
          }catch(IOException e){
              System.out.println("cant accept connection");
          }
         try{
             in=soc.getInputStream();
         } catch (IOException ex) {
             System.out.println("cant get socket input stream");
         }
         try {
             ou =new FileOutputStream("F:\\sem 4\ttttt.txt");
         } catch (FileNotFoundException ex) {
             Logger.getLogger(FileRecieve.class.getName()).log(Level.SEVERE, null, ex);
         }
         byte b[]=new byte[16*1024];
         int count;
         try {
             while((count=in.read(b))>0){
                 ou.write(b,0, count);
             }
         } catch (IOException ex) {
             Logger.getLogger(FileRecieve.class.getName()).log(Level.SEVERE, null, ex);
         }
             
     }
 
}
      
    
