package com.ptit.controller.addition;

import com.ptit.DAO.UserDAO;
import com.ptit.model.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

public class SendMail {

    public static int SendGmail(User user) {
        final String username = "sobinphim@gmail.com";
        final String password = "ybmmdnhvujorzlrj\n";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sobinphim@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("dodangdung1472001@gmail.com")
            );
            String passwordRandom = String.valueOf(RandomPassWord.generatePassword(8));
            message.setSubject("Mật khẩu đăng nhập Website SobinPhim");
            message.setText("Dear "+ user.getUsername() + ","
                    + "\n\n Your new password Website SobinPhim is " + passwordRandom + "\n\n Quay trở lại website: \n https://localhost:8443/WebMovie_war_exploded/login.jsp" );

            Transport.send(message);

            System.out.println("Done");

//            new UserDAO().setUserPassword(user.getId(), new HashMD5().getHashMD5(passwordRandom));
            return 1; // gửi mail thành công
        } catch (MessagingException e) {
            e.printStackTrace();
            return 0; // gửi mail fail
        }
//        catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//            return 0;
//        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(SendGmail(new UserDAO().getUserByUserPass("user3", new HashMD5().getHashMD5("123"))));
    }


}