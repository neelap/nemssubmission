package com.nems.revctx.services.submission;

import com.nems.revctx.domain.SubmissionEntity;
import com.nems.revctx.domain.SubmissionRevisionEntity;
import com.nems.revctx.repository.submission.SubmissionRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NE281900 on 4/9/2016.
 */
public class SubmissionService {

    public static void createSubmission(SubmissionEntity submissionEntity) {
        SubmissionRepository submissionRepository =  new SubmissionRepository();
        submissionRepository.saveSubmission(submissionEntity);
    }

    public static void deleteSubmission(SubmissionEntity submissionEntity) {

    }

    public static void createSubmissionRevision(SubmissionRevisionEntity submissionRevisionEntity) {

    }

    public static void deleteSubmissionRevision(SubmissionRevisionEntity submissionRevisionEntity) {

    }

    public static List<SubmissionEntity> getSubmissions() {
        SubmissionRepository submissionRepository =  new SubmissionRepository();
        return submissionRepository.getSubmissionEntities();
    }

    public static void main(String args[]){
        SubmissionRepository submissionRepository =  new SubmissionRepository();
        ArrayList<SubmissionEntity> sub = (ArrayList<SubmissionEntity>) submissionRepository.getSubmissionEntities();
        System.out.println(sub.size());
    }
}
