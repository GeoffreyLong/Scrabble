package actualGame;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import scrabbleGUI.*;
public class PointCounter {

	
	PlayerPanel playerPanels = new PlayerPanel();
	
	
	public boolean checkValidity(String theString){
		boolean theBoolean = false;
		ArrayList<String> list = new ArrayList<String>();
		String fileName = System.getProperty("user.dir");
		fileName += "/src/ScrabbleWordsOne.txt";
		list = readWordsFromFile(fileName);
		if (list.contains(theString)){
			theBoolean=true;
		}
		return theBoolean;
	}
	
	public int thePoints (String theString, int player){
		int score = 0;
		String delims = "";
		String[] charArray = theString.split(delims);
		for (int i = 1; i<=theString.length(); i++){
			String thePointChar = charArray[i];
			score = score + valueOfCharacter(thePointChar);
		}
		return score;
	}
	
	public static ArrayList<String> readWordsFromFile(String filename)
	{
		ArrayList<String> words = new ArrayList<String>();
		try
		{
			File file = new File(filename);
			Scanner scanner = new Scanner(file);
			// Strip non-alphanumeric \\W
			scanner.useDelimiter("\\W+"); 
			while (scanner.hasNext())
			{
				words.add(scanner.next());
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
		return words;
	}
	
	public int valueOfCharacter (String thePointChar){
		int score=0;
		if (thePointChar.equals("A")){
			score = score+5;
		}
		if (thePointChar.equals("B")){
			score = score+13;
		}
		if (thePointChar.equals("C")){
			score = score+10;
		}
		if (thePointChar.equals("D")){
			score = score+9;
		}
		if (thePointChar.equals("E")){
			score = score+3;
		}
		if (thePointChar.equals("F")){
			score = score+16;
		}
		if (thePointChar.equals("G")){
			score = score+11;
		}
		if (thePointChar.equals("H")){
			score = score+13;
		}
		if (thePointChar.equals("I")){
			score = score+4;
		}
		if (thePointChar.equals("J")){
			score = score+29;
		}
		if (thePointChar.equals("K")){
			score = score+19;
		}
		if (thePointChar.equals("L")){
			score = score+7;
		}
		if (thePointChar.equals("M")){
			score = score+11;
		}
		if (thePointChar.equals("N")){
			score = score+6;
		}
		if (thePointChar.equals("O")){
			score = score+6;
		}
		if (thePointChar.equals("P")){
			score = score+10;
		}
		if (thePointChar.equals("Q")){
			score = score+30;
		}
		if (thePointChar.equals("R")){
			score = score+6;
		}
		if (thePointChar.equals("S")){
			score = score+4;
		}
		if (thePointChar.equals("T")){
			score = score+6;
		}
		if (thePointChar.equals("U")){
			score = score+9;
		}
		if (thePointChar.equals("V")){
			score = score+18;
		}
		if (thePointChar.equals("W")){
			score = score+18;
		}
		if (thePointChar.equals("X")){
			score = score+27;
		}
		if (thePointChar.equals("Y")){
			score = score+16;
		}
		if (thePointChar.equals("Z")){
			score = score+25;
		}
		return score;
	}
	
}
