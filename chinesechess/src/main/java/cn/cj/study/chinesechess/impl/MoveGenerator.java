package cn.cj.study.chinesechess.impl;

import cn.cj.study.chinesechess.BaseDefine;
import cn.cj.study.chinesechess.ResultObject;
import cn.cj.study.chinesechess.api.IMoveGenerator;
import cn.cj.study.chinesechess.basebean.ChessManPos;
import cn.cj.study.chinesechess.basebean.ChessMove;

/**
 * 棋子走法的校验实现
 * 
 * @author jun.chen
 *
 */
public class MoveGenerator extends IMoveGenerator {

	@Override
	public ResultObject IsValidMove(Byte[][] position, ChessManPos from, ChessManPos to) {
		return IsValidMove(position, from.getX(), from.getY(), to.getX(), to.getY());
	}

	private ResultObject IsValidMove(Byte[][] position, int fromX, int fromY, int toX, int toY) {
		int nMoceChessId, nTargetId;
		if (fromX == toX && fromY == toY) {
			// 目标与起始相同，非法（自己吃自己）
			return new ResultObject(false, "目标与起始相同，非法！");
		}
		nMoceChessId = position[fromY][fromX];
		nTargetId = position[toY][toX];

		switch (nMoceChessId) {
		case BaseDefine.B_KING:// 黑将
			return CheckKing(position, nTargetId, BaseDefine.R_KING, fromX, toX, fromY, toY, 1, toY > 2);
		case BaseDefine.R_KING:// 红将
			return CheckKing(position, nTargetId, BaseDefine.B_KING, fromX, toX, fromY, toY, -1, toY < 7);
		case BaseDefine.B_BISHOP:
			return CheckBishop(position, fromX, toX, fromY, toY, toY > 2);
		case BaseDefine.R_BISHOP:
			return CheckBishop(position, fromX, toX, fromY, toY, toY < 7);
		case BaseDefine.B_ELEPHANT:
			return CheckElephant(position, fromX, toX, fromY, toY, toY > 4);
		case BaseDefine.R_ELEPHANT:
			return CheckElephant(position, fromX, toX, fromY, toY, toY < 5);
		case BaseDefine.B_PAWN:
			return CheckPawn(position, fromX, toX, fromY, toY, toY - fromY, fromY < 5);
		case BaseDefine.R_PAWN:
			return CheckPawn(position, fromX, toX, fromY, toY, fromY - toY, fromY > 4);
		case BaseDefine.B_CAR:
		case BaseDefine.R_CAR:
			return CheckCar(position, fromX, toX, fromY, toY);
		case BaseDefine.B_HORSE:
		case BaseDefine.R_HORSE:
			return CheckHorse(position, fromX, toX, fromY, toY);
		case BaseDefine.B_CANON:
		case BaseDefine.R_CANON:
			return CheckCanon(position, nTargetId, fromX, toX, fromY, toY);
		}

		return null;
	}

	/**
	 * 判断老将的走法是否合法
	 * 
	 * @param position
	 * @param king_a
	 * @param king_b
	 * @param from_x
	 * @param to_x
	 * @param from_y
	 * @param to_y
	 * @param add_flag
	 * @param y_flag
	 * @return
	 */
	private ResultObject CheckKing(Byte[][] position, int king_a, int king_b, int from_x, int to_x, int from_y,
			int to_y, int add_flag, boolean y_flag) {
		boolean isTrue = true;
		String errorStr = null;
		if (king_a == king_b) {// 判断是否老将见面
			if (from_x != to_x) {// 判断横坐标是否相同
				isTrue = false;
				errorStr = "将军时，必须在用一列！";
			} else {
				int i = from_y + 1;
				while (i < to_y) {
					if (position[i][from_x] != BaseDefine.NOCHESS) {
						isTrue = false;// 中间隔有棋子,返回false
						errorStr = "将军时，将军间不能隔棋子！";
					}
					i += add_flag;
				}
			}
		} else {
			if (y_flag || to_x > 5 || to_x < 3) {
				isTrue = false;// 老将走出九宫格
				errorStr = "将军不能走出九宫格！";
			} else if (Math.abs(from_y - to_y) + Math.abs(from_x - to_x) > 1) {
				isTrue = false;// 老将每次只能挪一步
				errorStr = "将军每次只能走一格！";
			}
		}
		return new ResultObject(isTrue, errorStr);
	}

