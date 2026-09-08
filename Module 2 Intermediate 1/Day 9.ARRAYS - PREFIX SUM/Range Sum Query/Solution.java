import java.util.Scanner;

public class Solution 
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		String inputLine1 = sc.nextLine();
		String inputLine2 = sc.nextLine();
		
		String[] str1 = inputLine1.split(",");
		String[] str2 = inputLine2.split(",");
		
		int totalRows = (str2.length / 2);
		int N = str1.length;
		
		int[] input = new int[N];
		int[][] querys = new int[totalRows][2];
		long[] answer = new long[totalRows];
		
		for(int i = 0; i < N; i++)
		{
			input[i] = Integer.parseInt(str1[i]);
		}
		
		for(int i = 0,k = 0; i < (str2.length / 2); i++)
		{
			for(int j = 0; j <= 1; j++)
			{
				querys[i][j] = Integer.parseInt(str2[k++]);
			}
		}
		
		answer = rangeSum(input, querys);
		
		for(long element : answer)
		{
			System.out.print(element + " ");
		}
		
	}
	
	 public static long[] rangeSum(int[] array, int[][] querys) 
	 {
		 long[] answer = new long[querys.length];
		 long[] prefixSum = new long[array.length];
		 int index = 0;
		 
		 prefixSum = constructPrefixSum(array);
		 
		 for(int[] query : querys)
		 {
			 if(query[0] == 1)
			 {
				 answer[index] = prefixSum[query[1] - 1];
			 }else{
				 answer[index] = prefixSum[query[1] - 1] - prefixSum[query[0] - 1 - 1]; 
			 }
			 index++;
		 }
		 
		 return answer;
		 
	 }

	public static long[] constructPrefixSum(int[] array) 
	{
		long[] prefixSum = new long[array.length];
		prefixSum[0] = array[0];
		for(int i = 1; i < array.length; i++)
		{
			prefixSum[i] = array[i] + prefixSum[i - 1];
		}
		return prefixSum;
	}
}