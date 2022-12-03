package UI;

import file.ReservationFile;
import reservation.CleaningReservation;
import reservation.ReCleaningReservation;
import account.User;

import java.io.File;
import java.util.Scanner;

public class UserUI {
    private User user;

    public UserUI(User user) {
        this.user = user;
    }

    public void userMenu1() {
        user.showAllList();

    }

    public void userMenu2() {
        CleaningReservation cr = new CleaningReservation(user);

        ReservationFile uf = new ReservationFile();

        System.out.println("--------------------------------------------------");
        cr.requestClean();

        boolean check = cr.requestPayment();

        if(check) {
            //uf.writeFile(cr);
            //File recv_file = uf.createFile(cr);
            //File file = new File(uf.getPath());
            //String path = uf.getPath();

            /*
            File file2 = new File(path + "/" + cr.getReservationDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+".txt");
            try{
                if(file2.createNewFile()){
                    System.out.println("File created");
                }
                else{
                    System.out.println("File already Exists");
                }
                System.out.println();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            */

            cr.completeCleaning();
            /*
            try {

                BufferedWriter writer = new BufferedWriter(new FileWriter(file2));

                writer.write(cr.getProcessStatus());
                writer.write("\r\n");
                writer.write(cr.getFinishCleaningInfo().getFinishCleanTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            */
            uf.writeFile(cr);
        }
        else {
            System.out.println("결제를 취소하셨습니다.");
        }

        System.out.println("--------------------------------------------------");
    }

    public void userMenu3() {
        CleaningReservation cr = new CleaningReservation(user);
        ReCleaningReservation reCleaningReserv = new ReCleaningReservation(cr);
        reCleaningReserv.reRequestClean(user);

        /*
        CleaningReservation cr = new CleaningReservation(user);
        UserFile uf = new UserFile(cr);
        File file = new File(uf.getPath());
        String path = uf.getPath();

        String[] filenames = file.list();
        if(file.list().length==0){
            System.out.println("신청한 청소 내역이 없습니다.");
        }
        else {
            ReCleaningReservation reCleaningReserv = new ReCleaningReservation(cr);
            reCleaningReserv.reRequestClean(filenames, path);
        }
        */
    }


    public void userMainUI() {
        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.println("--------------------------------------------------");
            System.out.println("                      혼자야?");
            System.out.println("       (1인 가구 청소 대행 및 밀키트 배달 서비스)");
            System.out.println("--------------------------------------------------");

            System.out.println(user.getname() + "님 반갑습니다.");

            System.out.println("1. 청소 요청 정보 불러오기");
            System.out.println("2. 청소 요청");
            System.out.println("3. 청소 재요청");
            System.out.println("4. 종료");

            System.out.print("\n메뉴를 선택해주세요(숫자) : ");
            int input = in.nextInt();

            if(input == 1) {
                userMenu1();
            } else if(input == 2) {
                userMenu2();
            } else if(input == 3) {
                userMenu3();
            } else if (input == 4) {
                System.out.println("감사합니다. 안녕히 가세요.");
                break;
            } else {
                System.out.println("--------------------------------------------------");
                System.out.println("숫자 1 ~ 4를 입력해주세요.");
                System.out.println("--------------------------------------------------");
            }
            System.out.println("\n");
        }
    }
}
