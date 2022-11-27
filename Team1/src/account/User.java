package account;

public class User extends Account {
    private String address;
    private int[] creditInfo;
    private boolean isBanned;

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
    }

    public void editInfo() {
        // this method is used to edit User's Information.
    }


    public void banUserAccount() {
        // this method is used to ban User.
        setisBanned(true);
    }

}
