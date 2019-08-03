package com.assignment;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Meeting implements Comparable<Meeting> {

    LocalDateTime requestSubmissionTime;
    LocalDateTime startTime;
    LocalDateTime endTime;
    String requestedBy;

    public Meeting(LocalDateTime requestSubmissionTime, LocalDateTime startTime, int duration, String requestedBy) {
        this.requestSubmissionTime = requestSubmissionTime;
        this.startTime = startTime;
        this.endTime = this.startTime.plusHours(duration);
        this.requestedBy = requestedBy;
    }

    public LocalDateTime getRequestSubmissionTime() {
        return requestSubmissionTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getRequestedBy() {
        return requestedBy;
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
}
