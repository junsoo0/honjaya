import account.*;
import reservation.*;
import review.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] tempCreditInfo = {1,2,3};
        User user = new User("usr1", "01034235643", "kynpook@knu.ac.kr", "1234!!", "경북대 북문", tempCreditInfo,false);
        CleaningReservation cr = new CleaningReservation();
        cr.setUser(user);

        System.out.println("--------------------------------------------------");
        System.out.println("                      혼자야?");
        System.out.println("       (1인 가구 청소 대행 및 밀키트 배달 서비스)");
        System.out.println("--------------------------------------------------");

        Scanner in = new Scanner(System.in);


        while(true) {
            System.out.println(user.getname()+"님 예약 하시겠습니까?(Y/N)");
            String answer = in.next();
            if (answer.equals("Y")){
                cr.requestClean();
            } else if (answer.equals("N")){
                System.out.println("감사합니다. 안녕히 가세요.");
                return;
            } else {
                System.out.println("'Y' 또는 'N'을 입력해주세요.");
            }
        }


    }

}