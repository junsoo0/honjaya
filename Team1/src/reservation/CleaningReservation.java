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

    public String getReserveType() {
        return reserveType;
    }

    public void setReserveType(String reserveType) {
        this.reserveType = reserveType;
    }

    public LocalDateTime getSignUpTime() {
        return signUpTime;
    }

    public void setSignUpTime(LocalDateTime signUpTime) {
        this.signUpTime = signUpTime;
    }

    public int getCleaningSpace() {
        return cleaningSpace;
    }

    public void setCleaningSpace(int cleaningSpace) {
        this.cleaningSpace = cleaningSpace;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }
}
