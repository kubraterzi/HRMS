package project.hrms.entities.concretes;

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

    @OneToMany(mappedBy = "employer")
    private List<JobAnnouncement> jobAnnouncements;
}
