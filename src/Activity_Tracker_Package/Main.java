package Activity_Tracker_Package;
//Importing


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


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
            //if an exception occurs during the file reading it is rerun
            catch (Exception e) {
            throw new RuntimeException(e);
        }
        //Running the menu method
        Menu.displayMenu();


    }

    //CaloriesBurned method
    //Creating a comparator class based on the activityTracker object
    static class ActivityTrackerComparator implements Comparator<ActivityTracker> {

        //Instead of calling the regular method it will call this one
        @Override
        //Comparing both stats
        public int compare(ActivityTracker a, ActivityTracker b) {
            //Returing them in descending order
            return Double.compare(b.caloriesBurned(), a.caloriesBurned());
        }
    }

    //Duration method
    static class ActivityTrackerComparator2 implements Comparator<ActivityTracker> {
        @Override
        public int compare(ActivityTracker a, ActivityTracker b) {
            return Double.compare(b.getDuration(), a.getDuration());
        }
    }

    //Distance method
    static class ActivityTrackerComparator3 implements Comparator<ActivityTracker> {
        @Override
        public int compare(ActivityTracker a, ActivityTracker b) {
            return Double.compare(b.getDistance(), a.getDistance());
        }
    }

    //Date method
    static class ActivityTrackerComparatorDate implements Comparator<ActivityTracker> {
        @Override
        public int compare(ActivityTracker a, ActivityTracker b) {
            return b.getDate().compareTo(a.getDate()) ;
        }
    }



    //Sorting based on numbers returned in the comparator
    public static void SortDate()  {
        Collections.sort(stats, new Main.ActivityTrackerComparatorDate());
    }

    public static void caloriesBurned()  {
        Collections.sort(stats, new Main.ActivityTrackerComparator());
    }

    public static void sortduration()  {
        Collections.sort(stats, new Main.ActivityTrackerComparator2());
    }

    public static void sortdistance()  {
        Collections.sort(stats, new Main.ActivityTrackerComparator3());
    }

}