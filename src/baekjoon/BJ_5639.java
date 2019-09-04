package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


class Node2{
	int data;
	Node2 leftChild;
	Node2 rightChild;
	
	//�ļ���
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
	//��Ʈ���
	Node2 root;
	
	public void insert(int data) {
		//System.out.println("insert ����");
		if(root==null) {
			root = new Node2(data);
		}else {
			insertNode(root, data);
		}
	} //insert() �Ϸ�
	
	public void insertNode(Node2 node, int data) {
		//System.out.println("insertNode����");
		if(data<node.getData()) { //���� ��庸�� ���� ��->���� ����
			if(node.getLeftChild()!=null) { //���� ��� ����
				insertNode(node.getLeftChild(), data);
			}else {
				node.setLeftChild(new Node2(data));
			}
			
		}else { // ���� ��庸�� ū ��->������ ����
			if(node.getRightChild()!=null) {
				insertNode(node.getRightChild(), data);
			}else {
				node.setRightChild(new Node2(data));
			}			
		}
	} //insertNode()�Ϸ�
	
	// Ʈ���� ��Ʈ��� �Է�->������ȸ: ����->������->��Ʈ
	public void postOrderTraversal(Node2 node) {
		//System.out.println("��ȸ ����");
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
	// �����˻�Ʈ��: ����Ʈ���� ������ȸ�� �� �־����� ������ȸ�� ������ �ٲ㼭 ���
	// ������ȸ �� ���� ���� ��Ʈ�� �����ϱ� �װ� �������� ����Ʈ�� ���� �� �׳� ������ȸ�ϸ� �ɵ�?
	
	
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
				//System.out.println("����");
				e.printStackTrace();
				break;
			}	
		}

		//System.out.println("while ��");
		tree.postOrderTraversal(tree.root);
		
		

	}

}
