package advent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day_6 {

	public static void main(String[] args) throws IOException {
		System.out.println("Part 1 answer: " + work("C:\\Users\\Valkyrie\\eclipse-workspace\\Advent_Of_Code_2023\\src\\advent\\day6input.txt"));

	}
	
	public static int work(String filename) throws IOException
	{
		BufferedReader reader = 
				  new BufferedReader(new FileReader(filename));

		int product = 1;
		
		String line = reader.readLine();
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(line);
		List<Integer> times = new ArrayList<Integer>();
		List<Integer> distances = new ArrayList<Integer>();
		while(matcher.find())
		{
			times.add(Integer.valueOf(matcher.group(0)));
		}
		line = reader.readLine();
		matcher = pattern.matcher(line);
		while(matcher.find())
		{
			distances.add(Integer.valueOf(matcher.group(0)));
		}
		while(times.size()>0)
		{
			int waysToWin = 0;
			for(int i = 0; i < times.getFirst(); i++)
			{
				if(i*(times.getFirst()-i)>distances.getFirst())
					waysToWin++;
			}
			product=product*waysToWin;
			times.remove(0);
			distances.remove(0);
		}
		
		return product;
	}

}
