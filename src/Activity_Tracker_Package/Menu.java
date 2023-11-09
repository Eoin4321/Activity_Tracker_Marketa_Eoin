package Activity_Tracker_Package;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

import static Activity_Tracker_Package.Intensity.*;
import static Activity_Tracker_Package.Main.sortduration;
import static Activity_Tracker_Package.Main.stats;

public class Menu {
    public static void fileReader() throws Exception {
        System.out.println("\nPlease enter the name of the file you would like to add!");
        //Creating a scanner called keyboard which will be used to take in inputs
        Scanner keyboard = new Scanner(System.in);
        //Creating a string called filename which the user will input the name of the file into
        String filename;
        //Filename is set to the keyboard input
        filename = keyboard.next();
        //Choosing the file the user inputted added in relative path and .csv for the user already
        Scanner sc = new Scanner(new File("src\\TestData\\" + filename + ".csv"));
        //When a comma appears in the line the item ends and it moves on to the next part of the line
        sc.useDelimiter(",");
        //Telling the program how my dates are taken in as
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String type;
        int duration;
        //Setting up a date variable
        Date date;
        double distance;
        double averageHeartRate;
        String value;
        //Getting rid of the headers in the .csv file
        System.out.println(sc.nextLine());
        //While the csv file has  more to read it will keep running otherwise it will stop.
        while (sc.hasNext()) {
            //trim removes the spaces around the text
            type = sc.next().trim();
            date = null;
            //Converting the date into a new format
            try {
                date = dateFormat.parse(sc.next().trim());
            } catch (ParseException e) {
                System.out.println("Date not found");
            }

            value = sc.next().trim();
            //Converting the string into an int
            duration = Integer.parseInt(value);
            value = sc.next().trim();
            //Converting the string into a double
            distance = Double.parseDouble(value);
            //Using substring to remove extra text at start
            value = sc.nextLine().trim().substring(1);
            averageHeartRate = Double.parseDouble(value);
            ActivityTracker newActivity=new ActivityTracker(type, duration, date, distance, averageHeartRate);
            // Add the newActivity object to the stats ArrayList
            //Meant to remove duplicates. Does not work as I think its checking memory location and not attributes.
            if (!stats.contains(newActivity)) {
               stats.add(new ActivityTracker(type, duration, date, distance, averageHeartRate));
            }
        }
        //Closing the scanner
        sc.close();
    }

    public static void displayMenu() {
        boolean on = true;
        int menuNum;
        Scanner keyboard = new Scanner(System.in);
//the menu
        System.out.println("\nWelcome!");
        //A while loop while on is true the menu will run and loop forever until shut down.
        while (on == true){
        System.out.println("\nMenu");
        System.out.println("1) View files\n");
        System.out.println("2) Upload files\n");
        System.out.println("3) Amount of Energy Expanded\n");
        System.out.println("4) Shut down\n");
        System.out.println("(to navigate around the menu please type in number)");
        //User inputs their option.
        menuNum = keyboard.nextInt();
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
        //if the user types in 3 it will bring them to the energyExpended Method
        else if (menuNum==3)
        {
            energyExpended ();
        }
        //If the user types in 4 it will set on to false which will turn off the while loop running the menu ending the software
        else if (menuNum == 4) {
            on = false;
        }
    }

}

