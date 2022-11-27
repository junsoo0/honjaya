package Account;

public class user extends account {
    private String address;
    private int[] creditInfo;
    private boolean isBanned;

    public user(String name, String phoneNum, String eMail, String password, String address, int[] creditInfo, boolean isBanned) {
        super(name, phoneNum, eMail, password);
        //ㄴㅏ는 다훈이
        this.address = address;
        this.creditInfo = creditInfo;
        this.isBanned = isBanned;
    }

    public void showAllList() {
        System.out.println("이름 : "+getname());
        System.out.println("휴대전화 : "+getphoneNum());
        System.out.println("이메일 : "+geteMail());
        //나머지 정보 어디까지 보여줄지 설정.
    }

    public void editInfo() {
        // this method is used to edit User's Information.
    }

    public void banUserAccount() {
        // this method is used to ban User.
    }
}
