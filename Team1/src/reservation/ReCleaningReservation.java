package reservation;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ReCleaningReservation {
    private LocalDateTime signUpTime;
    private String evidencePhoto;
    private String reRequestReason;
    private Boolean isReRequestApproved;
    private LocalDateTime reRequestCleanDate;

    private CleaningReservation cleaningReservation;

    public void selectReRequestCleanDate() {

    }

    public void reRequestClean() {
        Scanner sc = new Scanner(System.in);

        // main에서 옮겨왔을 떄 반영!
        // cleaningReservation = cleaningReserve;

        FinishCleaningInfo finishCleaningInfo = cleaningReservation.getFinishCleaningInfo();
        LocalDateTime finishCleanTime = finishCleaningInfo.getFinishCleanTime();

        System.out.print("재요청 사유를 입력해주세요: ");
        reRequestReason = sc.nextLine();
        setReRequestReason(reRequestReason);

        System.out.print("증거 사진을 촬영해주세요: ");

        // file explorer UI 등장
    }

    public void approveReRequest() {

    }

    public LocalDateTime getSignUpTime() {
        return signUpTime;
    }

    public String getEvidencePhoto() {
        return evidencePhoto;
    }

    public String getReRequestReason() {
        return reRequestReason;
    }

    public Boolean getReRequestApproved() {
        return isReRequestApproved;
    }

    public LocalDateTime getReRequestCleanDate() {
        return reRequestCleanDate;
    }

    public void setSignUpTime(LocalDateTime signUpTime) {
        this.signUpTime = signUpTime;
    }

    public void setEvidencePhoto(String evidencePhoto) {
        this.evidencePhoto = evidencePhoto;
    }

    public void setReRequestReason(String reRequestReason) {
        this.reRequestReason = reRequestReason;
    }

    public void setReRequestApproved(Boolean reRequestApproved) {
        isReRequestApproved = reRequestApproved;
    }

    public void setReRequestCleanDate(LocalDateTime reRequestCleanDate) {
        this.reRequestCleanDate = reRequestCleanDate;
    }
}
