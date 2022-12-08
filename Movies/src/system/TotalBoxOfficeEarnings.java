package system;


import java.util.ArrayList;

import scanning.Cast;
import scanning.Grossing;
import scanning.Rating;

public class TotalBoxOfficeEarnings implements Query{
	//needed information
	int year;
	
	//goal information
	int totalEarnings=0;
	
	public String getAnswer(String neededInformation, Rating ratingList, Grossing grossingList, Cast castList) {
		year=Integer.parseInt(neededInformation);
		
		
		for (ArrayList<String> singularMovieData : grossingList.getInformation()) {
			if (year==Integer.parseInt(singularMovieData.get(2))) {			
				//this is maxing out with the real values because they are too big
				totalEarnings = totalEarnings + Integer.parseInt(singularMovieData.get(3));			
			}
		}
		
		
		return Integer.toString(totalEarnings);
	}

}
