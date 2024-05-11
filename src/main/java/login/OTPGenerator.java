package login;

import java.util.Random;

public class OTPGenerator {
    private String otpChars;
    private int otpLength;

    public OTPGenerator(String otpChars, int otpLength) {
        this.otpChars = otpChars;
        this.otpLength = otpLength;
    }

    public String generateOTP() {
        Random random = new Random();
        StringBuilder otp = new StringBuilder(otpLength);
        for (int i = 0; i < otpLength; i++) {
            otp.append(otpChars.charAt(random.nextInt(otpChars.length())));
        }
        return otp.toString();
    }
    public static void main(String[] args) {
        OTPGenerator otpGenerator = new OTPGenerator("0123456789", 5);
        String otp = otpGenerator.generateOTP();
        System.out.println("Generated OTP: " + otp);
    }
}