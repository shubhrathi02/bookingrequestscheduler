package com.assignment;

import junit.framework.TestCase;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class MeetingRequestProcessorTest extends TestCase {

    List<Meeting> meetingsInput;
    Map<LocalDate, List<Meeting>> meetingsOutput;
    LocalTime startTime;
    LocalTime endTime;

    public void testProcessor() throws FileNotFoundException {
        givenInputMeetings();
        meetingsOutput = MeetingRequestProcessor.process(meetingsInput, startTime, endTime);
        assertThat(meetingsOutput.size(), is(equalTo(2)));
        LocalDate date = LocalDate.of(2011, 03, 21);
        List<Meeting> meetingsOnDate = meetingsOutput.get(date);
        assertThat(meetingsOnDate.size(), is(equalTo(1)));
        LocalTime time = LocalTime.of(9, 0);
        assertThat(meetingsOnDate.get(0).getStartTime().getHour(), is(equalTo(9)));
        assertThat(meetingsOnDate.get(0).getRequestedBy(), is(equalTo("EMP002")));
    }

    private void givenInputMeetings() throws FileNotFoundException {
        File inputFile = new File("src/main/java/com/assignment/input.txt");
        Scanner scanner = new Scanner(inputFile);
        startTime = DateTimeUtils.convertStringToTime(scanner.next());
        endTime = DateTimeUtils.convertStringToTime(scanner.next());
        meetingsInput = new MeetingInputScanner().getInput(scanner);
    }
}
