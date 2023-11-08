package Activity_Tracker_Package;
import java.util.ArrayList;
import java.util.Arrays;
import static Activity_Tracker_Package.Main.stats;

public class BinarySearch {
    public static void binarySearch(int stats[], int first, int last, int key){
        Arrays.sort(stats);

        int mid = (first + last)/2;
        while( first <= last ){
            if ( stats[mid] < key ){
                first = mid + 1;
            }else if ( stats[mid] == key ){
                System.out.println("Element is found at index: " + mid);
                break;
            }else{
                last = mid - 1;
            }
            mid = (first + last)/2;
        }
        if ( first > last ){
            System.out.println("Element is not found!");
        }
    }
}

// negative comes before
// zero is equal
// positive is after


//code for binary search taken from: https://www.javatpoint.com/binary-search-in-java on the 8.11.2023