import java.lang.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;
import java.io.*;

public class Test
{
	public static void main(String argp[])
	{
	
	Scanner sc = new Scanner (System.in);
    System.out.println("[+] Please enter the name of which you want to Generate:");
    String input = sc.next();
    System.out.println("[+] How May Digit Password :");
    String len=sc.next();
    System.out.println("[+] Does Password contain specail Characters:[Y/N]");
    String spec=sc.next();
    System.out.println("[+] Performing Permutation");
    int iplen=input.length();
    Test t = new Test();
    int count=0;
    if(iplen==Integer.parseInt(len))
    {
    	int length=Integer.parseInt(len);
    	System.out.println(input);	
    	String reverse = new StringBuffer(input).reverse().toString(); 
    	System.out.println(reverse);
    //	System.out.println(length+":length");
    	  	for(int i=(length-1);i>=0;i--)
    		{
			//char[] c_arr = input.toCharArray();
			for(int j=i;j>=0;j--)
			{
			String str = t.changeCharInPosition(j,  (char)(i + '0'), input);
			System.out.println(str);
            t.writeToFile(str);
            count+=1;
			}
    	}
        //For Reverse
        for(int i=(length-1);i>=0;i--)
            {
            //char[] c_arr = input.toCharArray();
            for(int j=i;j>=0;j--)
            {
            String str = t.changeCharInPosition(j,  (char)(i + '0'), reverse);
            System.out.println(str);
            count+=1;
            }
        }
        System.out.println("Generated :"+(count+2));
        t.permute(input);
    }


	}
	public String changeCharInPosition(int position, char ch, String str){
    char[] charArray = str.toCharArray();
    charArray[position] = ch;
    return new String(charArray);
}
 public  void permute( String input)
    {
        int inputLength = input.length();
        boolean[ ] used = new boolean[ inputLength ];
        StringBuffer outputString = new StringBuffer();
        char[ ] in = input.toCharArray( );
        doPermute ( in, outputString, used, inputLength, 0 );
        
    }
    public static    void doPermute ( char[ ] in, StringBuffer outputString,
    boolean[ ] used, int inputLength, int level)
    {
       Test t = new Test();
        if( level == inputLength) {
            System.out.println ( outputString.toString());
            t.writeToFile(outputString.toString());
            return;
        }
        
        for( int i = 0; i < inputLength; ++i )
        {
            
            if( used[i] ) continue;
            
            outputString.append( in[i] );
            used[i] = true;
            doPermute( in,   outputString, used, inputLength, level + 1 );
            used[i] = false;
            outputString.setLength(   outputString.length() - 1 );
        }
    }
    public void writeToFile(String text)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        String fname =dtf.format(localDate);
        //System.out.println(fname+".txt");
        
       /* try
        {File fp = new File(fname+".txt");
        
        if(!fp.exists())
        {
            fp.createNewFile();
        }
        FileWriter fw = new FileWriter(fp.getAbsoluteFile(),true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(text);
        bw.close();
        fw.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
*/

    }
}
