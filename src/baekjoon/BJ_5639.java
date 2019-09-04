package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


class Node2{
	int data;
	Node2 leftChild;
	Node2 rightChild;
	
	//셍성자
	public Node2(int data) { 
		this.data=data;
	}
	//getter, setter
	
	public int getData() {
		return data;
	}
	public Node2 getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node2 leftChild) {
		this.leftChild = leftChild;
	}

	public Node2 getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node2 rightChild) {
		this.rightChild = rightChild;
	}
	
}

class Tree2{
	//루트노드
	Node2 root;
	
	public void insert(int data) {
		//System.out.println("insert 실행");
		if(root==null) {
			root = new Node2(data);
		}else {
			insertNode(root, data);
		}
	} //insert() 완료
	
	public void insertNode(Node2 node, int data) {
		//System.out.println("insertNode실행");
		if(data<node.getData()) { //현재 노드보다 작은 값->왼쪽 하위
			if(node.getLeftChild()!=null) { //왼쪽 노드 있음
				insertNode(node.getLeftChild(), data);
			}else {
				node.setLeftChild(new Node2(data));
			}
			
		}else { // 현재 노드보다 큰 값->오른쪽 하위
			if(node.getRightChild()!=null) {
				insertNode(node.getRightChild(), data);
			}else {
				node.setRightChild(new Node2(data));
			}			
		}
	} //insertNode()완료
	
	// 트리의 루트노드 입력->후위순회: 왼쪽->오른쪽->루트
	public void postOrderTraversal(Node2 node) {
		//System.out.println("순회 실행");
		if(node.getLeftChild()!=null) {
			postOrderTraversal(node.getLeftChild());
		}
		if(node.getRightChild()!=null) {
			postOrderTraversal(node.getRightChild());
		}
		System.out.println(node.getData());	
	}
	
	
}

public class BJ_5639 {
	// 이진검색트리: 이진트리를 전위순회한 값 주어지면 후위순회한 값으로 바꿔서 출력
	// 전위순회 시 가장 먼저 루트값 나오니까 그거 기준으로 이진트리 만든 후 그냥 후위순회하면 될듯?
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		int input = scan.nextInt();
		Tree2 tree = new Tree2();
		tree.root=new Node2(input);
		
		while(scan.hasNext()) {
			try {
				input = scan.nextInt();
				tree.insert(input);	
			}catch(Exception e) {
				//System.out.println("예외");
				e.printStackTrace();
				break;
			}	
		}

		//System.out.println("while 끝");
		tree.postOrderTraversal(tree.root);
		
		

	}

}
