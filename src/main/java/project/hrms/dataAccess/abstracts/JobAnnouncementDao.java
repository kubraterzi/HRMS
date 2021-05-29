package project.hrms.dataAccess.abstracts;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.JobAnnouncement;

import java.time.LocalDate;
import java.util.List;

public interface JobAnnouncementDao extends JpaRepository<JobAnnouncement, Integer> {

    List<JobAnnouncement> findAllByCity_Id(int cityId);
    List<JobAnnouncement> findAllByJobPosition_Id(int jobPositionId);
    List<JobAnnouncement> findAllByEmployer_IdAndIsActiveTrue(int employerId);
    List<JobAnnouncement> findAllByIsActiveTrueOrderByAnnouncementDeadlineDesc();
    List<JobAnnouncement> findAllByAnnouncementDeadlineLessThanEqual(LocalDate date);

//    List<JobAnnouncement> findAllByAnnouncementDeadlineBefore(LocalDate date); -> Eğer bu şekilde verirsek Swagger tarafında, istenilen günden bir gün sonrasını girmek gerekir.

//    @Query("FROM JobAnnouncement where employer.id=:employerId and isActive=true order by announcementPublishedAt ASC")
//    List<JobAnnouncement> findAllByActiveAndAnnouncementPublishedAt(int employerId);
}
