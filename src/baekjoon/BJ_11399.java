package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_11399 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //사람 수
		int people[] = new int[n];
		int i=0, minSum=0;
		for(i=0;i<n;i++) {
			people[i] = sc.nextInt();
		}
		Arrays.sort(people); // 가장 시간 짧게 걸리는 사람 순으로 정렬
		for(i=0;i<n;i++) {
			minSum+=people[i]*(n-i);
		}
		System.out.println(minSum);
		//sc.close();

	}

}
