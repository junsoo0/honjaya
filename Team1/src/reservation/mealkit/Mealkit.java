package reservation.mealkit;

import java.util.HashMap;
import java.util.Scanner;

import reservation.CleaningReservation;

public class Mealkit {
    private int mealkitNum;     //밀키트 개수
    private String mealkitMenu; //밀키트 메뉴
    private int mealkitPrice;   //밀키트 가격
    private int mealkitWeeks;   //밀키트 몇주차

    CleaningReservation cleaningReservation;

    public Mealkit(CleaningReservation cleaningReservation) {
        this.cleaningReservation = cleaningReservation;
    }

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
        HashMap<String, String> menu = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        String menuName;
        int menuNumber;
        int cnt = 1;

        menu.put("미역국", "10000");
        menu.put("육개장", "10000");
        menu.put("부대찌개", "13000");
        menu.put("짜장면", "10000");
        menu.put("떡볶이", "10000");
        menu.put("야채볶음밥", "10000");

        System.out.println("=============MealKit Request=============");
        System.out.println(cleaningReservation.getReserveType());
        if (cleaningReservation.getReserveType().equals("1회"))
            setMealkitWeeks(1);
        else
            while (true) {
                System.out.print("주차를 선택해주세요.(1 ~ 4) : ");

                int week = sc.nextInt();
                sc.nextLine();
                if (week >= 1 && week <= 4) {
                    setMealkitWeeks(week);
                    break;
                } else {
                    System.out.println("1 ~ 4주차 이내로 선택해야 합니다.");
                    System.out.println();
                }
            }
        System.out.println("=========================================");
        for (String j : menu.keySet()) {
            System.out.print(cnt + ". " + String.format("%-10s",j) + String.format("%7s",menu.get(j)+"원"));
            System.out.println();
            cnt++;
        }
        System.out.println("=========================================");

        while (true) {
            System.out.print("원하는 메뉴의 이름을 입력해주세요. : ");
            menuName = sc.next();
            if (menu.get(menuName) != null) {
                setMealkitMenu(menuName);  //메뉴 이름
                break;
            } else {
                System.out.println("메뉴 이름을 정확하게 입력해주세요.");
                System.out.println();
            }
        }

        while(true){
            System.out.print("개수를 입력해주세요(최대 7개까지 가능) : ");
            menuNumber = sc.nextInt();  //메뉴 개수

            if(menuNumber > 0 && menuNumber < 8) {
                break;
            } else {
                System.out.println("입력한 개수는 " +menuNumber+ "으로 잘못 입력 하셨습니다.");
                System.out.println();
            }
        }


        setMealkitNum(menuNumber); //메뉴 개수 저장
        setMealkitPrice(Integer.parseInt(menu.get(menuName)) * menuNumber); //메뉴 가격 저장
    }
}
