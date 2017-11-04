package cn.cj.study.chinesechess.api;

import cn.cj.study.chinesechess.ResultObject;
import cn.cj.study.chinesechess.basebean.ChessManPos;

/**
 * 走法生成器接口类
 * 
 * @author jun.chen
 *
 */
public interface InMoveGenerator {
	/**
	 * 检查一个走法是否合法
	 * 
	 * @param position
	 *            包含所有棋子位置信息的二位数组
	 * @param from
	 *            棋子的起始坐标
	 * @param to
	 *            棋子的目标坐标
	 * @return
	 */
	public ResultObject IsValidMove(Byte position[][], ChessManPos from, ChessManPos to);

	/**
	 * 产生给定棋盘上的所有合法的走法
	 * 
	 * @param position
	 *            包含所有棋子位置信息的二位数组
	 * @param nPly
	 *            指明当前搜索的层数
	 * @param nSide
	 *            指明哪一方走棋
	 * @return
	 */
	int CreatePossibleMove(Byte position[][], int nPly, boolean nSide);

	/**
	 * 向chessMoveList添加一个走法
	 * 
	 * @param from
	 *            棋子的起始坐标
	 * @param to
	 *            棋子的目标坐标
	 * @param nPly
	 * @return
	 */
	int AddMove(ChessManPos from, ChessManPos to, int nPly);

	/**
	 * 产生给定棋盘上的给定位置上的将/帅的走法
	 * 
	 * @param position
	 * @param i
	 * @param j
	 * @param nPly
	 */
	void Gen_KingMove(Byte position[][], ChessManPos from, int nPly);

	/**
	 * 产生给定棋盘上的给定位置上的红士的走法
	 * 
	 * @param position
	 * @param i
	 * @param j
	 * @param nPly
	 */
	void Gen_RBishopMove(Byte position[][], ChessManPos from, int nPly);

	/**
	 * 产生给定棋盘上的给定位置上的黑士的走法
	 * 
	 * @param position
	 * @param i
	 * @param j
	 * @param nPly
	 */
	void Gen_BBishopMove(Byte position[][], ChessManPos from, int nPly);

	/**
	 * 产生给定棋盘上的给定位置上的相/象的走法
	 * 
	 * @param position
	 * @param i
	 * @param j
	 * @param nPly
	 */
	void Gen_ElephantMove(Byte position[][], ChessManPos from, int nPly);

	/**
	 * 产生给定棋盘上的给定位置上的马的走法
	 * 
	 * @param position
	 * @param i
	 * @param j
	 * @param nPly
	 */
	void Gen_HorseMove(Byte position[][], ChessManPos from, int nPly);

	/**
	 * 产生给定棋盘上的给定位置上的車的走法
	 * 
	 * @param position
	 * @param i
	 * @param j
	 * @param nPly
	 */
	void Gen_CarMove(Byte position[][], ChessManPos from, int nPly);

	/**
	 * 产生给定棋盘上的给定位置上的红卒的走法
	 * 
	 * @param position
	 * @param i
	 * @param j
	 * @param nPly
	 */
	void Gen_RPawnMove(Byte position[][], ChessManPos from, int nPly);

	/**
	 * 产生给定棋盘上的给定位置上的黑兵的走法
	 * 
	 * @param position
	 * @param i
	 * @param j
	 * @param nPly
	 */
	void Gen_BPawnMove(Byte position[][], ChessManPos from, int nPly);

	/**
	 * 产生给定棋盘上的给定位置上的炮的走法
	 * 
	 * @param position
	 * @param i
	 * @param j
	 * @param nPly
	 */
	void Gen_CanonMove(Byte position[][], ChessManPos from, int nPly);
}
