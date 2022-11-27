package reservation.mealkit;

public class Mealkit {
    private int mealkitNum;     //밀키트 개수
    private String mealkitMenu; //밀키트 메뉴
    private int mealkitPrice;   //밀키트 가격
    private int mealkitWeeks;   //밀키트 몇주차

    public void setMealkitNum(int mealkitNum) {
        this.mealkitNum = mealkitNum;
    }
    public void setMealkitMenu(String mealkitMenu){
        this.mealkitMenu = mealkitMenu;
    }
    public void setMealkitPrice(int mealkitPrice){
        this.mealkitPrice = mealkitPrice;
    }
    public void setMealkitWeeks(int mealkitWeeks){
        this.mealkitWeeks = mealkitWeeks;
    }

    public int getMealkitNum(){
        return mealkitNum;
    }
    public String getMealkikMenu(){
        return mealkitMenu;
    }
    public int getMealkitPrice(){
        return mealkitPrice;
    }
    public int getMealkitWeeks(){
        return mealkitWeeks;
    }


    public static void requestMealkit(){

    }
}
