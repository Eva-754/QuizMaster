/**
 * Represents one multiple-choice quiz question.
 
 * I have only used resources indicated that are allowable.
  The work submitted is my/our, and only my/our work.
  Signature: Jiya Mahalavat & Eva Pathak 
  Date: 9/14/2026

  Author: Jiya 
 */
public class Question {

    private String questionText;
    private String[] answerChoices;
    private String correctAnswer;
    private String hintText;

    /**
     * Creates a question with four answer choices.
     *
     * @param questionText the question
     * @param answerChoices the four possible answers
     * @param correctAnswer the correct letter (A, B, C, or D)
     * @param hintText a hint for the player
     */
    public Question(String questionText,
                    String[] answerChoices,
                    String correctAnswer,
                    String hintText) {

        setQuestionText(questionText);
        setAnswerChoices(answerChoices);
        setCorrectAnswer(correctAnswer);
        setHintText(hintText);
    }

    /**
     * Gets the question text.
     * 
     * @return the question text
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Sets the question text.
     *
     * @param questionText the new question text
     */
    public void setQuestionText(String questionText) {
        if (questionText == null || questionText.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Question cannot be empty."
            );
        }

        this.questionText = questionText;
    }

    /**
     * Gets the answer choices.
     * Created using ChatGPT because I didn't know how to create a copy of the answer choices. 
     * @return a copy of the answer choices
     */
    public String[] getAnswerChoices() {
        return answerChoices.clone();
    }

    /**
     * Sets the answer choices.
     *
     * @param answerChoices an array containing four choices
     */
    public void setAnswerChoices(String[] answerChoices) {
        if (answerChoices == null || answerChoices.length != 4) {
            throw new IllegalArgumentException(
                "A question must have exactly four answer choices."
            );
        }

        this.answerChoices = answerChoices.clone();
    }

    /**
     * Gets the correct answer.
     *
     * @return the correct answer letter
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Sets the correct answer.
     * Created using ChatGPT because I didn't know how to "match" the correct answer or that it was a keyword. I was able to learn that [A-Da-d] checks for uppercase and lowercase letters A through D.
     * @param correctAnswer the correct letter (A, B, C, or D)
     */
    public void setCorrectAnswer(String correctAnswer) {
        if (correctAnswer == null ||
            !correctAnswer.matches("[A-Da-d]")) {

            throw new IllegalArgumentException(
                "Correct answer must be A, B, C, or D."
            );
        }

        this.correctAnswer = correctAnswer.toUpperCase();
    }

    /**
     * Gets the hint text.
     *
     * @return the hint
     */
    public String getHintText() {
        return hintText;
    }

    /**
     * Sets the hint text.
     *
     * @param hintText the new hint
     */
    public void setHintText(String hintText) {
        if (hintText == null || hintText.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Hint cannot be empty."
            );
        }

        this.hintText = hintText;
    }

    /**
     * Displays the question and its four choices.
     */
    public void displayQuestion() {
        System.out.println(questionText);

        for (int i = 0; i < answerChoices.length; i++) {
            System.out.println( 
                (char) ('A' + i) + ". " + answerChoices[i]
            );
        }
    }

    /**
     * Displays the hint.
     */
    public void displayHint() {
        System.out.println("Hint: " + hintText);
    }
}
