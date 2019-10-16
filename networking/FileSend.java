package lanchat.networking;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import lanchat.gui.MainScreen;
public class FileSend extends Thread{
     File f;
      Socket sr;
   public FileSend(File f, String hostname,int port)
    {
        this.f=f;
         try {
             sr=new Socket(hostname,port);
         } 
         catch (IOException ex) {
             Logger.getLogger(FileSend.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    @Override
       public void run()
     {
          byte b[]=new byte[2002];
         try {
             InputStream is = sr.getInputStream();
               is.read(b,0,b.length);
         } catch (IOException ex) {
             Logger.getLogger(FileRecieve.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             FileOutputStream fos= new FileOutputStream("F:\\sem 4\new.txt");
              try {
                  fos.write(b,0,b.length);
              } catch (IOException ex) {
                  Logger.getLogger(FileRecieve.class.getName()).log(Level.SEVERE, null, ex);
              }
         } catch (FileNotFoundException ex) {
             Logger.getLogger(FileRecieve.class.getName()).log(Level.SEVERE, null, ex);
         }
        
     } 
}
