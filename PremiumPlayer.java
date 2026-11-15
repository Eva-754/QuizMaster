/**
 * Represents a premium player who receives a discount
 * when purchasing hints.
 *
 * @author Jiya Mahalavat & Eva Pathak 
 */
public class PremiumPlayer extends Player {

    private double discount;

    /**
     * Creates a premium player.
     *
     * @param name the player's name
     * @param wallet the player's starting wallet balance
     * @param discount the hint discount as a decimal
     */
    public PremiumPlayer(String name, double wallet, double discount) {
        super(name, wallet);
        setDiscount(discount);
    }

    /**
     * Gets the discount.
     *
     * @return the discount amount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Sets the discount.
     *
     * @param discount the discount as a decimal from 0 to 1
     */
    public void setDiscount(double discount) {
        if (discount < 0 || discount > 1) {
            throw new IllegalArgumentException(
                "Discount must be between 0 and 1."
            );
        }

        this.discount = discount;
    }

    /**
     * Overrides the regular hint cost to apply the premium discount.
     *
     * @return the discounted hint cost
     */
    @Override
    public double getHintCost() {
        return super.getHintCost() * (1 - discount);
    }
}
