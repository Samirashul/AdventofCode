package advent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day_5 {

	public static void main(String[] args) throws IOException {
		System.out.println("Part 2 answer: " + work("C:\\Users\\Valkyrie\\eclipse-workspace\\Advent_Of_Code_2023\\src\\advent\\day5input.txt"));

	}
	
	public static int work(String filename) throws IOException
	{
		List<Seed> seeds = new ArrayList<Seed>();
		
		BufferedReader reader = 
				  new BufferedReader(new FileReader(filename));

		String line = reader.readLine();
		List<Integer> copies = new ArrayList<Integer>();
		Pattern pattern = Pattern.compile("\\d+");
		Matcher m = pattern.matcher(line);
		HashMap<Integer, Integer> seedMap = new HashMap<Integer, Integer>();
		while(m.find())
		{
			seedMap.put(Integer.valueOf(m.group(0)), Integer.valueOf(m.group(0)));
		}

		line = reader.readLine();
		line = reader.readLine();

		
		HashMap<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
		while (line!= null)
		{
			while (line != "") 
			{
				if(!line.contains("map"))
				{
					m = pattern.matcher(line);
					m.find();
					for(int i = 0; i<Integer.valueOf(m.group(2)); i++)
					{
						tempMap.put(Integer.valueOf(m.group(1)), Integer.valueOf(m.group(0)));
					}
				}
				line = reader.readLine();
			}
			for(int i : seedMap.keySet())
			{
				if(tempMap.get(i) != null)
					seedMap.replace(seedMap.get(i), tempMap.get(seedMap.get(i)));
			}
			line=reader.readLine();
		}
		int location = Integer.MAX_VALUE;
		int seed = 0;
		for(int i : seedMap.keySet())
		{
			if(seedMap.get(i)<location)
			{
				location = seedMap.get(i);
				seed = i;
			}
		}
		
		
		return seed;
	}
	
	

}

 class Seed {
	int seed;
	int soil;
	int fertiliser;
	int water;
	int light;
	int temperature;
	int location;
	
	public Seed(int seed)
	{
		this.seed = seed;
	}
}
