import java.io.*;
import java.lang.Object;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
public class Converter
{
	int age=0,slot=0;
	public int sessions(String sesh)
	{
		int a,b,c,d,e,f,g,agetemp=-1,slottemp=-1,slot1temp=-1;
		String s,t,u,v;
		a=0;
		age=slot=-1;
		d=sesh.length();
		for(b=0;b<d;b++)
		{
			if(sesh.charAt(b)=='[')
				a++;
			else if(sesh.charAt(b)==']')
				a--;
			if(a==0)
				break;
			if(b<d-20)
			{
				s=sesh.substring(b,b+20);
				if(s.equals("\"available_capacity\""))
				{
					b+=21;
					u=sesh.substring(b);
					c=u.indexOf(',');
					t=u.substring(0,c);
					slottemp=Integer.parseInt(t);
					b+=c;
					b++;
				}
			}
			if(b<d-15)
			{
				s=sesh.substring(b,b+15);
				if(s.equals("\"min_age_limit\""))
				{
					b+=16;
					u=sesh.substring(b);
					c=u.indexOf(',');
					t=u.substring(0,c);
					agetemp=Integer.parseInt(t);
					b+=c;
				}
			}
			if(agetemp==18&&slottemp>0)
			{
				age=18;
				slot=slottemp;
				slot1temp=-1;
				for(c=b;c<d;c++)
				{
					if(c<d-26)
					{
						s=sesh.substring(c,c+26);
						if(s.equals("\"available_capacity_dose1\""))
						{
							c+=27;
							u=sesh.substring(c);
							e=u.indexOf(',');
							//e=u.indexOf('}');
							t=u.substring(0,e);
							slot1temp=Integer.parseInt(t);
							c+=e;
							break;
						}
					}
				}
				b=c;
				if(slot1temp>0)
				{
					slot=slot1temp;
					break;
				}
				else 
					agetemp=slottemp=slot1temp=age=slot=-1;
			}
			else 
				agetemp=slottemp=slot1temp=-1;
		}
		return b;
	}
	public void print(String res)throws IOException
	{
		String name="",feetype="";
		int len,a,b,c,d,e,f,g,h;
		String s,t,u;
		len=res.length();
		for(a=e=0;a<len;a++)
		{
			if(a<len-6)
			{
				t=res.substring(a,a+6);
				if(t.equals("\"name\""))
				{
					a+=8;
					s=res.substring(a);
					b=s.indexOf('\"');
					name=s.substring(0,b);
					a+=b;
				}
			}
			/*if(a<len-11)
			{
				t=res.substring(a,a+11);
				if(t.equals("\"fee_type\""))
				{
					a+=13;
					s=res.substring(a);
					b=s.indexOf('\"');
					feetype=s.substring(0,b);
					a+=b;
				}
			}*/
			if(a<len-10)//&&feetype.equals("Paid"))
			{
				t=res.substring(a,a+10);
				if(t.equals("\"sessions\""))
				{
					a+=11;
					s=res.substring(a);
					b=sessions(s);
					a+=b;
					if(age==18&&slot>0)
					{
						System.out.println(name+"\nfree slots :"+slot+"\n");
						e++;
						//Runtime.getRuntime().exec(new String[] { "C:/Program Files/VideoLAN/VLC/vlc", "D:\\Downloads\\alarm.mp3" });
						//while(true){}
					}
				}
			}
		}
		if(e==0)System.out.println("No slots \n\n");
	}
}