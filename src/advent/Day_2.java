package advent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day_2 {
	
	static Map<String, Integer> limits = new HashMap<String, Integer>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = 
				  new BufferedReader(new FileReader("C:\\Users\\Valkyrie\\eclipse-workspace\\Advent_Of_Code_2023\\src\\advent\\day2input.txt"));

		limits.put("red", 12);
		limits.put("green", 13);
		limits.put("blue", 14);
		
		String line = reader.readLine();
		int total = 0;
		int currentGame = 0;
			while (line != null) 
			{
				currentGame++;
				if(isPossible(line))
					total+=currentGame;
			    line = reader.readLine();
			}
		System.out.println(total);
	}
	
	private static boolean isPossible (String s)
	{
		for(String p : limits.keySet())
		{
			if(getBiggest(s, p)>limits.get(p))
				return false;
		}
		return true;
	}
	
	private static int getBiggest(String s, String p)
	{
		int result = 0;
		Pattern pattern = Pattern.compile("[0-9]+ " + p);
		Matcher m = pattern.matcher(s);
		while(m.find())
		{
			int i = Integer.valueOf(m.group(0).replace(" " + p, ""));
			if (i > result)
				result = i;
		}
		
		return result;
	}
}
