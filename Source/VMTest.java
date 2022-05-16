import java.util.ArrayList;
import java.io.IOException;
import java.util.Random;
/**
* @author Alex Olteanu
*/
public class VMTest {
  /**
  * Used for testing the entire program
  */
  public static void main(String[] args)throws IOException{
    //Initialize fields
    BallotReader reader = new BallotReader();
    ResultWriter writer = new ResultWriter();

    String input = "input.txt";
    String output = "output.txt";

    Random random = new Random();
    int randomVotes = 100;

    Ballot ballotRead = reader.readBallot(input);
    ArrayList<Candidate> candList = ballotRead.getCandidates();

    //Randomly assign votes
    for(int i = 0; i < candList.size(); i++){
      int randomNum = random.nextInt(randomVotes);
      for(int j = 0; j < randomNum; j++){
        candList.get(i).tallyVote();
      }
    }
    writer.writeResults(output, ballotRead);
  }
}
