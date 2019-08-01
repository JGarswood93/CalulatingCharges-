package com.barton;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameTest {
    /**
    scores is based on how many pins you knock down in a frame i.e
    two rolls
     */
    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void canScoreGutterGame() {

        game.roll(0,0, 0,0, 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
        assertThat(game.score(), is(0));
    }

    private int times() {
        return 20;
    }

    @Test
    public void canScoreGameOfOnes() {
        game.roll(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
        assertThat(game.score(), is(20));
    }
    @Test
    public void canScoreSpareFollowedByThree(){
        game.roll(5,5,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
        assertThat(game.score(), is(16));
    }

    @Test
    public void canScoreStrikeFollowedByThreeThenThree() {
        game.roll(10,3,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
        assertThat(game.score(), is(22));
    }

    @Test
    public void canScorePerfectGame() {
        game.roll(10,10,10,10,10,10,10,10,10,10,10,10);
        assertThat(game.score(), is(300));
    }
}



