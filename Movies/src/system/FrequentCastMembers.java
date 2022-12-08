package system;

import java.util.ArrayList;

import scanning.Cast;
import scanning.Grossing;
import scanning.Rating;

public class FrequentCastMembers extends FrequentPeople{
	
	
	protected void getPeople(ArrayList<String> singularMovieInformation) {
		for (int i=4;i<=8;i++) {
			people.add(singularMovieInformation.get(i));
		}
	}

}
