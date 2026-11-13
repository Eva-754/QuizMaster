/*
I have only used resources indicated that are allowable.
The work submitted is my/our, and only my/our work.
Signature: Eva Pathak & Jiya Mahalavat
Date: 11/11/2026
*/

/* Programmer: Eva */

//regular player in game
public class Player {
    private String name;
    private double wallet;
    private double totalSpent;
    private double totalEarned;
    private int totalGamesPlayed;
    private int totalGamesWon;
    private int hintsUsed;
    private int hintCredits;

    /** 
     * creating new player with name and wallet amount
     * @param name name of player
     * @param wallet amount of money player has
     */
    public Player(String name, double wallet) {
        setName(name);
        setWallet(wallet);
        totalSpent = 0;
        totalEarned = 0;
        totalGamesPlayed = 0;
        totalGamesWon = 0;
        hintsUsed = 0;
        hintCredits = 0;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        if (wallet < 0) {
            throw new IllegalArgumentException("Wallet amount cannot be negative");
        }
        this.wallet = wallet;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
    }

    public double getTotalEarned() {
        return totalEarned;
    }

    public void setTotalEarned(double totalEarned) {
        this.totalEarned = totalEarned;
    }

    public int getTotalGamesPlayed() {
        return totalGamesPlayed;
    }

    public void setTotalGamesPlayed(int totalGamesPlayed) {
        this.totalGamesPlayed = totalGamesPlayed;
    }

    public int getTotalGamesWon() {
        return totalGamesWon;
    }

    public void setTotalGamesWon(int totalGamesWon) {
        this.totalGamesWon = totalGamesWon;
    }

    public int getHintsUsed() {
        return hintsUsed;
    }

    public void setHintsUsed(int hintsUsed) {
        this.hintsUsed = hintsUsed;
    }

    public int getHintCredits() {
        return hintCredits;
    }   

    public void setHintCredits(int hintCredits) {
        this.hintCredits = hintCredits;
    }

    /** getting hints' cost
     * @return cost of hints
     */
    public double getHintsCost() {
        return 10.0;
    }

    /**
     * player gets a hint if they have enough points in their wallet
     * @return true if player gets a hint, false otherwise
     */
    public boolean getHint() {
        double cost = getHintsCost();
        if (wallet >= cost) {
            wallet -= cost;
            totalSpent += cost;
            hintCredits++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * player uses the hint
     * @return true if hint is available, false otherwise
     */

    public boolean useHint() {
        if (hintCredits > 0) {
            hintCredits--;
            hintsUsed++;
            return true;
        } else {
            return false;
        }
    }
    /**
     * add money to player's wallet
     * @param amount amount of money to add
     */
    public void addToWallet(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        wallet += amount;
        totalEarned += amount;
    }

    /**display stats */
    public void displayStats() {
        double net = totalEarned - totalSpent;
        double winRate = 0;
        if (totalGamesPlayed > 0) {
            winRate = (double) totalGamesWon / totalGamesPlayed * 100;
        }
        System.out.println("Player: " + name);
        System.out.println("Wallet: $" + wallet);
        System.out.println("Total Spent: $" + totalSpent);
        System.out.println("Total Earned: $" + totalEarned);
        System.out.println("Total Games Played: " + totalGamesPlayed);
        System.out.println("Total Games Won: " + totalGamesWon);
        System.out.println("Hints Used: " + hintsUsed);
        System.out.println("Net Earnings: $" + net);
        System.out.println("Win Rate: " + winRate + "%");
        System.out.println("Available Hints: " + hintCredits);
    }
}