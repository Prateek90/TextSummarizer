/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package text_summarisation;
import java.io.*;
import java.util.*;
/**
 *
 * @author Sonam
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

    String query="You may copy it";
    ArrayList<File> filelist=new ArrayList<File>();
    //filelist.add(new File("D:\\summary_tool\\Test.txt"));
    filelist.add(new File("I:\\matlab\\Matlabdata1.txt"));
    filelist.add(new File("I:\\matlab\\Matlabdata2.txt"));
    //filelist.add(new File("C:\\summary_tool\\Doc3.txt"));
    //filelist.add(new File("C:\\summary_tool\\Doc4.txt"));
    File out=new File("I:\\matlab\\summary.txt");

    summarize(query,filelist,out);

  }

  static void summarize(String query, ArrayList<File> src, File dst) throws IOException {

  BufferedWriter out = new BufferedWriter(new FileWriter(dst));

  HashMap stoplist=new HashMap();
  String thisLine;
  ArrayList<String> query_list=new ArrayList<String>();
  BufferedReader stop_br = new BufferedReader(new FileReader("I:\\matlab\\stoplist.txt"));
  while ((thisLine = stop_br.readLine()) != null) {
         stoplist.put(thisLine, 1);
       }
  String[] query_words=query.split(" ");
  for(String word: query_words)
  {
      if(!stoplist.containsKey(word))
          query_list.add(word);
  }
System.out.println("Query words are :");
    for(int i=0; i<query_list.size();++i)
    {
        System.out.println(query_list.get(i));
    }


for(File f: src)
{
 ArrayList<Integer> count_list=new ArrayList<Integer>();
 ArrayList<Integer> position_list=new ArrayList<Integer>();
 LineNumberReader r = new LineNumberReader(new FileReader(f));
    String l;

    while ((l = r.readLine()) != null)
    {
        int count=0;
        String str;
        Scanner s = new Scanner(l);

        while (s.hasNext())
        {
            if(query_list.contains(str=s.next()))
            {
              //System.out.println(str+" is same");
              count++;
            }
            //else
              //System.out.println(str+" is not same");
        }
        System.out.println("Para with count "+count+" ends");
        count_list.add(count);
        int position=r.getLineNumber();
        position_list.add(position);
         //System.out.println("One line read");
    }
    int max=0, i=0;

    System.out.println("Max count is :");

    for(i=1; i<count_list.size();++i)
    {
        if(count_list.get(i)>count_list.get(max))
            max=i;
    }
    System.out.println(count_list.get(max)+" in para "+max);
//    System.out.println(count_list.size());
//    System.out.println(position_list.size());

    r = new LineNumberReader(new FileReader(f));
    int mark=position_list.get(max);
    r.setLineNumber(3);
    //r.setLineNumber(mark);
    for(i=0;i<mark-1;++i)
    {
        r.readLine();
    }
    //System.out.println("Summary is: " + r.readLine());
    out.append(r.readLine()+"\r\n\r\n");
    System.out.println("One document read");
}

out.close();
  }

}
