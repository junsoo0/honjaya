import account.*;
import reservation.*;
import review.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        System.out.println("--------------------------------------------------");
        System.out.println("                      혼자야?");
        System.out.println("       (1인 가구 청소 대행 및 밀키트 배달 서비스)");
        System.out.println("--------------------------------------------------");

        Scanner in = new Scanner(System.in);
        System.out.println(user.getname()+"님 예약 하시겠습니까?(Y/N)");
        while(true) {
            String answer = in.next();
            if (answer.equals("Y")){
                CleaningReservation user.
            } else if (answer.equals("N")){
                System.out.println("감사합니다. 안녕히 가세요.");
                return;
            } else {
                System.out.println("'Y' 또는 'N'을 입력해주세요.");
            }
        }


    }

}