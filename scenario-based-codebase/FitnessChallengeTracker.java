/*
		13. Sandeep’s Fitness Challenge Tracker 
		 Each day Sandeep completes a number of push-ups.
		● Store counts for a week.
		● Use for-each to calculate total and average.
		● Use continue to skip rest days.
*/


public class FitnessChallengeTracker {

    public static void main(String[] args) {

        // Push-ups done each day, 0 means rest day
        int[] pushUp = {30, 0, 45, 50, 0, 40, 60};

        int total = 0;
        int activeDay = 0;

        for (int dayPushUp : pushUp) {

            // Skip rest days
            if (dayPushUp == 0) {
                continue;
            }

            total += dayPushUp;
            activeDay++;
        }

        double average = (activeDay > 0) ? (double) total / activeDay  : 0;

        System.out.println("\n---------- Sandeep's Fitness Challenge Tracker-----------\n");
        System.out.println("Total Push-ups in Week: " + total);
        System.out.println("Active Days: " + activeDay);
        System.out.println("Average Push-ups per Active Day: " + average);
    }
}
