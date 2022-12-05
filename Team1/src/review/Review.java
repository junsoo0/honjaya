package review;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Review {
    int starPoint;
    String reviewPhoto;
    String reviewContent;
    LocalDateTime writeTime;

    public int getStarPoint() {
        return starPoint;
    }

    public String getReviewPhoto() {
        return reviewPhoto;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public LocalDateTime getWriteTime() {
        return writeTime;
    }

    public void writeReview(){
        Scanner in = new Scanner(System.in);

        System.out.println("리뷰를 작성해 주세요.");
        this.reviewContent = in.nextLine();


        System.out.println("사진을 첨부해 주세요");
        this.reviewPhoto = in.nextLine();

    }

    public void removeComment(Comment comment){
    }
}
