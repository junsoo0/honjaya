package file;

import account.User;
import reservation.CleaningReservation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ReservationFile {
    private CleaningReservation rsrvInfo;
    private User user;
    private String path;
    private File folder;

    public ReservationFile(CleaningReservation rsrvInfo) {
        this.rsrvInfo = rsrvInfo;
        this.user = rsrvInfo.getUser();
        path = System.getProperty("user.dir") + File.separator + user.getname();
        folder = new File(path);
        folder.mkdir();
    }

    public File createFile() {
        File file = new File(path + "/" + rsrvInfo.getReservationDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ".txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("File already Exists");
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

    public void writeFile(File file) {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write(rsrvInfo.getFinishCleaningInfo().getFinishCleanTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            writer.write("\r\n");
            writer.write(rsrvInfo.getProcessStatus());

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
