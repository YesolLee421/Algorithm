package leetCode_Sort;

import java.util.Arrays;
import java.util.Stack;

public class Sort_922 {
	
public int[] sortArrayByParityII(int[] A) {
	
	int answer [] = new int[A.length];
	Stack<Integer> odd = new Stack();
	Stack<Integer> even = new Stack();
	
	
	for(int i=0; i<A.length; i++) { //�迭 ó������ ���鼭 ���� ���� ¦��/Ȧ�� ������ �ٸ� stack�� ����
		
		if(A[i]%2==0) {
			even.add(A[i]); // ������=0 -> ¦�� ����
		}else {
			odd.add(A[i]); // ������!=0 -> Ȧ�� ����
		}
	}
	
	for(int j=0; j<A.length; j++) { //�ٽ� �迭���̸�ŭ ���鼭 �ε��� ���� ���� ¦��/Ȧ�� ���ÿ��� �� �����ͼ� ����
		if(j%2==0) {
			answer[j]=even.pop();
		}else {
			answer[j]=odd.pop();
		}
	}
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr2 [] = {2,3,5,6};
		int arr1 [] = {3,2,2,2,2,3,6,4,5};
		
		Sort_1122 obj1 = new Sort_1122();
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(obj1.relativeSortArray(arr1, arr2)));
		
		
		
		

	}

}
