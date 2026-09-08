import java.util.Scanner;

public class Solution 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		String[] arr = sc.nextLine().split(",");
		int N = arr.length;
		int[] A = new int[N];
		
		for(int i = 0; i < N; i++)
		{
			A[i] = Integer.parseInt(arr[i]);
		}
		
		System.out.print(singleNumber(A));
		
	}

	// DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int singleNumber(final int[] A) 
    {
    	int N = A.length;
    	int ans = 0;
    	
    	for(int i = 0; i < N; i++)
    	{
    		ans = ans ^ A[i];
    	}
    	
    	return ans;
    }
}