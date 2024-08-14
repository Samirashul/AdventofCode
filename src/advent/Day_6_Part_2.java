package advent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day_6_Part_2 {

	public static void main(String[] args) throws IOException {
		System.out.println("Part 2 answer: " + work("C:\\Users\\Valkyrie\\eclipse-workspace\\Advent_Of_Code_2023\\src\\advent\\day6input.txt"));

	}
	
	public static int work(String filename) throws IOException
	{
		BufferedReader reader = 
				  new BufferedReader(new FileReader(filename));

		int product = 0;
		
		String line = reader.readLine();
		line=line.replaceAll("\\s+", "");
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(line);
		List<Double> times = new ArrayList<Double>();
		List<Double> distances = new ArrayList<Double>();
		while(matcher.find())
		{
			times.add(Double.valueOf(matcher.group(0)));
		}
		line = reader.readLine();
		line=line.replaceAll("\\s+", "");
		matcher = pattern.matcher(line);
		while(matcher.find())
		{
			distances.add(Double.valueOf(matcher.group(0)));
		}
		while(times.size()>0)
		{
			for(int i = 0; i < times.getFirst(); i++)
			{
				if(i*(times.getFirst()-i)>distances.getFirst())
					product++;
			}
			times.remove(0);
			distances.remove(0);
		}
		
		return product;
	}

}
