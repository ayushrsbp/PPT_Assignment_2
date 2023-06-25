import java.util.*;
public class Assignment_2
{
    // ----------------Question-1--------------//
    
    public static int maxGroup(int nums[]) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i = i+2) {
            sum+=nums[i];
        }
        return sum;
    }
    
    // ----------------Question-2--------------//
    
    public static int num_candy(int candyType[]) {
        
        HashSet<Integer> set = new HashSet<>();
        int n = candyType.length;
        for(int i : candyType) {
            if(!set.contains(i)) {
                set.add(i);
                if(set.size() == n/2) {
                    break;
                }
            }
        }
        return set.size();
    }
    
    // ----------------Question-3--------------//
    
    public static int lhs(int nums[]) {
        return helper(nums, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
    }
    public static int helper(int nums[], int l, int min, int max, int idx) {
        if(idx == nums.length) {
            return 0;
        }
        int incl = helper(nums, l+1, Math.min(min,nums[idx]), Math.max(max, nums[idx]), idx+1);
        int excl = helper(nums, l, min, max, idx+1);
        if(max-min == 1) {
            return Math.max(Math.max(incl, excl), l);
        }
        return Math.max(incl, excl);
    }
    
    // ----------------Question-4--------------//
    
    public static boolean canPlanted(int nums[], int n) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0 && i == 0 && nums[1] == 0) {
                return true;
            }
            if(nums[i] == 0 && i == nums.length-1 && nums[nums.length-2] == 0) {
                return true;
            }
            if(nums[i] == 0 && nums[i-1] == 0 && nums[i+1] == 0) {
                return true;
            }
        }
        return false;
    }
    
    // ----------------Question-5--------------//
    
    public static int maxProduct(int nums[]) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0]*nums[1]*nums[n-1], nums[n-1]*nums[n-2]*nums[n-3]);
    }
    
    // ----------------Question-6--------------//
    
    public static int search(int nums[], int target) {
        int si = 0, ei = nums.length;
        while(si<=ei) {
            int mid = (si+ei)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] > target) {
                ei = mid-1;
            }
            else {
                si = mid+1;
            }
        }
        return -1;
    }
    
    // ----------------Question-7--------------//
    
    public static boolean isMonotonic(int nums[]) {
        int n = nums.length;
        int i = 0;
        while(nums[i] == nums[i+1]) {
            i++;
        }
        if(nums[i] < nums[i+1]) {
            for(i = i+1; i < n-1; i++) {
                if(nums[i] > nums[i+1]) {
                    return false;
                }
            }
        }
        else {
            for(i = i+1; i < n-1; i++) {
                if(nums[i] < nums[i+1]) {
                    return false;
                }
            }
        }
        return true;
    }
    // ----------------Question-8--------------//
    
    public static int minScore(int nums[], int k) {
        int n = nums.length;
        if(n == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int largest = nums[n-1];
        int sndLargest = nums[n-2];
        int smallest = nums[0];
        int sndSmallest = nums[1];
        int x = Math.min(largest-sndLargest,k);
        int x2 = Math.min(sndSmallest-smallest, k);
        return Math.min((largest-smallest-x2),(largest-x-smallest));
    }

    
	public static void main(String[] args) {
	    
	    
	    // ----------------Question-1--------------//
	    System.out.println("----------------Question-1--------------");
	    
	    int nums1[] = {1,4,3,2};
	    System.out.println(maxGroup(nums1));
	    
	    // ----------------Question-2--------------//
	    System.out.println("----------------Question-2--------------");
	    
	    int candyType[] = {1,1,2,2,3,3};
	    System.out.println(num_candy(candyType));
	    
	    // ----------------Question-3--------------//
	    System.out.println("----------------Question-3--------------");
	    
	    int nums3[] = {1,3,2,2,5,2,3,7};
	    System.out.println(lhs(nums3));
	    
	    // ----------------Question-4--------------//
	    System.out.println("----------------Question-4--------------");
	    
	    int flowerbed[] = {1,0,0,0,1}, n = 1;
	    System.out.println(canPlanted(flowerbed, n));
	    
	    // ----------------Question-5--------------//
	    System.out.println("----------------Question-5--------------");
	    
	    int nums5[] = {4,1,2,3};
	    System.out.println(maxProduct(nums5));
	    
	    // ----------------Question-6--------------//
	    System.out.println("----------------Question-6--------------");
	    
	    int nums6[] = {-1,0,3,5,9,12}, target = 9;
	    System.out.println(search(nums6, target));
	    
	    // ----------------Question-7--------------//
	    System.out.println("----------------Question-7--------------");
	    
	    int nums7[] = {1,2,2,3};
	    System.out.println(isMonotonic(nums7));
	    
	    // ----------------Question-8--------------//
	    System.out.println("----------------Question-8--------------");
	    
	    int nums8[] = {1}, k = 0;
	    System.out.println(minScore(nums8,k));
	}
}
