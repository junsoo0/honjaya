package reservation;

import java.util.Vector;
import java.time.LocalDateTime;

import account.User;
import reservation.mealkit.Mealkit;
import review.Review;

import java.lang.ref.Cleaner;


public class CleaningReservation {
    private String          reserveType;    // 정기 or 1회
    private LocalDateTime   signUpTime;     // 청소 요청 시간
    private int             cleaningSpace;  // 청소 면적
    private int             price;          // 청소 가격만
    private LocalDateTime   reservationDate;// 청소 예정 시간
    private String          location;       // 청소 장소
    private String          processStatus;  // 진행 상태

    private User                    user;
    private Cleaner                 cleaner;
    private Mealkit                 mealkit; // 여러개여서 수정!!!
    private FinishCleaningInfo      finishCleaningInfo;
    private AdditionalOption        additionalOption;
    private ReCleaningReservation   reCleaningReservation;
    private Review                  review;

    public CleaningReservation(String reserveType, LocalDateTime signUpTime, int cleaningSpace, int price,
                               LocalDateTime reservationDate, String location, String processStatus) {
        this.reserveType        = reserveType;
        this.signUpTime         = signUpTime;
        this.cleaningSpace      = cleaningSpace;
        this.price              = price;
        this.reservationDate    = reservationDate;
        this.location           = location;
        this.processStatus      = processStatus;
    }

    public String getreserveType() {
        return reserveType;
    }
    public LocalDateTime getsignUpTime() {
        return signUpTime;
    }
    public int getcleaningSpace() {
        return cleaningSpace;
    }
    public int getprice() {
        return price;
    }
    public LocalDateTime getreservationDate() {
        return reservationDate;
    }
    public String getlocation() {
        return location;
    }
    public String getprocessStatus() {
        return processStatus;
    }

    public void setreserveType(String reserveType) {
        this.reserveType = reserveType;
    }
    public void setsignUpTime(LocalDateTime signUpTime) {
        this.signUpTime = signUpTime;
    }
    public void setcleaningSpace(int cleaningSpace) {
        this.cleaningSpace = cleaningSpace;
    }
    public void setprice(int price) {
        this.price = price;
    }
    public void setreservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }
    public void setlocation(String location) {
        this.location = location;
    }
    public void setprocessStatus(String processStatus) {
        this.processStatus = processStatus;
    }
}
