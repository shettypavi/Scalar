import java.util.Scanner;

public class Solution 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		String line1 = sc.nextLine();
		String[] str = line1.split(",");
		int N = str.length;
		int[] input = new int[N];
		
		for(int i = 0; i < N; i++)
		{
			input[i] = Integer.parseInt(str[i]);
		}
		
		System.out.print(solve(input));
		
	}
	
	 public static int solve(int[] array) 
	 {
		 int timeCount = 0;
		 int max = Integer.MIN_VALUE;
		 
		 //Find max element in given array
		 for(int element : array)
		 {
			 if(max < element)
			 {
				 max = element;
			 }
		 }
		 
		 //find the time to make all element equal
		 for(int element : array)
		 {
			 timeCount = timeCount + (max - element);
		 }
		 
		 return timeCount;
	 }

}