	/**
	 * 判断士的走法是否合法
	 * 
	 * @param position
	 * @param from_x
	 * @param to_x
	 * @param from_y
	 * @param to_y
	 * @param y_flag
	 * @return
	 */
	private ResultObject CheckBishop(Byte[][] position, int from_x, int to_x, int from_y, int to_y, boolean y_flag) {
		boolean isTrue = true;
		String errorStr = null;
		if (y_flag || to_x > 5 || to_x < 3) {
			isTrue = false;// 仕走出了九宫格
			errorStr = "士不能走出九宫格！";
		} else if (Math.abs(from_y - to_y) != 1 || Math.abs(from_x - to_x) != 1) {
			isTrue = false;// 仕应该走斜线
			errorStr = "士只能走斜线！";
		}
		return new ResultObject(isTrue, errorStr);
	}

	/**
	 * 判断象的走法是否合法
	 * 
	 * @param position
	 * @param from_x
	 * @param to_x
	 * @param from_y
	 * @param to_y
	 * @param y_flag
	 * @return
	 */
	private ResultObject CheckElephant(Byte[][] position, int from_x, int to_x, int from_y, int to_y, boolean y_flag) {
		boolean isTrue = true;
		String errorStr = null;
		if (y_flag) {
			isTrue = false;// 象不能过河
			errorStr = "象不能过河！";
		} else if (Math.abs(from_y - to_y) != 2 || Math.abs(from_x - to_x) != 2) {
			isTrue = false;// 象必须走田字
			errorStr = "象必须走田字！";
		} else if (position[(from_y + to_y) / 2][(from_x + to_x) / 2] != BaseDefine.NOCHESS) {
			isTrue = false;// 象眼不能有棋子
			errorStr = "象眼不能有棋子！";
		}
		return new ResultObject(isTrue, errorStr);
	}

	/**
	 * 判断兵的走法是否合法
	 * 
	 * @param position
	 * @param from_x
	 * @param to_x
	 * @param from_y
	 * @param to_y
	 * @param y_sub
	 * @param y_flag
	 * @return
	 */
	private ResultObject CheckPawn(Byte[][] position, int from_x, int to_x, int from_y, int to_y, int y_sub,
			boolean y_flag) {
		boolean isTrue = true;
		String errorStr = null;
		if (to_y < from_y) {
			isTrue = false;// 兵不能回头
			errorStr = "兵不能回头！";
		} else if (y_flag && from_y == to_y) {
			isTrue = false;// 兵过河前只能直走
			errorStr = "兵过河前只能直走！";
		} else if (y_sub + Math.abs(to_x - from_x) > 1) {
			isTrue = false;// 兵每次只能走一步直线
			errorStr = "兵每次只能走一步直线！";
		}
		return new ResultObject(isTrue, errorStr);
	}

	/**
	 * 判断車的走法是否合法
	 * 
	 * @param position
	 * @param from_x
	 * @param to_x
	 * @param from_y
	 * @param to_y
	 * @param y_flag
	 * @return
	 */
	private ResultObject CheckCar(Byte[][] position, int from_x, int to_x, int from_y, int to_y) {
		boolean isTrue = true;
		String errorStr = null;
		if (from_y != to_y && from_x != to_x) {
			isTrue = false;// 車走直线
			errorStr = "車只能走直线！";
		} else if (from_y == to_y) {
			if (from_x < to_x) {
				if (!CheckIsNoChess_x(position, from_y, from_x, to_x)) {
					isTrue = false;// 車走的直线上存在棋子
					errorStr = "車走的直线上存在棋子！";
				}
			} else {
				if (!CheckIsNoChess_x(position, from_y, to_x, from_x)) {
					isTrue = false;// 車走的直线上存在棋子
					errorStr = "車走的直线上存在棋子！";
				}
			}
		} else {
			if (from_y < to_y) {
				if (!CheckIsNoChess_y(position, from_x, from_y, to_y)) {
					isTrue = false;// 車走的直线上存在棋子
					errorStr = "車走的直线上存在棋子！";
				}
			} else {
				if (!CheckIsNoChess_y(position, from_x, to_y, from_y)) {
					isTrue = false;// 車走的直线上存在棋子
					errorStr = "車走的直线上存在棋子！";
				}
			}
		}
		return new ResultObject(isTrue, errorStr);
	}

