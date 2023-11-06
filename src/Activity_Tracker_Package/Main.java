package Activity_Tracker_Package;
//Importing

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

    //viewing file method - an array list of how many files the user uploaded
    public static void viewFile(){
        Scanner keyboard = new Scanner(System.in);
        String answer;

        System.out.println("Loading...");
        //view the file by default
        System.out.println("How do you want to view the file?");
        System.out.println("1) Default\n");
        System.out.println("2) Subset\n");
        System.out.println("3) Overall Performance");
        answer=keyboard.nextLine();

        if(answer == "1"){
            defaultView();
        }

        else if(answer == "2"){
            subsetView();
        }

        else if(answer == "3"){
            overallView();
        }

    }

    public static void defaultView(){
        Scanner keyboard = new Scanner(System.in);
        String answer;

        System.out.println("1) Calories Burned\n" +
                "2) Date\n" +
                "3) Activity duration\n" +
                "4) Type of activity\n" +
                "5) Distance\n");

        answer=keyboard.nextLine();

        if(answer == "1"){
            caloriesBurned();
        }
        else if(answer == "2"){
            date();
        }
        else if(answer == "3"){
            activityDuration();
        }
        else if(answer == "4"){
            activityType();
        }
        else if(answer == "5"){
            distance();
        }

    }

    public static void subsetView(){
        Scanner keyboard = new Scanner(System.in);
        String answer;

        System.out.println("1) Activity type\n" +
                "2) Above a minimum distance\n" +
                "3) Type of energy expended\n" +
                "4) Above a minimum duration");
    }

    public static void overallView(){
        Scanner keyboard = new Scanner(System.in);
        String answer;

        System.out.println("1) Average distance per activity\n" +
                "2) Average calories burned");
    }


    public static void caloriesBurned(){

    }
}