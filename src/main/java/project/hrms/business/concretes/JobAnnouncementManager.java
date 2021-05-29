package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.JobAnnouncementService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.JobAnnouncementDao;
import project.hrms.entities.concretes.JobAnnouncement;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobAnnouncementManager implements JobAnnouncementService {

    private JobAnnouncementDao jobAnnouncementDao;

    @Autowired
    public JobAnnouncementManager(JobAnnouncementDao jobAnnouncementDao) {
        this.jobAnnouncementDao = jobAnnouncementDao;
    }


    @Override
    public DataResult<List<JobAnnouncement>> getAllByCityName(int cityId) {
        return new SuccessDataResult<List<JobAnnouncement>>(this.jobAnnouncementDao.findAllByCity_Id(cityId));
    }

    @Override
    public DataResult<List<JobAnnouncement>> getAllByJobPosition(int jobPositionId) {
        return new SuccessDataResult<List<JobAnnouncement>>(this.jobAnnouncementDao.findAllByJobPosition_Id(jobPositionId));
    }

    @Override
    public DataResult<List<JobAnnouncement>> getAllByActive() {
        return new SuccessDataResult<List<JobAnnouncement>>(this.jobAnnouncementDao.findAllByIsActiveTrueOrderByAnnouncementDeadlineDesc());
    }

    @Override
    public DataResult<List<JobAnnouncement>> getAllByActiveAndEmployer(int employerId) {
        return new SuccessDataResult<List<JobAnnouncement>>(this.jobAnnouncementDao.findAllByEmployer_IdAndIsActiveTrue(employerId));
    }

    @Override
    public DataResult<List<JobAnnouncement>> getAllByAnnouncementDeadline(LocalDate date) {
        return new SuccessDataResult<List<JobAnnouncement>>(this.jobAnnouncementDao.findAllByAnnouncementDeadlineLessThanEqual(date));
    }

    @Override
    public Result addJobAnnouncement(JobAnnouncement jobAnnouncement) {
        this.jobAnnouncementDao.save(jobAnnouncement);
        return new SuccessResult("Added.");
    }

    @Override
    public Result publishJobAnnouncement(int jobAnnouncementId) {
        JobAnnouncement publishedJobAnnouncement = this.jobAnnouncementDao.findById(jobAnnouncementId).get();
        publishedJobAnnouncement.setActive(true);
        publishedJobAnnouncement.setAnnouncementPublishedAt(LocalDate.now());
        this.jobAnnouncementDao.save(publishedJobAnnouncement);
        return new SuccessResult("The announcement has been published.");
    }

    @Override
    public Result setPassiveJobAnnouncement(int jobAnnouncementId) {
        JobAnnouncement doPassivedJobAnnouncement = this.jobAnnouncementDao.findById(jobAnnouncementId).get();
        doPassivedJobAnnouncement.setActive(!doPassivedJobAnnouncement.isActive());
        this.jobAnnouncementDao.save(doPassivedJobAnnouncement);
        return new SuccessResult("The announcement has been deactivated.");

    }


}
