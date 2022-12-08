package system;

import java.util.ArrayList;

import scanning.Cast;
import scanning.Grossing;
import scanning.Rating;

public class AllDirectors implements Query{

	
	//array before goal to check
	ArrayList<String> directors=new ArrayList<String>();
	ArrayList<String> directorsWithNoRepeats=new ArrayList<String>();
	
	
	
	public String getAnswer(String neededInformation, Rating ratingList, Grossing grossingList, Cast castList) {
		
		for (ArrayList<String> singularMovieInformation : castList.getInformation()) {
			directors.add(singularMovieInformation.get(3));
		}

		
		//no repeats
		for (String name : directors) {
			if (!directorsWithNoRepeats.contains(name)) {
				directorsWithNoRepeats.add(name);
			}
			
		}
		
		directorsWithNoRepeats.sort(null);

		return directorsWithNoRepeats.toString();
	}
	

}
