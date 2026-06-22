package com.jud.yaari.Yaari.Backend.Code.DTO;

public class PostCommentDTO {
    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getCommentBy() {
        return commentBy;
    }

    public void setCommentBy(String commentBy) {
        this.commentBy = commentBy;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String commentId, postId, commentBy, comment;

    public PostCommentDTO(String commentId, String postId, String commentBy, String comment) {
        this.commentId = commentId;
        this.postId = postId;
        this.commentBy = commentBy;
        this.comment = comment;
    }
}
