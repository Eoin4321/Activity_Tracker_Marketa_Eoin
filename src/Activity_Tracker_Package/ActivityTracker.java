package Activity_Tracker_Package;

public class ActivityTracker {

    private String type;
    private int duration;
    private String date;
    private double distance;
    private double averageHeartRate;
    private Intensity intensity;
    private double caloriesBurned;

    public ActivityTracker() {
    }

    public ActivityTracker(String type, int duration, String date, double distance, double averageHeartRate) {
        this.type = type;
        this.duration = duration;
        this.date = date;
        this.distance = distance;
        this.averageHeartRate = averageHeartRate;
        this.intensity = calcintensity();
        this.caloriesBurned = caloriesBurned();
    }

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

    public void setType(String type) {
        this.type = type;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setAverageHeartRate(double averageHeartRate) {
        this.averageHeartRate = averageHeartRate;
    }

    public double caloriesBurned() {
        double kilometresPerHour = duration / distance;
        return duration * kilometresPerHour;
    }

    public Intensity calcintensity() {
        double kilometresPerHour = duration / distance;
        // Switch statement for every activity and intensity based on enum
        // ...

        return intensity;
    }

    @Override
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
