package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. 노드 클래스 작성
 * 2. 트리 클래스? 혹은 인터페이스 작성(메소드)
 * 3. 그 후 순회 3종 메소드 구현
 */

class Node{
	private char data; // 노드에 들어갈 데이터
	private Node leftChild; // 왼쪽 하위 노드
	private Node rightChild; // 오른쪽 하위 노드
	
	//생성자: 노드 만들 때 데이터 넣어주기
	public Node(char data){
		this.data = data;
	}
	
	//getter, setter
	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

}

// 이진트리 클래스: 메소드
class Tree{
	//루트 노드
	Node root;
	public void addRoot(char [] data) {
		if(root==null) {
			root = new Node(data[0]);
			if(data[1]!='.') root.setLeftChild(new Node(data[1]));
			if(data[2]!='.') root.setRightChild(new Node(data[2]));
		}else {
			add(root, data);
		}
	}
	
	//삽입 메소드: 
	public void add(Node node, char [] data) {
		
		if(node==null) { //데이터 없음
			return;
		}else if(node.getData()==data[0]) { //같은 데이터 찾음->왼쪽, 오른쪽 노드 넣기
				if(data[1]!='.') node.setLeftChild(new Node(data[1]));
				if(data[2]!='.') node.setRightChild(new Node(data[2]));
			
		}else { //아직 같은 데이터 못찾음-> 왼쪽, 오른쪽 노드 각각 탐색
			add(node.getLeftChild(),data);
			add(node.getRightChild(),data);
		}
		
	} // add()메소드 완료
	
	// 순회 메소드 시작
	public void traversal() {
		if(root!=null) {
			preOrder(root);
			System.out.println();
			inOrder(root);
			System.out.println();
			postOrder(root);
		}
	
	}// traversal() 완료
	
	//중위순회: 왼쪽 하위-> 루트-> 오른쪽 하위
	public void inOrder(Node node) {
		// 왼쪽 하위 탐색
		if(node.getLeftChild()!=null) {
			inOrder(node.getLeftChild());
		}
		// 왼쪽 하위 노드 출력 -> 루트 출력 -> 오른쪽 하위 탐색
		System.out.print(node.getData());
		if(node.getRightChild()!=null) {
			inOrder(node.getRightChild());
		}
		
	}
	//전위순회: 루트->왼쪽 하위->오른쪽 하위
	public void preOrder(Node node) {
		System.out.print(node.getData());
		// 왼쪽 하위 탐색
		if(node.getLeftChild()!=null) {
			preOrder(node.getLeftChild());
		}
		// 오른쪽 하위 탐색
		if(node.getRightChild()!=null) {
			preOrder(node.getRightChild());
		}
		
	}
	//후위순회: 왼쪽 하위->오른쪽 하위->루트
	public void postOrder(Node node) {
		// 왼쪽 하위 탐색
		if(node.getLeftChild()!=null) {
			postOrder(node.getLeftChild());
		}
		// 오른쪽 하위 탐색
		if(node.getRightChild()!=null) {
			postOrder(node.getRightChild());
		}
		System.out.print(node.getData());
	}	
} //tree 클래스 완료

public class BJ_1991 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n=0;
		
		try {
			//몇 줄인지 알아오기
			n = Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		char [] data;
		
		Tree tree = new Tree();
		
		// 0번째 줄은 노드 개수
		// 트리에 값 넣기
		for(int i=0;i<n;i++) {
			data = in.readLine().replaceAll(" ", "").toCharArray();
			tree.addRoot(data);
		}
		
		tree.traversal();
		in.close();

	}

}
