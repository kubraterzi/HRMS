package project.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="employers_verification_systempersonnels")
@AllArgsConstructor
@NoArgsConstructor
public class VerificateEmployerBySystemPersonnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private Employer employerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private SystemPersonnel systempersonnelId;

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="is_confirmed")
    private boolean isConfirmed;
}
