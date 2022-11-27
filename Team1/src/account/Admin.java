package account;

public class Admin extends Account {

    public Admin(String name, String phoneNum, String eMail, String password) {
        super(name, phoneNum, eMail, password);
    }

    public Cleaner createCleanerAccount(){
        //this method is to create Cleaner Account.
    }
}
