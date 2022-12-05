package reservation;

import java.time.LocalDateTime;
import java.util.Scanner;

public class FinishCleaningInfo {
    private LocalDateTime finishCleanTime;
    private String finishPhoto;

    private CleaningReservation cleaningReservation;

    public FinishCleaningInfo(CleaningReservation cleaningReservation) {
        this.cleaningReservation = cleaningReservation;
    }

    public void finishClean() {
        Scanner sc = new Scanner(System.in);
        int year, month, day, hour, minute;
        LocalDateTime finishCleanTime;
        String finishPhoto;

        System.out.println("청소 완료 시간 입력");
        while (true) {
            System.out.print("연(year): ");
            if (sc.hasNextInt())
                break;
            sc.next();
            System.out.println("숫자를 입력해주세요.");
            System.out.println();
        }
        year = sc.nextInt();
        sc.nextLine();

        while (true) {
            System.out.print("월(month): ");
            if (sc.hasNextInt())
                break;
            sc.next();
            System.out.println("숫자를 입력해주세요.");
            System.out.println();
        }
        month = sc.nextInt();
        sc.nextLine();

        while (true) {
            System.out.print("일(day): ");
            if (sc.hasNextInt())
                break;
            sc.next();
            System.out.println("숫자를 입력해주세요.");
            System.out.println();
        }
        day = sc.nextInt();
        sc.nextLine();

        while (true) {
            System.out.print("시(hour): ");
            if (sc.hasNextInt())
                break;
            sc.next();
            System.out.println("숫자를 입력해주세요.");
            System.out.println();
        }
        hour = sc.nextInt();
        sc.nextLine();

        while (true) {
            System.out.print("분(minute): ");
            if (sc.hasNextInt())
                break;
            sc.next();
            System.out.println("숫자를 입력해주세요.");
            System.out.println();
        }
        minute = sc.nextInt();
        sc.nextLine();

        finishCleanTime = LocalDateTime.of(year, month, day, hour, minute);
        setFinishCleanTime(finishCleanTime);

        System.out.print("청소 완료 사진 경로 입력: ");
        finishPhoto = sc.next();
        setFinishPhoto(finishPhoto);
    }

    public void setFinishCleanTime(LocalDateTime finishCleanTime) {
        this.finishCleanTime = finishCleanTime;
    }

    public void setFinishPhoto(String finishPhoto) {
        this.finishPhoto = finishPhoto;
    }

    public LocalDateTime getFinishCleanTime() {
        return finishCleanTime;
    }

    public String getFinishPhoto() {
        return finishPhoto;
    }
}
