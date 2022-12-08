package system;


import java.math.BigInteger;
import java.util.ArrayList;

import scanning.Cast;
import scanning.Grossing;
import scanning.Rating;

public class TotalBoxOfficeEarnings implements Query{
	//needed information
	int year;
	
	//goal information
	BigInteger totalEarnings=new BigInteger("0");
	
	public String getAnswer(String neededInformation, Rating ratingList, Grossing grossingList, Cast castList) {
		year=Integer.parseInt(neededInformation);
		
		
		for (ArrayList<String> singularMovieData : grossingList.getInformation()) {
			if (year==Integer.parseInt(singularMovieData.get(2))) {			
				BigInteger added= new BigInteger(singularMovieData.get(3));
				totalEarnings = totalEarnings.add(added);			
			}
		}
		
		
		return totalEarnings.toString();
	}

}
