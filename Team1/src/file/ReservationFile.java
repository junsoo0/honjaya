package file;

import account.User;
import reservation.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Vector;

public class ReservationFile {
    private CleaningReservation rsrvInfo;

    private ArrayList<CleaningReservation> rsrvAllInfo;
    private User user;
    private String path;
    private File folder;

    public ReservationFile() {
    }

    public File createFile() {
        path = System.getProperty("user.dir") + File.separator + user.getname();
        folder = new File(path);
        folder.mkdir();

        File file = new File(path + "/" + rsrvInfo.getReservationDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ".txt");
        try {
            if (file.createNewFile()) {
            } else {
                System.out.println("오류가 발생했습니다.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

    public void writeFile(CleaningReservation cr) {
        try {
            this.rsrvInfo = cr;
            this.user = cr.getUser();

            // File recv_file = this.createFile();
            this.createFile();
            File file = new File(path + "/" + rsrvInfo.getReservationDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ".txt");
            String path = this.getPath();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write("processStatus:: " + rsrvInfo.getProcessStatus());
            writer.write("\r\n");
            if (rsrvInfo.getFinishCleaningInfo() != null) {
                writer.write("FinishCleaningInfo_finishCleanTime:: " + rsrvInfo.getFinishCleaningInfo().getFinishCleanTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                writer.write("\r\n");
            }
            writer.write("ReCleaningReservation_signUpTime:: ");
            if (rsrvInfo.getReCleaningReservation() != null) {
                writer.write(rsrvInfo.getFinishCleaningInfo().getFinishCleanTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                writer.write("\r\n");
            }


            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<CleaningReservation> readAllFile(User usr) {
        this.user = usr;
        this.path = System.getProperty("user.dir") + File.separator + user.getname();
        File file = new File(path);
        String[] filenames = file.list();

        rsrvAllInfo = new ArrayList<CleaningReservation>();

        try {
            for (String filename : filenames) {
                rsrvInfo = new CleaningReservation(usr);

                File rf = new File(path + "/" + filename);
                BufferedReader reader = new BufferedReader(new FileReader(rf));
                String sLine;
                while ((sLine = reader.readLine()) != null) {
                    String[] lineSplit = sLine.split(":: ");
                    System.out.printf("%s\n", lineSplit[0]);
                    if (lineSplit.length > 1)
                        System.out.printf("%s\n\n", lineSplit[1]);
                    if (lineSplit[0].equals("processStatus")) {
                        rsrvInfo.setProcessStatus(lineSplit[1]);
                    }
                    else if (lineSplit[0].equals("FinishCleaningInfo_finishCleanTime")) {
                        if (lineSplit.length > 1) {
                            FinishCleaningInfo ficlInfo = new FinishCleaningInfo(rsrvInfo);
                            rsrvInfo.setFinishCleaningInfo(ficlInfo);
                            ficlInfo.setFinishCleanTime(LocalDateTime.parse(lineSplit[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                        }
                    }
                    else if (lineSplit[0].equals("ReCleaningReservation_signUpTime")) {
                        if (lineSplit.length > 1) {
                            ReCleaningReservation reclInfo = new ReCleaningReservation(rsrvInfo);
                            rsrvInfo.setReCleaningReservation(reclInfo);
                            reclInfo.setSignUpTime(LocalDateTime.parse(lineSplit[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                        }
                    }
                }
                rsrvAllInfo.add(rsrvInfo);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return rsrvAllInfo;
    }

    //  public CleaningReservation readFile() {}

    public File getFolder() {
        return folder;
    }

    public User getUser() {
        return user;
    }

    public String getPath() {
        return path;
    }

    public void setFolder(File folder) {
        this.folder = folder;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
