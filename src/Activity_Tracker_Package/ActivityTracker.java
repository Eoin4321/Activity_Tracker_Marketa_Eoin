package Activity_Tracker_Package;
import java.time.LocalDate;
import java.util.Date;
public class ActivityTracker {

    private String type;
    private int duration;
    private String date;
    private double distance;
    private double averageHeartRate;
    private Intensity intensity;
    private double caloriesBurned;

    //full constructor
    public ActivityTracker(String type, int duration, String date, double distance, double averageHeartRate) {
        this.type = type;
        this.duration = duration;
        this.date = date;
        this.distance = distance;
        this.averageHeartRate = averageHeartRate;
        this.intensity = intensity;
        this.caloriesBurned = caloriesBurned;
    }


//getters
    public String getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public String getDate() {
        return date;
    }

    public double getDistance() {
        return distance;
    }

    public double getAverageHeartRate() {
        return averageHeartRate;
    }

    public Intensity getIntensity() {
        return intensity;
    }

    public double getCaloriesBurned() {
        return caloriesBurned;
    }


    //setters
    public void setType(String type) {
        this.type = type;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setIntensity(Intensity intensity) {
        this.intensity = intensity;
    }

    public void setCaloriesBurned(double caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setAverageHeartRate(double averageHeartRate) {
        this.averageHeartRate = averageHeartRate;
    }



    //calories burned method
    public double caloriesBurned() {
        //calculates kilometres per hour first = intensity
        double kilometresPerHour = duration / distance;

        //and to get how many calories the user has burned it will multiply it by duration
        return duration * kilometresPerHour;
    }

    //intensity method
    public Intensity calcintensity() {
        double kilometresPerHour;
        //kilometres per hour formula
        kilometresPerHour =  (distance/duration)*60 ;
        //switch statement for every activity and intensity based on enum
        //based on the content from the tables in ca1 brief
        switch (type) {
            case "Swimming" -> {
                if (kilometresPerHour <= 0.5) {
                    intensity = intensity.VERY_LIGHT;
                } else if (kilometresPerHour <= 1.25) {
                    intensity = intensity.LIGHT;
                } else if (kilometresPerHour <= 2) {
                    intensity = intensity.MODERATE;
                } else if (kilometresPerHour <= 2.75) {
                    intensity = intensity.VIGOROUS;
                } else if (kilometresPerHour >= 2.75) {
                    intensity = intensity.VERY_VIGOROUS;
                }
                break;
            }
            case "Running" -> {
                if (kilometresPerHour <= 4) {
                    intensity = intensity.VERY_LIGHT;
                } else if (kilometresPerHour > 4 && kilometresPerHour <= 8) {
                    intensity = intensity.LIGHT;
                } else if (kilometresPerHour > 8 && kilometresPerHour <= 12) {
                    intensity = intensity.MODERATE;
                } else if (kilometresPerHour > 12 && kilometresPerHour <= 16) {
                    intensity = intensity.VIGOROUS;
                } else if (kilometresPerHour > 16 ) {
                    intensity = intensity.VERY_VIGOROUS;
                }
                break;
            }
            case "Cycling" -> {
                if (kilometresPerHour <= 8) {
                    intensity = intensity.VERY_LIGHT;
                } else if (kilometresPerHour > 8 && kilometresPerHour <= 16) {
                    intensity = intensity.LIGHT;
                } else if (kilometresPerHour >= 17 && kilometresPerHour <= 25) {
                    intensity = intensity.MODERATE;
                } else if (kilometresPerHour > 25 && kilometresPerHour <= 33) {
                    intensity = intensity.VIGOROUS;
                } else if (kilometresPerHour > 33 ) {
                    intensity = intensity.VERY_VIGOROUS;
                }
                break;
            }
        }
        return intensity;
    }

    //compares two strings lexicographically
    public static void main(String[] args) {
        String myStr1 = "Hello";
        String myStr2 = "Hello";

        // returns 0 because they are equal
        System.out.println(myStr1.compareTo(myStr2));
    }

//    public static void{
//        // storing input in variable
//        int n = 4;
//
//        // create string array called names
//        String names[]
//                = { "Rahul", "Ajay", "Gourav", "Riya" };
//        String temp;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//
//                // to compare one string with other strings
//                if (names[i].compareTo(names[j]) > 0) {
//                    // swapping
//                    temp = names[i];
//                    names[i] = names[j];
//                    names[j] = temp;
//                }
//            }
//        }
//    }

    //toString method
    public String toString() {
        return "ActivityTracker{" +
                "type='" + type + '\'' +
                ", duration=" + duration +
                ", date='" + date + '\'' +
                ", distance=" + distance +
                ", averageHeartRate=" + averageHeartRate +
                ", intensity=" + intensity +
                '}';
    }
}
