package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.adapters.mernis.MernisVerificationManager;
import project.hrms.adapters.mernis.MernisVerificationService;
import project.hrms.business.abstracts.*;
import project.hrms.core.utilities.business.BusinessRules;
import project.hrms.core.utilities.results.*;
import project.hrms.dataAccess.abstracts.CandidateDao;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.concretes.JobExperience;
import project.hrms.entities.dtos.CandidateResumeDto;
import project.hrms.entities.dtos.RegisterForCandidateAuthDto;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;
    private MernisVerificationService mernisVerificationService = new MernisVerificationManager();

    private EducationService educationService;
    private JobExperienceService jobExperienceService;
    private ForeignLanguageService foreignLanguageService;
    private SkillService skillService;
    private LinkService linkService;
    private CandidateImageService candidateImageService;
    private CurriculumVitaeService curriculumVitaeService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, EducationService educationService, JobExperienceService jobExperienceService, ForeignLanguageService foreignLanguageService,
                            SkillService skillService, LinkService linkService, CandidateImageService candidateImageService, CurriculumVitaeService curriculumVitaeService) {
        this.candidateDao = candidateDao;
        this.educationService = educationService;
        this.jobExperienceService = jobExperienceService;
        this.foreignLanguageService = foreignLanguageService;
        this.skillService = skillService;
        this.linkService = linkService;
        this.candidateImageService = candidateImageService;
        this.curriculumVitaeService = curriculumVitaeService;
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(candidateDao.findAll());
    }

    @Override
    public DataResult<Candidate> getByNationalId(String nationalId) {
        return new SuccessDataResult<Candidate>(candidateDao.findByNationalId(nationalId));
    }

    @Override
    public DataResult<CandidateResumeDto> getCandidateResumeByCandidateId(int candidateId) {

        CandidateResumeDto candidateResumeDto = new CandidateResumeDto();
        candidateResumeDto.setCandidate(this.get(candidateId).getData());
        candidateResumeDto.setEducationList(this.educationService.getAllEducationsByCandidateId(candidateId).getData());
        candidateResumeDto.setJobExperienceList(this.jobExperienceService.getJobExperiencesByCandidateId(candidateId).getData());
        candidateResumeDto.setForeignLanguageList(this.foreignLanguageService.getForeignLanguagesByCandidateId(candidateId).getData());
        candidateResumeDto.setSkillList(this.skillService.getSkillsByCandidateId(candidateId).getData());
        candidateResumeDto.setLinks(this.linkService.getLinksByCandidateId(candidateId).getData());
        candidateResumeDto.setCurriculumVitaeList(this.curriculumVitaeService.getCurriculumVitaesByCandidateId(candidateId).getData());
        candidateResumeDto.setCandidateImage(this.candidateImageService.getCandidateImagesByCandidateId(candidateId).getData());
        return new SuccessDataResult<CandidateResumeDto>(candidateResumeDto);
    }

    @Override
    public DataResult<Candidate> get(int id) {
        return new SuccessDataResult<Candidate>(this.candidateDao.findById(id).get());
    }

    @Override
    public Result add(Candidate candidate) {
        var result = BusinessRules.run(checkUserExistsByNationalId(candidate), this.mernisVerificationService.checkIfRealPerson(candidate));
        if (!result.isSuccess()){
            return new ErrorResult(result.getMessage());
        }

        candidateDao.save(candidate);
        return new SuccessResult("Added.");
    }

    @Override
    public Result delete(Candidate candidate) {
        candidateDao.delete(candidate);
        return new SuccessResult("Deleted.");
    }

    @Override
    public Result update(Candidate candidate) {
        candidateDao.save(candidate);
        return new SuccessResult("Updated.");
    }

    private Result checkUserExistsByNationalId(Candidate candidate){

        var candidateNationalId = getByNationalId(candidate.getNationalId());
        if(candidateNationalId.getData() !=null){
            new ErrorResult("This identification number has been used before.");
        }

        return new SuccessResult();
    }

}
