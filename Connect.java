import java.net.*;
import java.util.*;
import java.io.*;
public class Connect
{
	public void accessUrl()throws IOException
	{
		URLConnection connection = new URL("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByDistrict?district_id=307&date=18-09-2021").openConnection();
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36"); // Do as if you're using Chrome 41 on Windows 7.
		InputStream response = connection.getInputStream();
		
		
		try (Scanner scanner = new Scanner(response)) {
			String responseBody = scanner.useDelimiter("\\A").next();
			Converter con=new Converter();
			System.out.println(responseBody);
		}
	}
	public void accessU()throws IOException
	{
		URLConnection connection = new URL("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode=680020&date=18-09-2021").openConnection();
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36"); // Do as if you're using Chrome 41 on Windows 7.
		InputStream response = connection.getInputStream();
		
		
		try (Scanner scanner = new Scanner(response)) {
			String responseBody = scanner.useDelimiter("\\A").next();
			Converter con=new Converter();
			System.out.println(responseBody);
		}
	}
	public void accessTCR()throws IOException
	{
		URLConnection connection = new URL("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByDistrict?district_id=303&date=18-09-2021").openConnection();
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36"); // Do as if you're using Chrome 41 on Windows 7.
		InputStream response = connection.getInputStream();
		
		
		try (Scanner scanner = new Scanner(response)) {
			String responseBody = scanner.useDelimiter("\\A").next();
			Converter con=new Converter();
			con.print(responseBody);
		}
	}
}