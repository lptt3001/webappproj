package com.example.demo.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendResetPasswordEmail(String to, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hieunao96@gmail.com");
        message.setTo(to);
        message.setSubject("Khôi phục mật khẩu - 📖 Blog");
        message.setText("Chào bạn,\n\nBạn đã yêu cầu khôi phục mật khẩu trên Blog của chúng tôi.\n" +
                "Mã khôi phục của bạn là: " + token + "\n" +
                "Hoặc click vào link: http://localhost:8080/reset-password?token=" + token + "\n\n" +
                "Nếu bạn không yêu cầu điều này, hãy bỏ qua email này.");
        
        mailSender.send(message);
    }
}
