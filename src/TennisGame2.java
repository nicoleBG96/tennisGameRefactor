
public class TennisGame2 implements TennisGame
{

    public int P1Points = 0;
    public int P2Points = 0;
    
    private String player1Name;
    private String player2Name;
    
    String score = "";

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        if(isTie())
        	score = getScoreForTie();
        if (isDeuce())
        	score = getScoreForDeuce();
        if(isNormal())
        	score = getScoreForNormal();
        advantage();
        win();
        return score;
    }

	private String getScoreForNormal() {
		return getLiteralScore(P1Points) 
		+ "-" 
		+ getLiteralScore(P2Points);
	}

	private String getScoreForDeuce() {
		return "deuce";
	}

	private String getScoreForTie() {
		return getLiteralScore(P1Points)+ "-All";
	}

	private boolean isNormal() {
		return P1Points !=P2Points  && 
		(P1Points<4 || P2Points<4);
	}


	private boolean isDeuce() {
		return P1Points==P2Points && P1Points>=3;
	}

	private boolean isTie() {
		return P1Points == P2Points && P1Points < 4;
	}

	private void win() {
		if (isWinnerOver(P1Points, P2Points))
            score = "Win for player1";
        if (isWinnerOver(P2Points, P1Points))
            score = "Win for player2";
	}

	private boolean isWinnerOver(int firstPlayerPoints, int secondPlayerPoints) {
		return firstPlayerPoints>=4 && secondPlayerPoints>=0 && (firstPlayerPoints-secondPlayerPoints)>=2;
	}

	private void advantage() {
		if (isAdvantageOver(P1Points, P2Points))
            score = "Advantage player1";
        if (isAdvantageOver(P2Points, P1Points))
            score = "Advantage player2";
	}

	private boolean isAdvantageOver(int firstPlayerPoints, int secondPlayerPoints) {
		return firstPlayerPoints > secondPlayerPoints && secondPlayerPoints >= 3;
	}

	private String getLiteralScore(int playerPoints) {
		String result="";
		if (playerPoints==0)
		    result = "Love";
		if (playerPoints==1)
		    result = "Fifteen";
		if (playerPoints==2)
		    result = "Thirty";
		if (playerPoints==3)
		    result = "Forty";
		return result;
	}
	
    public void wonPoint(String player) {
        if (player == "player1")
			P1Points++;
		else
			P2Points++;
    }

}