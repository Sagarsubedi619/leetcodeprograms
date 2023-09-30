/*
 * Author: Sagar Subedi
 * Date  : 09/27/2023
 */
package arrayandstring;

import java.util.Arrays;

/**
 * Class containing solutions to various Array and String related Leetcode problems.
 */
public class ArrayAndStringProblems
{
	/**
	 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number
	 * of elements in nums1 and nums2 respectively. Merge nums1 and nums2 into a single array sorted in non-decreasing order. The final
	 * sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a
	 * length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and
	 * should be ignored. nums2 has a length of n.
	 *
	 * @param nums1  array 1
	 * @param  m number of elements in nums1 array
	 * @param nums2 arrray 2
	 * @param  n number of elements in nums2 array
	 */
	public static void program1(int[] nums1, int m, int[] nums2, int n)
	{
		System.arraycopy(nums2, 0, nums1, m, n);

		//		Alternatively:
		//		for (int i = 0; i < n; i++)
		//		{
		//			nums1[m + i] = nums2[i];
		//		}

		Arrays.sort(nums1);
	}

	/**
	 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be
	 * changed. Then return the number of elements in nums which are not equal to val. Consider the number of elements in nums which are not
	 * equal to val be k, to get accepted, you need to do the following things:
	 * <ol>
	 *     <li>Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining
	 *     elements of nums are not important as well as the size of nums.</li>
	 *     <li>Return k.</li>
	 * </ol>
	 *
	 * @param nums array
	 * @param val evaluation value
	 * @return result
	 */
	public static int program2(int[] nums, int val)
	{
		int k = 0;
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] != val)
			{
				nums[k] = nums[i];
				k++;

			}
		}
		return k;
	}

	/**
	 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only
	 * once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
	 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
	 * <ol>
	 *     <li> Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in
	 *     nums initially. The remaining elements of nums are not important as well as the size of nums. </li>
	 * 	   <li> Return k.</li>
	 * 	</ol>
	 *
	 * @param nums array to use for evaluation
	 * @return result
	 */
	public static int program3(int[] nums)
	{
		int k = 0;
		for (int i = 0; i < nums.length; i++)
		{

			if (nums[k] != nums[i])
			{
				k++;
				nums[k] = nums[i];
			}
		}
		return k + 1;
	}
}