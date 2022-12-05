package reservation;

import file.ReservationFile;
import account.User;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReCleaningReservation {
    private LocalDateTime signUpTime;
    private String evidencePhoto = "";
    private String reRequestReason;
    private Boolean isReRequestApproved;
    private LocalDateTime reRequestCleanDate;

    private final CleaningReservation cleaningReservation;

    public void selectReRequestCleanDate() {

    }

    public ReCleaningReservation(CleaningReservation cleaningReservation) {
        this.cleaningReservation = cleaningReservation;
    }

    public void reRequestClean(User user) {
        this.signUpTime = LocalDateTime.now();
        ReservationFile uf = new ReservationFile();
        ArrayList<CleaningReservation> allList = uf.readAllFile(user);
        CleaningReservation cr;

        if (allList.size() == 0) {
            System.out.println("신청한 청소 내역이 없습니다.");
            return;
        }

        for (int i = allList.size() - 1; i >= 0; i--) {
            cr = allList.get(i);
            if (!(cr.getProcessStatus().equals("청소 완료")) ||
                    (cr.getFinishCleaningInfo().getFinishCleanTime().plusHours(12).compareTo(this.signUpTime) < 0))
                allList.remove(cr);
        }

        if (allList.size() == 0) {
            System.out.println("재요청을 할 수 있는 청소 내역이 없습니다.");
            return;
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("--------------------------------------------------");
        System.out.println("[재요청 가능 날짜]");
        System.out.println("       청소 완료 날짜   진행 상태 ");
        for (int i = 0; i <= allList.size() - 1; i++) {
            cr = allList.get(i);
            System.out.println((i + 1) + ": " +
                    cr.getFinishCleaningInfo().getFinishCleanTime().format(
                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + " | "
                    + cr.getProcessStatus() + " | ");
        }
        System.out.println("--------------------------------------------------");

        while (true) {
            System.out.print("재청소 원하는 청소 번호 입력 : ");
            int tempDate = sc.nextInt();
            sc.nextLine();

            if (tempDate <= 0 || tempDate > allList.size()) {
                System.out.println("목록에 없는 번호를 입력하셨습니다.");
            } else {
                cr = allList.get(tempDate - 1);
                cr.setReCleaningReservation(this);
                break;
            }
        }

        System.out.print("재요청 사유를 입력해주세요. : ");
        reRequestReason = sc.nextLine();
        setReRequestReason(reRequestReason);

        while (true) {
            System.out.print("증거 사진을 첨부해주세요.(파일 경로 입력) : ");
            File src = new File(sc.nextLine());

            try {
                FileInputStream fi = new FileInputStream(src);
                byte[] buf = new byte[1024 * 10];
                while (true) {
                    int n = fi.read(buf);
                    evidencePhoto += Integer.toString(n);
                    if (n < buf.length)
                        break;
                }
                fi.close();
                break;
                } catch (IOException e) {
                    System.out.println("파일 복사 오류");
            }
        }

        cr.setProcessStatus("청소 재요청 승인 대기");

        ReservationFile rf = new ReservationFile();
        rf.writeFile(cr);
        System.out.println("청소 재요청이 완료되었습니다.");

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
