package login;

import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
    private static String lastSentOTP;

    public String getLastSentOTP() {
        return lastSentOTP;
    }
    
    public void sendOTP(String recipientEmail) {
    	final String username = "khoanguyenanh218@gmail.com";
        final String password = "zlcs dynx wutq ddpc";
        System.out.println("OTP GEnerator");
        OTPGenerator otpGenerator = new OTPGenerator("0123456789", 5);
        lastSentOTP = otpGenerator.generateOTP(); 

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        System.out.println("alo");
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        System.out.println("!!@@??");
        try {
        	System.out.println("alo1");
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("BKN SHOES - Your OTP Code");
            message.setText("Your OTP code is: " + lastSentOTP);

            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
    public void sendShipmentConfirmationEmail(String recipientEmail, List<String> productNames, String status) {
        final String username = "khoanguyenanh218@gmail.com";
        final String password = "zlcs dynx wutq ddpc";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Thông báo vận chuyển đơn hàng");

            StringBuilder emailContent = new StringBuilder();
            emailContent.append("Chào bạn,\n\n");
            emailContent.append("Đơn hàng của bạn " + status + " . Dưới đây là danh sách sản phẩm đã đặt:\n");
            for (String productName : productNames) {
                emailContent.append("- ").append(productName).append("\n");
            }
            emailContent.append("\nChúng tôi rất hân hạnh được phục vụ bạn. Nếu có bất kỳ thắc mắc nào, vui lòng liên hệ với chúng tôi.\n\n");
            emailContent.append("Trân trọng,\n[BKN SHOES]");

            message.setText(emailContent.toString());

            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) {
		EmailSender a = new EmailSender();
		a.sendOTP("trannhattan410@gmail.com");
	}
}
