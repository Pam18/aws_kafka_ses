package br.com.aws_kafka_consumer.services.ses;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import software.amazon.awssdk.services.ses.SesClient;

public class SESService {
    public static void sendMessage(String subject, String message) {
        SesClient sesClient = Configurations.getSesClient();

        String bodyText = "E-mail: " + message;

        String bodyHTML = "<html>"
                + "<head></head>"
                + "<body>"
                + "<h1>Olá Pamela!</h1>"
                + "<p>" + message + " enviada pelo Java.</p>"
                + "</body>"
                + "</html>";

        try {
            MimeMessage messageMime = SendMessage.send(sesClient, "yhaohannah@gmail.com", "yhaohannah@gmail.com", 
                "Email!!!", bodyText, bodyHTML);

            ByteMessage.sendByte(messageMime);

            sesClient.close();

            System.out.println("O e-mail foi enviado.");

        } catch (IOException | MessagingException e) {
            e.getStackTrace();
        }
    }
}
