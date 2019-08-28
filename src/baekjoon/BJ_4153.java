package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_4153 {
	
	public static String isRightTriangle(String[] input) {
		//피타고라스 정리
		// a^2 + b^2 = c^ 이용
		String answer;
		int nums[] = new int[input.length];
		 
		int max = -1; //가장 큰 수의 제곱 저장
		int sum=0; // 배열 값 합 저장
		
		for(int i=0; i<input.length; i++) {
			
			// 정수 배열에 길이 값 제곱 저장
			nums[i] = (int)Math.pow(Double.parseDouble(input[i]), 2);
			
			sum +=nums[i]; //배열 값제곱의 합 저장
			
			if(nums[i]>max) {
				max = nums[i]; //최대 값의 제곱 저장
			}
		}
		
		if(sum/2==max) { // 최대값 제곱이 총합의 1/2이면 직각삼각형
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
