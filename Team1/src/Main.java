import account.*;
import file.*;
import reservation.*;
import ui.*;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] tempCreditInfo = {1,2,3};
        User user = new User("usr1", "01034235643", "kynpook@knu.ac.kr", "1234!!", "경북대 북문", tempCreditInfo,false);
        UserUI userUI = new UserUI(user);
        userUI.userMainUI();


    }

}