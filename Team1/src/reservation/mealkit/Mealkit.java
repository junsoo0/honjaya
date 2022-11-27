package reservation.mealkit;
import java.util.HashMap;
import java.util.Scanner;
import reservation.CleaningReservation;

public class Mealkit {
    class Meal {
        int mealkitNum = 0;
        String mealkitMenu = "";
        int mealkitPrice = 0;
        int mealkitWeeks = 0;
    }

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

    //밀키트 예약요청 함수
    public void requestMealkit(String reserveType){
        HashMap<String, String> menu = new HashMap<String, String>();
        Scanner sc = new Scanner(System.in);

        String menuName = "";
        int menuNumber = 0;

        menu.put("미역국","10,000");
        menu.put("육개장","10,000");
        menu.put("부대찌개","13,000");
        menu.put("짜장면","10,000");
        menu.put("떡볶이","10,000");
        menu.put("야채볶음밥","10,000");


        if(reserveType=="장기"){
            this.setMealkitWeeks(4);
        }else{ // 1회
            this.setMealkitWeeks(1);
        }

        Meal mk[] = new Meal[mealkitWeeks];   //주차 만큼 메뉴 담을 구조체 배열
        for(int i = 0; i<mk.length; i++){
            mk[i] = new Meal();
        }

        for(int i =0; i<mealkitWeeks; i++){
            int cnt = 1;
            System.out.println("=============MealKit Request=============");
            System.out.printf("=================%d 주차=================\n",i+1);
            for(String j:menu.keySet()){
                System.out.println(cnt+". "+j + menu.get(j) + "원");
                cnt++;
            }
            System.out.print("원하는 메뉴의 이름을 입력하시오 : ");
            menuName = sc.next();   //메뉴 이름
            System.out.print("개수를 입력하시오 : ");
            menuNumber = sc.nextInt();  //메뉴 개수
            this.setMealkitMenu(menuName);  //메뉴 이름 저장
            this.setMealkitPrice(Integer.parseInt(menu.get(menuName))); //메뉴 가격 저장
            this.setMealkitNum(menuNumber); //메뉴 개수 저장

            mk[i].mealkitMenu = this.mealkitMenu;
            mk[i].mealkitPrice = this.mealkitPrice;
            mk[i].mealkitWeeks = this.mealkitWeeks;
            mk[i].mealkitNum = this.mealkitNum;
        }

    }
}
