package reservation.mealkit;

import java.util.HashMap;
import java.util.Scanner;

import reservation.CleaningReservation;

public class Mealkit {
    private int mealkitNum;     //밀키트 개수
    private String mealkitMenu; //밀키트 메뉴
    private int mealkitPrice;   //밀키트 가격
    private int mealkitWeeks;   //밀키트 몇주차

    public void setMealkitNum(int mealkitNum) {
        this.mealkitNum = mealkitNum;
    }

    public void setMealkitMenu(String mealkitMenu) {
        this.mealkitMenu = mealkitMenu;
    }

    public void setMealkitPrice(int mealkitPrice) {
        this.mealkitPrice = mealkitPrice;
    }

    public void setMealkitWeeks(int mealkitWeeks) {
        this.mealkitWeeks = mealkitWeeks;
    }

    public int getMealkitNum() {
        return mealkitNum;
    }

    public String getMealkikMenu() {
        return mealkitMenu;
    }

    public int getMealkitPrice() {
        return mealkitPrice;
    }

    public int getMealkitWeeks() {
        return mealkitWeeks;
    }

    //밀키트 예약요청 함수
    public void requestMealkit() {
        HashMap<String, String> menu = new HashMap<String, String>();
        Scanner sc = new Scanner(System.in);

        String menuName = "";
        int menuNumber = 0;
        int cnt = 1;

        menu.put("미역국", "10,000");
        menu.put("육개장", "10,000");
        menu.put("부대찌개", "13,000");
        menu.put("짜장면", "10,000");
        menu.put("떡볶이", "10,000");
        menu.put("야채볶음밥", "10,000");

        System.out.println("=============MealKit Request=============");
        System.out.println("주차 선택 : ");
        setMealkitWeeks(sc.nextInt());
        System.out.println("=========================================");
        for (String j : menu.keySet()) {
            System.out.println(cnt + ". " + j + menu.get(j) + "원");
            cnt++;
        }
        System.out.print("원하는 메뉴의 이름을 입력하시오 : ");
        menuName = sc.next();
        setMealkitMenu(menuName);  //메뉴 이름
        System.out.print("개수를 입력하시오 : ");
        menuNumber = sc.nextInt();  //메뉴 개수
        setMealkitNum(menuNumber); //메뉴 개수 저장
        setMealkitPrice(Integer.parseInt(menu.get(menuName))); //메뉴 가격 저장
    }
}
