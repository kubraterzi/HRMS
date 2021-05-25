package project.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Column(name="employer_id")
    private int employerId;

    @Column(name="systempersonnel_id")
    private int systempersonnelId;

    @Column(name="created_at", columnDefinition = "Date default CURRENT_DATE")
    private LocalDate createdAt = LocalDate.now();

    @Column(name="is_verified", columnDefinition = "boolean default true")
    private boolean isVerified = true;

    @Column(name="is_deleted", columnDefinition = "boolean default true")
    private boolean isDeleted=false;
}
