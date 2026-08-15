/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l = 1;
        int r = mountainArr.length() - 2;
        int m = 0;
        while (l <= r) {
            m = l + (r-l) / 2;
            int left = mountainArr.get(m-1);
            int mid = mountainArr.get(m);
            int right = mountainArr.get(m+1);
            if (left < mid && mid > right) {
                break;
            }
            if (left < mid && mid < right) {
                l = m + 1; 
            }
            else {
                r = m - 1;
            }
        } 
        
        l = 0;
        r = m;
        while (l <= r) {
            int m1 = l + (r - l) / 2;
            if (mountainArr.get(m1) == target) {
                return m1;
            }
            if (mountainArr.get(m1) < target) {
                l = m1 + 1;
            }
            else {
                r = m1 - 1;
            }
        }

        l = m + 1;
        r = mountainArr.length() - 1;
        while (l <= r) {
            int m2 = l + (r - l) / 2;
            if (mountainArr.get(m2) == target) {
                return m2;
            }
            if (mountainArr.get(m2) < target) {
                r = m2 - 1;
            }
            else {
                l = m2 + 1;
            }
        }
        
        return -1;
    }
}

// find deflection with binary -> binary 1st half -> binary 2nd half
// 3log(n) = O(log(n))