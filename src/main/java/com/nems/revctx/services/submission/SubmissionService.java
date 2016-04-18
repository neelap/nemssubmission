package com.nems.revctx.services.submission;

import com.nems.revctx.domainmodel.submission.Submission;
import com.nems.revctx.domainmodel.submission.SubmissionAsset;
import com.nems.revctx.domainmodel.submission.SubmissionRevision;
import com.nems.revctx.repository.submission.SubmissionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by NE281900 on 4/9/2016.
 */
public class SubmissionService {

    public static void createSubmission(Submission submission) {
        SubmissionRepository submissionRepository =  new SubmissionRepository();
        submissionRepository.saveSubmission(submission);
    }

    public static void deleteSubmission(Submission submissionEntity) {

    }

    public static void createSubmissionRevision(SubmissionRevision submissionRevision) {
        SubmissionRepository submissionRepository =  new SubmissionRepository();
        submissionRepository.saveSubmissionRevision(submissionRevision);

    }

    public static void createSubmissionAsset(SubmissionAsset submissionAsset) {
        SubmissionRepository submissionRepository =  new SubmissionRepository();
        submissionRepository.saveAsset(submissionAsset);

    }

    public static void deleteSubmissionRevision(SubmissionRevision submissionRevisionEntity) {

    }

    public static ArrayList<Submission> getSubmissions() {
        SubmissionRepository submissionRepository =  new SubmissionRepository();
        return submissionRepository.getSubmissions();
    }

    public static void main(String args[]){
        SubmissionRepository submissionRepository =  new SubmissionRepository();
        ArrayList<Submission> sub = (ArrayList<Submission>) submissionRepository.getSubmissions();
        System.out.println(sub.size());
    }
}
