package baekjoon;

public class BJ_1085 {
	
	public int getMinDistance(String[] input) {
		
		//x, y, w, h ������ �Է�
		// ���� w, ���� h�� ���簢�� �ȿ� �ִ� �� (x,y)���� ���簢�� �׵θ����� �Ÿ� �ּڰ�
		// x, w-x, y, h-y �� �ּڰ� ��ȯ
		
		int nums[] = new int[4];
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<4; i++) {
			nums[i]=Integer.parseInt(input[i]);
			
			if(i<2) { //x, y��
				if(nums[i]<min) { //�ϴ� x, y �� ���� ���� �� ����
					min = nums[i];
				}
			}else {// w, h
				if(nums[i]-nums[i-2]<min) {
					min = nums[i]-nums[i-2]; //w-x, h-y �� ���� �� ����
				}
			}
		}
		return min;
	}
}
