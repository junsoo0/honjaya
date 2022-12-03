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

        /*
        CleaningReservation cr = new CleaningReservation(this);
        //ReservationFile uf = new ReservationFile(cr);
        File file = new File(uf.getPath());
        String path = uf.getPath();
        String[] filenames = file.list();
        */

        if(allList.size() == 0) {
            System.out.println("신청한 청소 내역이 없습니다.");
            return;
        }
        System.out.println("--------------------------------------------------");
        System.out.println("[" + this.getname() + "님의 예약 정보]");
        System.out.println("       예약 날짜       진행 상태 ");
        // try {
        int i = 1;
        for (CleaningReservation cr : allList) {
            /*
            File rf = new File(path + "/" + filename);
            BufferedReader reader = new BufferedReader(new FileReader(rf));
            String sLine;
            System.out.print(i++ + ": ");
                             */
            System.out.print(i++
                    + ": " + cr.getFinishCleaningInfo().getFinishCleanTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                    + "     " + cr.getProcessStatus());
            if ((recr = cr.getReCleaningReservation()) != null)
                System.out.print("     " + recr.getSignUpTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            System.out.print("\n");
        }
            /*
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
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
