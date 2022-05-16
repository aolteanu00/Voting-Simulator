import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
/**
* @author Alex Olteanu
*/

public class BallotReader{
	/**
	* Reads a formatted input file describing a political race and retrives the name of office, candidates running and their affiliations.
	* Returns a Ballot object completed with corresponding information.
	* @Param Name of input file
	* @Return Ballot object
	*/
	public static Ballot readBallot(String filename) throws IOException {
		//Initialize fields
		String candidate;
		String officeName;
		String skip;
		int candCount;
		ArrayList<String> candList = new ArrayList<String>();

		FileInputStream fileByteStream = null;
    Scanner inFS = null;

		fileByteStream = new FileInputStream(filename);
    inFS = new Scanner(fileByteStream);

		//Retrieve first line of input, denoting the office being run for
		officeName = inFS.nextLine();

		//Generate a brallot object using retrieved office name
		Ballot ballot = new Ballot(officeName);

		//Retrieve next line of input, denoting the number of candidates running
		candCount = inFS.nextInt();

		//Skip next line of input because nextInt() doesn't do so automatically
		skip = inFS.nextLine();

		//Iterate through remaining lines, denoting each candidate's name and affiliation
		//Adds each candidate and their information to the ballot
		while(inFS.hasNext()) {
			candidate = inFS.nextLine();
			String name = "";
			String affiliation = "";

			String[] array = candidate.split(";");
			name = array[0];
			affiliation = array[1];

			ballot.addCandidate(new Candidate(name, affiliation));
		}

		//Finalizing process
		fileByteStream.close();
		return ballot;
	}
}
