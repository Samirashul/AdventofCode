package advent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day_1_Part_2 {
	
	static Map<String, String> numbers = new HashMap<String, String>();

	public static void main(String[] args) throws IOException {
		
		numbers.put("^one", "1");
		numbers.put("^two", "2");
		numbers.put("^three", "3");
		numbers.put("^four", "4");
		numbers.put("^five", "5");
		numbers.put("^six", "6");
		numbers.put("^seven", "7");
		numbers.put("^eight", "8");
		numbers.put("^nine", "9");
		numbers.put("^1", "1");
		numbers.put("^2", "2");
		numbers.put("^3", "3");
		numbers.put("^4", "4");
		numbers.put("^5", "5");
		numbers.put("^6", "6");
		numbers.put("^7", "7");
		numbers.put("^8", "8");
		numbers.put("^9", "9");
		
		System.out.println("Part 2 answer: " + turnInputToTotals("C:\\Users\\Valkyrie\\eclipse-workspace\\Advent_Of_Code_2023\\src\\advent\\day1input.txt"));
		
	}
	
	public static int getCoordinates (String s)
	{
		String result = "";
		while(s.length()>0)
		{
			
			for(String i : numbers.keySet())
			{
				Pattern pattern = Pattern.compile(i);
				Matcher m = pattern.matcher(s);
				if(m.find())
					result+=numbers.get(i);
			}
			s=s.substring(1);
		}
		result = result.length() == 2 ? result : weirdCoordinate(result);
		System.out.println(Integer.valueOf(result));
		return Integer.valueOf(result);
	}
	
	public static String weirdCoordinate (String s)
	{
		return s.length()==1 ? s.concat(s) : (Character.toString(s.charAt(0))+Character.toString(s.charAt(s.length()-1)));
	}
	
	public static int turnInputToTotals (String input) throws IOException
	{
		BufferedReader reader = 
				  new BufferedReader(new FileReader(input));

		String line = reader.readLine();
		int total = 0;
			while (line != null) 
			{
			    total+=getCoordinates(line);
			    line = reader.readLine();
			}
		
		return total;
	}

}
