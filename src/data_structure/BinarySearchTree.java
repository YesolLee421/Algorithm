package data_structure;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T>{
	
	private Node<T> root; //루트 노드
	
	@Override
	public void insert(T data) { //삽입
		// TODO Auto-generated method stub
		// 루트 노드가 null이면 루트노드 삽입 , 아니면 하위 노드에 삽입
		if(root==null) {
			root = new Node<>(data);
		}else {
			insertNode(data, root);
		}
		
	} //insert()완료
	
	// 넣을 데이터, 루트노드 받아서 값 넣기
	private void insertNode(T newData, Node<T> node) {
		//새로운 데이터가 기존 데이터보다 작으면 왼쪽 하위노드
		if(newData.compareTo(node.getData())<0) {
			//왼쪽 하위노드 있을 때
			if(node.getLeftChild()!=null) {
				insertNode(newData, node.getLeftChild());
			}else { //왼쪽 하위노드 없을 때: 새로 만들어서 넣어줌
				Node<T> newNode = new Node(newData);
				node.setLeftChild(newNode);				
			}
			//새로운 데이터가 기존 데이터보다 크면 오른쪽 하위노드
		}else { 
			//오른쪽 하위노드 있을 때->해당 하위노드를 다시 루트로 주는 재귀함수(하위 없을때까지 반복)
			if(node.getRightChild()!=null) {
				insertNode(newData, node.getRightChild());
				
			}else { //오른쪽 하위노드 없을 때
				Node<T> newNode = new Node(newData);
				node.setRightChild(newNode);	
			}
		}
	} //insertNode() 완료


	@Override
	public T getMinValue() { //최소값 반환
		// TODO Auto-generated method stub
		if(root==null) {
			return null;
		}else {
			return getMin(root);
		}
	}
	
	//최소값 구하기: 가장 왼쪽에 위치한 노드 찾기
	private T getMin(Node<T> node) {
		if(node.getLeftChild()!=null) {
			return getMin(node.getLeftChild());
		}else {
			return node.getData();
		}
	}


	@Override
	public T getMaxValue() {
		// TODO Auto-generated method stub
		if(root==null) {
			return null;
		}else {
			return getMax(root);
		}
	}
	
	// 가장 큰 값: 가장 오른쪽 노드 반환
	private T getMax(Node<T> node) {
		if(node.getRightChild()!=null) {
			return getMax(node.getRightChild());
		}else {
			return node.getData();
		}
	}

	//순회: 중위, 전위, 후위
	@Override
	public void traversal() {
		// TODO Auto-generated method stub
		if(root!=null) { //루트 있으면 중위, 전위, 후위 순회 각각 구현
			inOrderTraversal(root);
			System.out.println();
			preOrderTraversal(root);
			System.out.println();
			postOrderTraversal(root);
			System.out.println();
		}
	}
	
	// 중위 순회: 왼쪽 노드-루트노드-오른쪽 노드 순
	private void inOrderTraversal(Node<T>node) {
		if(node.getLeftChild()!=null) { //왼쪽노드 없을때까지 내려가기
			inOrderTraversal(node.getLeftChild());
		}
		System.out.print(node + " --> "); //루트 노드 출력
		if(node.getRightChild()!=null) {
			inOrderTraversal(node.getRightChild());
		}
	} // inOrderTraversal() 완료
	
	// 전위 순회: 루트 - 왼쪽 하위 - 오른쪽 하위
	private void preOrderTraversal(Node<T>node) {
		System.out.print(node + " --> "); //루트 노드 출력
		if(node.getLeftChild()!=null) { //왼쪽노드 없을때까지 내려가기
			preOrderTraversal(node.getLeftChild());
		}
		if(node.getRightChild()!=null) {
			preOrderTraversal(node.getRightChild());
		}
		
	}
	
	// 후위 순회 : 왼쪽 하위 - 오른쪽 하위 - 루트
	private void postOrderTraversal(Node<T>node) {
		if(node.getLeftChild()!=null) { //왼쪽노드 없을때까지 내려가기
			postOrderTraversal(node.getLeftChild());
		}
		if(node.getRightChild()!=null) {
			postOrderTraversal(node.getRightChild());
		}
		System.out.print(node + " --> "); //루트 노드 출력
	}
	
	
	@Override
	public void delete(T data) {
		// TODO Auto-generated method stub
		if(root!=null) {
			root = deleteNode(root, data);
		}		
	}
	
	// 삭제: 값을 찾아서 지우기
	// 경우1: 삭제할 노드가 leaf, 경우2: 삭제할 노드의 자식노드가 1개, 경우3: 삭제할 노드의 자식노드가 2개
	private Node<T> deleteNode(Node<T> node, T data){
		if(node==null) {
			return node;
		}
		
		//삭제할 데이터와 현제 노드 데이터 비교해서 왼쪽, 오른쪽 탐색 시작
		// 1. 삭제할 데이터가 현재 데이터보다 작음->왼쪽으로 가기
		if(data.compareTo(node.getData())<0) { // compareTo해서 0보다 작으면 괄호 안 값이 작은 것
			//삭제 재귀 호출: setLeftChild()부분이 잘 이해 안됨
			// set하는 이유는 leaf삭제 시 null 넣어주고 하위 노드 있으면 그 값 저장해줌
			node.setLeftChild(deleteNode(node.getLeftChild(), data));
		}else if(data.compareTo(node.getData())>0) {
			//삭제 재귀 호출: setLeftChild()부분이 잘 이해 안됨
			node.setRightChild(deleteNode(node.getRightChild(), data));
		}else { // 삭제할 값 찾은 경우
			// 1. 해당 노드가 leaf면 그냥 삭제
			if(node.getLeftChild()==null && node.getRightChild()==null) {
				System.out.println("remove "+ node);
				return null;
			}
			//2.왼쪽 노드 없고 오른쪽 노드만 있음
			if(node.getLeftChild()==null) { 
				Node<T> tempNode = node.getRightChild();
				node = null; // 기존 노드 삭제
				return tempNode; //그 자리에 오른쪽 하위노드 넣기
			//3. 오른쪽 노드 없고 왼쪽 노드만 있음
			} else if (node.getRightChild()==null) {
				Node<T>tempNode = node.getLeftChild();
				node=null;
				return tempNode;
			}
			
			// 하위노드 2개: 왼쪽 하위 노드 중 가장 큰 것 or 오른쪽 하위 노드 중 가장 작은 것 찾아서 바꾸기
			System.out.println("자식 2개 있는 노드 삭제" + node);
			// getPredecessor(): 왼쪽 하위 노드 중 가장 큰 노드 찾기
			Node<T> tempNode = getPredecessor(node.getLeftChild());
			node.setData(tempNode.getData());
			node.setLeftChild(deleteNode(node.getLeftChild(), tempNode.getData()));
		}
		return node;
	}
	
	// 노드의 왼쪽 하위 노드 중 가장 큰 것 찾기
	// getMax() 함수와 리턴 값만 다름
	private Node<T> getPredecessor(Node<T> node){
		if(node.getRightChild()!=null) {
			return getPredecessor(node.getRightChild());
		}else {
			return node;
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tree<Integer> bst = new BinarySearchTree<Integer>();
		int arr [] = {41, 20, 11, 29, 32, 65, 50, 91, 72, 99};
		
		for(int i=0;i<arr.length; i++) {
			bst.insert(arr[i]);
		}
		
		bst.traversal();
		
		bst.delete(41);
		bst.traversal();
		
		System.out.println("========================================");
		
		System.out.println("최솟값= "+ bst.getMinValue());
		System.out.println("최대값= "+ bst.getMaxValue());

	}


	

}
