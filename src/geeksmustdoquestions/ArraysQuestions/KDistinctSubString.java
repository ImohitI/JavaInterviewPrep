package geeksmustdoquestions.ArraysQuestions;

import java.util.HashMap;
import java.util.Map;

public class KDistinctSubString {
    /*
    SubString count

    Number of substrings of length one is n (We can choose any of the n characters)
    Number of substrings of length two is n-1 (We can choose any of the n-1 pairs formed by adjacent)
    Number of substrings of length three is n-2
    (We can choose any of the n-2 triplets formed by adjacent)
    In general, number of substrings of length k is n-k+1 where 1 <= k <= n

    Total number of substrings of all lengths from 1 to n =
    n + (n-1) + (n-2) + (n-3) + … 2 + 1
    = n * (n + 1)/2
     */
    public static void main(String[] args) {
        String s = "aabcbcdbca";
       // String s = "aabc";

        printAllSubstring(s);
        int k = 2;

        long answer = AtLeast_k_DistinctCharacters(s , k);
        System.out.println(answer);

        System.out.println("-----------------------------------------------------------");
         AtMost_K_DistinctCharacters(s, 2);
        AtMost_K_DistinctCharacters2(s ,2);

    }
    public static long AtLeast_k_DistinctCharacters(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        System.out.println(s.length()+" k "+k);
        int begin = 0, end = 0;

        long ans = 0;
        while (end < s.length()) {

            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            System.out.println("begin "+begin+"  end "+end+" char "+c+" size "+map.size());

            end++;


            while (map.size() >= k) {
                System.out.println("inner loop ");
                char pre = s.charAt(begin);
                if (map.containsKey(pre)) {
                    map.put(pre, map.getOrDefault(pre, 0) - 1);
                    if (map.get(pre) == 0) {
                        System.out.println("removal of pre "+pre);
                        map.remove(pre);
                    }
                }
                int toAdd = s.length() - end + 1;
                System.out.println(" toAdd "+toAdd);
                ans += toAdd;
                begin++;
            }
        }

        return ans;
    }
    static long findAllNonEmptySubstrings(String s){
        int n = s.length();
        return n * (n + 1) / 2;

    }
    static void printAllSubstring(String s){

        int n = s.length();
        int count=0;
        for(int i= 0; i < n ; i++){
            char[] temp = new char[n-i+1];
            int tempIndex = 0;

            for(int j = i; j < n ; j++){
                temp[tempIndex++] = s.charAt(j);
               // temp[tempIndex] = '\0';
                count++;
                System.out.println(temp);
            }
        }
        System.out.println(findAllNonEmptySubstrings(s)+" "+count);
    }

    static int AtMost_K_DistinctCharacters(String str , int k){

        int ans = 0;

        int begin = 0;
        int end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
/*
//valid substring starting at every index
a -- 3
a -- 2
b -- 4
c -- 3
b -- 2
c -- 2
d -- 2
b -- 2
c -- 2
a -- 1

//valid substring ending at every index
a -- 1
a -- 2
b -- 3
c -- 2
b -- 3
c -- 4
d -- 2
b -- 2
c -- 2
a -- 2
 */

        //find the a substring with atMost k distinct char starting from that index
        while(end < str.length()){
            char c = str.charAt(end);
            map.put(c , map.getOrDefault(c, 0)+1);

            if(map.size() <=k) {
                int toAdd = end - begin + 1;
                System.out.println(">> going to add "+toAdd+" for index "+end);
                ans += toAdd;
            }
            while(map.size() > k){
                // int toAdd = end - begin ;
               // System.out.println("adding "+toAdd+" for index "+begin);
               // ans += toAdd;//all substring with at most k distinct char starting from begin
                c = str.charAt(begin);

                if(map.get(c) == 1){
                    map.remove(c);
                }else {
                    map.put(c ,  map.get(c)-1);
                }
                begin++;

                if(map.size() == k){
                    int toAdd = end - begin + 1;
                    System.out.println(">>  adding "+toAdd+" for index "+begin+" end "+end);
                    ans += toAdd;
                }

            }
            end++;
        }


        System.out.println("ans "+ans);
        return ans;
    }
    static void AtMost_K_DistinctCharacters2(String str , int k){

        int ans = 0;

        int i = -1;
        int j = -1;
        HashMap<Character, Integer> map = new HashMap<>();

        while(true){
            while(i < str.length() - 1){
                System.out.println(" i "+i +" j "+ j);
                i++;
                char ch = str.charAt(i);
                map.put(ch , map.getOrDefault(ch , 0) + 1);

                if(map.size() <= k){
                    ans += i - j;
                }else{
                    break;
                }
            }

            if(i == str.length() - 1 && map.size() <= k){
                break;
            }

            while(j < i){
                j++;
                char ch = str.charAt(j);
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch , map.get(ch) - 1);
                }

                if(map.size() > k){
                    continue;
                }else{
                    ans += i - j;
                    break;
                }

            }
        }


        System.out.println("ans "+ans);
        //return ans;
    }
}
