package Activity_Tracker_Package;

public class anonymousinnerclasses {
    //this method creates an anonymous inner class that implements the Runnable interface
    public static void printHeaders() {
        Runnable printHeaderRunnable = new Runnable() {
            //overrides the tun method to define its behavior
            @Override
            //implementation of the run method
            public void run() {
                //formats and prints the header line by using %s and %n to format the output
                System.out.printf("%-10s %-8s %-12s %-8s %-16s %-12s %-15s%n",
                        "Type", "Duration", "Date", "Distance", "Avg Heart Rate", "Intensity", "Calories Burned");
            }
        };

        //calls the run method of Runnable that we created earlier, executes the code defined in the anonymous inner class
        printHeaderRunnable.run();
    }
}
