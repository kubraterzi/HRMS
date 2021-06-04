package project.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@PrimaryKeyJoinColumn(name="id")
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAnnouncements"})
public class Employer extends User {

    @Column(name="website")
    private String website;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="company_name")
    private String companyName;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<JobAnnouncement> jobAnnouncements;

    public Employer(String email, String password, String website, String phoneNumber, String companyName, List<JobAnnouncement> jobAnnouncements) {
        super(email, password);
        this.website = website;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
        this.jobAnnouncements = jobAnnouncements;
    }
}
