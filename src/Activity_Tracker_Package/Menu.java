package Activity_Tracker_Package;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

import static Activity_Tracker_Package.Intensity.*;
import static Activity_Tracker_Package.Main.stats;

public class Menu {
    public static void fileReader() throws Exception {
        System.out.println("Please enter the name of the file you would like to add!");
        Scanner keyboard = new Scanner(System.in);
        //Creating a string called filename which the user will input the name of the file into
        String filename;
        filename = keyboard.next();
        //Chosing the file the user inputed
        Scanner sc = new Scanner(new File("src\\TestData\\" + filename + ".csv"));
        sc.useDelimiter(",");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String type;
        int duration;
        Date date;
        double distance;
        double averageHeartRate;
        String value;
        System.out.println(sc.nextLine());
        while (sc.hasNext()) {
            type = sc.next().trim();
            date = null;
            try {
                date = dateFormat.parse(sc.next().trim());
            } catch (ParseException e) {
                System.out.println("Date not found");
            }

            value = sc.next().trim();
            duration = Integer.parseInt(value);
            value = sc.next().trim();
            distance = Double.parseDouble(value);
            value = sc.nextLine().trim().substring(1);
            averageHeartRate = Double.parseDouble(value);

            // Add the newActivity object to the stats ArrayList
            stats.add(new ActivityTracker(type, duration, date, distance, averageHeartRate));
            System.out.println("PRINT STATS"+stats);
//            if (!stats.contains(newActivity)) {
//                stats.add(newActivity);
//            }
        }
        System.out.println(stats);
        sc.close();
        displayMenu();
    }

