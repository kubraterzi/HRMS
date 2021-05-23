package project.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="candidate_verification_codes")
@PrimaryKeyJoinColumn(name="verification_id")
@AllArgsConstructor
@NoArgsConstructor
public class CandidateVerificationCode extends VerificationCode{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private Candidate candidateId;
}
