package data_structure;

public class Heap {
	// 배열을 이용한 heap 구현
	// 배열, 자료 개수 size, maxSize 변수
	int [] data;
	int size;
	int maxSize;
	
	// 생성자: 길이 100짜리 배열 생성
	public Heap() {
		data = new int[100];
	}
	public Heap(int maxSize) {
		if(maxSize < 1) {
			this.maxSize = 100;
		}else {
			this.maxSize = maxSize;
		}
		this.maxSize = maxSize;
	}
	// isEmpty()
	public boolean isEmpty() {
		return size == 0; // boolean식 결과를 바로 리턴
	}
	// isFull()
	public boolean isFull() {
		return size == 100;
	}
	// clear()
	public void clean() {
		data = null;
	}
	
	// main()
	public static void main(String[] args) {
		Heap heap = new Heap();
		heap.insert(3);
		heap.insert(9);
		heap.insert(4);
		heap.insert(19);
		heap.insert(13);
		heap.insert(2);
		//System.out.println("dd");
		
		for(int i=0;i<heap.size;i++) {
			System.out.println(heap.data[i]+" ");
		}
		heap.remove();
		System.out.println();
		for(int i=0;i<heap.size;i++) {
			System.out.println(heap.data[i]+" ");
		}
		
	}
	
	// 최대힙 새로운 데이터 삽입
	// 자식 인덱스/2 = 부모인덱스
	// 부모인덱스*2 = 왼쪽자식 인덱스
	// 부모인덱스*2+1 = 오른쪽자식 인덱스
	public void insert(int value) {
		int idx; //배열의 인덱스 가리키는 변수
		if(!isFull()) { // full 아닐때만 실행하자
			//배열 끝에 새로운 데이터 삽입
			data[size] = value;
			idx = size;
			size++;
			//System.out.println(value);
			//부모와 비교해서 교체
			// 자식 인덱스/2 = 부모인덱스
			while(idx>0 && data[idx]>data[(idx-1)/2]) { // 자식이 부모보다 크면 바꾸기
				int temp = data[idx];
				data[idx] = data[(idx-1)/2];
				data[(idx-1)/2] = temp;
				idx = (idx-1)/2;
			}
		}
	} //insert()완료
	
	// 최대 힙에서 노드 제거
	// 힙에서 제거 메소드는 가장 큰 노드 1개, 즉 루트 노드를 제거하고 반환한다.
	public int remove() {
		int toReturn=0; //리턴할 노드값
		if(!isEmpty()) { //비어있지 않을 때만 실행
			toReturn = data[0]; //가장 큰 수 저장
			// size 줄이고 배열 끝의 노드를 루트에 넣고 
			data[0] = data[--size];
			data[size] = 0;
		}
		// 배열 마지막 수 루트에 넣었으니 재정렬 필요
		// 힙 재정렬 메소드 실행
		fixRoot();
		return toReturn;
	}
	// swap 함수
	public void swap(int a, int b) {
		int temp = data[a];
		data[a] = data[b];
		data[b]= temp;
	}
	
	public void fixRoot() {
		// remove 메소드에서 가장 큰 노드,즉 루트 노드를 제거하고 그 자리에 가장 끝에 있는 노드를 삽입했다.
		// 다시 힙을 재정렬 함으로써 루트 노드가 적절값을 가지도록 해야한다.
		int idx = 0 ; // 루트노드부터 시작
		while(idx*2+1<size) {
			//자식 노드 중 더 큰 노드와 자리 교체
			if(data[idx*2+1]>data[idx*2+2]) {
				swap(idx*2+1,idx);
				idx = idx*2+1;
			}else {
				swap(idx,idx*2+2);
				idx = idx*2+2;
				
			}
		}
	} //fixRoot() 함수 종료

}
