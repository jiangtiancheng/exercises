package exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LambdaList {

	public static void main(String[] args) {
		List<Integer> items = new ArrayList<>();
		items.add(3);
		items.add(-1);
		items.add(1);
		items.add(2);
		items.add(-2);
		
		for (int i = 0; i < items.size(); i++){
			items.set(i, Math.abs(items.get(i)));
		}
		//将list转换为set去除重复
		System.out.println(items.size()+"qddddd");
		Set<Integer> result = new HashSet<Integer>(items);
		System.out.println(result.size()+"qeqeqwe");
		
	}

}
