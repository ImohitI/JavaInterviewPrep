package geeksmustdoquestions.SearchingQuestions;

public class FloorSqrt {
    public static void main(String[] args) {
        System.out.println(floorSqrt(5));
    }
    static long floorSqrt(long x){
        if(x == 0 || x == 1){
            return 1;
        }

        long i = 1, result = 1;

        while(result <= x){
            i++;
            result = i * i;
        }
        return i-1;
    }
}
