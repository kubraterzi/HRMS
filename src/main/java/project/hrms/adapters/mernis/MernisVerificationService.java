package project.hrms.adapters.mernis;

import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Candidate;

public interface MernisVerificationService {

    Result checkIfRealPerson(Candidate candidate);
}
