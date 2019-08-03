package com.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("src/main/java/com/assignment/input.txt");
        Scanner scanner = new Scanner(inputFile);

        LocalTime startTime = getTimeInput(scanner);
        LocalTime endTime = getTimeInput(scanner);

        List<Meeting> meetings = new MeetingInputScanner().getInput(scanner);

        Map<LocalDate, List<Meeting>> meetingsBookedByDate = MeetingRequestProcessor.process(meetings, startTime, endTime);
        for (Map.Entry<LocalDate, List<Meeting>> entry : meetingsBookedByDate.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().forEach(eachMeeting -> {
                System.out.println(eachMeeting.getStartTime().toLocalTime() + " "
                        + eachMeeting.getEndTime().toLocalTime() + " "
                        + eachMeeting.getRequestedBy());
            });
        }
    }

    private static LocalTime getTimeInput(Scanner scanner) {
        return DateTimeUtils.convertStringToTime(scanner.next());
    }
}
