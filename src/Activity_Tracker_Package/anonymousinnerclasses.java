package Activity_Tracker_Package;

public class anonymousinnerclasses {
    public static void printHeaders() {
        Runnable printHeaderRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.printf("%-10s %-8s %-12s %-8s %-16s %-12s %-15s%n",
                        "Type", "Duration", "Date", "Distance", "Avg Heart Rate", "Intensity", "Calories Burned");
            }
        };

        printHeaderRunnable.run();
    }
}
