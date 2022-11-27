package review;

import java.time.LocalDateTime;

public class Comment {
    String commentContent;
    LocalDateTime commentWriteTime;

    public String getCommentContent() {
        return commentContent;
    }

    public LocalDateTime getCommentWriteTime() {
        return commentWriteTime;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public void setCommentWriteTime(LocalDateTime commentWriteTime) {
        this.commentWriteTime = commentWriteTime;
    }

    void writeComment() {

    }

    void editComment() {

    }
}
