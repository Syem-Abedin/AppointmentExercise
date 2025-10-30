import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static int read() throws FileNotFoundException {
        int meetings = 0;
        File f = new File("Schedules.txt");
        Scanner s = new Scanner(f);
        String schedule = "";
        while (s.hasNext()) {
            while (s.hasNextBoolean()) {
                schedule += s.nextBoolean() + " ";
            }
            AppointmentBook a = new AppointmentBook((readSchedule(schedule)));
            schedule = "";
            if (a.makeAppointment(s.nextInt(), s.nextInt(), s.nextInt())) {
                meetings++;
            }
        }
        return meetings;
    }
    public static boolean[][] readSchedule(String lines) {
        Scanner s = new Scanner(lines);
        boolean[][] schedule = new boolean[8][60];
        for (int i = 0; i < schedule.length; i++) {
            for (int j = 0; j < schedule[i].length; j++) {
                schedule[i][j] = s.nextBoolean();
            }
        }
        return schedule;
    }
    public static void main(String[] args) throws IOException {
            System.out.println(read());
    }
}
//Answer is 496