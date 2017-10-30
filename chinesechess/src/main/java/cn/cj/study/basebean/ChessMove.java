package cn.cj.study.basebean;

/**
 * 棋子的走法
 * 
 * @author jun.chen
 *
 */
public class ChessMove {
	/** 标明是什么棋子 */
	private short chessId;
	/** 起始位置 */
	private ChessManPos from;
	/** 目标位置 */
	private ChessManPos to;
	/** 值 */
	private int score;

	public short getChessId() {
		return chessId;
	}

	public void setChessId(short chessId) {
		this.chessId = chessId;
	}

	public ChessManPos getFrom() {
		return from;
	}

	public void setFrom(ChessManPos from) {
		this.from = from;
	}

	public ChessManPos getTo() {
		return to;
	}

	public void setTo(ChessManPos to) {
		this.to = to;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
