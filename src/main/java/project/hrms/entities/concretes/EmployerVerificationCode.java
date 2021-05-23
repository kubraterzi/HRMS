package project.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="employer_verification_codes")
@PrimaryKeyJoinColumn(name="verification_id")
@AllArgsConstructor
@NoArgsConstructor
public class EmployerVerificationCode extends VerificationCode{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private Employer employerId;
}
