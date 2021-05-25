package project.hrms.core.utilities.mail;

public class MailSenderManager implements MailSenderService {
    @Override
    public void sendMail(String email) {
        System.out.println("Mail sended to : " + email);
    }
}


// kimden, kime, mail konusu, içerik
// username, password, smtpserver, port, ssl -> sunucu ayarları