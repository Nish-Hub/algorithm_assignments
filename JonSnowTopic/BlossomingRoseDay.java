
/*
Please refer to this url for output : https://goo.gl/2tc8ym
*/

import java.util.HashMap;
import java.util.Map;

public class Test1 {
	public static void main(String[] args) {
  // custom input
		int[] p = { 3, 1, 5, 4, 2 };
		System.out.println(solution(p, 3));
	}
	static int findMax(int[] arr)
	{
		int max=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(max<arr[i])
			{
				max=arr[i];
			}
		}
		return max;
	}
	
	public static int solution(int[] p, int k) {
		if(p==null)
			return -1;
		int[] arr = new int[findMax(p)];
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i = 0; i < p.length; i++) {
			arr[p[i]-1] = 1;
		int count = 0;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == 1) {
				count++;
			} else if (count != 0) {
					m.put(count,i+1);
				count = 0;

			}
		}
		
		}

		if (null != m.get(k))
			return m.get(k);

		return -1;

	}

}
