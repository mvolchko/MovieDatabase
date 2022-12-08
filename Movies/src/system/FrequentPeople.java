package system;

import java.util.ArrayList;

import scanning.Cast;
import scanning.Grossing;
import scanning.Rating;

public abstract class FrequentPeople implements Query{
	//needed
	String amountOfPeopleWanted;
	ArrayList<String> people=new ArrayList<String>();
	ArrayList<String> frequentPeople=new ArrayList<String>();
	String personWithCurrentHighest;

	//numbers
	int highestFrequency=0;
	int currentCount=0;
	ArrayList<Integer> placesOfName=new ArrayList<Integer>();

	public String getAnswer(String neededInformation, Rating ratingList, Grossing grossingList, Cast castList) {

		for (ArrayList<String> singularMovieInformation : castList.getInformation()) {
			getPeople(singularMovieInformation);
		}
		
		try {
			int amountWanted=Integer.parseInt(neededInformation);
			
			//go through the year names, check for biggest frequency
			for (int i=0; i<amountWanted; i++) {
				for (String name : people) {
					for (String name2 : people) {
						if (name.equals(name2)) {
							currentCount=currentCount+1;
						}
					}
					if (currentCount>highestFrequency) {
						highestFrequency=currentCount;
						personWithCurrentHighest=name;

					}
					currentCount=0;
				}
				frequentPeople.add(personWithCurrentHighest);
				//go through the amount of times the name is listed and delete it since remove does first occurrence
				for (int m=0; m<highestFrequency;m++) {
					people.remove(personWithCurrentHighest);
				}

				highestFrequency=0;
			}

			return frequentPeople.toString();
		}
		catch (NumberFormatException e){
			System.err.println("Not a valid input for the question");
			e.printStackTrace();
		}
		
		return frequentPeople.toString();
		
		
	}

	protected abstract void getPeople(ArrayList<String> singularMovieInformation);

}
