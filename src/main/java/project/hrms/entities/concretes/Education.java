package project.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="schools")
@AllArgsConstructor
@NoArgsConstructor
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="school_name")
    private String schoolName;

    @Column(name="department_name")
    private String departmentName;

    @Column(name="begin_of_date")
    private LocalDate beginOfDate;

    @Column(name="date_of_graduation")
    private LocalDate dateOfGraduation;

    @Column(name="created_at", columnDefinition = "Date default CURRENT_DATE")
    private LocalDate createdAt= LocalDate.now();

    @Column(name="is_active")
    private boolean isActive;

    @Column(name="is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted=false;

    @ManyToOne()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

}
