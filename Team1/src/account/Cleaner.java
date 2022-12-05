package account;

import reservation.CleaningReservation;

import java.util.ArrayList;

public class Cleaner extends Account {

    ArrayList<CleaningReservation> cleaningReservation = new ArrayList<CleaningReservation>();

    public Cleaner(String name, String phoneNum, String eMail, String password) {
        super(name, phoneNum, eMail, password);
    }


    /*
    public Cleaner createCleanerAccount(){
        //this method is to create Cleaner Account
    }
    */

}
