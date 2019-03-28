package time201312;

import java.util.Scanner;

public class MostNum1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int min = 0;		//出现次数相同中最小的数
		int max = 0;		//arr2最大的元素
		int temp = 0;
		
		Scanner sc = new Scanner(System.in);
		int n  = sc.nextInt();
		System.out.println(n);
		int arr1[] = new int[n];		//arr1作用：输入的数存放在arr1
		int arr2[] = new int[n];		//arr2作用：将arr1元素出现的次数作为arr2的元素
		for(int i=0;i<n;i++){
			arr1[i] = sc.nextInt();		
			arr2[i] = 0;			//将arr2元素都初始化
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){		//每个arr1每个元素都拿出来比较
				if(arr1[j]==arr1[i]){	//判断相同的元素，arr2序号元素自增
	        	   arr2[i]++;	
	        	}
			}
		}
		
		for(int i=0;i<n;i++){
		 if(arr2[i]>max){			//找出arr2中最大的元素
	        
	        max = arr2[i];			        //将arr2中最大的元素给max
	        temp = i;				//用temp记住最大元素的下标位置
	     
	        }
	       }
		
	 	min = arr1[temp];			//在数组arr1中找到出现次数最多的那个元素
	 	for(int i = 0;i<n;i++){
	 		if(arr2[i] == max)	{	//判断arr2中元素存在等于max(max是arr2最大的元素)
	 		   if(arr1[i]<arr1[temp]){      //遇见相同次数的元素，选择最小的
	 			   min = arr1[i];
	 		   }
	 		}
	 	}
	 		System.out.println(min);		
		}

	

}
