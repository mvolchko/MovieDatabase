package system;

import java.util.ArrayList;

import scanning.Cast;
import scanning.Grossing;
import scanning.Rating;

public class FrequentDirectors extends FrequentPeople{
	
	
	protected void getPeople(ArrayList<String> singularMovieInformation) {
		people.add(singularMovieInformation.get(3));
	}

}
