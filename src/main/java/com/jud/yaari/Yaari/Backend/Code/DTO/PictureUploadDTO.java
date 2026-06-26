package com.jud.yaari.Yaari.Backend.Code.DTO;

public class PictureUploadDTO {
    public PictureUploadDTO(String postId,
                            String postDescription,
                            String postLink,
                            String postLocation,
                            int postDayOfUpload,
                            int postDateOfUpload,
                            int postMonthOfUpload,
                            int postYearOfUpload,
                            String postOwner,
                            long postTimeOfUpload) {
        this.postId = postId;
        this.postDescription = postDescription;
        this.postLink = postLink;
        this.postLocation = postLocation;
        this.postDateOfUpload = postDateOfUpload;
        this.postDayOfUpload = postDayOfUpload;
        this.postMonthOfUpload = postMonthOfUpload;
        this.postYearOfUpload = postYearOfUpload;
        this.postOwner = postOwner;
        this.postTimeOfUpload = postTimeOfUpload;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\t\"postId\" : \"" + this.postId + "\",\n" +
                "\t\"postDescription\" : \"" + this.postDescription + "\",\n" +
                "\t\"postLink\" : \"" + this.postLink + "\",\n" +
                "\t\"postLocation\" : \"" + this.postLocation + "\",\n" +
                "\t\"postDateOfUpload\" : \"" + this.postDateOfUpload + "\",\n" +
                "\t\"postDayOfUpload\" : \"" + this.postDayOfUpload + "\",\n" +
                "\t\"postMonthOfUpload\" : \"" + this.postMonthOfUpload + "\",\n" +
                "\t\"postYearOfUpload\" : \"" + this.postYearOfUpload + "\",\n" +
                "\t\"postOwner\" : \"" + this.postOwner + "\",\n" +
                "\t\"postTimeOfUpload\" : \"" + this.postTimeOfUpload + "\",\n}";
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

    public int getPostDateOfUpload() {
        return postDateOfUpload;
    }

    public void setPostDateOfUpload(int postDateOfUpload) {
        this.postDateOfUpload = postDateOfUpload;
    }

    public int getPostYearOfUpload() {
        return postYearOfUpload;
    }

    public void setPostYearOfUpload(int postYearOfUpload) {
        this.postYearOfUpload = postYearOfUpload;
    }

    public long getPostTimeOfUpload() {
        return postTimeOfUpload;
    }

    public void setPostTimeOfUpload(long postTimeOfUpload) {
        this.postTimeOfUpload = postTimeOfUpload;
    }

    public String getPostOwner() {
        return postOwner;
    }

    public void setPostOwner(String postOwner) {
        this.postOwner = postOwner;
    }

    public int getPostMonthOfUpload() {
        return postMonthOfUpload;
    }

    public void setPostMonthOfUpload(int postMonthOfUpload) {
        this.postMonthOfUpload = postMonthOfUpload;
    }

    public String postId;
    public String postDescription;
    public String postLink;
    public String postLocation;
    public int postDateOfUpload;
    public int postMonthOfUpload;

    public int getPostDayOfUpload() {
        return postDayOfUpload;
    }

    public void setPostDayOfUpload(int postDayOfUpload) {
        this.postDayOfUpload = postDayOfUpload;
    }

    public int postDayOfUpload;
    public int postYearOfUpload;
    public long postTimeOfUpload;
    public String postOwner;

}
