package com.jud.yaari.Yaari.Backend.Code.DTO;

public class CommentsDTO {
    public CommentsDTO(String commentId, String postId, String commentBy, String commentDate, String timestamp) {
        this.commentId = commentId;
        this.postId = postId;
        this.commentBy = commentBy;
        CommentDate = commentDate;
        this.timestamp = timestamp;
    }

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

    public String getCommentDate() {
        return CommentDate;
    }

    public void setCommentDate(String commentDate) {
        CommentDate = commentDate;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String commentId, postId, commentBy, CommentDate, timestamp;

}
