# bookingrequestscheduler

Problem Statement: To process the booking requests in batches

Input:


0900 1730
2011-03-17 10:17:06 EMP001
2011-03-21 09:00 2
2011-03-16 12:34:56 EMP002
2011-03-21 09:00 2
2011-03-16 09:28:23 EMP003
2011-03-22 14:00 2
2011-03-17 11:23:45 EMP004
2011-03-22 16:00 1
2011-03-15 17:29:12 EMP005
2011-03-21 16:00 3


Output:

2011-03-21
09:00 11:00 EMP002
2011-03-22
14:00 16:00 EMP003
16:00 17:00 EMP004



Constraints
- No part of a meeting may fall outside office hours.
- Meetings may not overlap.
- The booking submission system only allows one submission at a time, so submission times are
guaranteed to be unique.
- Bookings must be processed in the chronological order in which they were submitted.
- The ordering of booking submissions in the supplied input is not guaranteed.


Please run App.java class to launch the application from any IDE.
