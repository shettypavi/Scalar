import java.util.Scanner;

public class Solution 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		//store the given input in string format into integer array
		String line = sc.nextLine();
		String[] stringArray = line.split(",");
		int[] input = new int[stringArray.length];
		
		for(int i = 0; i < stringArray.length; i++)
		{
			input[i] = Integer.parseInt(stringArray[i]);
		}
		
		//print the output
		System.out.print(solve(input));
		
	}
	
	public static int solve(int[] array) 
	{
		int count = 0;
		int N = array.length;
		int[] evenIdxPrefixSum = new int[N]; 
		int[] oddIdxPrefixSum = new int[N];
		int totalEvenIdxSum;	//to find total Even index sum when respective element is deleted
		int totalOddIdxSum;		//to find total odd index sum when respective element is deleted
		
		constructPrefixSum(evenIdxPrefixSum, oddIdxPrefixSum, array);
		
		//calculate total Even & odd index sum when respective element is deleted
		//i represent the index given array of which element is deleted
		//Eg. if i = 2 => we need to calculate total Even & odd index sum when array[2] is deleted
		for(int i = 0; i < N; i++)
		{
			if(i == 0)
			{
				totalEvenIdxSum = (oddIdxPrefixSum[N - 1] - oddIdxPrefixSum[i]);
				totalOddIdxSum	= (evenIdxPrefixSum[N - 1] - evenIdxPrefixSum[i]);
			}else {
				totalEvenIdxSum = evenIdxPrefixSum[i - 1] + (oddIdxPrefixSum[N - 1] - oddIdxPrefixSum[i]);
				totalOddIdxSum	= oddIdxPrefixSum[i - 1] + (evenIdxPrefixSum[N - 1] - evenIdxPrefixSum[i]);
			}
			
			/*
			 * As per the Question we need to find 
			 * total number of count of totalEvenIdxSum == totalOddIdxSum 
			 * when respective element form the given array is deleted
			*/
			if(totalEvenIdxSum == totalOddIdxSum)
			{
				count++;
			}
		}
		
		return count;
    }

	//construct prefix sum for odd and even index @O(N) time and O(N) space
	public static void constructPrefixSum(int[] evenIdxPrefixSum, int[] oddIdxPrefixSum, int[] array) 
	{
		evenIdxPrefixSum[0] = array[0];
		oddIdxPrefixSum[0] = 0;
		for(int index = 1; index < array.length; index++)
		{
			if(index % 2 == 1)	//for odd index calculate prefix sum
			{
				evenIdxPrefixSum[index] = evenIdxPrefixSum[index - 1];
				oddIdxPrefixSum[index] = oddIdxPrefixSum[index - 1] + array[index];
			}else{	//for even index calculate prefix sum
				evenIdxPrefixSum[index] = array[index] + evenIdxPrefixSum[index - 1];
				oddIdxPrefixSum[index] = oddIdxPrefixSum[index - 1];
			}
		}
	}

}