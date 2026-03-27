package org.mailtrap;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.example.Mailtrap;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        Mailtrap mail = new Mailtrap("sandbox.smtp.mailtrap.io", "176608dbaea411", "6e545bd6f295d5", 587);
        mail.enviarMail();
    }
}