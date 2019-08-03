package com.assignment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class MeetingRequestProcessor {
    public static Map<LocalDate, List<Meeting>> process(List<Meeting> meetings, LocalTime startTime, LocalTime endTime) {
        Collections.sort(meetings);
        Map<LocalDate, List<Meeting>> bookedMeetingsByDate = new HashMap<>();
        meetings.forEach(meeting -> {
            if(isValid(meeting, startTime, endTime)) {
                List<Meeting> allMeetingsOnDate = bookedMeetingsByDate.get(meeting.startTime.toLocalDate());
                if (allMeetingsOnDate != null) {
                    bookMeetingIfDoesNotOverlap(allMeetingsOnDate, meeting);
                } else {
                    bookedMeetingsByDate.put(meeting.startTime.toLocalDate(), new LinkedList<>(Collections.singletonList(meeting)));
                }
            }
        });
        return bookedMeetingsByDate;
    }

    private static boolean isValid(Meeting meeting, LocalTime startTime, LocalTime endTime) {
        return (meeting.startTime.toLocalTime().equals(startTime) || meeting.startTime.toLocalTime().isAfter(startTime))
                && (meeting.endTime.toLocalTime().equals(endTime) || meeting.endTime.toLocalTime().isBefore(endTime));
    }

    private static void bookMeetingIfDoesNotOverlap(List<Meeting> allMeetingsOnDate, Meeting meetingToAdd) {
        int noOfMeetings = allMeetingsOnDate.size();
        for (int i = 0; i < noOfMeetings; i++) {
            Meeting meeting = allMeetingsOnDate.get(i);
            if ((meeting.startTime.isEqual(meetingToAdd.endTime) || meeting.startTime.isAfter(meetingToAdd.endTime))) {
                allMeetingsOnDate.add(i, meetingToAdd);
                return;
            }
            if (meeting.endTime.isEqual(meetingToAdd.startTime) || meeting.endTime.isBefore(meetingToAdd.startTime)) {
                if((i+1) < noOfMeetings) {
                    Meeting nextMeeting = allMeetingsOnDate.get(i+1);
                    if(nextMeeting.startTime.isEqual(meetingToAdd.endTime) || nextMeeting.startTime.isAfter(meetingToAdd.endTime)){
                        allMeetingsOnDate.add((i+1), meetingToAdd);
                        return;
                    }
                } else {
                    allMeetingsOnDate.add((i+1), meetingToAdd);
                }
            }
        }
    }
}
