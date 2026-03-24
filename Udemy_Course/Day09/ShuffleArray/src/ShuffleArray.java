public class ShuffleArray {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = nums.length / 2;

        int[] rearranged = new int[nums.length];

        // We run this loop three times, because of the n's variable value =3
        for (int i = 0; i < n; i++) {
            //We're assigned the value of the even (par) positioned
            rearranged[2 * i] = nums[i];
            //We're assigned the value of the odd (impar) positioned
            rearranged[2 * i + 1] = nums[i + n];
        }

        //We show the new array (Rearranged) with a forEach loop
        System.out.print("Rearranged array: ");
        for (int i : rearranged) {
            System.out.print(i + " ");
        }

        /*NOTE: Even/Odd: Defines whether a number is divisible by 2 (even numbers end in 0,2,4,6,8; odd numbers in 1,3,5,7,9).*/
    }
}
