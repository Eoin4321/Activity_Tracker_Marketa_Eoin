package Activity_Tracker_Package;
//Importing
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //Creating an ArrayList
    ArrayList<ActivityTracker> stats = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        //Creating an ArrayList to store the users statistics.
        ArrayList<ActivityTracker> stats = new ArrayList<>();
        //Welcome Text
        System.out.println("Welcome to the activity tracker. Please enter the file you would like to read from(You can read more files later)");
        //Calling Methods
        fileReader(stats);
        //displayMenu(stats);

    }


    Activity intensity;
    public double kilometresPerHour(int duration, double distance){

        double kilometresPerHour;
        kilometresPerHour = duration/distance;
        return kilometresPerHour;
    }

    public static void fileReader( ArrayList<ActivityTracker> stats ) throws Exception {
        //Creating a scanner type keyboard called keyboard.
        Scanner keyboard = new Scanner(System.in);
        //Creating Variable to use to direct to the filepath
        String filename;

        System.out.println("Please type in the file location for the file you would to read.(Only type in the relative path and don't include .csv) ");
        //Setting the filename String to the users input.
        filename=keyboard.next();
        Scanner sc = new Scanner("src/TestData/"+new File(filename)+".csv");
        sc.useDelimiter(",");
        String type;
        int duration;
        String date;
        double distance;
        double averageHeartRate;
        String value;
        //Removing the stat labels at the top
        System.out.println(sc.nextLine());
        //Creating an ArrayList to store the new data
        ArrayList<ActivityTracker> newData = new ArrayList<>();
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


            //For loop to check for dublicates
        }





        sc.close();
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

//menu method
    public void displayMenu(int menuNum,  ArrayList<ActivityTracker> stats) throws Exception{
        Scanner keyboard = new Scanner(System.in);

//the menu
        System.out.println("Welcome!");
        System.out.println("Menu");
        System.out.println("1) View files\n");
        System.out.println("2) Upload files");
        System.out.println("(to navigate around the meu please type in number)");

//if user types in 1 it will bring them to the viewFile method to view the files
        if(menuNum == 1){
            viewFile();
        }

//if 2 it will bring them to the fileReader where the user can upload a new file
        else if(menuNum == 2){
            fileReader(stats);
        }
    }

//viewing file method
    public static void viewFile(){
        System.out.println("Which file would you like to view?");
    }
}