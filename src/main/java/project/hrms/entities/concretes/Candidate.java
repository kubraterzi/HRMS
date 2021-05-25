package project.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@PrimaryKeyJoinColumn(name="user_id")
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidates")
public class Candidate extends User {

    @Column(name="first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name="national_id")
    private String nationalId;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    public Candidate(String email, String password, String firstName, String lastName, String nationalId, LocalDate dateOfBirth) {
        super(email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalId = nationalId;
        this.dateOfBirth = dateOfBirth;
    }
}
