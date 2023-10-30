package Activity_Tracker_Package;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("C:\\Users\\bilam\\Documents\\Lab Project\\Activity_Tracker_Marketa_Eoin\\src\\TestData\\activity_data_10.csv"));
        sc.useDelimiter(",");

        while(sc.hasNext())
        {
            System.out.print(sc.next());
        }
        sc.close();
    }

    Activity intensity;
    public double kilometresPerHour(int duration, double distance){

        double kilometresPerHour;
        kilometresPerHour = duration/distance;
        return kilometresPerHour;
    }

    public void Intensity(double kilometresPerHour, String type){

        if(type=="Swimming")
        {
             if(kilometresPerHour<=0.5)
             {
                intensity = Activity.VERY_LIGHT;
             }

             else if(kilometresPerHour<=1.25)
             {
                 intensity = Activity.LIGHT;
             }

             else if(kilometresPerHour<= 2)
             {
                 intensity = Activity.MODERATE;
             }

             else if(kilometresPerHour<= 2.75)
             {
                intensity = Activity.VIGOROUS;
             }

             else if(kilometresPerHour<= 2.75)
             {
                intensity = Activity.VERY_VIGOROUS;
             }
        }

        else if(type=="Running")
        {
            if(kilometresPerHour==4)
            {
                intensity = Activity.VERY_LIGHT;
            }

            else if(kilometresPerHour>4 && kilometresPerHour <=8)
            {
                intensity = Activity.LIGHT;
            }

            else if(kilometresPerHour>8 && kilometresPerHour <=12)
            {
                intensity = Activity.MODERATE;
            }

            else if(kilometresPerHour>12 && kilometresPerHour <=16)
            {
                intensity = Activity.VIGOROUS;
            }

            else if(kilometresPerHour>16 && kilometresPerHour <=24)
            {
                intensity = Activity.VERY_VIGOROUS;
            }
        }

        else if(type=="Cycling")
        {
            if(kilometresPerHour==8)
            {
                intensity = Activity.VERY_LIGHT;
            }

            else if(kilometresPerHour>8 && kilometresPerHour <=16)
            {
                intensity = Activity.LIGHT;
            }

            else if(kilometresPerHour>=17 && kilometresPerHour <=25)
            {
                intensity = Activity.MODERATE;
            }

            else if(kilometresPerHour>25 && kilometresPerHour <=33)
            {
                intensity = Activity.VIGOROUS;
            }

            else if(kilometresPerHour>33 && kilometresPerHour <=40)
            {
                intensity = Activity.VERY_VIGOROUS;
            }
        }
    }
}