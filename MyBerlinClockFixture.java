package com.ubs.opsit.interviews;

import static com.ubs.opsit.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;

/*
 * This class is cloned with the BerlinClockFixture in the example given. This class tests the clocks 
 * fixture reading from the user story file. It also does some testing of the lamps of the clock.
 */
public class MyBerlinClockFixture {
	private TimeConverterImpl berlinClock;
    private String theTime;

    @Test
    public void berlinClockAcceptanceTests() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("berlin-clock.story")
                .run();
    }

    @When("the time is $time")
    public void whenTheTimeIs(String time) {
        theTime = time;
    }

    @Then("the clock should look like $")
    public void thenTheClockShouldLookLike(String theExpectedBerlinClockOutput) {
    	berlinClock = new TimeConverterImpl();
        assertThat(berlinClock.convertTime(theTime)).isEqualTo(theExpectedBerlinClockOutput);
    }
}
