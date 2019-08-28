package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_4153 {
	
	public static String isRightTriangle(String[] input) {
		//��Ÿ��� ����
		// a^2 + b^2 = c^ �̿�
		String answer;
		int nums[] = new int[input.length];
		 
		int max = -1; //���� ū ���� ���� ����
		int sum=0; // �迭 �� �� ����
		
		for(int i=0; i<input.length; i++) {
			
			// ���� �迭�� ���� �� ���� ����
			nums[i] = (int)Math.pow(Double.parseDouble(input[i]), 2);
			
			sum +=nums[i]; //�迭 �������� �� ����
			
			if(nums[i]>max) {
				max = nums[i]; //�ִ� ���� ���� ����
			}
		}
		
		if(sum/2==max) { // �ִ밪 ������ ������ 1/2�̸� �����ﰢ��
			answer = "right";
		}else {
			answer = "wrong";
		}
		
		return answer;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String str="";
		
		BJ_1085 obj = new BJ_1085();
		
		//while(!str.equals("0 0 0")) {
			
			try {
				str = in.readLine();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String input [] = str.split(" ");
			//System.out.println(isRightTriangle(input));
			System.out.println(obj.getMinDistance(input));
			
		//}
		
	}

}
