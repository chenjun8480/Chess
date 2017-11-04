package cn.cj.study.chinesechess.api;

import cn.cj.study.chinesechess.ResultObject;
import cn.cj.study.chinesechess.basebean.ChessManPos;
import cn.cj.study.chinesechess.basebean.ChessMove;

/**
 * 走法生成器
 * 
 * @author jun.chen
 *
 */
public abstract class IMoveGenerator implements InMoveGenerator {
	/** 存放CreatePossibleMove产生的所有走法的队列 */
	public ChessMove[][] chessMoveList = new ChessMove[8][80];

	/** 记录chessMoveList中走法的数量 */
	private int chessMoveListCount;

	public int getChessMoveListCount() {
		return chessMoveListCount;
	}

	public void setChessMoveListCount(int chessMoveListCount) {
		this.chessMoveListCount = chessMoveListCount;
	}

	public ResultObject IsValidMove(Byte position[][], ChessManPos from, ChessManPos to) {
		return new ResultObject(true, "");
	};

	public int CreatePossibleMove(Byte[][] position, int nPly, boolean nSide) {
		return 0;
	}

	public int AddMove(ChessManPos from, ChessManPos to, int nPly) {
		return 0;
	}

	public void Gen_KingMove(Byte[][] position, ChessManPos from, int nPly) {

	}

	public void Gen_RBishopMove(Byte[][] position, ChessManPos from, int nPly) {

	}

	public void Gen_BBishopMove(Byte[][] position, ChessManPos from, int nPly) {

	}

	public void Gen_ElephantMove(Byte[][] position, ChessManPos from, int nPly) {

	}

	public void Gen_HorseMove(Byte[][] position, ChessManPos from, int nPly) {

	}

	public void Gen_CarMove(Byte[][] position, ChessManPos from, int nPly) {

	}

	public void Gen_RPawnMove(Byte[][] position, ChessManPos from, int nPly) {

	}

	public void Gen_BPawnMove(Byte[][] position, ChessManPos from, int nPly) {

	}

	public void Gen_CanonMove(Byte[][] position, ChessManPos from, int nPly) {

	}

}
