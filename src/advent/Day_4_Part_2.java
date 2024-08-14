package advent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day_4_Part_2 {
	
	

	public static void main(String[] args) throws IOException {
		
		System.out.println("Part 2 answer: " + getTotals("C:\\Users\\Valkyrie\\eclipse-workspace\\Advent_Of_Code_2023\\src\\advent\\day4input.txt"));
		
	}
	
	public static int getTotals (String input) throws IOException
	{
		BufferedReader reader = 
				  new BufferedReader(new FileReader(input));

		String line = reader.readLine();
		int total = 0;
		List<Integer> copies = new ArrayList<Integer>();
		copies.add(0);		
		
			while (line != null) 
			{
				if(copies.size()==0)
					copies.add(0);
				int copiesOfCurrent = copies.getFirst()+1;
			    total+=copiesOfCurrent;
			    copies.remove(0);
			    int matches=getPoints(line);
			    for(int i = 0; i<matches; i++)
			    {
					if(i==copies.size())
			    	{
			    		copies.add(copiesOfCurrent);
			    	}
					else
					{
						copies.set(i, copies.get(i)+copiesOfCurrent);
					}
			    }
			    line = reader.readLine();
			}
		
		return total;
	}
	
	public static void loadCopies(int copies)
	{
		
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
					points++;
			}
		}
		System.out.println(points);
		return points;
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
