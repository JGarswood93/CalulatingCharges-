package com.barton;

public class Game {
    /**
     * kata dojo youtube
     *
     * Pretty refined example
     *
     * Logic needs noting
     */
    private int rollInt = 0;
    private int[] rolls = new int[21];

    /**
     * ... var args - accepts zero or multiple arguments the advantages is that we don't have
     * to provide overloaded methods which means less code
     */
    public void roll(int... rolls) {
        for (int pinsDown : rolls) {
            roll(pinsDown);
        }
    }

    public void roll(int pinsDown) {
        rolls[rollInt++] = pinsDown;
    }


    public int score() {
        int score = 0;
        int cursor = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(cursor)) {
                score += 10 + rolls[cursor + 1] + rolls[cursor + 2];
                cursor++;
            } else if (isSpare(cursor)) {
                score += 10 + rolls[cursor + 2];
                cursor += 2;
            } else {

                score += rolls[cursor] + rolls[cursor + 1];
                cursor += 2;

            }
        }
        return score;
    }

    private boolean isStrike(int cursor) {
        return rolls[cursor] == 10;
    }

    private boolean isSpare(int cursor) {
        return rolls[cursor] + rolls[cursor + 1] == 10;
    }
}
