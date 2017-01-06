import java.util.*;
public class cfs379B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[4];
		for (int i = 0; i < 4; i++)
		{
			nums[i] = sc.nextInt();
		}
		int num256 = Math.min(nums[0], nums[2]);
		num256 = Math.min(num256, nums[3]);
		int num32 = Math.min(nums[1], nums[0] - num256);
		if (num32 < 0)
			num32 = 0;
		System.out.print(num256 * 256 + num32 * 32);
	}

}
