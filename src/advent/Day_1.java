package advent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("Part 1 answer: " + turnInputToTotals("C:\\Users\\Valkyrie\\eclipse-workspace\\Advent_Of_Code_2023\\src\\advent\\day1input.txt"));
		
		
	}
	
	public static int getCoordinates (String s)
	{
		s = s.replaceAll("[a-z]", "");
		s = s.length() == 2 ? s : weirdCoordinate(s);
		return Integer.valueOf(s);
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
