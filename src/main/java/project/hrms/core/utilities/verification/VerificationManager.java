package project.hrms.core.utilities.verification;

import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.UUID;

@Service
public class VerificationManager implements VerificationService {

    @Override
    public void verificateWithVerificationLink(String email) {

        UUID generatedString =UUID.randomUUID();
        String verificationLink = "https://www.kthumanresources.com/" + generatedString;
        System.out.println("Verification code sended to : " + email);
        System.out.println("Please click to link : " + verificationLink);
    }

    @Override
    public String verificateWithVerificationCode() {

        byte[] array = new byte[6]; // length is bounded by 6 - resource : https://www.baeldung.com/java-random-string
        new Random().nextBytes(array);
        String verificationCode = new String(array, Charset.forName("UTF-8"));
        System.out.println("Your verification code : " + verificationCode);
        return verificationCode;

    }
}
