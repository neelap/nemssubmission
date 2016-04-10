package com.nems.revctx.services.submission;

import com.nems.revctx.domain.SubmissionEntity;
import com.nems.revctx.domain.SubmissionRevisionEntity;
import com.nems.revctx.repository.submission.SubmissionRepository;

/**
 * Created by NE281900 on 4/9/2016.
 */
public class SubmissionService {

    public void createSubmission(SubmissionEntity submissionEntity) {
        SubmissionRepository submissionRepository =  new SubmissionRepository();
        submissionRepository.saveSubmission(submissionEntity);
    }

    public void deleteSubmission(SubmissionEntity submissionEntity) {

    }

    public void createSubmissionRevision(SubmissionRevisionEntity submissionRevisionEntity) {

    }

    public void deleteSubmissionRevision(SubmissionRevisionEntity submissionRevisionEntity) {

    }
}
