import java.util.ArrayList;
/**
* @author Alex Olteanu
*/

public class Ballot{
	ArrayList<Candidate> candList = new ArrayList<Candidate>();
	protected String officeName;

	/**
	* Class constructor used for generating Ballot object.
	* @Param Ballot object's office name
	*/
	public Ballot(String officeName){
		this.officeName = officeName;
		this.candList = candList;
	}

	/**
	* Method used for retrieving Ballot object's office name.
	* @Return Ballot object's office name
	*/
	public String getOfficeName(){
    return officeName;
	}

	/**
	* Method used for adding a Candidate object to the Ballot object's array of candidates.
	* @Param Candidate object being added
	* @Return void
	*/
	public void addCandidate(Candidate c){
		boolean isDupe = false;
		for (int i = 0; i < candList.size(); i++) {
			if (c.getName().equals(candList.get(i).getName()) && (c.getAffiliation().equals(candList.get(i).getAffiliation()))) {
				isDupe = true;
			}
		}

		if (isDupe == false) {
			candList.add(c);
		}
	}

	/**
	* Method used for retrieving the list of Candidate objects in Ballot object.
	* @Return Arraylist of candidates in Ballot object
	*/
	public ArrayList<Candidate> getCandidates(){
    return candList;
	}
}
