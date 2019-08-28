
public class TennisGame2 implements TennisGame
{

    public int P1Points = 0;
    public int P2Points = 0;
    
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
    	String score = "";
        score = tie(score);
        score = deuce(score);
        score = normal(score);
        score = advantage(score);
        score = win(score);
        return score;
    }

	private String normal(String score) {
		if (P1Points !=P2Points  && 
		(P1Points<4 || P2Points<4))
			score = getLiteralScore(P1Points) 
			+ "-" 
			+ getLiteralScore(P2Points);
		return score;
	}

	private String deuce(String score) {
		if (P1Points==P2Points && P1Points>=3)
			score = "deuce";
		return score;
	}

	private String tie(String score) {
	 if ( P1Points == P2Points && P1Points < 4)
		 score = getLiteralScore(P1Points)+ "-All";
	return score;
	}

	private String win(String score) {
		if (P1Points>=4 && P2Points>=0 && (P1Points-P2Points)>=2)
            score = "Win for player1";
        if (P2Points>=4 && P1Points>=0 && (P2Points-P1Points)>=2)
            score = "Win for player2";
        return score;
	}

	private String advantage(String score) {
		if (P1Points > P2Points && P2Points >= 3)
            score = "Advantage player1";
        if (P2Points > P1Points && P1Points >= 3)
            score = "Advantage player2";
        return score;
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