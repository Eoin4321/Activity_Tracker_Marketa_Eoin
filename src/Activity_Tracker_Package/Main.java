package Activity_Tracker_Package;
import java.io.*;
import java.util.Scanner;
public class Main {
    Activity intensity;

        public static void main(String[] args) throws Exception
        {
            //parsing a CSV file into Scanner class constructor
            System.out.println("Test");
            Scanner sc = new Scanner(new File("src\\TestData\\activity_data_10.csv"));
            sc.useDelimiter(",");   //sets the delimiter pattern
            while (sc.hasNext())  //returns a boolean value
            {
                System.out.print(sc.next());  //find and returns the next complete token from this scanner
            }
            sc.close();  //closes the scanner

            Activity intensity;

        }

    public double KilometersPerHour(int Duration,Double Distance)
    {
        double KilometersPerHour;
        KilometersPerHour=Duration/Distance;
        return KilometersPerHour;
    }

    public void Intensity (double KilometersPerHour, String Type)
    {
        if(Type=="Swimming")
        {
            if(KilometersPerHour<=0.5)
            {
                intensity=Activity.Very_Light;
            }
            else if(KilometersPerHour<=1.25)
            {
                intensity=Activity.Light;
            }
            else if(KilometersPerHour<=2)
            {
                intensity=Activity.Moderate;
            }
            else if(KilometersPerHour<=2.75)
            {
                intensity=Activity.Vigorous;
            }
            else
            {
                intensity=Activity.Very_Vigorous;
            }
        }

        else if(Type=="Running")
        {
            if(KilometersPerHour==4)
            {
                intensity=Activity.Very_Light;
            }
            else if(KilometersPerHour>4 && KilometersPerHour<=8)
            {
                intensity=Activity.Light;
            }
            else if(KilometersPerHour>8 && KilometersPerHour<=12)
            {
                intensity=Activity.Moderate;
            }
            else if(KilometersPerHour>12 && KilometersPerHour<=16)
            {
                intensity=Activity.Vigorous;
            }
            else if(KilometersPerHour>16 && KilometersPerHour<=24)
            {
                intensity=Activity.Very_Vigorous;
            }
        }

        else if(Type=="Cycling")
        {
            if(KilometersPerHour==8)
            {
                intensity=Activity.Very_Light;
            }
            else if(KilometersPerHour>8 && KilometersPerHour<=16)
            {
                intensity=Activity.Light;
            }
            else if(KilometersPerHour>=17 && KilometersPerHour<=125)
            {
                intensity=Activity.Moderate;
            }
            else if(KilometersPerHour>25 && KilometersPerHour<=33)
            {
                intensity=Activity.Vigorous;
            }
            else if(KilometersPerHour>33 && KilometersPerHour<=40)
            {
                intensity=Activity.Very_Vigorous;
            }
        }
        }
    }





