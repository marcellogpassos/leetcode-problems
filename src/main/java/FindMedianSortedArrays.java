public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int[] smallest = nums1.length < nums2.length ? nums1 : nums2;
        final int[] largest = nums1 == smallest ? nums2 : nums1;

        final int[] enoughArray = new int[((smallest.length + largest.length) / 2) + 1];
        int si = 0;
        int li = 0;
        int ei = 0;
        while (ei < enoughArray.length) {
            if (si < smallest.length && (li == largest.length || smallest[si] < largest[li])) {
                enoughArray[ei] = smallest[si++];
            } else {
                enoughArray[ei] = largest[li++];
            }
            ei = si + li;
        }

        if (smallest.length + largest.length == 3) {
            return enoughArray[1];
        }

        return (smallest.length + largest.length) % 2 == 0 ?
                (enoughArray[enoughArray.length - 1] + enoughArray[enoughArray.length - 2]) / 2.0 :
                enoughArray[enoughArray.length - 1];
    }
}
