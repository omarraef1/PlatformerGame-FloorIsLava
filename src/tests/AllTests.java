package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({testPuzzlePlatModel.class, testCollision.class, testMyCircle.class, 
	testPlayerOne.class, testPuzzlePlatController.class})
public class AllTests {
	

}
