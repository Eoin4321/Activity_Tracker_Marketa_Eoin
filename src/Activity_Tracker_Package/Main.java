package Activity_Tracker_Package;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //Creating an ArrayList
    ArrayList<ActivityTracker> stats = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("C:\\Users\\kay\\Desktop\\OOPAssignment1\\Activity_Tracker\\src\\TestData\\activity_data_10.csv"));
        sc.useDelimiter(",");

        String type;
        int duration;
        String date;
        double distance;
        double averageHeartRate;
        String value;

        System.out.println(sc.nextLine());
        while(sc.hasNext())
        {

            type=sc.next();
            date=sc.next();
            value=sc.next();
            duration=Integer.parseInt(value.substring(SpaceCount(value)));
            System.out.println("duration added"+duration);

            value=sc.next();
            distance=Double.parseDouble(value.substring(SpaceCount(value)));
            System.out.println("Distance value added "+distance);

            value=sc.nextLine().substring(1);
            System.out.println("Current value before error "+value);
            averageHeartRate=Integer.parseInt(value.substring(SpaceCount(value)));

            System.out.println("\nTYPE = "+type+"\nDuration = "+duration+"\nDate = "+date+"\nTYPE = "+distance+"\nTYPE = "+averageHeartRate);

        }
        sc.close();
    }

    Activity intensity;
    public double kilometresPerHour(int duration, double distance){

        double kilometresPerHour;
        kilometresPerHour = duration/distance;
        return kilometresPerHour;
    }

    public void Intensity(double kilometresPerHour, String type){

        switch (type) {
            case "Swimming" -> {
                if (kilometresPerHour <= 0.5) {
                    intensity = Activity.VERY_LIGHT;
                } else if (kilometresPerHour <= 1.25) {
                    intensity = Activity.LIGHT;
                } else if (kilometresPerHour <= 2) {
                    intensity = Activity.MODERATE;
                } else if (kilometresPerHour <= 2.75) {
                    intensity = Activity.VIGOROUS;
                } else if (kilometresPerHour <= 2.75) {
                    intensity = Activity.VERY_VIGOROUS;
                }
            }
            case "Running" -> {
                if (kilometresPerHour == 4) {
                    intensity = Activity.VERY_LIGHT;
                } else if (kilometresPerHour > 4 && kilometresPerHour <= 8) {
                    intensity = Activity.LIGHT;
                } else if (kilometresPerHour > 8 && kilometresPerHour <= 12) {
                    intensity = Activity.MODERATE;
                } else if (kilometresPerHour > 12 && kilometresPerHour <= 16) {
                    intensity = Activity.VIGOROUS;
                } else if (kilometresPerHour > 16 && kilometresPerHour <= 24) {
                    intensity = Activity.VERY_VIGOROUS;
                }
            }
            case "Cycling" -> {
                if (kilometresPerHour == 8) {
                    intensity = Activity.VERY_LIGHT;
                } else if (kilometresPerHour > 8 && kilometresPerHour <= 16) {
                    intensity = Activity.LIGHT;
                } else if (kilometresPerHour >= 17 && kilometresPerHour <= 25) {
                    intensity = Activity.MODERATE;
                } else if (kilometresPerHour > 25 && kilometresPerHour <= 33) {
                    intensity = Activity.VIGOROUS;
                } else if (kilometresPerHour > 33 && kilometresPerHour <= 40) {
                    intensity = Activity.VERY_VIGOROUS;
                }
            }
        }
    }

    public static int SpaceCount(String value)
    {
        int spaceCount=0;
        for (int i = 0; i < value.length(); i++) {
            // Check if the character at the current index is a space
            if (value.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        return spaceCount;
    }
}