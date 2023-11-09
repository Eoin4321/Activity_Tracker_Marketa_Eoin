package Activity_Tracker_Package;

public class anonymousinnerclasses {

    public static void printHeaders() {
        //Actions to run when called
        Runnable printHeaderRunnable = new Runnable() {

            //Override to use this instead of the default run()
            @Override
            public void run() {
                //Using a printf statement to print headers in a good format
                System.out.printf("%-10s %-8s %-28s %-8s %-16s %-12s %-15s%n",
                        "Type", "Duration", "Date", "Distance", "Avg Heart Rate", "Intensity", "Calories Burned");
            }
        };
        //Running the method
        printHeaderRunnable.run();
    }
}
