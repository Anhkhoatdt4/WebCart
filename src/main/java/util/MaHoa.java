package util;

import java.security.MessageDigest;
import java.util.Base64;

public class MaHoa {
	public static String toSHA1(String mk)
	{
		String salt="khjsdvgbflsk.fjh,";
		String result=null;
		
		mk=mk+salt;
		try
		{
			byte[] dataBytes= mk.getBytes("UTF-8");
			MessageDigest md=MessageDigest.getInstance("SHA-1");
			result =Base64.getEncoder().encodeToString(dataBytes);
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(toSHA1("congbao19"));
	}
}
