package lab1.ts;

public class Triangle {
	public boolean judge(int x) {
//		int[] contain = new int[] {1, 2, 3, 5, 6, 7, 8, 20, 21, 22, 23, 25, 26, 27, 28, 50, 
//		         51, 52, 53, 55, 56, 57, 58, 70, 71, 72, 73, 75, 76, 77, 78};
		int[] contains = new int[100];
		int size = 0;
		int[] a = new int [] {1, 2, 3};
		int[] b = new int [] {5, 10};
		int[] c = new int [] {20, 50, 70};
		for(int i = 0; i < a.length; i++)
		{
			contains[size] = a[i];
			size++;
		}
		for(int j = 0; j < b.length; j++)
		{
			contains[size] = b[j];
			size++;
		}
		for(int k = 0; k < c.length; k++)
		{
			contains[size] = c[k];
			size++;
		}
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < b.length; j++)
			{
				contains[size] = a[i] + b[j];
				size++;
			}
		}
		for(int i = 0; i < a.length; i++)
		{
			for(int k = 0; k < c.length; k++)
			{
				contains[size] = a[i] + c[k];
				size++;
			}
		}
		for(int j = 0; j < b.length; j++)
		{
			for(int k = 0; k < c.length; k++)
			{
				contains[size] = b[j] + c[k];
				size++;
			}
		}
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < b.length; j++)
			{
				for(int k = 0; k < c.length; k++)
				{
					contains[size] = a[i] + b[j] + c[k];
					size++;
				}
			}
		}
		for(int i = 0; i < size; i++)
		{
//			System.out.print(contains[i]);
//			System.out.print(" ");
			if(x == contains[i])
			{
				return true;
			}
		}
		return false;
		
		
	}
	
}
