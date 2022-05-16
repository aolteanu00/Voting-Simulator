import static org.junit.jupiter.Assertions.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;

public class BallotTest{
  //Initilize fields
  private Ballot ballot;
  ArrayList<Candidate> candList = new ArrayList<Candidate>();
  private Candidate cand1 = new Candidate("a", "b");
  private Candidate cand2 = new Candidate("c", "d");

  public void createBallot(Candidate a, Candidate b){
    candList.add(a);
    candList.add(b);
  }

  @BeforeEach
  public void setUp(){
    ballot = new Ballot("Election");
  }

  @Test
  public void testOfficeName(){
    assertEquals("Election", ballot.getOfficeName());
  }

  @Test
  public void testCandidates(){
    createBallot(cand1, cand2);
    ballot.addCandidate(cand1);
    ballot.addCandidate(cand2);
    assertEquals(candList, ballot.getCandidates());
  }
}
