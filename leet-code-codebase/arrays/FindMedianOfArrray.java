
// In this problem, we are given two sorted arrays, nums1 and nums2. We need to return the median of these two arrays.

class FindMedianOfArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index=0;
        int merge[] = new int [nums1.length+nums2.length];
        for(int i=0; i<nums1.length; i++){
            merge[index] = nums1[i];
            index++;
        }
        for(int j=0; j<nums2.length;j++){
            merge[index] = nums2[j];
            index++;
        }
        Arrays.sort(merge);

        if(merge.length % 2 == 0){
            return (merge[merge.length/2]+ merge[(merge.length/2)-1])/2.0;
        }else{
            return merge[merge.length/2];
        }
    }
}