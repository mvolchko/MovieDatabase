package system;

import java.util.ArrayList;

import scanning.Cast;
import scanning.Grossing;
import scanning.Rating;

public class SpecificDirectorOrCast implements Query{
	//needed
	String type;
	String choice;
	protected String rankValue;
	String movieName="";
	
	//lists
	ArrayList<String> castPeople=new ArrayList<String>();
	
	//goal
	String answer="";
	
	


	public String getAnswer(String neededInformation, Rating ratingList, Grossing grossingList, Cast castList) {
		
		try {
			String[] splitInfo=neededInformation.split(",");
			type=splitInfo[0];
			choice=splitInfo[1];
			rankValue=splitInfo[2];
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Not a valid input for the question");
			e.printStackTrace();
		}
		
		if (type.equalsIgnoreCase("Rating")) {
			for (ArrayList<String> singularMovie : ratingList.getInformation()) {
				singularMovie(singularMovie,rankValue);
			}
		}
		
		if (type.equalsIgnoreCase("Grossing")) {
			for (ArrayList<String> singularMovie : grossingList.getInformation()) {
				singularMovie(singularMovie,rankValue);
			}
		}
		
		for (ArrayList<String> singularMovie : castList.getInformation()) {
			if (movieName.equalsIgnoreCase(singularMovie.get(1))) {
				if (choice.equalsIgnoreCase("Director")) {
					answer=singularMovie.get(3);
				}
				if (choice.equalsIgnoreCase("Cast")) {
					for (int i=4; i<=8;i++) {
						castPeople.add(singularMovie.get(i));
					}
					answer=castPeople.toString();
				}
			}
		}
			
		
		return answer;
		
	}
	
	private void singularMovie(ArrayList<String> singularMovie, String rankValue) {
		if (singularMovie.get(0).equals(rankValue)) {
			movieName=singularMovie.get(1);
		}
		
	}
	
	
}
