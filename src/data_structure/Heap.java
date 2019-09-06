package data_structure;

public class Heap {
	// �迭�� �̿��� heap ����
	// �迭, �ڷ� ���� size, maxSize ����
	int [] data;
	int size;
	int maxSize;
	
	// ������: ���� 100¥�� �迭 ����
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
		return size == 0; // boolean�� ����� �ٷ� ����
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
	
	// �ִ��� ���ο� ������ ����
	// �ڽ� �ε���/2 = �θ��ε���
	// �θ��ε���*2 = �����ڽ� �ε���
	// �θ��ε���*2+1 = �������ڽ� �ε���
	public void insert(int value) {
		int idx; //�迭�� �ε��� ����Ű�� ����
		if(!isFull()) { // full �ƴҶ��� ��������
			//�迭 ���� ���ο� ������ ����
			data[size] = value;
			idx = size;
			size++;
			//System.out.println(value);
			//�θ�� ���ؼ� ��ü
			// �ڽ� �ε���/2 = �θ��ε���
			while(idx>0 && data[idx]>data[(idx-1)/2]) { // �ڽ��� �θ𺸴� ũ�� �ٲٱ�
				int temp = data[idx];
				data[idx] = data[(idx-1)/2];
				data[(idx-1)/2] = temp;
				idx = (idx-1)/2;
			}
		}
	} //insert()�Ϸ�
	
	// �ִ� ������ ��� ����
	// ������ ���� �޼ҵ�� ���� ū ��� 1��, �� ��Ʈ ��带 �����ϰ� ��ȯ�Ѵ�.
	public int remove() {
		int toReturn=0; //������ ��尪
		if(!isEmpty()) { //������� ���� ���� ����
			toReturn = data[0]; //���� ū �� ����
			// size ���̰� �迭 ���� ��带 ��Ʈ�� �ְ� 
			data[0] = data[--size];
			data[size] = 0;
		}
		// �迭 ������ �� ��Ʈ�� �־����� ������ �ʿ�
		// �� ������ �޼ҵ� ����
		fixRoot();
		return toReturn;
	}
	// swap �Լ�
	public void swap(int a, int b) {
		int temp = data[a];
		data[a] = data[b];
		data[b]= temp;
	}
	
	public void fixRoot() {
		// remove �޼ҵ忡�� ���� ū ���,�� ��Ʈ ��带 �����ϰ� �� �ڸ��� ���� ���� �ִ� ��带 �����ߴ�.
		// �ٽ� ���� ������ �����ν� ��Ʈ ��尡 �������� �������� �ؾ��Ѵ�.
		int idx = 0 ; // ��Ʈ������ ����
		while(idx*2+1<size) {
			//�ڽ� ��� �� �� ū ���� �ڸ� ��ü
			if(data[idx*2+1]>data[idx*2+2]) {
				swap(idx*2+1,idx);
				idx = idx*2+1;
			}else {
				swap(idx,idx*2+2);
				idx = idx*2+2;
				
			}
		}
	} //fixRoot() �Լ� ����

}
