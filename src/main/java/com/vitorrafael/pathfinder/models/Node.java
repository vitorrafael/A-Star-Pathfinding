package com.vitorrafael.pathfinder.models;

public class Node {
	
	private Node parent;
	
	private int x;
	private int y;
	
	private int totalCost;
	private int currentDistanceFromStart;
	private int estimatedDistanceToEnd;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		
		this.parent = null;
	}
	
	public Node(int x, int y, int totalCost, int currentDistanceFromStart, int estimatedDistanceToEnd) {
		this(x, y);
		
		this.totalCost = totalCost;
		this.currentDistanceFromStart = currentDistanceFromStart;
		this.estimatedDistanceToEnd = estimatedDistanceToEnd;
	}
		
	public boolean equals(Node otherNode) {
		if(this.x == otherNode.x && this.y == otherNode.y)
			return true;
		return false;
	}
	
	public int getCurrentDistanceFromStart() {
		return currentDistanceFromStart;
	}
	
	public int getEstimatedDistanceToEnd() {
		return estimatedDistanceToEnd;
	}
	
	public int getTotalCost() {
		return totalCost;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public void setCurrentDistanceFromStart(int currentDistanceFromStart) {
		this.currentDistanceFromStart = currentDistanceFromStart;
	}
	
	public void setEstimatedDistanceToEnd(int estimatedDistanceToEnd) {
		this.estimatedDistanceToEnd = estimatedDistanceToEnd;
	}
	
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}	
}
