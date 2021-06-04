package project.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "links")
@AllArgsConstructor
@NoArgsConstructor
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "account_name")
    private String accountName;

    @Column(name="link_url")
    private String linkUrl;

    @Column(name="created_at", columnDefinition = "Date default CURRENT_DATE")
    private LocalDate createdAt= LocalDate.now();

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name="is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted=false;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

}
