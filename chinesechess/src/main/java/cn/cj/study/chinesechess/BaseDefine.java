package cn.cj.study.chinesechess;

/**
 * 基本定义
 * 
 * @author jun.chen
 *
 */
public class BaseDefine {
	/** 没有棋子 */
	public static int NOCHESS = 0;

	/** 黑帅 */
	public final static int B_KING = 1;
	/** 黑車 */
	public final static int B_CAR = 2;
	/** 黑马 */
	public final static int B_HORSE = 3;
	/** 黑炮 */
	public final static int B_CANON = 4;
	/** 黑士 */
	public final static int B_BISHOP = 5;
	/** 黑象 */
	public final static int B_ELEPHANT = 6;
	/** 黑兵 */
	public final static int B_PAWN = 7;
	public final static int B_BEGIN = B_KING;
	public final static int B_END = B_PAWN;

	/** 红帅 */
	public final static int R_KING = 8;
	/** 红車 */
	public final static int R_CAR = 9;
	/** 红马 */
	public final static int R_HORSE = 10;
	/** 红炮 */
	public final static int R_CANON = 11;
	/** 红士 */
	public final static int R_BISHOP = 12;
	/** 红象 */
	public final static int R_ELEPHANT = 13;
	/** 红兵 */
	public final static int R_PAWN = 14;
	public final static int R_BEGIN = R_KING;
	public final static int R_END = R_PAWN;

	/**
	 * 判断棋子是否是黑色
	 * 
	 * @param x
	 * @return
	 */
	public static Boolean IsBlack(int x) {
		return x >= B_BEGIN && x <= B_END;
	}

	/**
	 * 判断棋子是否是红色
	 * 
	 * @param x
	 * @return
	 */
	public static Boolean IsRed(int x) {
		return x >= R_BEGIN && x <= R_END;
	}

	/**
	 * 判断棋子是否同色
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Boolean IsSameSide(int x, int y) {
		return (IsBlack(x) && IsBlack(y)) || (IsRed(x) && IsRed(y));
	}

	
	/**
	 * 初始棋局的摆法
	 * 
	 * @return
	 */
	public static Byte[][] getDefault() {
		return new Byte[][] { 
			{ 2, 3, 6, 5, 1, 5, 6, 3, 2 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 4, 0, 0, 0, 0, 0, 4, 0 },
			{ 7, 0, 7, 0, 7, 0, 7, 0, 7 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 14, 0, 14, 0, 14, 0, 14, 0, 14 },
			{ 0, 11, 0, 0, 0, 0, 0, 11, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 9, 10, 13, 12, 8, 12, 13, 10, 9 } 
		};
	}
}
