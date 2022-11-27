package reservation.mealkit;
import reservation.CleaningReservation;
import java.time.LocalDateTime;

public class MealkitRefundRequest {
    private LocalDateTime refundRequestTime;
    private String refundPhoto;
    private Boolean isRefundApproved;

    public void setRefundRequestTime(LocalDateTime refundRequestTime) {
        this.refundRequestTime = refundRequestTime;
    }
    public void setRefundPhoto(String refundPhoto){
        this.refundPhoto = refundPhoto;
    }
    public void setIsRefundApproved(Boolean isRefundApproved){
        this.isRefundApproved = isRefundApproved;
    }

    public LocalDateTime getRefundRequestTime(){
        return refundRequestTime;
    }
    public String getRefundPhoto(){
        return refundPhoto;
    }
    public Boolean getIsRefundApproved(){
        return isRefundApproved;
    }

    //밀키트 승인 여부 판단함수
    public void approveMealkitRefund(){

    }

    //밀키트 함수 함수
    public void mealkitRefund(){

    }
}
