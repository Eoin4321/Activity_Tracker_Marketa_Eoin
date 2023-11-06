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
            type=sc.next().trim();
            date=sc.next().trim();
            value=sc.next().trim();
            duration=Integer.parseInt(value);
            System.out.println("duration added"+duration);
            value=sc.next().trim();
            distance=Double.parseDouble(value);
            System.out.println("Distance value added "+distance);
            value=sc.nextLine().trim().substring(1);
            averageHeartRate=Double.parseDouble(value);
            System.out.println("\nType = "+type+"\nDuration = "+duration+"\nDate = "+date+"\nDistance = "+distance+"\nAverageHeartRate = "+averageHeartRate);

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


}