package Activity_Tracker_Package;

public class ActivityTracker {

    //type of activity/sport
    String type;
    //how long the activity took
    int duration;
    //on what date did they do the activity
    String date;
    //the distance traveled
    double distance;
    //their average heart rate
    double averageHeartRate;
    //Intensity
    Intensity intensity;

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
        intensity = calcintensity();

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

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setAverageHearRate(double averageHearRate) {
        this.averageHeartRate = averageHearRate;
    }


    //intensity method bsed on activity
    public Intensity calcintensity() {
        double kilometresPerHour;
        kilometresPerHour = duration / distance;
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
                } else if (kilometresPerHour <= 2.75) {
                    intensity = intensity.VERY_VIGOROUS;
                }
                break;
            }
            case "Running" -> {
                if (kilometresPerHour == 4) {
                    intensity = intensity.VERY_LIGHT;
                } else if (kilometresPerHour > 4 && kilometresPerHour <= 8) {
                    intensity = intensity.LIGHT;
                } else if (kilometresPerHour > 8 && kilometresPerHour <= 12) {
                    intensity = intensity.MODERATE;
                } else if (kilometresPerHour > 12 && kilometresPerHour <= 16) {
                    intensity = intensity.VIGOROUS;
                } else if (kilometresPerHour > 16 && kilometresPerHour <= 24) {
                    intensity = intensity.VERY_VIGOROUS;
                }
                break;
            }
            case "Cycling" -> {
                if (kilometresPerHour == 8) {
                    intensity = intensity.VERY_LIGHT;
                } else if (kilometresPerHour > 8 && kilometresPerHour <= 16) {
                    intensity = intensity.LIGHT;
                } else if (kilometresPerHour >= 17 && kilometresPerHour <= 25) {
                    intensity = intensity.MODERATE;
                } else if (kilometresPerHour > 25 && kilometresPerHour <= 33) {
                    intensity = intensity.VIGOROUS;
                } else if (kilometresPerHour > 33 && kilometresPerHour <= 40) {
                    intensity = intensity.VERY_VIGOROUS;
                }
                break;
            }
        }

        {
            return null;
        }
    }



    //toString method
    @Override
    public String toString() {
        return "ActivityTracker{" +
                "type='" + type + '\'' +
                ", duration=" + duration +
                ", date='" + date + '\'' +
                ", distance=" + distance +
                ", averageHearRate=" + averageHeartRate +
                ", intensity=" + intensity +
                '}';
    }
}