        //viewing file method - an array list of how many files the user uploaded
        public static void viewFile () {
            Scanner keyboard = new Scanner(System.in);
            int answer;
            //view the file by default
            System.out.println("How do you want to view the file?");
            System.out.println("1) Default");
            System.out.println("2) Search by Binary");
            System.out.println("3) Overall Performance");
            answer = keyboard.nextInt();

            //Depending on input will run different methods
            if (answer == 1) {
                defaultView();
            } else if (answer == 2) {
                //Sorting array based on duration
                sortduration();
                //Reversing the array so its in the correct order for creating the new arraylist
                ReverseArray();

                //Making a new int arraylist
                ArrayList<Integer> durations = new ArrayList<>();

                //Running a for loop based on the size of stats.
                for (ActivityTracker activity : stats) {
                    //adding in the data from the current stats arraylist to the durations arraylist
                    int duration = activity.getDuration();
                    durations.add(duration);
                }
                System.out.println("Please type in the duration you are looking for");
                answer = keyboard.nextInt();
                //Using the binarySearch method. Inputing the duration array list and answer which will return where it is in the array list
                int index = Collections.binarySearch(durations, answer);
                //If it is less then 0 it means it does not exist in the array list so we print "Number not found"
                if (index < 0) {
                    System.out.println("Number not found");
                } else {
                    //If the number is found we print the number
                    System.out.println("The index of this duration is " + index);
                }
            } else if (answer == 3) {
                overallView();
            }
        }
        //DefaultView method
        public static void defaultView () {
            Scanner keyboard = new Scanner(System.in);
            int answer;
            System.out.println("1) Calories Burned\n" +
                    "2) Date\n" +
                    "3) Activity duration\n" +
                    "4) Type of activity\n" +
                    "5) Distance\n");
            //Running else ifs based on input
            answer = keyboard.nextInt();
            if (answer == 1) {
                //Linking to a different classes method
                Main.caloriesBurned();
            } else if (answer == 2) {
                Main.SortDate();
                System.out.println("Would you like to view in\n" +
                        "1) ASC\n" +
                        "2) DEC\n");
                //Reversing the array if they want to view in ASC order
                answer= keyboard.nextInt();
                if(answer==1)
                {
                    ReverseArray();
                }
            } else if (answer == 3) {
                Main.sortduration();
                System.out.println("Would you like to view in\n" +
                        "1) ASC\n" +
                        "2) DEC\n");
                answer= keyboard.nextInt();
                if(answer==1)
                {
                    ReverseArray();
                }
            } else if (answer == 4) {
                AlphabeticallyType();
            } else if (answer == 5) {
                Main.sortdistance();
                System.out.println("Would you like to view in\n" +
                        "1) ASC\n" +
                        "2) DEC\n");
                answer= keyboard.nextInt();
                if(answer==1)
                {
                    ReverseArray();
                }
            }
            System.out.println("\nPlease select a subset to view your data.");
            subsetView();
        }

