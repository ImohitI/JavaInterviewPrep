package geeksmustdoquestions.ArraysQuestions;

import java.util.ArrayList;
import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int ints[] = {1, 2, 4};
        ArrayList<Integer> intList = new ArrayList<Integer>(ints.length);
        for (int i : ints)
        {
            intList.add(i);
        }
        try{
            intList.get(100);
        }catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
       // increment(intList, 3);
        System.out.println(increment(intList, 3).toString());
    }
    static ArrayList<Integer> increment(ArrayList<Integer> arr , int N) {
        // code here
        int carry = 0;
        arr.set(N-1, arr.get(N-1)+1);

        for(int i = arr.size()-1 ; i>=0; i--){
            int temp = arr.get(i)+carry;
            if(temp > 9){
                carry = temp/10;
                temp = temp%10;
            }else{
                carry = 0;
            }
            arr.set(i, temp);
        }


        if(carry > 0 ){
            arr.add(0, 1);
        }


        return arr;


    }
}
