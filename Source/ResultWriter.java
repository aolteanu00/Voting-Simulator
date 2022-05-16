import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;
/**
* @author Alex Olteanu
*/

public class ResultWriter{
	/**
	* Given a ballot and file, the method writes the results of the election in a formatted way onto the file.
	* @Param File that the results will be written on
	* @Param Ballot object for the corresponding election
	* @Return void
	*/
	public static void writeResults(String filename, Ballot ballot) throws IOException {
		//Initialize fields
		ArrayList<Candidate> candList = ballot.getCandidates();

		FileOutputStream fileStream = null;
		PrintWriter outFS = null;

		fileStream = new FileOutputStream(filename);
		outFS = new PrintWriter(fileStream);

		//Writes the first line of output onto the file
		String firstLine = "RESULTS - " + ballot.getOfficeName();
		outFS.println(firstLine);

		//Writes the second line of output onto the file
		for (int i = 0; i < firstLine.length() - 1; i++) {
			outFS.print("-");
		}
		outFS.println("-");

		//Determine index of longest Candidate tag in candList
		int longestTagIndex = 0;
		for (int i = 0; i < candList.size(); i++) {
			if (candList.get(i).toString().length() > candList.get(longestTagIndex).toString().length()) {
				longestTagIndex = i;
			}
		}

		//Determine length of longest Candidate tag
		int longestTagLength = candList.get(longestTagIndex).toString().length();

		//Determine the index of Candidate with the highest vote count in candList
		int longestVoteIndex = 0;
		for (int i = 0; i < candList.size(); i++) {
			if (candList.get(i).getVoteCount() > candList.get(longestVoteIndex).getVoteCount()) {
				longestVoteIndex = i;
			}
		}

		//Determine the length of highest vote count
		int longestVoteLength = String.valueOf(candList.get(longestVoteIndex).getVoteCount()).length();

		//Writes the subsequent lines of output that correspond with each Candidate and their vote count
		//Separates each Candidate output line into a combination of: [TAG + SPACES TO REACH LENGTH OF LONGEST TAG + SPACES TO REACH LENGTH OF LONGEST VOTE + VOTECOUNT]
		String longestTag = candList.get(longestTagIndex).toString();
		int spaceToVotes = longestTagLength + 12;

		for (int i = 0; i < candList.size(); i++) {
			String currentTag = candList.get(i).toString();
			String currentVote = String.valueOf(candList.get(i).getVoteCount());

			int currentTagLength = 0;
			currentTagLength = candList.get(i).toString().length();

			int tagLengthLeft = 0;
			tagLengthLeft = longestTagLength - currentTagLength;

			int currentVoteLength = 0;
			currentVoteLength = String.valueOf(candList.get(i).getVoteCount()).length();

			int voteLengthLeft = 0;
			voteLengthLeft = longestVoteLength - currentVoteLength;

			outFS.print(currentTag);
			for (int j = 0; j < tagLengthLeft; j++) {
				outFS.print(" ");
			}

			for (int k = 0; k < 12; k++) {
				outFS.print(" ");
			}

			for (int l = 0; l < voteLengthLeft; l++) {
				outFS.print(" ");
			}
			outFS.println(currentVote);
		}

		//Writes empty line separating Candidate list and results
		outFS.println();

		//Determine if there is either a winning Candidate or a tie
		int winnerIndex = 0;
		boolean tie = false;

		for (int x = 0; x < candList.size(); x++) {
			if (candList.get(x).compareCandidate(candList.get(winnerIndex)) == 1) {
				winnerIndex = x;
			}

			else if (candList.get(x).compareCandidate(candList.get(winnerIndex)) == 0) {
				tie = true;
			}
		}

		//Writes the final line of output, the election's results
		if (tie = true) {
			outFS.println("WINNER: " + candList.get(winnerIndex).toString());
		}

		else{
			outFS.println("NO WINNER");
		}

		//Finalizing process
		outFS.flush();
		fileStream.close();
	}
}
