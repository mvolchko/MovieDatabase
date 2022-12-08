package system;

import scanning.Cast;
import scanning.Grossing;
import scanning.Rating;
import scanning.ScanInfo;

public interface Query {
	public String getAnswer(String neededInformation, Rating ratingList, Grossing grossingList, Cast castList);

}
