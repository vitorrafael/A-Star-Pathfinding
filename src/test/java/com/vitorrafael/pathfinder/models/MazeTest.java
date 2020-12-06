package com.vitorrafael.pathfinder.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

public class MazeTest extends TestCase {
	
	private Maze testMaze;
	
	@Override
	protected void setUp() {
		this.testMaze = new Maze();
	}
	
	public void testValidStructureShouldReturnShortestPath() {
    	
		List<List<Integer>> mazeStructure = new ArrayList<List<Integer>>() {
    		{ add(Arrays.asList(0, 0, 0, 0, 1, 0, 0, 0, 0)); }
    		{ add(Arrays.asList(0, 0, 0, 0, 1, 0, 0, 0, 0)); }
    		{ add(Arrays.asList(0, 0, 0, 0, 1, 0, 0, 0, 0)); }
    		{ add(Arrays.asList(0, 0, 0, 0, 1, 0, 0, 0, 0)); }
    		{ add(Arrays.asList(0, 0, 0, 0, 1, 0, 0, 0, 0)); }
    		{ add(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0)); }
    		{ add(Arrays.asList(0, 0, 0, 0, 1, 0, 0, 0, 0)); }
    		{ add(Arrays.asList(0, 0, 0, 0, 1, 0, 0, 0, 0)); }
    		{ add(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0)); }
    	};
    	
    	testMaze.setMaze(mazeStructure);
    	
    	List<Node> validPathList = new ArrayList() {
    		{ add(new Node(0, 0)); }
    		{ add(new Node(1, 1)); }
    		{ add(new Node(2, 2)); }
    		{ add(new Node(3, 3)); }
    		{ add(new Node(4, 3)); }
    		{ add(new Node(5, 4)); }
    		{ add(new Node(6, 5)); }
    		{ add(new Node(7, 6)); }
    	};
    	
    	List<Node> finalPath = testMaze.findPath(0, 0, 7, 6);

    	assertNotNull(finalPath);
    	assertEquals(validPathList.size(), finalPath.size());
    	
    	for(int i = 0; i < finalPath.size(); i++) {
    		Node currentNode = finalPath.get(i);
    		Node expectedNode = validPathList.get(i);
    		
    		assert currentNode.equals(expectedNode);
    	}
    	
	}
	
	public void testInalidStructureShouldReturnShortestPath() {
	    	
			List<List<Integer>> mazeStructure = new ArrayList<List<Integer>>() {
	    		{ add(Arrays.asList(0, 1, 0, 0, 1, 0, 0, 0, 0)); }
	    		{ add(Arrays.asList(1, 1, 0, 0, 1, 0, 0, 0, 0)); }
	    		{ add(Arrays.asList(0, 0, 0, 0, 1, 0, 0, 0, 0)); }
	    		{ add(Arrays.asList(0, 0, 0, 0, 1, 0, 0, 0, 0)); }
	    		{ add(Arrays.asList(0, 0, 0, 0, 1, 0, 0, 0, 0)); }
	    		{ add(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0)); }
	    		{ add(Arrays.asList(0, 0, 0, 0, 1, 0, 0, 0, 0)); }
	    		{ add(Arrays.asList(0, 0, 0, 0, 1, 0, 0, 0, 0)); }
	    		{ add(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0)); }
	    	};
	    	
	    	testMaze.setMaze(mazeStructure);
	    	
	    	List<Node> finalPath = testMaze.findPath(0, 0, 7, 6);
	
	    	assertNull(finalPath);
	    	
		}
}
