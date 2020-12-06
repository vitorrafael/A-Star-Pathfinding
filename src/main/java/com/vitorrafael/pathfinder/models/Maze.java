package com.vitorrafael.pathfinder.models;

import java.util.ArrayList;
import java.util.List;

public class Maze {
	
	private List<List<Integer>> maze;
		
	public Maze() {
		this.maze = new ArrayList<List<Integer>>();
	}
	
	public Maze(List<List<Integer>> maze) {
		this.maze = maze;
	}
	
	public List<List<Integer>> getMaze() {
		return maze;
	}
	
	public void setMaze(List<List<Integer>> maze) {
		this.maze = maze;
	}
	
	public List<Node> findPath(int startX, int startY, int endX, int endY) {
		
		Node startNode = new Node(startX, startY, 0, 0, 0);
		Node endNode = new Node(endX, endY, 0, 0, 0);
		
		List<Node> openedList = new ArrayList<Node>();
		List<Node> closedList = new ArrayList<Node>();
		
		openedList.add(startNode);
		
		while(!openedList.isEmpty()) {
			Node currentNode = openedList.get(0);
			int currentIndex = 0;
			
			for(int i = 0; i < openedList.size(); i++) {
				if(openedList.get(i).getTotalCost() < currentNode.getTotalCost()) {
					currentNode = openedList.get(i);
					currentIndex = i;
				}
			}
			
			openedList.remove(currentIndex);
			closedList.add(currentNode);
			
			if(currentNode.equals(endNode)) {
				
				List<Node> path = new ArrayList<Node>();
				
				while(currentNode != null) {
					path.add(0, currentNode);
					
					currentNode = currentNode.getParent();
				}
				
				return path;
				
			}
			
			int[] xCoordinates = new int[] {0, 0, -1, 1, -1, -1, 1, 1};
			int[] yCoordinates = new int[] {-1, 1, 0, 0, -1, 1, -1, 1};
			
			List<Node> childrenNodes = new ArrayList<Node>();
			
			for(int i = 0; i < 8; i++) {
				int nodeXPosition = currentNode.getX() + xCoordinates[i];
				int nodeYPosition = currentNode.getY() + yCoordinates[i];
				
				if(nodeXPosition > maze.size() || nodeXPosition < 0 || nodeYPosition > maze.get(0).size() || nodeYPosition < 0)
					continue;
				
				if(maze.get(nodeXPosition).get(nodeYPosition) == 1)
					continue;
				
				Node newNode = new Node(nodeXPosition, nodeYPosition);
				newNode.setParent(currentNode);
				
				childrenNodes.add(newNode);
			}
			
			for(Node childNode : childrenNodes) {
				
				for(Node closedChildNode : closedList) {
					if(closedChildNode.equals(childNode))
						continue;
				}
				
				int currentDistanceFromStart = currentNode.getTotalCost() + 1;
				childNode.setCurrentDistanceFromStart(currentDistanceFromStart);

				int estimatedDistanceToEnd = (int)(Math.pow(childNode.getX() - endNode.getX(), 2) + Math.pow(childNode.getY() - endNode.getY(), 2));
				childNode.setEstimatedDistanceToEnd(estimatedDistanceToEnd);
				
				childNode.setTotalCost(currentDistanceFromStart+ estimatedDistanceToEnd);
			
				for(Node openNode : openedList) {
					if(childNode.equals(openNode) && currentDistanceFromStart > openNode.getCurrentDistanceFromStart())
						continue;
				}
				
				openedList.add(childNode);
			}
		}
		
		return null;				
	}
	
	public void printPath(List<Node> path) {
		if(path == null) {
			System.out.println("No paths could be found!");
			return;
		}
		
		for(int i = 0; i < path.size() - 1; i++) {
			
			Node currentNode = path.get(i);
			int currentNodeX = currentNode.getX();
			int currentNodeY = currentNode.getY();
			System.out.printf("X: %d, Y: %d -> ", currentNodeX, currentNodeY);
		}
		
		Node lastNode = path.get(path.size() - 1);
		System.out.printf("X: %d, Y: %d\n", lastNode.getX(), lastNode.getY());
	}
}
