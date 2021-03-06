package com.nems.revctx.domainmodel.submission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ne281900 on 4/13/2016.
 */
@Table(name = "NEMS_SUBMISSION_REV")
@Entity(name = "SubmissionRevision")
@Indexed
public class SubmissionRevision {
    public SubmissionRevision() {
    }

    public SubmissionRevision(String full_title, int evise_sub_id, String statusCode, String ms_abstract, Set<SubmissionAsset> submissionAssets) {
        this.full_title = full_title;
        this.evise_sub_id = evise_sub_id;
        this.statusCode = statusCode;
        this.ms_abstract = ms_abstract;
        this.submissionAssets = submissionAssets;
    }

    @Id
    @Column(name = "SUBREV_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int subrev_id;
    @Column(name = "FULL_TITLE")
    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.YES)
    private String full_title;
    @Column(name = "SUBMISSION_ID")
    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.YES)
    @NumericField
    private int evise_sub_id;
    @Column(name = "STATUS")
    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.YES)
    private String statusCode;
    @Column(name = "ABSTRACT")
    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.YES)
    private String ms_abstract;

    @OneToMany(mappedBy = "subrev_id", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @IndexedEmbedded
    private Set<SubmissionAsset> submissionAssets;

    public int getSubrev_id() {
        return subrev_id;
    }

    public void setSubrev_id(int subrev_id) {
        this.subrev_id = subrev_id;
    }

    public String getFull_title() {
        return full_title;
    }

    public void setFull_title(String full_title) {
        this.full_title = full_title;
    }

    public int getEvise_sub_id() {
        return evise_sub_id;
    }

    public void setEvise_sub_id(int evise_sub_id) {
        this.evise_sub_id = evise_sub_id;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMs_abstract() {
        return ms_abstract;
    }

    public void setMs_abstract(String ms_abstract) {
        this.ms_abstract = ms_abstract;
    }

    public Set<SubmissionAsset> getSubmissionAssets() {
        return submissionAssets;
    }

    public void setSubmissionAssets(Set<SubmissionAsset> submissionAssets) {
        this.submissionAssets = submissionAssets;
    }
}
