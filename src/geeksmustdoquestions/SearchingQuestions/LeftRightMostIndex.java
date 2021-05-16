package geeksmustdoquestions.SearchingQuestions;

public class LeftRightMostIndex {
    public static void main(String[] args) {
        long[] v = {1 , 3 , 5 , 5 , 5, 5 , 67 , 123 , 125};
        int x = 5;

        pair p = indexes(v , 5);

        System.out.println(p.first +" "+p.second);
    }
    public static pair indexes(long v[], long x)
    {
        // Your code goes here
        int start = 0;
        int end = v.length-1;
        int first = -1;
        int last = -1;

        while(start <= end){

            if(v[start] == x){
                first = start;
            }else{
                start++;
            }
            if(v[end] == x ){
                last = end;
            }else{
                end--;
            }

            if(first > -1 && last > -1){
                break;
            }

        }

        return new pair(first,last);

    }
}
class pair{
    long first, second;
    public pair(long first, long second)
    {
        this.first = first;
        this.second = second;
    }
}
