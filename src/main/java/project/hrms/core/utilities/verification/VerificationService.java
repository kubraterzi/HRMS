package project.hrms.core.utilities.verification;

public interface VerificationService {

    void verificateWithVerificationLink(String email);
    String verificateWithVerificationCode();
}
