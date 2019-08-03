package com.assignment;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Meeting implements Comparable<Meeting> {

    private LocalDateTime requestSubmissionTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String requestedBy;

    Meeting(LocalDateTime requestSubmissionTime, LocalDateTime startTime, int duration, String requestedBy) {
        this.requestSubmissionTime = requestSubmissionTime;
        this.startTime = startTime;
        this.endTime = this.startTime.plusHours(duration);
        this.requestedBy = requestedBy;
    }

    public LocalDateTime getRequestSubmissionTime() {
        return requestSubmissionTime;
    }

    LocalDateTime getStartTime() {
        return startTime;
    }

    String getRequestedBy() {
        return requestedBy;
    }

    LocalDateTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "requestSubmissionTime=" + requestSubmissionTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", requestedBy='" + requestedBy + '\'' +
                '}';
    }

    @Override
    public int compareTo(Meeting meeting) {
        return this.requestSubmissionTime.isBefore(meeting.requestSubmissionTime) ? -1 : 1;
    }

    boolean isAfter(Meeting meetingToAdd) {
        return startTime.isEqual(meetingToAdd.getEndTime()) || startTime.isAfter(meetingToAdd.getEndTime());
    }

    LocalDate getMeetingDate() {
        return startTime.toLocalDate();
    }

}
