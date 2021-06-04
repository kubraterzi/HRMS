package project.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name="job_experiences")
@AllArgsConstructor
@NoArgsConstructor
public class JobExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="company_name")
    private String companyName;

    @Column(name="department_name")
    private String departmentName;

    @Column(name="date_of_begin")
    private LocalDate dateOfBegin;

    @Column(name = "date_of_end")
    private LocalDate dateOfEnd;

    @Column(name="created_at", columnDefinition = "Date default CURRENT_DATE")
    private LocalDate createdAt= LocalDate.now();

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name="is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted=false;

    @ManyToOne()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
