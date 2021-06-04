package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getAllByActive(){
        return ResponseEntity.ok(this.jobAnnouncementService.getAllByActive());
    }

    @GetMapping("getalbyactiveandemployer")
    public ResponseEntity<?> getAllByActiveAndEmployer(@RequestParam int employerId){
        return ResponseEntity.ok(this.jobAnnouncementService.getAllByActiveAndEmployer(employerId));
    }

    @GetMapping("getallbyjobposition")
    public ResponseEntity<?> getAllByJobPosition(@RequestParam int jobPositionId){
        return ResponseEntity.ok(this.jobAnnouncementService.getAllByJobPosition(jobPositionId));
    }

    @GetMapping("getallbyannouncementdeadline")
    public ResponseEntity<?> getAllByAnnouncementDeadline(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return ResponseEntity.ok(this.jobAnnouncementService.getAllByAnnouncementDeadline(date));
    }

    @GetMapping("publishjobannouncement")
    public ResponseEntity<?> publishJobAnnouncement(@RequestParam int jobAnnouncementId){
        return ResponseEntity.ok(this.jobAnnouncementService.publishJobAnnouncement(jobAnnouncementId));
    }

    @GetMapping("setpassivejobannouncement")
    public ResponseEntity<?> setPassiveJobAnnouncement(@RequestParam int jobAnnouncementId){
        return ResponseEntity.ok(this.jobAnnouncementService.setPassiveJobAnnouncement(jobAnnouncementId));
    }


    @PostMapping("addjobannouncement")
    public ResponseEntity<?> addJobAnnouncement(@RequestBody JobAnnouncement jobAnnouncement){
        return ResponseEntity.ok(this.jobAnnouncementService.addJobAnnouncement(jobAnnouncement));
    }

}
