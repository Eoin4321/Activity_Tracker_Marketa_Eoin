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
    //File Reader Method
    public static void fileReader() throws Exception {
        Scanner keyboard = new Scanner(System.in);
        //Creating a string called filename which the user will input the name of the file into
        String filename;
        filename= keyboard.next();
        System.out.println("Please type in the file you want to read from.");
        //Chosing the file the user inputed
        Scanner sc = new Scanner(new File("src\\TestData\\"+filename+".csv"));
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
            value=sc.next().trim();
            distance=Double.parseDouble(value);
            value=sc.nextLine().trim().substring(1);
            averageHeartRate=Double.parseDouble(value);
            ActivityTracker newActivity = new ActivityTracker(type, duration, date, distance, averageHeartRate);
            if(!stats.contains(newActivity)){
                stats.add(newActivity);
            }
        }
        sc.close();
    }
    //menu method
    public void displayMenu(int menuNum, ArrayList<ActivityTracker> stats) throws Exception {
        Scanner keyboard = new Scanner(System.in);

//the menu
        System.out.println("Welcome!");
        System.out.println("Menu");
        System.out.println("1) View files\n");
        System.out.println("2) Upload files");
        System.out.println("(to navigate around the meu please type in number)");

//if user types in 1 it will bring them to the viewFile method to view the files
        if (menuNum == 1) {
            viewFile();
        }

//if 2 it will bring them to the fileReader where the user can upload a new file
        else if (menuNum == 2) {
            fileReader();
        }
    }
    //viewing file method - an array list of how many files the user uploaded
    public static void viewFile() {
        Scanner keyboard = new Scanner(System.in);
        String answer;

        System.out.println("Loading...");
        //view the file by default
        System.out.println("How do you want to view the file?");
        System.out.println("1) Default\n");
        System.out.println("2) Subset\n");
        System.out.println("3) Overall Performance");
        answer = keyboard.nextLine();

        if (answer == "1") {
            defaultView();
        } else if (answer == "2") {
            subsetView();
        } else if (answer == "3") {
            overallView();
        }

    }

    public static void defaultView() {
        Scanner keyboard = new Scanner(System.in);
        String answer;

        System.out.println("1) Calories Burned\n" +
                "2) Date\n" +
                "3) Activity duration\n" +
                "4) Type of activity\n" +
                "5) Distance\n");

        answer = keyboard.nextLine();

        if (answer == "1") {
            //caloriesBurned();
        } else if (answer == "2") {
            date();
        } else if (answer == "3") {
            activityDuration();
        } else if (answer == "4") {
            activityType();
        } else if (answer == "5") {
            distance();
        }

    }

    public static void subsetView() {
        Scanner keyboard = new Scanner(System.in);
        String answer;

        System.out.println("1) Activity type\n" +
                "2) Above a minimum distance\n" +
                "3) Type of energy expended\n" +
                "4) Above a minimum duration");

        answer = keyboard.nextLine();

        if (answer == "1") {
            activityType();
        } else if (answer == "2") {
            //aboveMinimumDistance();
        } else if (answer == "3") {
            energyExpended();
        } else if (answer == "4") {
            aboveMinimumDuration();

        }
    }

    public static void overallView() {
        Scanner keyboard = new Scanner(System.in);
        String answer;

        System.out.println("1) Average distance per activity\n" +
                "2) Average calories burned");
    }


    public static void caloriesBurned(int duration, int kilometresPerHour) {
        Scanner keyboard = new Scanner(System.in);
        String answer;
        String activity;

        double caloriesBurned;
        caloriesBurned = duration * kilometresPerHour;
        //based on what should they view it? activity? - probs
        System.out.println("Based on what activity do you want to see: Calories Burned?");
        answer = keyboard.nextLine();

        if (answer == "Swimming") {

            //get only the swimming column (get)

            //sorts in ascending order
            // Arrays.sort(ARRAY NAME);

            //sorts in reverse order
            // reverse(ARRAY NAME);
        } else if (answer == "Cycling") {

        } else if (answer == "Running") {

        } else {

        }

    }

    public static void date() {
        Scanner keyboard = new Scanner(System.in);
        String answer;

        //based on what should they view it? activity? - probs
        System.out.println("Based on what activity do you want to see: Date?");
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

    public static void activityType() {
        Scanner keyboard = new Scanner(System.in);
        String answer;

        //based on what should they view it? activity? - probs
        System.out.println("Based on what activity do you want to see: Type of Activity?");
        answer = keyboard.nextLine();

        if (answer == "Swimming") {

            //get only the swimming column (get)
            //printout

        }

        else if(answer == "Running"){

        }

        else if(answer == "Cycling"){

        }
    }

    public static void aboveMinimumDistance(ArrayList<ActivityTracker> stats){
        Scanner keyboard = new Scanner(System.in);
       // Collections.sort(stats);
        int minDistance = Integer.MAX_VALUE;

        System.out.println("What's your minimum distance requirement?");
        minDistance = keyboard.nextInt();

       for(int i=1; i<stats.size();i++)
       {
            if(minDistance>stats.get(i).distance)
                {
                    System.out.println(stats.toString());
                }
       }

    }

    public static void energyExpended(){
        Scanner keyboard = new Scanner(System.in);

        String gender;
        int age;
        double weight;
        double bmr;

        System.out.println("What gender are you?");
        System.out.println("a) Male     OR      b) Female");
        gender = keyboard.nextLine();

        System.out.println("What age are you? (min 18, max 74)");
        age = keyboard.nextInt();

        System.out.println("How much do you weight?");
        weight = keyboard.nextDouble();

        if(gender=="Male" || gender=="a")
            {
                if(age>=18&&age<=29)
                    {
                        bmr = (0.063*weight+2.896)*238.85;
                    }

                else if(age>=30&&age<=59)
                    {
                        bmr = (0.048*weight+3.653)*238.85;
                    }

                else if(age>=60&&age<=74)
                    {
                        bmr = (0.0499*weight+2.930)*238.85;
                    }
            }

        else if(gender=="Female" || gender == "b")
            {
                if(gender=="Male" || gender=="a")
                    {
                        bmr=(0.062*weight+2.036)*238.85;
                    }

                else if(age>=30&&age<=59)
                    {
                       bmr = (0.034*weight*3.538)*238.85;
                    }

                else if(age>=60&&age<=74)
                {
                    bmr = (0.0386*weight+2.875)*238.85;
                }
            }

        System.out.println("The total energy expenditure is: "+bmr+" kcal.");
    }

    public static void aboveMinimumDuration(){

    }
}