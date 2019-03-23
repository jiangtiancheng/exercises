package time201312;

import java.util.HashMap;
import java.util.Scanner;

public class MostNum {
	/**
	 * 给定n个正整数，找出它们中出现次数最多的数。如果这样的数有多个，请输出其中最小的一个。
	 * 
	 * 输入的第一行只有一个正整数n(1 ≤ n ≤ 1000)，表示数字的个数。 
	 * 输入的第二行有n个整数s1, s2, …, sn (1 ≤ si ≤ 10000, 1 ≤ i ≤ n)。相邻的数用空格分隔。
	 * 
	 * 输入样例
	 * 6 
	 * 10 1 10 20 30 20
	 * 输出样例
	 * 10
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//控制台输入
		Scanner scanner=new Scanner(System.in);
		HashMap<Integer, Integer> map=new HashMap<>();
		int max=0;
		int number=scanner.nextInt();
		int[] array=new int[number];
		for (int i = 0; i < array.length; i++) {
			array[i]=scanner.nextInt();
			if (map.containsKey(array[i])) {
				map.put(array[i], map.get(array[i])+1);
			}else {
				map.put(array[i], 1);
			}
			if (map.get(array[i])>max) {
				max=map.get(array[i]);
			}
		}
		int min=1000;
		for (int key : map.keySet()) {  
			if (map.get(key)==max) {
				if (key<min) {
					min=key;
				}
			}
		 }  
		System.out.println(min);
		scanner.close();
	}

}
