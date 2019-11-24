package demo01;

public class TennisGame2 {
    private int player1Point;
    private int player2Point;

    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String[] textScores = { "Love", "Fifteen", "Thirty", "Forty" };

        if (isDeuce()) {
            return "Deuce";
        }

        if (isAll()) {
            return textScores[player1Point] + "-All";
        }

        if (isWinner()) {
            return "Win for " + 
                (player1Point > player2Point ? player1Name : player2Name);
        }

        // Advantage
        if (player1Point > player2Point && player2Point >= 3) {
            return "Advantage " + player1Name;
        }

        if (player2Point > player1Point && player1Point >= 3) {
            return "Advantage " + player2Name;
        }

        // Default :: Normal case
        return textScores[player1Point] + "-" + textScores[player2Point];
    }

    private boolean isWinner() {
        return Math.max(player1Point, player2Point) >= 4 
                && Math.abs(player1Point - player2Point) >= 2;
    }

    private boolean isAll() {
        return player1Point == player2Point && player1Point < 4;
    }

    private boolean isDeuce() {
        return player1Point == player2Point && player1Point >= 3;
    }

    public void P1Score() {
        player1Point++;
    }

    public void P2Score() {
        player2Point++;
    }

    public void wonPoint(String player) {
        if (this.player1Name.equals(player))
            P1Score();
        else
            P2Score();
    }
}
