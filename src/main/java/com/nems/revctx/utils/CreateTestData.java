package com.nems.revctx.utils;

import com.nems.revctx.domainmodel.submission.Submission;
import com.nems.revctx.domainmodel.submission.SubmissionAsset;
import com.nems.revctx.domainmodel.submission.SubmissionRevision;
import com.nems.revctx.services.submission.SubmissionService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by NE281900 on 4/18/2016.
 */
public class CreateTestData {

    public static void main(String args[]){
        /*Create Test data*/

        /*Create 100 submissions*/
        for (int i =1; i<=100; i++){
            Submission submission = new Submission("ALCOHOL","ALCOHOL_i",9999,"ALCOHOL_PII_".concat(Integer.toString(i)),null);
            SubmissionService.createSubmission(submission);
            int submissionId = submission.getEvise_sub_id();
            System.out.println(submissionId);
            /*Create 5 revisions against the submission ID*/
            Set<SubmissionRevision> submissionRevisions =  new HashSet<SubmissionRevision>();
            for(int j = 1; j<=5; j++){
                SubmissionRevision  revision = new SubmissionRevision(submission.getPii().concat("_").concat(Integer.toString(j)),submissionId,"IN_PROGRESS",submission.getPii().concat("_").concat(Integer.toString(j)).concat("ABSTRACT"),null);
                SubmissionService.createSubmissionRevision(revision);
                int subrevid = revision.getSubrev_id();
                /*For each revision Create a list of 5 files*/
                Set<SubmissionAsset> submissionAssets =  new HashSet<SubmissionAsset>();
                for(int k= 1; k<=5; k++){
                    SubmissionAsset asset = new SubmissionAsset(Integer.toString(submissionId).concat("_").concat(Integer.toString(subrevid)).concat("_").concat(Integer.toString(k)),"S3","Manuscript",subrevid);
                    SubmissionService.createSubmissionAsset(asset);
                    submissionAssets.add(asset);
                }
                revision.setSubmissionAssets(submissionAssets);
                submissionRevisions.add(revision);
            }
            submission.setSubmissionRevisions(submissionRevisions);
        }

    }
}
