package leetCode_Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sort_1122 {
	
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		
		if(arr1.length==1) {
			return arr1; //�־��� �迭 ���� 1�̸� �ٷ� ��ȯ
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list_non = new ArrayList<Integer>();
		int answer [] = new int [arr1.length]; // �迭 1 ���̿� ���� �亯 �迭 ����
		// �迭 2�� ���Ե� ���� �ƴ� ���� �����ؼ� ���� �����ؾ� ��
		// �ٵ� �迭 2�� ���Ե� ���� �迭 2 ������� �����ϰ� �ƴ� ������ �������� ����
		
		//�迭 2�� ���� �ε���(����) ¦ �̷��
		Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		
		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		
		for(int i=0; i<arr2.length; i++) {
			map2.put(i, arr2[i]); //key = �ε���, value = �� ����
		}
		
		for(int i=0; i<arr1.length; i++) { //�迭 1 �� ���� �� ���� ����ִ��� �� �� ����
			
			if(map1.containsKey(arr1[i])) {
				map1.put(arr1[i], map1.get(arr1[i])+1);
			}else {
				map1.put(arr1[i],1); //
			}
			
		}
		
		int notDup = 0; // �ߺ����� ���� ���� ����
		
		//�ڿ������� Ű ���� ��� �ع���
		
		for(Map.Entry<Integer, Integer> set1 : map2.entrySet()) {
			
			int key1 = set1.getKey();
			int value1 = set1.getValue();
			
			System.out.println("key="+key1+" / value="+value1);
			
			for(int a=0; a<map1.get(value1); a++) {
        		list.add(value1);
        	}
			
//            if(map2.containsValue(key1)) { //�迭 2�� �ִ� ��
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
//            if(map2.containsValue(key)) { //�迭 2�� �ִ� ��
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