	// y相同时的校验x方向
	private boolean CheckIsNoChess_x(Byte[][] position, int from_y, int from_x, int to_x) {
		int i = from_x + 1;
		while (i < to_x) {
			if (position[from_y][i] != BaseDefine.NOCHESS) {
				return false;
			}
			i++;
		}
		return true;
	}

	// x相同时的校验y方向
	private boolean CheckIsNoChess_y(Byte[][] position, int from_x, int from_y, int to_y) {
		int j = from_y + 1;
		while (j < to_y) {
			if (position[j][from_x] != BaseDefine.NOCHESS) {
				return false;
			}
			j++;
		}
		return true;
	}

	/**
	 * 判断馬的走法是否合法
	 * 
	 * @param position
	 * @param from_x
	 * @param to_x
	 * @param from_y
	 * @param to_y
	 * @return
	 */
	private ResultObject CheckHorse(Byte[][] position, int from_x, int to_x, int from_y, int to_y) {
		boolean isTrue = true;
		String errorStr = null;
		if ((sub_abs(to_x, from_x, 1) && sub_abs(to_y, from_y, 2))
				|| (sub_abs(to_x, from_x, 2) && sub_abs(to_y, from_y, 1))) {
			isTrue = false;// 马走日
			errorStr = "馬必须走日！";
			return new ResultObject(isTrue, errorStr);
		}

		int i = -1;
		int j = -1;
		if (to_x - from_x == 2) {
			i = from_x + 1;
			j = from_y;
		} else if (from_x - to_x == 2) {
			i = from_x - 1;
			j = from_y;
		} else if (to_y - from_y == 2) {
			i = from_x;
			j = from_y + 1;
		} else if (from_y - to_y == 2) {
			i = from_x;
			j = from_y - 1;
		}

		if (position[j][i] != BaseDefine.NOCHESS) {
			isTrue = false;// 绊马腿
			errorStr = "绊马腿！";
		}
		return new ResultObject(isTrue, errorStr);
	}

	/**
	 * 判断炮的走法是否合法
	 * 
	 * @param position
	 * @param targetVal
	 * @param from_x
	 * @param to_x
	 * @param from_y
	 * @param to_y
	 * @return
	 */
	private ResultObject CheckCanon(Byte[][] position, int targetVal, int from_x, int to_x, int from_y, int to_y) {
		boolean isTrue = true;
		String errorStr = null;
		if (from_y != to_y && from_x != to_x) {
			isTrue = false;// 炮走直线
			errorStr = "炮只能走直线！";
		}
		// 炮不吃子时经过的路线中不能有棋子
		if (targetVal == BaseDefine.NOCHESS) {
			if (from_y == to_y) {
				if (from_x < to_x) {
					if (!CheckIsNoChess_x(position, from_y, from_x, to_x)) {
						isTrue = false;// 炮的直线上存在棋子
						errorStr = "炮不吃子时，炮走的直线上存在棋子！";
					}
				} else {
					if (!CheckIsNoChess_x(position, from_y, to_x, from_x)) {
						isTrue = false;// 炮的直线上存在棋子
						errorStr = "炮不吃子时，炮走的直线上存在棋子！";
					}
				}
			} else {
				if (from_y < to_y) {
					if (!CheckIsNoChess_y(position, from_x, from_y, to_y)) {
						isTrue = false;// 炮的直线上存在棋子
						errorStr = "炮不吃子时，炮走的直线上存在棋子！";
					}
				} else {
					if (!CheckIsNoChess_y(position, from_x, to_y, from_y)) {
						isTrue = false;// 炮的直线上存在棋子
						errorStr = "炮不吃子时，炮走的直线上存在棋子！";
					}
				}
			}
		} else {// 跑吃子时
			if (from_y == to_y) {
				if (from_x < to_x) {
					if (!CheckChessCount_x(position, from_y, from_x, to_x)) {
						isTrue = false;// 炮的直线上存在棋子不唯一
						errorStr = "炮吃子时，炮走的直线上只能存在一个棋子！";
					}
				} else {
					if (!CheckChessCount_x(position, from_y, to_x, from_x)) {
						isTrue = false;// 炮的直线上存在棋子不唯一
						errorStr = "炮吃子时，炮走的直线上只能存在一个棋子！";
					}
				}
			} else {
				if (from_y < to_y) {
					if (!CheckChessCount_y(position, from_x, from_y, to_y)) {
						isTrue = false;// 炮的直线上存在棋子不唯一
						errorStr = "炮吃子时，炮走的直线上只能存在一个棋子！";
					}
				} else {
					if (!CheckChessCount_y(position, from_x, to_y, from_y)) {
						isTrue = false;// 炮的直线上存在棋子不唯一
						errorStr = "炮吃子时，炮走的直线上只能存在一个棋子！";
					}
				}
			}

		}
		return new ResultObject(isTrue, errorStr);
	}

