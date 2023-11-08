package Activity_Tracker_Package;
import java.util.ArrayList;
import java.util.Arrays;
import static Activity_Tracker_Package.Main.stats;


//binary search on an array of integers
public class BinarySearch {
    public static void binarySearch(int stats[], int first, int last, int key){

        //sorts stats arraylist in ascending order
        Arrays.sort(stats);


        //calculating the index of middle element (that's in the middle)
        int mid = (first + last)/2;

        //as long as the first element is less than the last element
        while( first <= last )
            {
                //if the middle element is less than the key the user is looking for (target)
                if ( stats[mid] < key )
                    {
                        //updates the first element to be one element to the right of the mid element
                        first = mid + 1;
                    }

                //if the middle element is equal to the key
                else if ( stats[mid] == key )
                    {
                        //prints out message that the key is found at the current index mid
                        System.out.println("Element is found at index: " + mid);

                        //breaks the loop
                        break;
                    }

                //if the middle element is greater than the key
                else
                    {
                        //updates last to be one element to the left of mid
                        last = mid - 1;
                    }

                //formula to calculate where the mid is
                mid = (first + last)/2;
            }

        //after the loop is done, if the first element is greater than the last element
        if ( first > last )
            {
                //the key element was not found in the array
                System.out.println("Element is not found!");
            }
    }
}

// negative comes before
// zero is equal
// positive is after


//code for binary search taken from: https://www.javatpoint.com/binary-search-in-java on the 8.11.2023