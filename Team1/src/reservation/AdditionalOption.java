package reservation;

import java.util.Scanner;

public class AdditionalOption {
    private Boolean isLaundry;
    private Boolean isDishWash;
    private String additionalRequirement;
    private int additionalPrice;

    public void requestAdditionalOption() {
        Scanner sc = new Scanner(System.in);
        String answer;
        String additionalRequirement;
        int additionalPrice = 0;

        while(true) {
            System.out.print("빨래를 추가하시겠습니까?(Y/N) : ");
            answer = sc.next();
            if (answer.equals("Y")) {
                setLaundry(true);
                break;
            } else if (answer.equals("N")) {
                setLaundry(false);
                break;
            } else {
                System.out.println("'Y' 또는 'N'을 입력해주세요.");
            }
        }

        while(true) {
            System.out.print("설거지를 추가하시겠습니까?(Y/N) : ");
            answer = sc.next();
            if (answer.equals("Y")) {
                setDishWash(true);
                break;
            } else if (answer.equals("N")) {
                setDishWash(false);
                break;
            } else {
                System.out.println("'Y' 또는 'N'을 입력해주세요.");
            }
        }

        sc.nextLine();
        System.out.print("추가 요구사항을 입력해주세요. : ");
        additionalRequirement = sc.nextLine();
        setAdditionalRequirement(additionalRequirement);

        if(getLaundry())
            additionalPrice += 5000;
        if(getDishWash())
            additionalPrice += 5000;
        setAdditionalPrice(additionalPrice);
    }

    public void setLaundry(Boolean laundry) {
        isLaundry = laundry;
    }

    public void setDishWash(Boolean dishWash) {
        isDishWash = dishWash;
    }

    public void setAdditionalRequirement(String additionalRequirement) {
        this.additionalRequirement = additionalRequirement;
    }

    public void setAdditionalPrice(int additionalPrice) {
        this.additionalPrice = additionalPrice;
    }

    public Boolean getLaundry() {
        return isLaundry;
    }

    public Boolean getDishWash() {
        return isDishWash;
    }

    public String getAdditionalRequirement() {
        return additionalRequirement;
    }

    public int getAdditionalPrice() {
        return additionalPrice;
    }
}
