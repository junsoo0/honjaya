package account;

import file.ReservationFile;
import reservation.CleaningReservation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
        CleaningReservation cr = new CleaningReservation(this);
        ReservationFile uf = new ReservationFile(cr);
        File file = new File(uf.getPath());
        String path = uf.getPath();


        System.out.println("[" + this.getname() + "님의 예약 정보]");
        String[] filenames = file.list();
        System.out.println("       예약 날짜       진행 상태 ");
        try {
            int i = 1;
            for (String filename : filenames) {
                File rf = new File(path + "/" + filename);
                BufferedReader reader = new BufferedReader(new FileReader(rf));
                String sLine;
                System.out.print(i++ + ": ");
                while( (sLine = reader.readLine()) != null ){
                    System.out.print(sLine + " | ");
                }
                System.out.print("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    public void editInfo() {
        // this method is used to edit User's Information.
    }


    public void banUserAccount() {
        // this method is used to ban User.
        setisBanned(true);
    }
    */

}
