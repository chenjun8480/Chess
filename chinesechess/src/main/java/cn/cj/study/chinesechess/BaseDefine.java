package cn.cj.study.chinesechess;

/**
 * 基本定义
 * 
 * @author jun.chen
 *
 */
public class BaseDefine {
	/** 没有棋子 */
	public static Integer NOCHESS = 0;

	/** 黑帅 */
	public static Integer B_KING = 1;
	/** 黑車 */
	public static Integer B_CAR = 2;
	/** 黑马 */
	public static Integer B_HORSE = 3;
	/** 黑炮 */
	public static Integer B_CANON = 4;
	/** 黑士 */
	public static Integer B_BISHOP = 5;
	/** 黑象 */
	public static Integer B_ELEPHANT = 6;
	/** 黑兵 */
	public static Integer B_PAWN = 7;
	public static Integer B_BEGIN = B_KING;
	public static Integer B_END = B_PAWN;

	/** 红帅 */
	public static Integer R_KING = 8;
	/** 红車 */
	public static Integer R_CAR = 9;
	/** 红马 */
	public static Integer R_HORSE = 10;
	/** 红炮 */
	public static Integer R_CANON = 11;
	/** 红士 */
	public static Integer R_BISHOP = 12;
	/** 红象 */
	public static Integer R_ELEPHANT = 13;
	/** 红兵 */
	public static Integer R_PAWN = 14;
	public static Integer R_BEGIN = R_KING;
	public static Integer R_END = R_PAWN;

	/**
	 * 判断棋子是否是黑色
	 * 
	 * @param x
	 * @return
	 */
	public Boolean IsBlack(Integer x) {
		return x >= B_BEGIN && x <= B_END;
	}

	/**
	 * 判断棋子是否是红色
	 * 
	 * @param x
	 * @return
	 */
	public Boolean IsRed(Integer x) {
		return x >= R_BEGIN && x <= R_END;
	}

	/**
	 * 判断棋子是否同色
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Boolean IsSameSide(Integer x, Integer y) {
		return (IsBlack(x) && IsBlack(y)) || (IsRed(x) && IsRed(y));
	}
}
