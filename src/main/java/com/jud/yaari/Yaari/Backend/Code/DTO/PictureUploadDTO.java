package com.jud.yaari.Yaari.Backend.Code.DTO;

public class PictureUploadDTO {
    public PictureUploadDTO(String postId, String postDescription, String postLink, String postLocation, String postDateOfUpload,  String postMonthOfUpload, String postYearOfUpload, String postOwner, String postTimeOfUpload) {
        this.postId = postId;
        this.postDescription = postDescription;
        this.postLink = postLink;
        this.postLocation = postLocation;
        this.postDateOfUpload = postDateOfUpload;
        this.postMonthOfUpload = postMonthOfUpload;
        this.postYearOfUpload = postYearOfUpload;
        this.postOwner = postOwner;
        this.postTimeOfUpload = postTimeOfUpload;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public String getPostLink() {
        return postLink;
    }

    public void setPostLink(String postLink) {
        this.postLink = postLink;
    }

    public String getPostLocation() {
        return postLocation;
    }

    public void setPostLocation(String postLocation) {
        this.postLocation = postLocation;
    }

    public String getPostDateOfUpload() {
        return postDateOfUpload;
    }

    public void setPostDateOfUpload(String postDateOfUpload) {
        this.postDateOfUpload = postDateOfUpload;
    }

    public String getPostYearOfUpload() {
        return postYearOfUpload;
    }

    public void setPostYearOfUpload(String postYearOfUpload) {
        this.postYearOfUpload = postYearOfUpload;
    }

    public String getPostTimeOfUpload() {
        return postTimeOfUpload;
    }

    public void setPostTimeOfUpload(String postTimeOfUpload) {
        this.postTimeOfUpload = postTimeOfUpload;
    }

    public String getPostOwner() {
        return postOwner;
    }

    public void setPostOwner(String postOwner) {
        this.postOwner = postOwner;
    }

    public String getPostMonthOfUpload() {
        return postMonthOfUpload;
    }

    public void setPostMonthOfUpload(String postMonthOfUpload) {
        this.postMonthOfUpload = postMonthOfUpload;
    }

    public String postId, postDescription, postLink, postLocation, postDateOfUpload, postMonthOfUpload, postYearOfUpload, postTimeOfUpload, postOwner;

}
