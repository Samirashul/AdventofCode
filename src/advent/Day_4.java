package advent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day_4 {
	
	

	public static void main(String[] args) throws IOException {
		
		System.out.println("Part 1 answer: " + getTotals("C:\\Users\\Valkyrie\\eclipse-workspace\\Advent_Of_Code_2023\\src\\advent\\day4input.txt"));
		
	}
	
	public static int getTotals (String input) throws IOException
	{
		BufferedReader reader = 
				  new BufferedReader(new FileReader(input));

		String line = reader.readLine();
		int total = 0;
		
			while (line != null) 
			{
			    total+=getPoints(line);
			    line = reader.readLine();
			}
		
		return total;
	}
	
	public static int getPoints (String totalString)
	{
		int points = 0;
		
		totalString = totalString.split(":")[1];
		System.out.println(totalString);
		String[] split = totalString.split("\\|");
		String winnersString = totalString.split("\\|")[0];
		totalString = totalString.split("\\|")[1];
		System.out.println(winnersString);
		System.out.println(totalString);
		ArrayList<Integer> winners = getNumbers(winnersString);
		ArrayList<Integer> total = getNumbers(totalString);
		for(int i : winners)
		{
			for(int j : total)
			{
				if(i==j)
					points = addPoints(points);
			}
		}
		System.out.println(points);
		return points;
	}
	
	public static int addPoints(int points)
	{
		if(points==0)
			return 1;
		return points*2;
	}
	
	public static ArrayList<Integer> getNumbers(String s)
	{
		ArrayList<Integer> results = new ArrayList();
		Pattern pattern = Pattern.compile("\\d+");
		Matcher m = pattern.matcher(s);
		while(m.find())
			results.add(Integer.valueOf(m.group()));
		return results;
	}

}
