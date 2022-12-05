package account;

import file.ReservationFile;
import reservation.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class User extends Account {
    private String address;
    private int[] creditInfo;
    private boolean isBanned;

    public User() {
        super();
    }
    public User(String name, String phoneNum, String eMail, String password, String address, int[] creditInfo, boolean isBanned) {
        super(name, phoneNum, eMail, password);
        this.address = address;
        this.creditInfo = creditInfo;
        this.isBanned = isBanned;
    }

    //getter, setter
    public String getaddress(){
        return address;
    }
    public int[] getcreditInfo(){
        return creditInfo;
    }
    public boolean getisBanned(){
        return isBanned;
    }
    public void setaddress(String address) {
        this.address = address;
    }
    public void setcreditInfo(int[] creditInfo){
        this.creditInfo = creditInfo;
    }
    public void setisBanned(boolean isBanned){
        this.isBanned = isBanned;
    }



    public void showAllList() {
        //this method show all reservations of user.

        ReservationFile uf = new ReservationFile();
        ArrayList<CleaningReservation> allList = uf.readAllFile(this);
        ReCleaningReservation recr;

        if(allList.size() == 0) {
            System.out.println("신청한 청소 내역이 없습니다.");
            return;
        }
        System.out.println("--------------------------------------------------");
        System.out.println("[" + this.getname() + "님의 예약 정보]");
        System.out.printf("%5s %-14s | %-20s | %-15s\n", " ", "청소 완료 날짜", "진행 상태", "재요청 등록 날짜");
        int i = 1;
        for (CleaningReservation cr : allList) {
            System.out.printf("%4s: %-20s | %-15s", i++,
                            cr.getFinishCleaningInfo().getFinishCleanTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                            cr.getProcessStatus());
            if ((recr = cr.getReCleaningReservation()) != null)
                System.out.printf(" | %-15s", recr.getSignUpTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            System.out.print("\n");
        }

        System.out.println("--------------------------------------------------");
    }

    /*
    public void editInfo() {
         //this method is used to edit User's Information
    }


    public void banUserAccount() {
        // this method is used to ban User.
        setIsBanned(true);
    }
    */

}
