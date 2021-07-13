package com.lru;


public class LRUCacheTest {
	public static void main(String[] args) {
		LRUCache lru = new LRUCache(5);
		System.out.println("set(1, 2)");
		lru.set(1, 2);
		lru.printList();
		System.out.println("set(2, 3)");
		lru.set(2, 3);
		lru.printList();
		System.out.println("set(1, 3)");
		lru.set(1, 3);
		lru.printList();
		System.out.println("set(3, 5)");
		lru.set(3, 5);
		lru.printList();
		System.out.println("set(4, 5)");
		lru.set(4, 5);
		lru.printList();
		System.out.println("set(5, 5)");
		lru.set(5, 5);
		lru.printList();
		System.out.println(lru.get(2));
		lru.printList();
		System.out.println(lru.get(3));
		lru.printList();
		System.out.println(lru.get(1));
		lru.printList();
		//SET 1 2 GET 1
		lru.set(10, 2);
		lru.printList();
		System.out.println(lru.get(1));
		lru.printList();
	
	}
}
