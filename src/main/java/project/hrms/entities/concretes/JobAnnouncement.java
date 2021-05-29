package project.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="job_announcements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAnnouncement {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "job_position_description")
    private String jobPositionDescription;

    @Column(name="open_position_quoto")
    private int openPositionQuoto;

    @Column(name="announcement_published_at")
    private LocalDate announcementPublishedAt;

    @Column(name="announcement_deadline")
    private LocalDate announcementDeadline;

    @Column(name="min_salary")
    private int minSalary;

    @Column(name="max_salary")
    private int maxSalary;

    @Column(name="is_active")
    private boolean isActive;

    @Column(name="is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted=false;

    @Column(name="created_at", columnDefinition = "Date default CURRENT_DATE")
    private LocalDate createdAt=LocalDate.now();

    @ManyToOne()
    @JoinColumn(name="city_id")
    private City city;

    @ManyToOne()
    @JoinColumn(name="employer_id", referencedColumnName = "id")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name="job_position_id")
    private JobPosition jobPosition;

}
