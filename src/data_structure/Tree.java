package data_structure;

public interface Tree<T> {
	
	public void insert(T data); //Ʈ���� �� ����
	public T getMinValue(); //Ʈ�� �ּڰ� ��ȯ
	public T getMaxValue(); //Ʈ�� �ִ밪 ��ȯ
	public void traversal(); //��ȸ
	public void delete(T data); //����

}
