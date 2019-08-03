package com.assignment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

class MeetingRequestProcessor {

    static Map<LocalDate, List<Meeting>> process(List<Meeting> meetings, LocalTime startTime, LocalTime endTime) {
        Collections.sort(meetings);
        Map<LocalDate, List<Meeting>> bookedMeetingsByDate = new TreeMap<>(getDateComparator());

        meetings.forEach(meeting -> {
            if (isValidMeeting(meeting, startTime, endTime)) {

                List<Meeting> allMeetingsOnDate = bookedMeetingsByDate.get(meeting.getMeetingDate());
                if (allMeetingsOnDate != null) {
                    bookMeetingIfDoesNotOverlap(allMeetingsOnDate, meeting);
                } else {
                    bookedMeetingsByDate.put(meeting.getMeetingDate(), new LinkedList<>(Collections.singletonList(meeting)));
                }
            }
        });

        return bookedMeetingsByDate;
    }

    private static Comparator<LocalDate> getDateComparator() {
        return (LocalDate d1, LocalDate d2) -> {
            if (d1.isEqual(d2))
                return 0;
            else if (d1.isBefore(d2)) {
                return -1;
            } else {
                return 1;
            }
        };
    }

    private static boolean isValidMeeting(Meeting meeting, LocalTime startTime, LocalTime endTime) {
        return (meeting.getStartTime().toLocalTime().equals(startTime) || meeting.getStartTime().toLocalTime().isAfter(startTime))
                && (meeting.getEndTime().toLocalTime().equals(endTime) || meeting.getEndTime().toLocalTime().isBefore(endTime));
    }

    private static List<Meeting> bookMeetingIfDoesNotOverlap(List<Meeting> allMeetingsOnDate, Meeting meetingToAdd) {
        int noOfMeetings = allMeetingsOnDate.size();
        for (int index = 0; index < noOfMeetings; index++) {
            Meeting meeting = allMeetingsOnDate.get(index);
            if (meeting.isAfter(meetingToAdd)) {
                allMeetingsOnDate.add(index, meetingToAdd);
                return allMeetingsOnDate;
            }
//            if (meeting.getEndTime().isEqual(meetingToAdd.getStartTime()) || meeting.getEndTime().isBefore(meetingToAdd.getStartTime())) {
            if (meetingToAdd.isAfter(meeting)) {
                if ((index + 1) < noOfMeetings) {
                    Meeting nextMeeting = allMeetingsOnDate.get(index + 1);
                    if (nextMeeting.isAfter(meetingToAdd)) {
                        allMeetingsOnDate.add((index + 1), meetingToAdd);
                        return allMeetingsOnDate;
                    }
                } else {
                    allMeetingsOnDate.add((index + 1), meetingToAdd);
                }
            }
        }
        return allMeetingsOnDate;
    }
}
