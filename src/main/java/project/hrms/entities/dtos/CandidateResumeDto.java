package project.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.hrms.entities.concretes.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateResumeDto {

    private Candidate candidate;
    private CandidateImage candidateImage;
    private List<Education> educationList;
    private List<JobExperience> jobExperienceList;
    private List<Skill> skillList;
    private List<ForeignLanguage> foreignLanguageList;
    private List<Link> links;
    private List<CurriculumVitae> curriculumVitaeList;

}
