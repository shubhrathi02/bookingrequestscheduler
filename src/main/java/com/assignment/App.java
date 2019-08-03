package com.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws FileNotFoundException {
        File inputFile = new File("src/main/java/com/assignment/input.txt");
        Scanner scanner = new Scanner(inputFile);

        LocalTime startTime = getTimeInput(scanner);
        LocalTime endTime = getTimeInput(scanner);

        List<Meeting> meetings = new MeetingInputScanner().getInput(scanner);

        System.out.println(startTime + " - " + endTime);
        meetings.forEach(meeting -> System.out.println(meeting.toString()));

        MeetingRequestProcessor.process(meetings, startTime, endTime);
    }

    private static LocalTime getTimeInput(Scanner scanner) {
        return DateTimeUtils.convertStringToTime(scanner.next());
    }
}
