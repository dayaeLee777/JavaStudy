package com.ssafy.그래프.copy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS{
	static StringBuilder sb = new StringBuilder();
	static int N, M, V, start, end;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
		}


		br.close();
	}
}

class Node {
	String data;
	Node left;
	Node right;

	public Node() {
		super();
	}

	public Node(String data, Node left, Node right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public Node(String data) {
		super();
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}

class BinaryTree {
	LinkedList<Node> tree;
	int lastIndex;
	Node node = new Node();
	Node n;

	public BinaryTree(LinkedList<Node> tree, int lastIndex) {
		super();
		this.tree = tree;
		this.lastIndex = lastIndex;
	}

	public void add(Node node) {
		if (lastIndex == tree.size())
			return;
		tree.add(++lastIndex, node);
	}

	public Node searchNode(String data) {
		for (Node n : tree) {
			if (n.getData().equals(data))
				return n;
		}
		return null;
	}

	public void preOrder() {
		preOrder(tree.get(0));
	}

	public void preOrder(Node node) {
		// 자신
		if (node != null) {
			System.out.print(node.getData());
		}
		Node left = (node.left!=null ?searchNode(node.left.data):null) ;
		Node right = (node.right!=null ?searchNode(node.right.data):null);
		// 왼쪽 자식
		if (left != null) {
			preOrder(left);
		}
		// 오른쪽 자식
		if (right != null) {
			preOrder(right);
		}
	}
	
	public void InOrder() {
		InOrder(tree.get(0));
	}
	
	public void InOrder(Node node) {
		Node left = (node.left!=null ?searchNode(node.left.data):null) ;
		Node right = (node.right!=null ?searchNode(node.right.data):null);
		// 왼쪽 자식
		if (left != null) {
			InOrder(left);
		}
		// 자신
		if (node != null) {
			System.out.print(node.getData());
		}
		// 오른쪽 자식
		if (right != null) {
			InOrder(right);
		}
	}
	
	public void postOrder() {
		postOrder(tree.get(0));
	}
	
	public void postOrder(Node node) {
		Node left = (node.left!=null ?searchNode(node.left.data):null) ;
		Node right = (node.right!=null ?searchNode(node.right.data):null);
		// 왼쪽 자식
		if (left != null) {
			postOrder(left);
		}
		// 오른쪽 자식
		if (right != null) {
			postOrder(right);
		}
		// 자신
		if (node != null) {
			System.out.print(node.getData());
		}
	}

}
