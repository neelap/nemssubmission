package com.nems.revctx.domainmodel.submission;

import javax.persistence.*;

/**
 * Created by ne281900 on 4/14/2016.
 */
@Table(name = "NEMS_FILE_ASSETS")
@Entity(name = "SubmissionAsset")
public class SubmissionAsset {

    public SubmissionAsset() {
    }

    public SubmissionAsset(String file_name, String s3_id, String fileLocation, String fileType, int subrev_id) {
        this.file_name = file_name;
        this.s3_id = s3_id;
        this.fileLocation = fileLocation;
        this.fileType = fileType;
        this.subrev_id = subrev_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FILE_ID")
    private int evise_fileId;
    @Column(name = "FILE_NAME")
    private String file_name;
    @Column(name = "S3_ID")
    private String s3_id;
    @Column(name = "FILE_LOCATION")
    private String fileLocation;
    @Column(name = "FILE_TYPE")
    private String fileType;
    @Column(name = "SUBREV_ID")
    private int subrev_id;

    public int getEvise_fileId() {
        return evise_fileId;
    }

    public void setEvise_fileId(int evise_fileId) {
        this.evise_fileId = evise_fileId;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getS3_id() {
        return s3_id;
    }

    public void setS3_id(String s3_id) {
        this.s3_id = s3_id;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public int getSubrev_id() {
        return subrev_id;
    }

    public void setSubrev_id(int subrev_id) {
        this.subrev_id = subrev_id;
    }
}


