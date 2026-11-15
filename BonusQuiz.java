import java.util.ArrayList;
/**
 * Represents a bonus quiz that gives the player extra points.
 *
 * @author Jiya M
 */
public class BonusQuiz extends Quiz {

    private double bonusPoints;

    /**
     * Creates a bonus quiz.
     *
     * @param questions the questions in the quiz
     * @param roundNumber the quiz round number
     * @param bonusPoints the extra points awarded
     */
    public BonusQuiz(ArrayList<Question> questions,
                     int roundNumber,
                     double bonusPoints) {

        super(questions, roundNumber, "Bonus Quiz");
        this.bonusPoints = bonusPoints;
    }

    /**
     * Gets the bonus points.
     *
     * @return the bonus points
     */
    public double getBonusPoints() {
        return bonusPoints;
    }

    /**
     * Sets the bonus points.
     *
     * @param bonusPoints the new bonus point amount
     */
    public void setBonusPoints(double bonusPoints) {
        if (bonusPoints < 0) {
            throw new IllegalArgumentException(
                "Bonus points cannot be negative."
            );
        }

        this.bonusPoints = bonusPoints;
    }

    /**
     * Calculates the quiz reward and adds bonus points.
     *
     * @return the total reward including bonus points
     */
    @Override
    public double calculateReward() {
        double totalReward = super.calculateReward() + bonusPoints;
        setReward(totalReward);
        return totalReward;
    }
}
