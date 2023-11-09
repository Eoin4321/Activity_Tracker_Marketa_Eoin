package Activity_Tracker_Package;
import java.time.LocalDate;
import java.util.Date;
public class ActivityTracker {

    //Setting up variables
    private String type;
    private int duration;
    private Date date;
    private double distance;
    private double averageHeartRate;
    private Intensity intensity;
    private double caloriesBurned;

    //Constructor
    public ActivityTracker(String type, int duration, Date date, double distance, double averageHeartRate) {
        this.type = type;
        this.duration = duration;
        this.date = date;
        this.distance = distance;
        this.averageHeartRate = averageHeartRate;
        this.intensity = calcintensity();
        this.caloriesBurned = caloriesBurned();
    }


    //Getters
    public String getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public Date getDate() {
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

    //Setters
    public void setType(String type) {
        this.type = type;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDate(Date date) {
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

    //CaloriesBurned calculation method
    public double caloriesBurned() {
        double kilometresPerHour = duration / distance;
        return duration * kilometresPerHour;
    }

    //Calc intensity method
    public Intensity calcintensity() {
        double kilometresPerHour;
        kilometresPerHour =  (distance/duration)*60 ;
        //switch statement for every activity and intensity based on enum
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
