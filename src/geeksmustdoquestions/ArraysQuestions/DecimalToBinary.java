package geeksmustdoquestions.ArraysQuestions;

import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        decimal2binary(30);

        digitSum(78);
    }
    public static void decimal2binary(int decimal){
        Stack<Integer> binary = new Stack<>();
        int temp = decimal;
        while(decimal > 0){
            binary.push(decimal % 2);
            decimal = decimal/2;
        }

        while(!binary.isEmpty()){
            System.out.print(binary.pop());
        }

        System.out.println();
        System.out.println(Integer.toBinaryString(temp));

    }
    public static void digitSum(int number ){
        //List<Integer> list = new ArrayList<>();
        int sum = 0;
        int temp = number;
        while(number > 0){
            //list.add(number%10);
            sum = number%10 + sum;
            number = number/10;
        }
        System.out.println("number "+temp+" sum "+sum);

    }

}
