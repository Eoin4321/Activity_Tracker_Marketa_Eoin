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
            //calls the fileReader() method from the Menu class
            Menu.fileReader();
        }
            //if an exception occurs during the file reading it is rethrown as a RunTimeException
            catch (Exception e) {
            throw new RuntimeException(e);
        }
        //prints the contents of the stats arraylist
        System.out.println(stats);

    }

    //nested static class that implements the comparator interface for activitytracker objects
    static class ActivityTrackerComparator implements Comparator<ActivityTracker> {
       //overrides the compare method
        @Override
        public int compare(ActivityTracker a, ActivityTracker b) {
            // Sort in descending order based on caloriesBurned
            return Double.compare(b.caloriesBurned(), a.caloriesBurned());
        }
    }

    // -,,-
    static class ActivityTrackerComparator2 implements Comparator<ActivityTracker> {
        @Override
        public int compare(ActivityTracker a, ActivityTracker b) {
            // Sort in descending order based on duration
            return Double.compare(b.getDuration(), a.getDuration());
        }
    }

    //-,,-
    static class ActivityTrackerComparatorDate implements Comparator<ActivityTracker> {
        @Override
        public int compare(ActivityTracker a, ActivityTracker b) {
            // overrides the compare method to sort the objects based on their dates
            return b.getDate().compareTo(a.getDate()) ;
        }
    }


    public static void SortDate()  {

        // Sort the ArrayList based on the dates of activitytracker object
        Collections.sort(stats, new Main.ActivityTrackerComparatorDate());
    }

    public static void caloriesBurned()  {

        // Sort the ArrayList in descending order based on caloriesBurned
        Collections.sort(stats, new Main.ActivityTrackerComparator());
    }

    public static void sortduration()  {
        // sorts the arraylist based on the durations of activitytracker objects
        Collections.sort(stats, new Main.ActivityTrackerComparator2());
    }

}