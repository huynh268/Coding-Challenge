/**
 * Created by Tien on 11/24/2017.
 * You have an array nums. We determine two functions to perform on nums. In both cases, n is the length of nums:

 fi(nums) = nums[0] · nums[1] · ... · nums[i - 1] · nums[i + 1] · ... · nums[n - 1]. (In other words, fi(nums) is the product of all array elements except the ithf.)
 g(nums) = f0(nums) + f1(nums) + ... + fn-1(nums).
 Using these two functions, calculate all values of f modulo the given m. Take these new values and add them together to get g. You should return the value of g modulo the given m.

 Example

 For nums = [1, 2, 3, 4] and m = 12, the output should be
 productExceptSelf(nums, m) = 2.

 The array of the values of f is: [24, 12, 8, 6]. If we take all the elements modulo m, we get:
 [0, 0, 8, 6]. The sum of those values is 8 + 6 = 14, making the answer 14 % 12 = 2.
 */
public class ProductExceptSelf {
    public static int productExceptSelf1(int[] nums, int m) {
        int n = nums.length;
        int[] preProduct = new int[n],
                suffProduct = new int[n];

        preProduct[0] = 1;
        suffProduct[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            preProduct[i] = preProduct[i - 1] * nums[i - 1] % m;
        }

        for (int i = n - 2; i >= 0; i--) {
            suffProduct[i] = suffProduct[i + 1] * nums[i + 1] % m;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (preProduct[i] * suffProduct[i]) % m;
        }
        return sum % m;
    }

    //Using https://en.wikipedia.org/wiki/Horner%27s_method
    //http://blog.codefights.com/productexceptself-solution/
    public static int productExceptSelf2(int[] nums, int m) {
        int product = 1;
        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            sum = (sum*nums[i] +product)%m;
            product = product*nums[i]%m;
        }

        return sum;
    }
}
