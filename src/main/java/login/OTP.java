package login;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Random;

public class OTP {
	public String sendSms() {
	try {
		// Construct data
		String apiKey = "apikey=" + "NTg1NTcxNzU2OTMyNjY3NzY3NDE3MjU4NDI2NDU5NGU=";
		Random rand = new Random();
		int otp  = rand.nextInt(99999);
		
		
		String message = "&message=" + "Your OTP is1 : " + otp;
		String sender = "&sender=" + "TSN";
		String numbers = "&numbers=" + "84932549135";
		
		// Send data
		HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
		String data = apiKey + numbers + message + sender;
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
		conn.getOutputStream().write(data.getBytes("UTF-8"));
		final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		final StringBuffer stringBuffer = new StringBuffer();
		String line;
		while ((line = rd.readLine()) != null) {
			stringBuffer.append(line);
		}
		rd.close();
		
		return stringBuffer.toString();
	} 
	catch (Exception e)
		{
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
	
	 public static void main(String[] args) {
	        // Tạo một đối tượng OTP
	        OTP otpSender = new OTP();
	        
	        // Gửi tin nhắn và nhận kết quả từ API
	        String result = otpSender.sendSms();
	        
	        // In kết quả ra màn hình
	        System.out.println("Kết quả từ API: " + result);
	    }
}
