package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

public class AirPlaneSeatAllocation {
    public static int airPlaneSeatReservation(int N, String S) {
        int seatAllocated = N * 3;

        if (S.contains(" ")) {
            String[] splitSeatReservation = S.split(" ");
            if (splitSeatReservation != null) {
                for (int i = 0; i < splitSeatReservation.length; i++) {
                    String seatReservation = splitSeatReservation[i];
                    char col = seatReservation.charAt(1);
                    if ((col == 'A' || col == 'B' || col == 'C')
                            || (col == 'E' || col == 'F')
                            || (col == 'H' || col == 'J' || col == 'K'))
                        seatAllocated -= 1;
                }
            }
        }

        return seatAllocated;
    }
}
