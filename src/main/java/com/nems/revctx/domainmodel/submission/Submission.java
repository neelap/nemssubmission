package com.nems.revctx.domainmodel.submission;



import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ne281900 on 4/13/2016.
 */
@Table(name = "NEMS_SUBMISSION")
@Entity(name = "Submission")
@Indexed
public class Submission {
    public Submission() {
    }

    public Submission(String prism_issn, String evise_journalSubmissionId, int evise_journalId, String pii, Set<SubmissionRevision> submissionRevisions) {
        this.prism_issn = prism_issn;
        this.evise_journalSubmissionId = evise_journalSubmissionId;
        this.evise_journalId = evise_journalId;
        this.pii = pii;
        this.submissionRevisions = submissionRevisions;
    }

    @Column(name = "ISSN")
    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.YES)
    private String prism_issn;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SUBMISSION_ID")
    private int evise_sub_id;
    @Column(name = "JRNL_SUBMISSION_ID")
    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.YES)
    private String evise_journalSubmissionId;
    @Column(name = "JRNL_ID")
    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.YES)
    @NumericField
    private int evise_journalId;
    @Column(name = "PII")
    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.YES)
    private String pii;
    @OneToMany(mappedBy = "evise_sub_id", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    @IndexedEmbedded
    private Set<SubmissionRevision> submissionRevisions;


    public String getPrism_issn() {
        return prism_issn;
    }

    public void setPrism_issn(String prism_issn) {
        this.prism_issn = prism_issn;
    }

    public int getEvise_sub_id() {
        return evise_sub_id;
    }

    public void setEvise_sub_id(int evise_sub_id) {
        this.evise_sub_id = evise_sub_id;
    }

    public String getEvise_journalSubmissionId() {
        return evise_journalSubmissionId;
    }

    public void setEvise_journalSubmissionId(String evise_journalSubmissionId) {
        this.evise_journalSubmissionId = evise_journalSubmissionId;
    }

    public int getEvise_journalId() {
        return evise_journalId;
    }

    public void setEvise_journalId(int evise_journalId) {
        this.evise_journalId = evise_journalId;
    }

    public String getPii() {
        return pii;
    }

    public void setPii(String pii) {
        this.pii = pii;
    }

    public Set<SubmissionRevision> getSubmissionRevisions() {
        return submissionRevisions;
    }

    public void setSubmissionRevisions(Set<SubmissionRevision> submissionRevisions) {
        this.submissionRevisions = submissionRevisions;
    }
}
