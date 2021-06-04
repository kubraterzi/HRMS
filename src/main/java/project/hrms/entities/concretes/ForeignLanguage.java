package project.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name="foreign_languages")
@AllArgsConstructor
@NoArgsConstructor
public class ForeignLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "language_name")
    private String languageName;

    @Min(1)
    @Max(5)
    @Column(name = "level")
    private short level;

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
