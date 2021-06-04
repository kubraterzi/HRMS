package project.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@PrimaryKeyJoinColumn(name="id")
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

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<Education> schools;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<JobExperience> jobExperiences;


    @OneToMany(mappedBy = "candidate", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Link> links;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<ForeignLanguage> foreignLanguages;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<Skill> skills;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<CurriculumVitae> curriculumVitaes;

    @OneToOne(mappedBy = "candidate")
    @JsonIgnore
    private CandidateImage candidateImage;

    public Candidate(String email, String password, String firstName, String lastName, String nationalId, LocalDate dateOfBirth) {
        super(email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalId = nationalId;
        this.dateOfBirth = dateOfBirth;
    }
}
