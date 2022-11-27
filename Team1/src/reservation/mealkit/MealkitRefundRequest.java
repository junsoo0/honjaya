package reservation.mealkit;
import reservation.CleaningReservation;
import java.time.LocalDateTime;
import java.util.Scanner;
public class MealkitRefundRequest {

    private LocalDateTime refundRequestTime;
    private String refundPhoto;
    private boolean isRefundApproved;

    public void setRefundRequestTime(LocalDateTime refundRequestTime) {
        this.refundRequestTime = refundRequestTime;
    }
    public void setRefundPhoto(String refundPhoto){
        this.refundPhoto = refundPhoto;
    }
    public void setIsRefundApproved(boolean isRefundApproved){
        this.isRefundApproved = isRefundApproved;
    }

    public LocalDateTime getRefundRequestTime(){
        return refundRequestTime;
    }
    public String getRefundPhoto(){
        return refundPhoto;
    }
    public boolean getIsRefundApproved(){
        return isRefundApproved;
    }



    public void approveMealkitRefund(){
        //사용자의 밀키트 정보를 넘겨준다. (상태에 이상이 있다면 사진 등등)
        System.out.println("사용자의 밀키트 환불정보가 도착했습니다...");
        System.out.println(getRefundPhoto());
        //isRefundApproved
        Scanner scanner = new Scanner(System.in);
        int in;
        System.out.println("환불 요청을 승인하시겠습니까? : 승인(1)  거절(2)입력");
        in = scanner.nextInt();
        if (in == 1) {
            this.isRefundApproved = true;
        }
        else{
            this.isRefundApproved = false;
        }
    }

    //밀키트 함수 함수
    public void mealkitRefund(int mealkitNum, int mealkitPrice){
        if (getIsRefundApproved() == true)
        {
            System.out.println("환불성공..환불된 정보를 출력합니다.");
            System.out.println("환불된 밀키트 갯수 : "+mealkitNum+" 환불된 금액 : "+mealkitPrice);
        }
        else {
            System.out.println("관리자가 환불요청을 거부했습니다.");
        }
    }
}
