package testSuite;

import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Test.*;

import scanning.Cast;
import scanning.Grossing;
import scanning.Rating;
import scanning.ScanInfo;
import system.AllDirectors;
import system.FrequentCastMembers;
import system.FrequentDirectors;
import system.SpecificDirectorOrCast;
import system.TotalBoxOfficeEarnings;
import userConnection.TalkToUser;

public class JUnit {
	//initialize
	TalkToUser talkToUser=new TalkToUser();
	AllDirectors allDirectors=new AllDirectors();
	FrequentCastMembers frequentCastMembers=new FrequentCastMembers();
	SpecificDirectorOrCast specificDirectorOrCast=new SpecificDirectorOrCast();
	TotalBoxOfficeEarnings totalBoxOfficeEarnings=new TotalBoxOfficeEarnings();
	FrequentDirectors frequentDirectors=new FrequentDirectors();
	Rating rating=new Rating();
	Grossing grossing=new Grossing();
	Cast cast=new Cast();

	
	@Before
	public void init() {
		rating.testData();
		grossing.testData();
		cast.testData();
		rating.scanInInfo();
		grossing.scanInInfo();
		cast.scanInInfo();
	}
	
	// All Directors
	@Test
	public void allDirectorsWorks() {
		String anyKey="f";
		String answer="[Clyde Geronimi, Leonard Nimoy, Rajkumar Hirani, Roland Emmerich, Sidney Lumet, Stanley Kubrick, Zack Snyder]";
		assertTrue(answer.equals(allDirectors.getAnswer(anyKey, rating, grossing, cast)));
	}

	
	// Frequent Cast Members
	@Test
	public void frequentCastMembersWorks() {
		String amount="3";
		String answer= "[Martin Balsam, Dominic West, David Wenham]";
		assertTrue(answer.equals(frequentCastMembers.getAnswer(amount, rating, grossing, cast)));
	}
	
	@Test 
	public void frequentCastMembersInvalidInput() {
		String badInput= "bad info";
		assertTrue("[]".equals(frequentCastMembers.getAnswer(badInput, rating, grossing, cast)));
	}
	
	// Frequent Director
	@Test
	public void frequentDirectorsWorks() {
		String amount="3";
		String answer="[Zack Snyder, Clyde Geronimi, Sidney Lumet]";
		assertTrue(answer.equals(frequentDirectors.getAnswer(amount, rating, grossing, cast)));
	}
	
	@Test 
	public void frequentDirectorsInvalidInput() {
		String badInput= "bad info";
		assertTrue("[]".equals(frequentDirectors.getAnswer(badInput, rating, grossing, cast)));
	}
	
	// Specific Director or Cast
	@Test
	public void SpecificDirectorOrCastWorks() {
		String input="Rating,Cast,6";
		String answer="[John Cusack, Amanda Peet, Chiwetel Ejiofor, Thandie Newton, Oliver Platt]";
		assertTrue(answer.equals(specificDirectorOrCast.getAnswer(input, rating, grossing, cast)));
	}
	
	@Test 
	public void specificDirectorOrCastInvalidInput() {
		String badInput= "bad info";
		assertTrue("".equals(specificDirectorOrCast.getAnswer(badInput, rating, grossing, cast)));
	}
	
	// Total Box Office Earnings
	@Test
	public void TotalBoxOfficeEarnings() {
		String input="1997";
		String answer="658672303";
		assertTrue(answer.equals(totalBoxOfficeEarnings.getAnswer(input, rating, grossing, cast)));
	}
	
	@Test 
	public void totalBoxOfficeEarningsInvalidInput() {
		String badInput= "bad info";
		assertTrue("0".equals(totalBoxOfficeEarnings.getAnswer(badInput, rating, grossing, cast)));
	}
	
	
	
	
	
}


