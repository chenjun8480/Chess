package cn.cj.study.chinesechess.api;

import cn.cj.study.chinesechess.basebean.ChessMove;

/**
 * 走法生成器
 * 
 * @author jun.chen
 *
 */
public abstract class IMoveGenerator {
	/** 存放CreatePossibleMove产生的所有走法的队列 */
	ChessMove[][] chessMoveList = new ChessMove[8][80];

	/** 记录chessMoveList中走法的数量 */
	private int chessMoveListCount;

	public int getChessMoveListCount() {
		return chessMoveListCount;
	}

	public void setChessMoveListCount(int chessMoveListCount) {
		this.chessMoveListCount = chessMoveListCount;
	}

	/**
	 * 检查一个走法是否合法
	 * 
	 * @param position
	 * @param fromX
	 * @param fromY
	 * @param toX
	 * @param toY
	 * @return
	 */
	public Boolean IsValidMove(Byte position[][], int fromX, int fromY, int toX, int toY) {
		return null;
	}

	/**
	 * 产生给定棋盘上的所有合法的走法
	 * 
	 * @param position
	 * @param nPly
	 * @param nSide
	 * @return
	 */
	int CreatePossibleMove(Byte position[][], int nPly, int nSide) {
		return 0;
	}

	/**
	 * 向chessMoveList添加一个走法
	 * 
	 * @param fromX
	 * @param toX
	 * @param fromY
	 * @param toY
	 * @param nPly
	 * @return
	 */
	protected int AddMove(int fromX, int toX, int fromY, int toY, int nPly) {
		return 0;
	}

	/**
	 * 产生给定棋盘上的给定位置上的将/帅的走法
	 * 
	 * @param position
	 * @param i
	 * @param j
	 * @param nPly
	 */
	protected void Gen_KingMove(Byte position[][], int i, int j, int nPly) {
	}

	/**
	 * 产生给定棋盘上的给定位置上的红士的走法
	 * 
	 * @param position
	 * @param i
	 * @param j
	 * @param nPly
	 */
	protected void Gen_RBishopMove(Byte position[][], int i, int j, int nPly) {
	}

	/**
	 * 产生给定棋盘上的给定位置上的黑士的走法
	 * 
	 * @param position
	 * @param i
	 * @param j
	 * @param nPly
	 */
	protected void Gen_BBishopMove(Byte position[][], int i, int j, int nPly) {
	}

	/**
	 * 产生给定棋盘上的给定位置上的相/象的走法
	 * 
	 * @param position
	 * @param i
	 * @param j
	 * @param nPly
	 */
	protected void Gen_ElephantMove(Byte position[][], int i, int j, int nPly) {
	}

	/**
	 * 产生给定棋盘上的给定位置上的马的走法
	 * 
	 * @param position
	 * @param i
	 * @param j
	 * @param nPly
	 */
	protected void Gen_HorseMove(Byte position[][], int i, int j, int nPly) {
	}

	/**
	 * 产生给定棋盘上的给定位置上的車的走法
	 * 
	 * @param position
	 * @param i
	 * @param j
	 * @param nPly
	 */
	protected void Gen_CarMove(Byte position[][], int i, int j, int nPly) {
	}

	/**
	 * 产生给定棋盘上的给定位置上的红卒的走法
	 * 
	 * @param position
	 * @param i
	 * @param j
	 * @param nPly
	 */
	protected void Gen_RPawnMove(Byte position[][], int i, int j, int nPly) {
	}

	/**
	 * 产生给定棋盘上的给定位置上的黑兵的走法
	 * 
	 * @param position
	 * @param i
	 * @param j
	 * @param nPly
	 */
	protected void Gen_BPawnMove(Byte position[][], int i, int j, int nPly) {
	}

	/**
	 * 产生给定棋盘上的给定位置上的炮的走法
	 * 
	 * @param position
	 * @param i
	 * @param j
	 * @param nPly
	 */
	protected void Gen_CanonMove(Byte position[][], int i, int j, int nPly) {
	}

}
