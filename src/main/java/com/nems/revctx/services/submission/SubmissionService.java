package com.nems.revctx.services.submission;

import com.nems.revctx.domainmodel.submission.Submission;
import com.nems.revctx.domainmodel.submission.SubmissionRevision;
import com.nems.revctx.repository.submission.SubmissionRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NE281900 on 4/9/2016.
 */
public class SubmissionService {

    public static void createSubmission(Submission submissionEntity) {
        SubmissionRepository submissionRepository =  new SubmissionRepository();
        submissionRepository.saveSubmission(submissionEntity);
    }

    public static void deleteSubmission(Submission submissionEntity) {

    }

    public static void createSubmissionRevision(SubmissionRevision submissionRevisionEntity) {

    }

    public static void deleteSubmissionRevision(SubmissionRevision submissionRevisionEntity) {

    }

    public static List<Submission> getSubmissions() {
        SubmissionRepository submissionRepository =  new SubmissionRepository();
        return submissionRepository.getSubmissionEntities();
    }

    public static void main(String args[]){
        SubmissionRepository submissionRepository =  new SubmissionRepository();
        ArrayList<Submission> sub = (ArrayList<Submission>) submissionRepository.getSubmissionEntities();
        System.out.println(sub.size());
    }
}
