package data_structure;

public interface Tree<T> {
	
	public void insert(T data); //트리에 값 삽입
	public T getMinValue(); //트리 최솟값 반환
	public T getMaxValue(); //트리 최대값 반환
	public void traversal(); //순회
	public void delete(T data); //삭제

}