        //SUBSET VIEWS
        public static void subsetView () {
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
                typeSelected = selectType();
                //Linking to the anonymousinnerclass to print headers
                anonymousinnerclasses.printHeaders();
                //Running a for loop for my entire arraylist. If the type equals the type inputed it will print it
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

            else if (answer == 2) {
                double minimumDistance;
                System.out.println("Please enter the minimum distance for stats to be displayed.");
                minimumDistance = keyboard.nextDouble();
                anonymousinnerclasses.printHeaders();
                //Running a for loop for my Arraylist if the distance is less then minimum distance it won't print but will print if it is above the minimum distance.
                for (ActivityTracker activity : stats) {
                    if (minimumDistance < activity.getDistance()) {
                        System.out.printf("%-10s %-8d %-12s %-8.2f %-16.2f %-12s %-15.2f%n",
                                activity.getType(), activity.getDuration(), activity.getDate(),
                                activity.getDistance(), activity.getAverageHeartRate(),
                                activity.getIntensity(), activity.caloriesBurned());
                    }
                }
            }

            //TYPE OF ENERGY EXPANDED

            else if (answer == 3) {
                //Creating a new enum variable
                Intensity intensityInput = null;
                System.out.println("Based on what type of energy expaned would you like to view?\n" +
                        "1)Very Light\n" +
                        "2)Light\n" +
                        "3)Moderate\n" +
                        "2)Vigorous\n" +
                        "2)Very_Vigorous\n");
                //Setting the variable based on input
                answer = keyboard.nextInt();
                if (answer == 1) {
                    intensityInput = VERY_LIGHT;
                } else if (answer == 2) {
                    intensityInput = LIGHT;
                } else if (answer == 3) {
                    intensityInput = MODERATE;
                } else if (answer == 4) {
                    intensityInput = VIGOROUS;
                } else if (answer == 5) {
                    intensityInput = VERY_VIGOROUS;
                }
                //Running through the arraylist if the enums match it will print
                anonymousinnerclasses.printHeaders();
                for (ActivityTracker activity : stats) {
                    if (intensityInput == activity.getIntensity()) {
                        System.out.printf("%-10s %-8d %-12s %-8.2f %-16.2f %-12s %-15.2f%n",
                                activity.getType(), activity.getDuration(), activity.getDate(),
                                activity.getDistance(), activity.getAverageHeartRate(),
                                activity.getIntensity(), activity.caloriesBurned());
                    }
                }


            }
            //ABOVE A MINIMUM DURATION
            else if (answer == 4) {
                {
                    double minimumInput;
                    System.out.println("Please enter the minimum distance for stats to be displayed.");
                    minimumInput = keyboard.nextDouble();
                    anonymousinnerclasses.printHeaders();
                    //Running a for loop if the duration is greater then the minimumInput it will print else it wont.
                    for (ActivityTracker activity : stats) {
                        if (minimumInput < activity.getDuration()) {
                            //Using printf so its formated correctly
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


        public static void overallView () {

            Scanner keyboard = new Scanner(System.in);
            int answer;
            System.out.println("1) Average distance per activity\n" +
                    "2) Average calories burned");
            //Running methods based on input
            answer = keyboard.nextInt();
            if (answer == 1) {
                String activityInput = selectType();
                averageDistancePerActivity(activityInput);
            } else if (answer == 2) {
                caloriesBurnedAverage();
            }
        }
        public static void averageDistancePerActivity (String typeSelected)
        {
            double average = 0;
            int count = 0;
            //Running a for loop.
            for (ActivityTracker activity : stats) {
                //If type select equals the activity inputed it will run the if statement which adds to the count and adds the distance to the average
                if (typeSelected.equals(activity.getType())) {
                    count++;
                    average = average + activity.getDistance();
                }
                //Dividing total by count to get average
                average = average / count;
            }
            //Putting this data to a new method
            averageDistancePrintInformation(average, typeSelected);
        }

        //Taking average and type selected to print them
        public static void averageDistancePrintInformation ( double average, String typeSelected)
        {
            anonymousinnerclasses.printHeaders();
            System.out.println("TYPE =" + typeSelected);
            System.out.println("Average =" + average);
            //System.out.printf("%-10s %-8sn %-10d %-8sf" ,"Type","Average Distance",average,typeSelected);
        }

        //SELECT TYPE METHOD
        public static String selectType () {
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

        //CaloriesBurnedMethod
        public static void caloriesBurnedAverage ()
        {
            double average = 0;
            int count = 0;
            for (ActivityTracker activity : stats) {
                count++;
                average = average + activity.getDistance();
                average = average / count;
            }
            System.out.println("The average of calories burned is " + average);

        }

        public static void AlphabeticallyType ()
        {
            //Using a lambda expression to sort the arraylist in alphabetical order.
            Collections.sort(stats, (activity1, activity2) -> activity1.getType().compareTo(activity2.getType()));
        }


        //ENERGY EXPANDED OTHER WAY Calculation
        public static void energyExpended () {
            Scanner keyboard = new Scanner(System.in);

            String gender;
            int age;
            double weight;
            double bmr = 0;

            System.out.println("What gender are you?");
            System.out.println("a) Male     OR      b) Female");
            gender = keyboard.next();

            System.out.println("What age are you? (min 18, max 74)");
            age = keyboard.nextInt();

            System.out.println("How much do you weight?");
            weight = keyboard.nextDouble();

            if (gender.equals("Male") || gender.equals("a")) {
                if (age >= 18 && age <= 29) {
                    bmr = (0.063 * weight + 2.896) * 238.85;
                } else if (age >= 30 && age <= 59) {
                    bmr = (0.048 * weight + 3.653) * 238.85;
                } else if (age >= 60 && age <= 74) {
                    bmr = (0.0499 * weight + 2.930) * 238.85;
                }
            } else if (gender.equals("Female") || gender.equals("b")) {
                if (gender.equals("Female") || gender.equals("b")) {
                    bmr = (0.062 * weight + 2.036) * 238.85;
                } else if (age >= 30 && age <= 59) {
                    bmr = (0.034 * weight * 3.538) * 238.85;
                } else if (age >= 60 && age <= 74) {
                    bmr = (0.0386 * weight + 2.875) * 238.85;
                }
            }

            System.out.printf("The total energy expenditure is: " + bmr + " kcal.");
        }

        public static void ReverseArray ()
        {
            Collections.reverse(stats);
        }



}


