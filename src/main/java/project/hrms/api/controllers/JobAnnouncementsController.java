package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.JobAnnouncementService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobAnnouncement;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/job-announcements/")
public class JobAnnouncementsController {
    private JobAnnouncementService jobAnnouncementService;

    @Autowired
    public JobAnnouncementsController(JobAnnouncementService jobAnnouncementService) {
        this.jobAnnouncementService = jobAnnouncementService;
    }


    @GetMapping("getallbyactive")
    public DataResult<List<JobAnnouncement>> getAllByActive(){
        return this.jobAnnouncementService.getAllByActive();
    }

    @GetMapping("getalbyactiveandemployer")
    public DataResult<List<JobAnnouncement>> getAllByActiveAndEmployer(@RequestParam int employerId){
        return this.jobAnnouncementService.getAllByActiveAndEmployer(employerId);
    }

    @GetMapping("getallbyjobposition")
    public DataResult<List<JobAnnouncement>> getAllByJobPosition(@RequestParam int jobPositionId){
        return this.jobAnnouncementService.getAllByJobPosition(jobPositionId);
    }

    @GetMapping("getallbyannouncementdeadline")
    public DataResult<List<JobAnnouncement>> getAllByAnnouncementDeadline(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return this.jobAnnouncementService.getAllByAnnouncementDeadline(date);
    }

    @PostMapping("addjobannouncement")
    public Result addJobAnnouncement(@RequestBody JobAnnouncement jobAnnouncement){
        return this.jobAnnouncementService.addJobAnnouncement(jobAnnouncement);
    }

    @GetMapping("publishjobannouncement")
    public Result publishJobAnnouncement(@RequestParam int jobAnnouncementId){
        return this.jobAnnouncementService.publishJobAnnouncement(jobAnnouncementId);
    }

    @GetMapping("setpassivejobannouncement")
    public Result setPassiveJobAnnouncement(@RequestParam int jobAnnouncementId){
        return this.jobAnnouncementService.setPassiveJobAnnouncement(jobAnnouncementId);
    }


}
