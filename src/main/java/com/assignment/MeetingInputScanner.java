package com.assignment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MeetingInputScanner {
    public List<Meeting> getInput(Scanner scanner) {
        List<Meeting> meetings = new ArrayList<>();

        while(scanner.hasNext()){
            LocalDateTime meetingRequestSubmissionTime = getRequestSubmissionTimeInput(scanner);
            String meetingRequestedBy = scanner.next();
            LocalDateTime meetingStartTime = getMeetingStartTimeInput(scanner);
            int duration = scanner.nextInt();
            Meeting meeting = new Meeting(meetingRequestSubmissionTime, meetingStartTime, duration, meetingRequestedBy);
            meetings.add(meeting);
        }
        return meetings;
    }

    private LocalDateTime getMeetingStartTimeInput(Scanner scanner) {
        LocalDate date = getDateInput(scanner);
        LocalTime time = DateTimeUtils.convertStringToTimeforHHmmWithColon(scanner.next());
        return DateTimeUtils.convertTimeAndDateToDateTime(date, time);
    }

    private LocalDateTime getRequestSubmissionTimeInput(Scanner scanner) {
        LocalDate date = getDateInput(scanner);
        LocalTime time = DateTimeUtils.convertStringToTimeForHHmmss(scanner.next());
        return DateTimeUtils.convertTimeAndDateToDateTime(date, time);
    }

    private LocalDate getDateInput(Scanner scanner) {
        return DateTimeUtils.convertStringToDate(scanner.next());
    }

}
