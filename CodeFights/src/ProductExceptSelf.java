/**
 * Created by Tien on 11/24/2017.
 */
public class ProductExceptSelf {
    public static int productExceptSelf(int[] nums, int m) {
        Long p = 1L;

        for(int i = 0; i < nums.length; i++){
            p*=nums[i];
            p%=m;
        }
        System.out.println("p = "+p);
        Long sum = 0L;

        for(int i = 0; i < nums.length; i++) {
            sum += (p/nums[i])%m;

        }


        //System.out.print(sum);
        return sum%m;
    }
}
