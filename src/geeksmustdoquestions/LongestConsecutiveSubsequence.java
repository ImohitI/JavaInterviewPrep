package geeksmustdoquestions;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int n = 6;
        int arr[] = {8, 8 , 9 ,9 ,3 ,4};
        findLongestConseqSubseq(arr, n);
    }
    static int findLongestConseqSubseq(int arr[], int N)
    {

        if(arr.length == 1){
            return 1;
        }
        // add your code here
        int arr1[] = arr.clone();
        Arrays.sort(arr1);
        int result = 0;
        int count = 1;
        int max = 0;
        //System.out.println(Arrays.toString(arr1));
        //1 2 3 3 3 4 5 8 9
        for(int i = 1 ; i < arr1.length ; i++){
            int diff = arr1[i] - arr1[i-1];
            if(diff == 1){
                count++;
            }
            if(diff > 1 || i == (arr1.length-1)){
                max = Math.max(max, count);
                count= 1;
            }
        }
        //System.out.println(count);
        return max;
    }
    static int findLongestConseqSubseq_2(int a[], int n)
    {
        //using a HashSet to store elements.
        HashSet<Integer> hs = new HashSet<Integer>();
        int ans = 0;

        //inserting all the array elements in HashSet.
        for(int i=0; i<n; i++)
            hs.add(a[i]);

        //checking each possible sequence from the start.
        for(int i=0; i<n; i++)
        {
            //if current element is starting element of a sequence then only
            //we try to find out the length of sequence.
            if(!hs.contains(a[i]-1))
            {
                int j = a[i];
                //then we keep checking whether the next consecutive elements
                //are present in HashSet and we keep incrementing the counter.
                while(hs.contains(j))
                {
                    j++;
                }

                //storing the maximum count.
                if(ans<j-a[i])
                    ans=j-a[i];
            }
        }
        //returning the length of longest subsequence.
        return ans;
    }
}
