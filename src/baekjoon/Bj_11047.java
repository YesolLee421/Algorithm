package baekjoon;

import java.util.Scanner;

public class Bj_11047 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // ���� ����
		int k = sc.nextInt(); // ��ǥ��
		
		int [] value = new int[n];
		
		for(int i=0; i<value.length;i++) {
			value[i] = sc.nextInt();
		}
		int count = 0;
		for(int j = n-1;j>=0;j--) {
			if(value[j]<=k) {
				count+=k/value[j];
				k = k%value[j]; //������ ����
				//System.out.println("k="+k+"count="+count);
			}
			if(k<=0) break; //k�� ���� ���������� ���߱�
		}
		System.out.println(count);
		//sc.close();

	}

}
