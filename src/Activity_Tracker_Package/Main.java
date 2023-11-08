package Activity_Tracker_Package;
//Importing

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

import static Activity_Tracker_Package.Intensity.*;

public class Main {

    //creating our ArrayList for ActivityTracker Objects
    public static ArrayList<ActivityTracker> stats = new ArrayList<ActivityTracker>();

    public static void main(String[] args) {
        //Running the file reader method when the program starts.
        System.out.println("Welcome to the Activity Tracker!");
        try {
            Menu.fileReader();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(stats);

    }


    static class ActivityTrackerComparator implements Comparator<ActivityTracker> {
        @Override
        public int compare(ActivityTracker a, ActivityTracker b) {
            // Sort in descending order based on caloriesBurned
            return Double.compare(b.caloriesBurned(), a.caloriesBurned());
        }
    }

    static class ActivityTrackerComparator2 implements Comparator<ActivityTracker> {
        @Override
        public int compare(ActivityTracker a, ActivityTracker b) {
            // Sort in descending order based on caloriesBurned
            return Double.compare(b.getDuration(), a.getDuration());
        }
    }


    static class ActivityTrackerComparator3 implements Comparator<ActivityTracker> {
        @Override
        public int compare(ActivityTracker a, ActivityTracker b) {
            // Sort in descending order based on date
            return CharSequence.compare(b.getDate(), a.getDate());
        }
    }

    public static void caloriesBurned()  {

        // Sort the ArrayList in descending order based on caloriesBurned
        Collections.sort(stats, new Main.ActivityTrackerComparator());
    }

    public static void sortduration()  {
        // Sort the ArrayList in descending order based on caloriesBurned
        Collections.sort(stats, new Main.ActivityTrackerComparator2());
    }

    public static void sortdates()  {
        // Sort the ArrayList in descending order based on caloriesBurned
        Collections.sort(stats, new Main.ActivityTrackerComparator3());
    }
}