package com.practice.coding.solutions.dataStructures;

public class Trie {

	class TrieNode {
		
		TrieNode[] arr;
		boolean isEnd;
		final char value;

		public TrieNode(char value) {
			this.value = value;
			this.arr = new TrieNode[26];
		}
	}

	private TrieNode root;

	public Trie() {
		root = new TrieNode(' ');
	}

	public void insert(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
//			Identify the index location for the character
			int index = c - 'a';
			if (p.arr[index] == null) {
//				Create a new node since there is none at the index location
				TrieNode temp = new TrieNode(c);
//				add the new node at the index location
				p.arr[index] = temp;
//				Make p the root node to add the next character in the word
				p = temp;
			} else {
//				If node / char already exists, make that node the root node to process next character
				p = p.arr[index];
			}
		}
		p.isEnd = true;
	}
	
	public boolean search(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = c - 'a';
			if (null != p.arr[index] && p.arr[index].value == c)
				p = p.arr[index];
			else 
				return Boolean.FALSE;
		}
		return p.isEnd;
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("test");
		trie.insert("temp");
		System.out.println(trie.search("test")); // true
		System.out.println(trie.search("tail")); // false
		System.out.println(trie.search("abs")); // false
	}
}
