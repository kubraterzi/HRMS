package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobAnnouncement;

import java.time.LocalDate;
import java.util.List;

public interface JobAnnouncementService {

    DataResult<List<JobAnnouncement>> getAllByCityName(int cityId);
    DataResult<List<JobAnnouncement>> getAllByJobPosition(int jobPositionId);
    DataResult<List<JobAnnouncement>> getAllByActive();
    DataResult<List<JobAnnouncement>> getAllByActiveAndEmployer(int employerId);
    DataResult<List<JobAnnouncement>> getAllByAnnouncementDeadline(LocalDate date);
    Result addJobAnnouncement(JobAnnouncement jobAnnouncement);
    Result publishJobAnnouncement(int jobAnnouncementId);
    Result setPassiveJobAnnouncement(int jobAnnouncementId);
}
