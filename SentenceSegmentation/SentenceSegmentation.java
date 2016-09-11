/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SentenceSegmentation;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Krattika
 */
public class SentenceSegmentation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
   
    int i=0;
      String result[]=new String[10];
      ArrayList<String> sen_list=new ArrayList<String>();
      ArrayList<Integer> word_count=new ArrayList<Integer>();
      String paragraph=new Scanner(new File("I:\\final_doc.txt")).useDelimiter("\\Z").next();;
      result =paragraph.split("(\\.|\\?|!)*(_)(\\.|\\?|!|\n)*");

          for(String sentence:result)
          {
              sen_list.add(sentence);
              System.out.println(sentence +"\n");
              word_count.add(result[i].length());
              i++;
          }
   

    
  }
  
     
         
          
      
          
      
     
  

 
}
