package reservation;

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

    private CleaningReservation cleaningReservation;

    public void selectReRequestCleanDate() {

    }

    public ReCleaningReservation(CleaningReservation cleaningReservation) {
        this.cleaningReservation = cleaningReservation;
    }

    public void reRequestClean(String[] filenames, String path) {
        Scanner sc = new Scanner(System.in);

        int i = 0;
        String status = "";
        LocalDateTime finishCleanTime = LocalDateTime.now();
        ArrayList<LocalDateTime> cleanInfo = new ArrayList<LocalDateTime>();
        this.signUpTime = LocalDateTime.now();

        CleaningReservation cleaningReserv = new CleaningReservation();
        FinishCleaningInfo cleaningInfo = new FinishCleaningInfo();

        //String[] filenames = file.list();
        //파일 불러서 status , finishcleantime string으로 받았다면, for문으로 받았을 때
        try {
            for (String filename : filenames) {
                File rf = new File(path + "/" + filename);
                BufferedReader reader = new BufferedReader(new FileReader(rf));
                String sLine = null;
                if ((sLine = reader.readLine()) != null) {
                    finishCleanTime = LocalDateTime.parse(sLine, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                }
                if ((sLine = reader.readLine()) != null) {
                    status = sLine;
                }
                if (status.equals("청소 완료") && finishCleanTime.plusHours(12).compareTo(this.signUpTime) > 0)
                    cleanInfo.add(i, finishCleanTime);
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        if (cleanInfo.size() == 0) {
            System.out.println("재요청을 할 수 있는 청소 내역이 없습니다.");
            return;
        }

        for(int j = 0; j < cleanInfo.size(); j++){
            System.out.println(j + ": 완료시간 : "+ cleanInfo.get(j) + " 청소상태 : " + status);
        }
        System.out.print("재청소 원하는 청소 번호 입력 : ");
        int tempDate = sc.nextInt();
        sc.nextLine();

        while (true) {
            if (tempDate < 0 || tempDate >= cleanInfo.size()) {
                System.out.println("목록에 없는 번호를 입력하셨습니다. 다시 입력해주세요: ");
                tempDate = sc.nextInt();
            }
            else
                break;
        }
        finishCleanTime = cleanInfo.get(tempDate);

        cleaningReserv.setProcessStatus("청소 완료");
        cleaningReserv.setFinishCleaningInfo(cleaningInfo);
        cleaningInfo.setFinishCleanTime(finishCleanTime);
        cleaningReservation = cleaningReserv;

        FinishCleaningInfo finishCleaningInfo = cleaningReservation.getFinishCleaningInfo();
        finishCleanTime = finishCleaningInfo.getFinishCleanTime();

        System.out.print("재요청 사유를 입력해주세요: ");
        reRequestReason = sc.nextLine();
        setReRequestReason(reRequestReason);

        System.out.print("증거 사진을 첨부해주세요(파일 경로 입력): ");

        File src = new File(sc.nextLine());
        try {
            FileInputStream fi = new FileInputStream(src);
            byte [] buf = new byte [1024*10];
            while (true) {
                int n = fi.read(buf);
                evidencePhoto += buf.toString();
                if (n < buf.length)
                    break;
            }
            fi.close();
        } catch (IOException e) {
            System.out.println("파일 복사 오류");
        }

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
