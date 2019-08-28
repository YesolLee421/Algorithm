package leetCode_Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sort_1122 {
	
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		
		if(arr1.length==1) {
			return arr1; //주어진 배열 길이 1이면 바로 반환
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list_non = new ArrayList<Integer>();
		int answer [] = new int [arr1.length]; // 배열 1 길이와 같은 답변 배열 생성
		// 배열 2에 포함된 수와 아닌 수를 구별해서 각각 정렬해야 함
		// 근데 배열 2에 포함된 수는 배열 2 순서대로 정렬하고 아닌 수들은 오름차순 정렬
		
		//배열 2의 값과 인덱스(순서) 짝 이루기
		Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		
		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		
		for(int i=0; i<arr2.length; i++) {
			map2.put(i, arr2[i]); //key = 인덱스, value = 값 저장
		}
		
		for(int i=0; i<arr1.length; i++) { //배열 1 각 값이 몇 개씩 들어있는지 알 수 있음
			
			if(map1.containsKey(arr1[i])) {
				map1.put(arr1[i], map1.get(arr1[i])+1);
			}else {
				map1.put(arr1[i],1); //
			}
			
		}
		
		int notDup = 0; // 중복되지 않은 수의 개수
		
		//자연스럽게 키 정렬 대로 해버림
		
		for(Map.Entry<Integer, Integer> set1 : map2.entrySet()) {
			
			int key1 = set1.getKey();
			int value1 = set1.getValue();
			
			System.out.println("key="+key1+" / value="+value1);
			
			for(int a=0; a<map1.get(value1); a++) {
        		list.add(value1);
        	}
			
//            if(map2.containsValue(key1)) { //배열 2에 있는 값
//            	
//            	for(int a=0; a<map1.get(value1); a++) {
//            		list.add(value1);
//            	}
//            	
//            }else {
//            	list_non.add(key1);
//            	notDup++;
//            }
			
		}
		
		System.out.println("list=" +list.toString());
		
//		for(Map.Entry<Integer,Integer> set : map1.entrySet()){
//			
//			int key = set.getKey();
//			int value = set.getValue();
//			
//			System.out.println("key="+set.getKey()+" / value="+set.getValue());
//			
//            if(map2.containsValue(key)) { //배열 2에 있는 값
//            	
//            	for(int a=0; a<value; a++) {
//            		list.add(key);
//            	}
//            	
//            }else {
//            	list_non.add(key);
//            	notDup++;
//            }
//        }
		
		
		
//		for(int a=0; a<list.size();a++) {
//			answer[a] = list.get(a);
//		}
//		
//		for(int a=list.size(); a<answer.length;a++) {
//			answer[a]= list_non.get(a-list.size());
//		}
		
		
		return answer;
    }

}
