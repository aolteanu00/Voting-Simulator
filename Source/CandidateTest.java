import static org.junit.jupiter.api.Assertions.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
public class CandidateTest{
  //Initilize fields
  private Candidate cand1;

  @BeforeEach
  public void setUp(){
    cand1 = new Candidate("name", "affiliation");
  }

  @Test
  public void testName(){
    assertEquals("name", cand1.getName());
  }

  @Test
  public void testAffiliation(){
    assertEquals("affiliation", cand1.getAffiliation());
  }

  @Test
  public void testVoteCount(){
    assertEquals(0, cand1.getVoteCount());
  }

  @Test
  public void testTallyVote(){
    cand1.tallyVote();
    cand1.tallyVote();
    assertEquals(2, cand1.getVoteCount());
  }

  @Test
  public void testToString(){
    String candidateString = "candidate - affiliation            0";
    assertEquals(candidateString, cand1.toString(23, 1));
  }
}
