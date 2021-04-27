package algorithms;


import java.util.*;

public class SubstringCombination {
    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);

        ArrayList<String> res = new ArrayList<>();

        while(true){
            String temp = sc.nextLine();
            if(temp.equals("0")){
                break;
            }

             temp = process(temp);
            res.add(temp);
        }
        System.out.println();
        for(int i = 0;i<res.size();i++)
            System.out.println(res.get(i));
    }

    private static String process(String m) {

        // trimming extra space
        m.trim();

        // splitting the String m into two Strings s and l
        String[] arr = m.split(" ");
        ArrayList<Integer> res = new ArrayList<>();

        String s = arr[0];
        String l = arr[1];

        char[] arrChar = new char[]{'A','G','C','T'};
        //check for A G C T

        for(char c : m.toCharArray()){
           // System.out.println(c);
            if(c != arrChar[0] && c != arrChar[1] && c != arrChar[2] &&c != arrChar[3] && c != ' ' ){
                return "0 0 0";
            }
        }

        //Count type1 substrings
        res.add(getSubStringCount(s , l));

        //check type2 substrings
        HashSet<String> set = new HashSet<>();

        //using substring method split the substring at every index to get a new string which does not have the character at that index
        //using hashset to store unique substrings
        for(int i = 0 ; i < s.length() ; i++){

            String sub1 = s.substring(0,i);
            String sub2 = s.substring(i+1);
            String newString = sub1 + sub2;
            set.add(newString);
        }

        //counting by calling getSubStringCount on all substring of type2
        int type2Count = 0;
        Iterator<String> itr = set.iterator();
        while(itr.hasNext()){
            String temp = itr.next();
             type2Count += getSubStringCount(temp, l);
        }
        res.add(type2Count);

        //check type 3
        HashSet<String> set3 = new HashSet<>();
        //at every index add one of A G C T and build a new String
        //hashset used to store all unique substrings
        for(int i = 0 ; i <= s.length() ; i++){

            int j =0;
            while(j < arrChar.length) {
                StringBuilder newString = new StringBuilder("");

                if (i == 0) {

                    newString.append(arrChar[j]);
                    newString.append(s);

                }else if (i == s.length()){

                    newString.append(s);
                    newString.append(arrChar[j]);

                }else{

                    String sub1 = s.substring(0, i);
                    String sub2 = s.substring(i);
                    newString.append(sub1);
                    newString.append(arrChar[j]);
                    newString.append(sub2);

                }

                set3.add(newString.toString());
                j++;
            }
        }
        //counting all substring by calling getSubStringCount method on all type3 substrings
        int type3Count = 0;
        Iterator<String> it = set3.iterator();
        while(it.hasNext()){
            String temp = it.next();
            type3Count += getSubStringCount(temp, l);
        }
        res.add(type3Count);

        //converting res ArrayList to a String
        String result = "";
        for(int i = 0 ; i < res.size() ; i++){
            result += res.get(i)+" ";
        }

        return result.trim();
    }

    public static int getSubStringCount(String a , String l){
        int index = 0 ;
        int count = 0;

        while(true){
            index = l.indexOf(a, index);
            if(index != -1){
                count++;
                index++;
            }else{
                break;
            }
        }
        return count;
    }
}
