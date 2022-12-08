package userConnection;

import java.util.HashMap;
import java.util.Scanner;

import scanning.Cast;
import scanning.Grossing;
import scanning.Rating;
import system.AllDirectors;
import system.FrequentCastMembers;
import system.FrequentDirectors;
import system.Query;
import system.SpecificDirectorOrCast;
import system.TotalBoxOfficeEarnings;

//class for talking to user 
//the controller
public class TalkToUser {
	//hashmap for choices
	HashMap<String,String> choiceSelection;
	
	//hashmap for talking to user
	HashMap<String,String> userSelection;
	
	//hashmap for figuring out method
	HashMap<String,Query> methodSelection;
	
	//user
	Scanner option=new Scanner(System.in);
	String input;
	
	//initalize
	Grossing grossing=new Grossing();
	Rating rating=new Rating();
	Cast cast=new Cast();
	
	
	public TalkToUser() {
		rating.realData();
		grossing.realData();
		cast.realData();
		rating.scanInInfo();
		grossing.scanInInfo();
		cast.scanInInfo();
	}
	
	public void askQuestion() {
		
		//setting my hashmaps
		choiceSelection=new HashMap<String,String>()
		{{
			put("1", "Total box office earnings of a year");
			put("2", "All the directors in database");
			put("3", "Frequent directors");
			put("4", "Specific directors/cast members of a movie");
			put("5", "Frequent cast members");
			put("6","Quit");
		}};
		
		userSelection=new HashMap<String,String>()
				{{
					put("1","What year?");
					put("2","Press any key and hit enter");
					put("3","How many directors do you want to see?");
					put("4", "Rating or Grossing? Director or Cast? What number? (enter the two with a comma inbetween)");
					put("5","How many cast members do you want to see?");
				}};
		
		methodSelection=new HashMap<String,Query>()
				{{
					put("1",new TotalBoxOfficeEarnings());
					put("2",new AllDirectors());
					put("3",new FrequentDirectors());
					put("4",new SpecificDirectorOrCast());
					put("5",new FrequentCastMembers());
				}};
		
		//talking to the user
	
		twoLines();
		while (!input.equals("6")) {
			conversation();
		}
	
	}
	
	public void conversation() {
		System.out.print(userSelection.get(input));
		String informationNeeded=option.next();
		System.out.println(methodSelection.get(input).getAnswer(informationNeeded,rating,grossing,cast));
		twoLines();
	}
	
	public void twoLines() {
		System.out.println(choiceSelection);
		input=option.next();
	}
	
	

}
