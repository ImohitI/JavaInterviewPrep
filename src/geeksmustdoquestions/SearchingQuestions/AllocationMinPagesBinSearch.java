package geeksmustdoquestions.SearchingQuestions;

public class AllocationMinPagesBinSearch {
    public static void main(String[] args) {
        int arr[] = {12, 34, 67, 90};

        int m = 2; //No. of students

        System.out.println("Minimum number of pages = " +
                findPages(arr, arr.length, m));

        long x = Integer.MAX_VALUE + 13;
        System.out.println((int)x);//-2147483636

    }
    public static boolean isPossible(int arr[] , int n , int m , int min_curr){
        int studentsReq = 1;
        int curr_sum = 0;

        for(int x : arr){
            if(x > min_curr){
                return false;
            }

            if(curr_sum + x > min_curr){

                //reach the page allocation limit , cannot add more pages to a student , need more students
                studentsReq++;

                //start fresh new curr sum start with this book
                curr_sum = x;

                //cannot add more student
                if(studentsReq > m){
                    return  false;
                }
            }else{
                curr_sum += x;
            }
        }
        return true;
    }

    public static int findPages(int arr[] , int n , int m){

        long sum = 0;
        if(n < m){
            return -1;
        }

        for(int x: arr){
            sum += x;
        }
        int start = 0 , end = (int) sum;
        int result = Integer.MAX_VALUE;

        while(start <= end){
            int mid = (start + end)/2;
            if(isPossible(arr, n , m , mid)){
                result = Math.min(result, mid);
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return result;
    }
}
