import java.io.*;
import java.util.*;
public class Vame
{
	public static void main(String[]args)throws IOException
	{
		Connect c=new Connect();
		Scanner in=new Scanner(System.in);
		System.out.println("Enter 1 for tcr or 2 for ekm or 3 for PHC");
		int b=0,a=in.nextInt();
		while(true)
		{
			//System.out.println(b++);
			if(a==1) c.accessTCR();
			else if(a==2)c.accessUrl();
			else c.accessU();
			try
			{
				Thread.sleep(3000);//to achieve the limits of no. of api calls per minute
			}
			catch(Exception e)
			{
				System.out.println("restart");
				break;
			}
		}
	}
}