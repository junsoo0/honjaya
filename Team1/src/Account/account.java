package Account;

public class account {
    private String name;
    private String phoneNum;
    private String eMail;
    private String password;
    public account(String name, String phoneNum, String eMail, String password){
        this.name = name;
        this.phoneNum = phoneNum;
        this.eMail = eMail;
        this.password = password;
    }

    //getter, setter method.
    public String getname() {
        return name;
    }
    public String getphoneNum(){
        return phoneNum;
    }
    public String geteMail(){
        return eMail;
    }
    public String getpassword(){ return password; }
    public void setname(String name) {
        this.name = name;
    }
    public void setphoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }
    public void seteMail(String eMail){
        this.eMail = eMail;
    }
    public void setpassword(String password){
        this.password = password;
    }

}

