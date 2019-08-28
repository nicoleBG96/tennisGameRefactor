
public class TennisGame2 implements TennisGame
{

    public int P1Res = 0;
    public int P2Res = 0;
    
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
		if (P1Res !=P2Res  && 
		(P1Res<4 || P2Res<4))
			score = getLiteralScore(P1Res) 
			+ "-" 
			+ getLiteralScore(P2Res);
		return score;
	}

	private String deuce(String score) {
		if (P1Res==P2Res && P1Res>=3)
			score = "deuce";
		return score;
	}

	private String tie(String score) {
	 if ( P1Res == P2Res && P1Res < 4)
		 score = getLiteralScore(P1Res)+ "-All";
	return score;
	}

	private String win(String score) {
		if (P1Res>=4 && P2Res>=0 && (P1Res-P2Res)>=2)
            score = "Win for player1";
        if (P2Res>=4 && P1Res>=0 && (P2Res-P1Res)>=2)
            score = "Win for player2";
        return score;
	}

	private String advantage(String score) {
		if (P1Res > P2Res && P2Res >= 3)
            score = "Advantage player1";
        if (P2Res > P1Res && P1Res >= 3)
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
			P1Res++;
		else
			P2Res++;
    }

}