package ik.com.anup.sorting;

//hint :: same number of entries in both array are populated //but in the second array-- last non zero in second aray

/*First array has n positive numbers, and they are sorted in the non-descending order.

Second array has 2n numbers: first n are also positive and sorted in the same way but the last n are all zeroes.

Merge the first array into the second and return the latter. You should get 2n positive integers sorted in the non-descending order.

Example
{
"first": [1, 3, 5],
"second": [2, 4, 6, 0, 0, 0]
}
Output:

[1, 2, 3, 4, 5, 6]
Notes
Constraints:

1 <= n <= 105
1 <= array elements (except those zeroes) <= 2 * 109
You can use only constant auxiliary space
		*/
		
		
import java.util.ArrayList;

public class Merge_one_into_another {
    static ArrayList<Integer> merge_one_into_another(ArrayList<Integer> first, ArrayList<Integer> second) {
        int k = second.size() - 1;
      
        int i = first.size() - 1;
        int j =i; // same number of entries in both array are populated //but in the second array-- last non zero in second aray
        
        
        while (k >= 0 && i >= 0) {
            
            if (j >= 0 && second.get(j) >= first.get(i)) {
                second.set(k, second.get(j));
                j--;
            } else {
                second.set(k, first.get(i));
                i--;
            }
            k--;
        }
        
        return second;
    }
}
