package com.droovo.tn.usermessagingservice.Services.Impl;

import com.droovo.tn.usermessagingservice.Entites.UserDetail;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.droovo.tn.usermessagingservice.Entites.Message;
import com.droovo.tn.usermessagingservice.Repositories.MessageRepository;
import com.droovo.tn.usermessagingservice.Repositories.UserDetailRepository;
import com.droovo.tn.usermessagingservice.Services.EmailService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender emailSender;
    private final MessageRepository messageRepository;
    private final UserDetailRepository userDetailRepository;

    @Override
    public void sendSimpleEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    @Override

    public void sendEmailWithTemplate(UserDetail user) {
        // Créer une instance de MimeMessage à l'aide de la fonction JavaMailSender
        MimeMessage message = emailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    "UTF-8");

            // Définir l'adresse électronique du destinataire
            helper.setTo(user.getEmail());

            // Définir l'objet de l'e-mail
            helper.setSubject("Subscription Alert");

            // Charger le modèle de courrier électronique à partir d'un fichier ou d'une
            // chaîne de caractères
            String emailTemplate = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Welcome to Droovo Application</title>\n" +
                    "    <style>\n" +
                    "        .container {\n" +
                    "            font-family: Arial, sans-serif;\n" +
                    "            padding: 20px;\n" +
                    "            background-color: #f9f9f9;\n" +
                    "            color: #333;\n" +
                    "            border: 1px solid #ddd;\n" +
                    "            border-radius: 5px;\n" +
                    "            max-width: 600px;\n" +
                    "            margin: auto;\n" +
                    "        }\n" +
                    "        h2 {\n" +
                    "            color: #4CAF50;\n" + // Changed to a more neutral, welcoming color
                    "        }\n" +
                    "        .info {\n" +
                    "            font-size: 14px;\n" +
                    "            line-height: 1.5;\n" +
                    "        }\n" +
                    "        .highlight {\n" +
                    "            font-weight: bold;\n" +
                    "            color: #4CAF50;\n" + // Matched the color with the header
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <div class=\"container\">\n" +
                    "        <h2>Welcome to HR Manager Portal!</h2>\n" +
                    "        <p>Hello {{username}},</p>\n" +
                    "        <p class=\"info\">\n" +
                    "            Your Droovo account has been successfully created. We're excited to have you onboard and look forward to helping you manage your account tasks effectively.\n" +
                    "        </p>\n" +
                    "        <p class=\"info\">\n" +
                    "            <strong>Username:</strong> {{email}}\n" +
                    "            <br>\n" +
                    "            <strong>Registration Date:</strong> {{date}}\n" +
                    "        </p>\n" +
                    "        <p class=\"info\">\n" +
                    "            Start by visiting your Dashboard to customize your profile and explore the features available to you.\n" +
                    "        </p>\n" +
                    "        <p>Best regards,<br>HR Droovo Team</p>\n" +
                    "    </div>\n" +
                    "</body>\n" +
                    "</html>";

            // Remplacer les espaces réservés par des valeurs réelles
            // Get current date
            Date currentDate = new Date();

            // Format the date as a string
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(currentDate);

            emailTemplate = emailTemplate.replace("{{date}}", currentDate.toString());
            emailTemplate = emailTemplate.replace("{{email}}", user.getEmail());
            emailTemplate = emailTemplate.replace("{{username}}", user.getDisplayName());

            // Définir le contenu de l'e-mail en HTML
            helper.setText(emailTemplate, true);

            // Envoyer l'email
            emailSender.send(message);
        } catch (MessagingException e) {
            // Handle messaging exceptions
            throw new RuntimeException(e);
        }
    }

    @Override
    public Message  saveMessage(Message message) {
        UserDetail sender = userDetailRepository.findById(message.getSender().getId()).orElseThrow(() -> new RuntimeException("Sender not found"));
        UserDetail receiver = userDetailRepository.findById(message.getReceiver().getId()).orElseThrow(() -> new RuntimeException("Receiver not found"));
        message.setSender(sender);
        message.setReceiver(receiver);
        return messageRepository.save(message);
    }
    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> getMessagesByUserIds(Long senderId, Long receiverId) {
        return messageRepository.findBySenderIdAndReceiverId(senderId, receiverId);
    }
    @Override
    public Message sendMessage(String senderId, String receiverId, String content) {
        UserDetail sender = userDetailRepository.findById(senderId)
                .orElseThrow(() -> new RuntimeException("Sender not found"));

        UserDetail receiver = userDetailRepository.findById(receiverId)
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        Message message = new Message();
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setContent(content);
        message.setTimestamp(System.currentTimeMillis());

        return messageRepository.save(message);
    }
}
