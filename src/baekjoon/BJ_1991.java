package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. ��� Ŭ���� �ۼ�
 * 2. Ʈ�� Ŭ����? Ȥ�� �������̽� �ۼ�(�޼ҵ�)
 * 3. �� �� ��ȸ 3�� �޼ҵ� ����
 */

class Node{
	private char data; // ��忡 �� ������
	private Node leftChild; // ���� ���� ���
	private Node rightChild; // ������ ���� ���
	
	//������: ��� ���� �� ������ �־��ֱ�
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

// ����Ʈ�� Ŭ����: �޼ҵ�
class Tree{
	//��Ʈ ���
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
	
	//���� �޼ҵ�: 
	public void add(Node node, char [] data) {
		
		if(node==null) { //������ ����
			return;
		}else if(node.getData()==data[0]) { //���� ������ ã��->����, ������ ��� �ֱ�
				if(data[1]!='.') node.setLeftChild(new Node(data[1]));
				if(data[2]!='.') node.setRightChild(new Node(data[2]));
			
		}else { //���� ���� ������ ��ã��-> ����, ������ ��� ���� Ž��
			add(node.getLeftChild(),data);
			add(node.getRightChild(),data);
		}
		
	} // add()�޼ҵ� �Ϸ�
	
	// ��ȸ �޼ҵ� ����
	public void traversal() {
		if(root!=null) {
			preOrder(root);
			System.out.println();
			inOrder(root);
			System.out.println();
			postOrder(root);
		}
	
	}// traversal() �Ϸ�
	
	//������ȸ: ���� ����-> ��Ʈ-> ������ ����
	public void inOrder(Node node) {
		// ���� ���� Ž��
		if(node.getLeftChild()!=null) {
			inOrder(node.getLeftChild());
		}
		// ���� ���� ��� ��� -> ��Ʈ ��� -> ������ ���� Ž��
		System.out.print(node.getData());
		if(node.getRightChild()!=null) {
			inOrder(node.getRightChild());
		}
		
	}
	//������ȸ: ��Ʈ->���� ����->������ ����
	public void preOrder(Node node) {
		System.out.print(node.getData());
		// ���� ���� Ž��
		if(node.getLeftChild()!=null) {
			preOrder(node.getLeftChild());
		}
		// ������ ���� Ž��
		if(node.getRightChild()!=null) {
			preOrder(node.getRightChild());
		}
		
	}
	//������ȸ: ���� ����->������ ����->��Ʈ
	public void postOrder(Node node) {
		// ���� ���� Ž��
		if(node.getLeftChild()!=null) {
			postOrder(node.getLeftChild());
		}
		// ������ ���� Ž��
		if(node.getRightChild()!=null) {
			postOrder(node.getRightChild());
		}
		System.out.print(node.getData());
	}	
} //tree Ŭ���� �Ϸ�

public class BJ_1991 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n=0;
		
		try {
			//�� ������ �˾ƿ���
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
		
		// 0��° ���� ��� ����
		// Ʈ���� �� �ֱ�
		for(int i=0;i<n;i++) {
			data = in.readLine().replaceAll(" ", "").toCharArray();
			tree.addRoot(data);
		}
		
		tree.traversal();
		in.close();

	}

}
