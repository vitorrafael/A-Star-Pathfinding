package com.vitorrafael.pathfinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vitorrafael.pathfinder.models.Maze;
import com.vitorrafael.pathfinder.models.Node;

public class App 
{
    public static void main( String[] args )
    {
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
    	
    	Maze maze = new Maze(mazeStructure);
    	
    	List<Node> pathToEnd = maze.findPath(0,  0, 7, 6);
    	
    	maze.printPath(pathToEnd);
    }
}
