package Activity_Tracker_Package;

public class ActivityTracker {

    String type;
    int duration;
    String date;
    double distance;
    double averageHeartRate;

    //default constructor
    public ActivityTracker() {
    }

    //full constructor
    public ActivityTracker(String type, int duration, String date, double distance, double averageHearRate) {
        this.type = type;
        this.duration = duration;
        this.date = date;
        this.distance = distance;
        this.averageHeartRate = averageHearRate;
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

    public double getAverageHearRate() {
        return averageHeartRate;
    }

    //setter
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

    public void setAverageHearRate(double averageHearRate) {
        this.averageHeartRate = averageHearRate;
    }

    @Override
    public String toString() {
        return "ActivityTracker{" +
                "type='" + type + '\'' +
                ", duration=" + duration +
                ", date='" + date + '\'' +
                ", distance=" + distance +
                ", averageHearRate=" + averageHeartRate +
                '}';
    }
}
