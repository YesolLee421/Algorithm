package baekjoon;

public class BJ_1085 {
	
	public int getMinDistance(String[] input) {
		
		//x, y, w, h 순으로 입력
		// 넓이 w, 높이 h인 직사각형 안에 있는 점 (x,y)에서 직사각형 테두리까지 거리 최솟값
		// x, w-x, y, h-y 중 최솟값 반환
		
		int nums[] = new int[4];
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<4; i++) {
			nums[i]=Integer.parseInt(input[i]);
			
			if(i<2) { //x, y중
				if(nums[i]<min) { //일단 x, y 중 가장 작은 값 저장
					min = nums[i];
				}
			}else {// w, h
				if(nums[i]-nums[i-2]<min) {
					min = nums[i]-nums[i-2]; //w-x, h-y 중 작은 값 저장
				}
			}
		}
		return min;
	}
}
