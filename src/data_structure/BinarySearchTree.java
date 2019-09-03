package data_structure;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T>{
	
	private Node<T> root; //��Ʈ ���
	
	@Override
	public void insert(T data) { //����
		// TODO Auto-generated method stub
		// ��Ʈ ��尡 null�̸� ��Ʈ��� ���� , �ƴϸ� ���� ��忡 ����
		if(root==null) {
			root = new Node<>(data);
		}else {
			insertNode(data, root);
		}
		
	} //insert()�Ϸ�
	
	// ���� ������, ��Ʈ��� �޾Ƽ� �� �ֱ�
	private void insertNode(T newData, Node<T> node) {
		//���ο� �����Ͱ� ���� �����ͺ��� ������ ���� �������
		if(newData.compareTo(node.getData())<0) {
			//���� ������� ���� ��
			if(node.getLeftChild()!=null) {
				insertNode(newData, node.getLeftChild());
			}else { //���� ������� ���� ��: ���� ���� �־���
				Node<T> newNode = new Node(newData);
				node.setLeftChild(newNode);				
			}
			//���ο� �����Ͱ� ���� �����ͺ��� ũ�� ������ �������
		}else { 
			//������ ������� ���� ��->�ش� ������带 �ٽ� ��Ʈ�� �ִ� ����Լ�(���� ���������� �ݺ�)
			if(node.getRightChild()!=null) {
				insertNode(newData, node.getRightChild());
				
			}else { //������ ������� ���� ��
				Node<T> newNode = new Node(newData);
				node.setRightChild(newNode);	
			}
		}
	} //insertNode() �Ϸ�


	@Override
	public T getMinValue() { //�ּҰ� ��ȯ
		// TODO Auto-generated method stub
		if(root==null) {
			return null;
		}else {
			return getMin(root);
		}
	}
	
	//�ּҰ� ���ϱ�: ���� ���ʿ� ��ġ�� ��� ã��
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
	
	// ���� ū ��: ���� ������ ��� ��ȯ
	private T getMax(Node<T> node) {
		if(node.getRightChild()!=null) {
			return getMax(node.getRightChild());
		}else {
			return node.getData();
		}
	}

	//��ȸ: ����, ����, ����
	@Override
	public void traversal() {
		// TODO Auto-generated method stub
		if(root!=null) { //��Ʈ ������ ����, ����, ���� ��ȸ ���� ����
			inOrderTraversal(root);
			System.out.println();
			preOrderTraversal(root);
			System.out.println();
			postOrderTraversal(root);
			System.out.println();
		}
	}
	
	// ���� ��ȸ: ���� ���-��Ʈ���-������ ��� ��
	private void inOrderTraversal(Node<T>node) {
		if(node.getLeftChild()!=null) { //���ʳ�� ���������� ��������
			inOrderTraversal(node.getLeftChild());
		}
		System.out.print(node + " --> "); //��Ʈ ��� ���
		if(node.getRightChild()!=null) {
			inOrderTraversal(node.getRightChild());
		}
	} // inOrderTraversal() �Ϸ�
	
	// ���� ��ȸ: ��Ʈ - ���� ���� - ������ ����
	private void preOrderTraversal(Node<T>node) {
		System.out.print(node + " --> "); //��Ʈ ��� ���
		if(node.getLeftChild()!=null) { //���ʳ�� ���������� ��������
			preOrderTraversal(node.getLeftChild());
		}
		if(node.getRightChild()!=null) {
			preOrderTraversal(node.getRightChild());
		}
		
	}
	
	// ���� ��ȸ : ���� ���� - ������ ���� - ��Ʈ
	private void postOrderTraversal(Node<T>node) {
		if(node.getLeftChild()!=null) { //���ʳ�� ���������� ��������
			postOrderTraversal(node.getLeftChild());
		}
		if(node.getRightChild()!=null) {
			postOrderTraversal(node.getRightChild());
		}
		System.out.print(node + " --> "); //��Ʈ ��� ���
	}
	
	
	@Override
	public void delete(T data) {
		// TODO Auto-generated method stub
		if(root!=null) {
			root = deleteNode(root, data);
		}		
	}
	
	// ����: ���� ã�Ƽ� �����
	// ���1: ������ ��尡 leaf, ���2: ������ ����� �ڽĳ�尡 1��, ���3: ������ ����� �ڽĳ�尡 2��
	private Node<T> deleteNode(Node<T> node, T data){
		if(node==null) {
			return node;
		}
		
		//������ �����Ϳ� ���� ��� ������ ���ؼ� ����, ������ Ž�� ����
		// 1. ������ �����Ͱ� ���� �����ͺ��� ����->�������� ����
		if(data.compareTo(node.getData())<0) { // compareTo�ؼ� 0���� ������ ��ȣ �� ���� ���� ��
			//���� ��� ȣ��: setLeftChild()�κ��� �� ���� �ȵ�
			// set�ϴ� ������ leaf���� �� null �־��ְ� ���� ��� ������ �� �� ��������
			node.setLeftChild(deleteNode(node.getLeftChild(), data));
		}else if(data.compareTo(node.getData())>0) {
			//���� ��� ȣ��: setLeftChild()�κ��� �� ���� �ȵ�
			node.setRightChild(deleteNode(node.getRightChild(), data));
		}else { // ������ �� ã�� ���
			// 1. �ش� ��尡 leaf�� �׳� ����
			if(node.getLeftChild()==null && node.getRightChild()==null) {
				System.out.println("remove "+ node);
				return null;
			}
			//2.���� ��� ���� ������ ��常 ����
			if(node.getLeftChild()==null) { 
				Node<T> tempNode = node.getRightChild();
				node = null; // ���� ��� ����
				return tempNode; //�� �ڸ��� ������ ������� �ֱ�
			//3. ������ ��� ���� ���� ��常 ����
			} else if (node.getRightChild()==null) {
				Node<T>tempNode = node.getLeftChild();
				node=null;
				return tempNode;
			}
			
			// ������� 2��: ���� ���� ��� �� ���� ū �� or ������ ���� ��� �� ���� ���� �� ã�Ƽ� �ٲٱ�
			System.out.println("�ڽ� 2�� �ִ� ��� ����" + node);
			// getPredecessor(): ���� ���� ��� �� ���� ū ��� ã��
			Node<T> tempNode = getPredecessor(node.getLeftChild());
			node.setData(tempNode.getData());
			node.setLeftChild(deleteNode(node.getLeftChild(), tempNode.getData()));
		}
		return node;
	}
	
	// ����� ���� ���� ��� �� ���� ū �� ã��
	// getMax() �Լ��� ���� ���� �ٸ�
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
		
		System.out.println("�ּڰ�= "+ bst.getMinValue());
		System.out.println("�ִ밪= "+ bst.getMaxValue());

	}


	

}
