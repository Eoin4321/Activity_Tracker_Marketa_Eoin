package Activity_Tracker_Package;

public class ActivityTracker {
String Type;
int Duration;
String Date;
double Distance;
double AverageHeartRate;
    //Default Constructor
    public ActivityTracker() {
    }
    //Full Constructor

    public ActivityTracker(String type, int duration, String date, double distance, double averageHeartRate) {
        Type = type;
        Duration = duration;
        Date = date;
        Distance = distance;
        AverageHeartRate = averageHeartRate;
    }
    //Getters

    public String getType() {
        return Type;
    }

    public int getDuration() {
        return Duration;
    }

    public String getDate() {
        return Date;
    }

    public double getDistance() {
        return Distance;
    }

    public double getAverageHeartRate() {
        return AverageHeartRate;
    }

    //Setters

    public void setType(String type) {
        Type = type;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setDistance(double distance) {
        Distance = distance;
    }

    public void setAverageHeartRate(double averageHeartRate) {
        AverageHeartRate = averageHeartRate;
    }

    @Override
    public String toString() {
        return "ActivityTracker{" +
                "Type='" + Type + '\'' +
                ", Duration=" + Duration +
                ", Date='" + Date + '\'' +
                ", Distance=" + Distance +
                ", AverageHeartRate=" + AverageHeartRate +
                '}';
    }
}
