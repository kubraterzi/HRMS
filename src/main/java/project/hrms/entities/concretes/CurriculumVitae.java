package project.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "curriculum_vitaes")
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumVitae {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cv_note")
    private String cvNote;

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
