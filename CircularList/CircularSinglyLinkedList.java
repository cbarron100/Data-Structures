package CircularList;

import java.util.Iterator;

public class CircularSinglyLinkedList<E> implements Iterable<E>{


	private Node<E> head;
	private int size;

	private static class Node<E>{
		E data;
		Node<E> next;
		public Node(E data){
			this.data = data;
			this.next = null;
		}
	}

	public CircularSinglyLinkedList(){
		this.head = null;
		this.head.next = head;
		size = 0;
	}


	public void addFirst(E element){
		Node<E> newNode = new Node<>(element);
		if(this.size == 0){
			head = newNode;
			head.next = head;
		}else{
			newNode.next = head;
			newNode = head;
		}
		size++;
	}

	public void addLast(E element){
		if(this.size == 0){
			this.addFirst(element);
		}else{
			Node<E> newNode = new Node<>(element);
			Node<E> curNode = head;
			while(!curNode.next.equals(head)){
				curNode = curNode.next;
			}
			curNode.next = newNode;
			newNode.next = head;
			size++;
		}
	}

	public int size(){
		return this.size;
	}

	public boolean isEmpty(){
		return this.size == 0;
	}

	public boolean contains(E element){
		if(isEmpty()){
			return false;
		}else{
			Node<E> curNode = head;
			while(curNode.next.equals(head)){
				if(curNode.data.equals(element)){
					return true;
				}
				curNode = curNode.next;
			}
			return false;
		}
	}

	public E getFirst() throws RuntimeException{
		if(isEmpty()){
			throw new RuntimeException("List is empty");
		}else{
			return head.data;
		}
	}

	public E getLast() throws RuntimeException{
		if(isEmpty()){
			throw new RuntimeException("List is empty");
		}else{
			Node<E> curNode = head;
			while(!curNode.next.equals(head)){
				curNode = curNode.next;
			}
			return curNode.data;
		}
	}

	public void clear() throws RuntimeException{
		if(isEmpty()){
			throw new RuntimeException("List is empty");
		}else{
			Node<E> curNode = head;
			while(!curNode.next.equals(null)){
				curNode = null;
				curNode = curNode.next;
			}
			curNode = null;
		}
	}

	public CircularSinglyLinkedList<E> rotate() throws RuntimeException{
		if(isEmpty()){
			throw new RuntimeException("List is empty");
		}else{
			return null;
		}
	}
}
