package scanning;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


//Super class for information being scanned in
//the view
public abstract class ScanInfo {
	private ArrayList<ArrayList<String>> information;
	protected String DATASET_NAME;
	private String testOrReal;
	
	public ArrayList<ArrayList<String>> getInformation() {
		return information;
	}
	
	//for switching between test and real
	public void testData() {
		testOrReal="test_data/";
	}
	
	public void realData() {
		testOrReal="real_data/";
	}
	
	public void scanInInfo() {
		Scanner movie=null;
		String dataset;
		information=new ArrayList<ArrayList<String>>();
		
		try {
				dataset= testOrReal+DATASET_NAME+".txt";
				movie= new Scanner(new File(dataset));
				while (movie.hasNextLine()) {
					String str= movie.nextLine();
					ArrayList<String> info= new ArrayList<String>(Arrays.asList(str.split("	")));
					information.add(info);
					str=null;
				}
				//get rid of titles
				information.remove(0);
	
		}
		catch (IOException  exp) {
			      exp.printStackTrace();
		}
		finally{
			      if(movie != null)
			        movie.close();
		}

	}
	


}

