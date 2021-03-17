package LeetCodeQuestions;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();


        //threeSum(new int[]{-1,0,1,2,-1,-4});
        threeSum_2(new int[]{-1,0,1,2,-1,-4});
        threeSum_2(new int[]{-2,-1 ,1,1,3,5});
        threeSum_3(new int[]{-1,0,1,2,-1,-4});

    }
//---------------------------------------------O(n^3log(n))------------------------------------------------------------------

    public static List<List<Integer>> threeSum(int[] nums) {

        //Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i = 0 ; i < nums.length ; i++){
          twoSum(list, nums , 0-nums[i] , i);
        }

        System.out.println("result ...");
        System.out.println(list.toString());
        return list;

    }
    public static List<List<Integer>> twoSum(List<List<Integer>> list, int[] nums , int target, int index){

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i] , map.get(nums[i]) + 1);
            }else{
                map.put(nums[i] , 1);
            }
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(i == index) continue;

            int complement = target - nums[i];
            if(map.containsKey(complement)){
                if(complement != nums[index]){
                    System.out.print(" nums[i] "+nums[i]);
                    System.out.print(" complement "+complement);
                    System.out.println(" nums[index] "+nums[index]);
                    List<Integer> tempList = Arrays.asList(nums[i], complement , nums[index]);
                    Collections.sort(tempList);
                    //fnCheckForDuplicate O(n)
                    list.add(tempList);
                }else{
                    if(map.get(complement) >1){
                        List<Integer> tempList = Arrays.asList(nums[i], complement , nums[index]);
                        Collections.sort(tempList);
                        list.add(Arrays.asList(nums[i], complement , nums[index]));
                        map.put(complement, 1);
                    }
                }
            }
        }
        return list;
    }

    //-----------------------------------------O(n^2)-------space O(1)------------------------------------------------------------------

    public static List<List<Integer>> threeSum_2(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length ; i++){
            //skip for duplicates and go through for index 0
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];

                //two Sum
                while(low < high){
                    if(nums[low] + nums[high] == sum){
                        result.add(Arrays.asList(nums[i], nums[low] , nums[high]));
                        while(low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while(low< high && nums[high] == nums[high - 1]){
                            high--;
                        }
                        low++;
                        high--;
                    }else if(nums[low] + nums[high] > sum){
                        high--;
                    }else{
                        low++;
                    }
                }
            }
        }

        System.out.println(result.toString());
        return result;
    }

    //--------------------------------------O(n^2)---------space O(n)-------------------------------------------------

    public static List<List<Integer>> threeSum_3(int[] nums ){

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        List<List<Integer>> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        List<Integer> triplet = new ArrayList<>();

        for(int i = 0 ; i < nums.length -2; i++){

            int j = i + 1;

            int k = nums.length - 1;

            while(j < k){
                if(nums[i] + nums[j] + nums[k] == 0){

                    String str = nums[i] + ":"+nums[j]+":"+ nums[k];

                    if(!set.contains(str)){
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        list.add(triplet);
                        set.add(str);
                        triplet = new ArrayList<>();
                    }
                    j++;
                    k--;
                }else if(nums[i] + nums[j] + nums[k] < 0){
                    j++;
                }else
                    k--;
            }
        }
        System.out.println("result ...");
        System.out.println(list.toString());
        return list;
    }

}