	// y相同时的校验x方向中间子个数是否是1
	private boolean CheckChessCount_x(Byte[][] position, int from_y, int from_x, int to_x) {
		int count = 0;
		int i = from_x + 1;
		while (i < to_x) {
			if (position[from_y][i] != BaseDefine.NOCHESS) {
				count++;
			}
			i++;
		}
		return count == 1;
	}

	// x相同时的校验y方向中间子个数是否是1
	private boolean CheckChessCount_y(Byte[][] position, int from_x, int from_y, int to_y) {
		int count = 0;
		int j = from_y + 1;
		while (j < to_y) {
			if (position[j][from_x] != BaseDefine.NOCHESS) {
				count++;
			}
			j++;
		}
		return count == 1;
	}

	private boolean sub_abs(int a, int b, int val) {
		return Math.abs(a - b) == val;
	}

	@Override
	public int AddMove(ChessManPos from, ChessManPos to, int nPly) {
		int count = getChessMoveListCount();
		ChessMove chessMove = new ChessMove();
		chessMove.setFrom(from);
		chessMove.setTo(to);
		this.chessMoveList[nPly][count] = chessMove;
		setChessMoveListCount(count + 1);
		return getChessMoveListCount();
	}

	@Override
	public int CreatePossibleMove(Byte[][] position, int nPly, boolean nSide) {

		int chessVal;
		setChessMoveListCount(0);
		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 10; i++) {
				if (position[i][j] != BaseDefine.NOCHESS) {
					chessVal = position[i][j];
					if ((!nSide && BaseDefine.IsRed(chessVal)) || (nSide && BaseDefine.IsBlack(chessVal))) {
						continue;
					}

					ChessManPos from = new ChessManPos(j, i);
					switch (chessVal) {
					case BaseDefine.R_KING:// 红将
					case BaseDefine.B_KING:// 黑将
						Gen_KingMove(position, from, nPly);
						break;
					case BaseDefine.R_BISHOP:
						Gen_RBishopMove(position, from, nPly);
						break;
					case BaseDefine.B_BISHOP:
						Gen_BBishopMove(position, from, nPly);
						break;
					case BaseDefine.R_ELEPHANT:
					case BaseDefine.B_ELEPHANT:
						Gen_ElephantMove(position, from, nPly);
						break;
					case BaseDefine.R_HORSE:
					case BaseDefine.B_HORSE:
						Gen_HorseMove(position, from, nPly);
						break;
					case BaseDefine.R_CAR:
					case BaseDefine.B_CAR:
						Gen_CarMove(position, from, nPly);
						break;
					case BaseDefine.R_PAWN:
						Gen_RPawnMove(position, from, nPly);
						break;
					case BaseDefine.B_PAWN:
						Gen_BPawnMove(position, from, nPly);
						break;
					case BaseDefine.R_CANON:
					case BaseDefine.B_CANON:
						Gen_CanonMove(position, from, nPly);
						break;
					}
				}

			}

		}
		return getChessMoveListCount();
	}

	@Override
	public void Gen_KingMove(Byte[][] position, ChessManPos from, int nPly) {

		for (int y = 0; y < 3; y++) {
			for (int x = 3; x < 6; x++) {
				ChessManPos to = new ChessManPos(x, y);
				if(IsValidMove(position, from, to).isTrue()) {
					AddMove(from, to, nPly);
				}
			}

		}
		
		for (int y = 7; y < 10; y++) {
			for (int x = 3; x < 6; x++) {
				ChessManPos to = new ChessManPos(x, y);
				if(IsValidMove(position, from, to).isTrue()) {
					AddMove(from, to, nPly);
				}
			}

		}
	}

}
