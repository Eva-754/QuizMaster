/*
I have only used resources indicated that are allowable.
The work submitted is my and only my work.
Signature: Eva Pathak & Jiya Mahalavat
Date: 11/13/2026
*/

/* Programmer: Eva */

/**
 * This class represents a quiz game.
 * It stores player answers, checks correct answers,
 * and calculates rewards based on matches.
 */

public class Quiz {
    private int roundNumber;
    private int matches;
    private double baseReward;
    private double reward;
    private String quizMode;
    private String[] playerAnswers;
    
    /** make new quiz 
     * @param roundNumber the round number of the quiz
     * @param quizMode the type of quiz
     */
    public Quiz(int roundNumber, String quizMode) {
        this.roundNumber = roundNumber;
        this.matches = 0;
        this.baseReward = 10.0; // Base reward for the quiz
        this.reward = 0.0; // Initialize reward to 0
        this.playerAnswers = new String[5];
        this.quizMode = quizMode;
    }

    /**getters and setters */

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public double getBaseReward() {
        return baseReward;
    }

    public void setBaseReward(double baseReward) {
        this.baseReward = baseReward;
    }   

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public String getQuizMode() {
        return quizMode;
    }

    public void setQuizMode(String quizMode) {
        this.quizMode = quizMode;
    }

    public String[] getPlayerAnswers() {
        return playerAnswers;
    }

    public void setPlayerAnswers(String[] playerAnswers) {
        this.playerAnswers = playerAnswers;
    }

    /** compare answers from players with correct ones
     * @param correctAnswers the correct answers for the quiz
     * @return the number of matches between player answers and correct answers
     */

    public int compareAnswers(String[] correctAnswers) {
        matches = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (playerAnswers[i] != null && playerAnswers[i].equalsIgnoreCase(correctAnswers[i])) {
                matches++;
            }
        }
        return matches;
    }

    /** calculate reward using multiplier
     * @return total reward
     */

    public double calculateReward() {
        double multiplier = 1.0;

        if (matches == 1) {
            multiplier = 1.2;
        } else if (matches == 2) {
            multiplier = 1.5;
        } else if (matches == 3) {
            multiplier = 2.0;
        } else if (matches == 4) {
            multiplier = 2.5;
        } else if (matches == 5) {
            multiplier = 3.0;
        }

        reward = (baseReward * matches) * multiplier;
        return reward;
    }

    /**
     * adds quiz reward to wallet
     * @param player
     */

    public void addRewardToWallet(Player player) {
        player.addToWallet(reward);
    }

}