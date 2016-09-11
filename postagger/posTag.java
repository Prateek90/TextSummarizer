/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package postagger;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author subhash
 */
public class posTag {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        // TODO code application logic here
        String untagged;
        MaxentTagger tagger = new MaxentTagger("taggers/english-left3words-distsim.tagger");
        BufferedReader file = new BufferedReader(new FileReader("I:\\doc1.txt"));
         BufferedWriter out = new BufferedWriter(new FileWriter("I:\\tagged_doc.txt"));
         while((untagged=file.readLine())!=null)
         {
             String tagged=tagger.tagString(untagged);
             out.append(tagged+"\r\n\r\n");
         }

out.close();
    }

}
