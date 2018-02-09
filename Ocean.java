package com.main;

import java.util.ArrayList;

public class Ocean {

// Fields
	private Fish[][] layout;
	private ArrayList<Fish> fishInside;
	
// Constructor
	public Ocean(int dimensions, ArrayList<Fish> fishToStart)
	{
		Utilities util = new Utilies();
		layout = new Fish[dimensions][dimensions];
		for(Fish fish : fishToStart) {
			boolean done = false;
			while(!done) {
				int randx = util.randInt();
				int randy = util.randInt();
				if(layout[randy][randx] == null) {
					layout[randy][randx] = fish;
					done = true;
				}
			}
		}
	}
	
	
// Methods
	public void paint()
	{
		for(int y = layout.length -1; y >= 0; y--) {
			for(int x = layout[y].length -1; x >= 0; x--) {
				Fish fish = layout[y][x];
				if(fish != null) {
					System.out.print(fish.getCode());
				}else {
					System.out.print("    ");
				}
				System.out.print("|");
			}
			System.out.println();
		}			
	}
	
	public void setCell(int x, int y, Fish fish)
	{
		layout[y][x] = fish;
	}
	
	public Fish getCell(int x, int y)
	{
		return layout[y][x];
	}
	
	public void nextTurn()
	{
		for(Fish fish : fishInside) {
			fish.turn();
		}
	}
	
	
}