    public static void displayMenu() {
        int menuNum;
        Scanner keyboard = new Scanner(System.in);
//the menu
        System.out.println("Welcome!");
        System.out.println("Menu");
        System.out.println("1) View files\n");
        System.out.println("2) Upload files");
        System.out.println("(to navigate around the menu please type in number)");
        menuNum= keyboard.nextInt();
//if user types in 1 it will bring them to the viewFile method to view the files
        if (menuNum == 1) {
            viewFile();
        }
//if 2 it will bring them to the fileReader where the user can upload a new file
        else if (menuNum == 2) {
            try {
                fileReader();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    //viewing file method - an array list of how many files the user uploaded
    public static void viewFile() {
        Scanner keyboard = new Scanner(System.in);
        int answer;
        //view the file by default
        System.out.println("How do you want to view the file?");
        System.out.println("1) Default\n");
        System.out.println("3) Overall Performance");
        answer = keyboard.nextInt();

        if (answer == 1) {
            defaultView();
        } else if (answer == 3) {
            overallView();
        }
    }

    public static void defaultView() {
        Scanner keyboard = new Scanner(System.in);
        int answer;
        System.out.println("1) Calories Burned\n" +
                "2) Date\n" +
                "3) Activity duration\n" +
                "4) Type of activity\n" +
                "5) Distance\n");
        answer = keyboard.nextInt();
        if (answer == 1) {
            System.out.println("Running CaloriesBurned Method");
            Main.caloriesBurned();
        } else if (answer == 2) {
           // Main.sortdates();
        } else if (answer == 3) {
            Main.sortduration();
        } else if (answer == 4) {
            AlphabeticallyType();
        } else if (answer == 5) {
            distance();
        }
        System.out.println("TEST Entering SubsetView");
        subsetView();
    }

    //SUBSET VIEWS
    public static void subsetView() {
        Scanner keyboard = new Scanner(System.in);
        int answer;

        System.out.println("1) Activity type\n" +
                "2) Above a minimum distance\n" +
                "3) Type of energy expended\n" +
                "4) Above a minimum duration");

        answer = keyboard.nextInt();
        //SORTING BASED ON ACTIVITY TYPE
        String typeSelected = "";
        if (answer == 1) {
            typeSelected=selectType();
            anonymousinnerclasses.printHeaders();
            for (ActivityTracker activity : stats) {
                if (typeSelected.equals(activity.getType())) {
                    System.out.printf("%-10s %-8d %-12s %-8.2f %-16.2f %-12s %-15.2f%n",
                            activity.getType(), activity.getDuration(), activity.getDate(),
                            activity.getDistance(), activity.getAverageHeartRate(),
                            activity.getIntensity(), activity.caloriesBurned());
                }
            }
        }
        //ABOVE MINIMUM DISTANCE SUBSET

        else if (answer == 2)
        {
            double minimumDistance;
            System.out.println("Please enter the minimum distance for stats to be displayed.");
            minimumDistance = keyboard.nextDouble();
            anonymousinnerclasses.printHeaders();
            for (ActivityTracker activity : stats) {
                if(minimumDistance<activity.getDistance())
                {
                    System.out.printf("%-10s %-8d %-12s %-8.2f %-16.2f %-12s %-15.2f%n",
                            activity.getType(), activity.getDuration(), activity.getDate(),
                            activity.getDistance(), activity.getAverageHeartRate(),
                            activity.getIntensity(), activity.caloriesBurned());
                }
            }
        }

        //TYPE OF ENERGY EXPANDED

        else if (answer == 3) {
            Intensity intensityInput=null;
            System.out.println("Based on what type of energy expaned would you like to view?\n" +
                    "1)Very Light\n" +
                    "2)Light\n" +
                    "3)Moderate\n"+
                    "2)Vigorous\n" +
                    "2)Very_Vigorous\n");
            answer = keyboard.nextInt();
            if (answer == 1) {
                intensityInput = VERY_LIGHT;
            } else if (answer == 2) {
                intensityInput = LIGHT;
            } else if (answer == 3) {
                intensityInput = MODERATE;
            }
            else if (answer == 4) {
                intensityInput = VIGOROUS;
            }
            else if (answer == 5) {
                intensityInput = VERY_VIGOROUS;
            }

            anonymousinnerclasses.printHeaders();
            for (ActivityTracker activity : stats) {
                if (intensityInput==activity.getIntensity()) {
                    System.out.printf("%-10s %-8d %-12s %-8.2f %-16.2f %-12s %-15.2f%n",
                            activity.getType(), activity.getDuration(), activity.getDate(),
                            activity.getDistance(), activity.getAverageHeartRate(),
                            activity.getIntensity(), activity.caloriesBurned());
                }
            }


        }
        //ABOVE A MINIMUM DURATION
        else if(answer==4) {
            {
                double minimumInput;
                System.out.println("Please enter the minimum distance for stats to be displayed.");
                minimumInput = keyboard.nextDouble();
                anonymousinnerclasses.printHeaders();
                for (ActivityTracker activity : stats) {
                    if (minimumInput < activity.getDuration()) {
                        System.out.printf("%-10s %-8d %-12s %-8.2f %-16.2f %-12s %-15.2f%n",
                                activity.getType(), activity.getDuration(), activity.getDate(),
                                activity.getDistance(), activity.getAverageHeartRate(),
                                activity.getIntensity(), activity.caloriesBurned());
                    }
                }
            }
        }
    }

    //OLD CODE FOR PRINTING HEADERS. REPLACED IT WITH AN ANONYMUS INNER CLASS.
//    public static void printHeaders() {
//        System.out.printf("%-10s %-8s %-12s %-8s %-16s %-12s %-15s%n",
//                "Type", "Duration", "Date", "Distance", "Avg Heart Rate", "Intensity", "Calories Burned");
//    }


    public static void overallView() {
        String activityInput=selectType();

        Scanner keyboard = new Scanner(System.in);
        int answer;
        System.out.println("1) Average distance per activity\n" +
                "2) Average calories burned");
        answer = keyboard.nextInt();
        if(answer==1)
        {
            averageDistancePerActivity(activityInput);
        }
        else if(answer==2)
        {
            caloriesBurnedAverage();
        }
    }





    public static void date() {
        Scanner keyboard = new Scanner(System.in);
        String answer;

        //based on what should they view it? activity? - probs
        System.out.println("Based on what activity do you want to see: Date?");
        answer = keyboard.nextLine();

        if (answer == "Swimming") {

            //stats.get().
            //get only the swimming column (get)

            //sorts in ascending order
            // Arrays.sort(ARRAY NAME);

            //sorts in reverse order
            // reverse(ARRAY NAME);

//            String input;
//            System.out.println("View in: 1) Ascending  OR   2)Descending order");
//            input = keyboard.nextLine();
//
//            if (input == "1" || input == "Ascending") {
//                Collections.sort(stats);
//                System.out.println(stats);
//
//            } else if (input == "2" || input == "Descending") {
//                Collections.sort(stats);
//                Collections.reverse(stats);
//                System.out.println(stats);
//            }
        } else if (answer == "Cycling") {
            String input;
            System.out.println("View in: 1) Ascending  OR   2)Descending order");
            input = keyboard.nextLine();

            if (input == "1" || input == "Ascending") {
                // Arrays.sort(ARRAY NAME);
                //sout the array
            } else if (input == "2" || input == "Descending") {
                // Arrays.sort(ARRAY NAME);
                // reverse(ARRAY NAME);
                //sout the array
            }
        } else if (answer == "Running") {
            String input;
            System.out.println("View in: 1) Ascending  OR   2)Descending order");
            input = keyboard.nextLine();

            if (input == "1" || input == "Ascending") {
                // Arrays.sort(ARRAY NAME);
                //sout the array
            } else if (input == "2" || input == "Descending") {
                // Arrays.sort(ARRAY NAME);
                // reverse(ARRAY NAME);
                //sout the array
            }
        }
    }

    public static void activityDuration() {
        Scanner keyboard = new Scanner(System.in);
        String answer;

        //based on what should they view it? activity? - probs
        System.out.println("Based on what activity do you want to see: Activity Duration?");
        answer = keyboard.nextLine();

        if (answer == "Swimming") {

            //get only the swimming column (get)

            //sorts in ascending order
            // Arrays.sort(ARRAY NAME);

            //sorts in reverse order
            // reverse(ARRAY NAME);

            String input;
            System.out.println("View in: 1) Ascending  OR   2)Descending order");
            input = keyboard.nextLine();

            if (input == "1" || input == "Ascending") {
                // Arrays.sort(ARRAY NAME);
                //sout the array
            } else if (input == "2" || input == "Descending") {
                // Arrays.sort(ARRAY NAME);
                // reverse(ARRAY NAME);
                //sout the array
            }
        } else if (answer == "Cycling") {
            String input;
            System.out.println("View in: 1) Ascending  OR   2)Descending order");
            input = keyboard.nextLine();

            if (input == "1" || input == "Ascending") {
                // Arrays.sort(ARRAY NAME);
                //sout the array
            } else if (input == "2" || input == "Descending") {
                // Arrays.sort(ARRAY NAME);
                // reverse(ARRAY NAME);
                //sout the array
            }
        } else if (answer == "Running") {
            String input;
            System.out.println("View in: 1) Ascending  OR   2)Descending order");
            input = keyboard.nextLine();

            if (input == "1" || input == "Ascending") {
                // Arrays.sort(ARRAY NAME);
                //sout the array
            } else if (input == "2" || input == "Descending") {
                // Arrays.sort(ARRAY NAME);
                // reverse(ARRAY NAME);
                //sout the array
            }
        }
    }

    public static void distance() {
        Scanner keyboard = new Scanner(System.in);
        String answer;

        //based on what should they view it? activity? - probs
        System.out.println("Based on what activity do you want to see: Distance?");
        answer = keyboard.nextLine();

        if (answer == "Swimming") {

            //get only the swimming column (get)

            //sorts in ascending order
            // Arrays.sort(ARRAY NAME);

            //sorts in reverse order
            // reverse(ARRAY NAME);

            String input;
            System.out.println("View in: 1) Ascending  OR   2)Descending order");
            input = keyboard.nextLine();

            if (input == "1" || input == "Ascending") {
                // Arrays.sort(ARRAY NAME);
                //sout the array
            } else if (input == "2" || input == "Descending") {
                // Arrays.sort(ARRAY NAME);
                // reverse(ARRAY NAME);
                //sout the array
            }
        } else if (answer == "Cycling") {
            String input;
            System.out.println("View in: 1) Ascending  OR   2)Descending order");
            input = keyboard.nextLine();

            if (input == "1" || input == "Ascending") {
                // Arrays.sort(ARRAY NAME);
                //sout the array
            } else if (input == "2" || input == "Descending") {
                // Arrays.sort(ARRAY NAME);
                // reverse(ARRAY NAME);
                //sout the array
            }
        } else if (answer == "Running") {
            String input;
            System.out.println("View in: 1) Ascending  OR   2)Descending order");
            input = keyboard.nextLine();

            if (input == "1" || input == "Ascending") {
                // Arrays.sort(ARRAY NAME);
                //sout the array
            } else if (input == "2" || input == "Descending") {
                // Arrays.sort(ARRAY NAME);
                // reverse(ARRAY NAME);
                //sout the array
            }
        }
    }

    public static String activityType() {
        Scanner keyboard = new Scanner(System.in);
        int answer;
        //based on what should they view it? activity? - probs
        System.out.println("Based on what activity type would you like to view?\n" +
                "1)Cycling\n" +
                "2)Running\n" +
                "3)Swimming\n");
        answer = keyboard.nextInt();
        String typeSelected = "";
        if (answer == 1) {
            answer = keyboard.nextInt();
            if (answer == 1) {
                typeSelected = "Cycling";
            } else if (answer == 2) {
                typeSelected = "Running";
            } else if (answer == 3) {
                typeSelected = "Swimming";
            }
        }
        return typeSelected;
    }

    public static void averageDistancePerActivity(String typeSelected)
    {
        System.out.println("AVERAGEDISTANCEPERACTITIVITY METHOD RUNNING");
        double average=0;
        int count=0;
        for (ActivityTracker activity : stats) {
            System.out.println("TEST FOR LOOP RUNING");
            if (typeSelected.equals(activity.getType())) {
                count++;
                average=average+activity.getDistance();
                System.out.println("TEST CURRENT AVERAGE IN FOR LOOP=" +average);
            }
            average=average/count;
        }
        System.out.println("TEST Average = " +average);
        averageDistancePrintInformation(average,typeSelected);
    }



    public static void averageDistancePrintInformation(double average, String typeSelected)
    {
        anonymousinnerclasses.printHeaders();
        System.out.println("TYPE =" + typeSelected);
        System.out.println("Average =" + average);
        //System.out.printf("%-10s %-8sn %-10d %-8sf" ,"Type","Average Distance",average,typeSelected);
        System.out.println("AVERAGE DISTANCE PRINT INFORMATION RUNNING");
    }

    //SELECT TYPE METHOD

    public static String selectType() {
        Scanner keyboard = new Scanner(System.in);
        int answer = 1;
        String typeSelected = "";
        if (answer == 1) {
            System.out.println("Based on what activity type would you like to view?\n" +
                    "1)Cycling\n" +
                    "2)Running\n" +
                    "3)Swimming\n");
            answer = keyboard.nextInt();
            if (answer == 1) {
                typeSelected = "Cycling";
            } else if (answer == 2) {
                typeSelected = "Running";
            } else if (answer == 3) {
                typeSelected = "Swimming";
            }
        }
        return typeSelected;
    }

    public static void caloriesBurnedAverage()
    {
        double average=0;
        int count=0;
        for (ActivityTracker activity : stats) {
            System.out.println("TEST FOR LOOP RUNING");
            count++;
            average=average+activity.getDistance();
            System.out.println("TEST CURRENT AVERAGE IN FOR LOOP=" +average);
            average=average/count;
        }
        System.out.println("The average of calories burned is " +average);

    }

    public static void AlphabeticallyType()
    {
        //Using a lambda expression to sort the arraylist in alphabetical order.
        Collections.sort(stats, (activity1, activity2) -> activity1.getType().compareTo(activity2.getType()));
    }



    //ENERGY EXPANDED OTHER WAY
    public static void energyExpended() {
        Scanner keyboard = new Scanner(System.in);

        String gender;
        int age;
        double weight;
        double bmr = 0;

        System.out.println("What gender are you?");
        System.out.println("a) Male     OR      b) Female");
        gender = keyboard.nextLine();

        System.out.println("What age are you? (min 18, max 74)");
        age = keyboard.nextInt();

        System.out.println("How much do you weight?");
        weight = keyboard.nextDouble();

        if (gender == "Male" || gender == "a") {
            if (age >= 18 && age <= 29) {
                bmr = (0.063 * weight + 2.896) * 238.85;
            } else if (age >= 30 && age <= 59) {
                bmr = (0.048 * weight + 3.653) * 238.85;
            } else if (age >= 60 && age <= 74) {
                bmr = (0.0499 * weight + 2.930) * 238.85;
            }
        } else if (gender == "Female" || gender == "b") {
            if (gender == "Female" || gender == "b") {
                bmr = (0.062 * weight + 2.036) * 238.85;
            } else if (age >= 30 && age <= 59) {
                bmr = (0.034 * weight * 3.538) * 238.85;
            } else if (age >= 60 && age <= 74) {
                bmr = (0.0386 * weight + 2.875) * 238.85;
            }
        }

        System.out.printf("The total energy expenditure is: " + bmr + " kcal.");
    }



}


