/**
* @author Alex Olteanu
*/
public class Candidate {
	protected String name;
	protected String affiliation;
	protected int votes;

	/**
	* Class constructor used for generating Candidate object.
	* @Param Candidate name
	* @Param Candidate object's affiliation
	*/
	public Candidate(String name, String affiliation) {
		this.name = name;
		this.affiliation = affiliation;
		this.votes = 0;
	}

	/**
	* Method used for retrieving Candidate object's name.
	* @Return Candidate object's name
	*/
	public String getName(){
		return name;
	}

	/**
	* Method used for retrieving Candidate object's affiliation
	* @Return Candidate object's affiliation
	*/
	public String getAffiliation(){
		return affiliation;
	}

	/**
	* Method used for retrieving Candidate object's vote count.
	* @Return Candidate object's votes
	*/
	public int getVoteCount(){
		return votes;
	}

	/**
	* Method used for incrementing Candidate object's vote count by 1.
	* @Return void
	*/
	public void tallyVote(){
		votes += 1;
	}

	/**
	* Method used for generating a string representation of Candidate object.
	* @Return String representation of Candidate object
	*/
	public String toString(){
		return name + " - " + affiliation;
	}

	/**
	* Method used for comparing the vote count of two Candidate objects.
	* @param other Candidate
	* @Return -1 if Candidate vote count is less than other Candidate
	* @Return 0 if Candidate vote count is equal to other Candidate
	* @Return 1 if Candidate vote count is greater than other Candidate
	*/
	public int compareCandidate(Candidate otherCandidate){
		if (votes < otherCandidate.getVoteCount()) {
			return -1;
		}

		else if (votes == otherCandidate.getVoteCount()) {
			return 0;
		}

		else {
			return 1;
		}
	}
}
