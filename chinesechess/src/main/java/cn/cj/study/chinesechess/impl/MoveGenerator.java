package cn.cj.study.chinesechess.impl;

import cn.cj.study.chinesechess.api.IMoveGenerator;

public class MoveGenerator extends IMoveGenerator {

	@Override
	public Boolean IsValidMove(Byte[][] position, int fromX, int fromY, int toX, int toY) {
		int i, j;
		int nMoceChessId, nTargetId;
		if (fromX == toX && fromY == toY) {
			// 目标与起始相同，非法
			return false;
		}
		nMoceChessId = position[fromY][fromX];
		nTargetId = position[toY][toX];

		switch (nMoceChessId) {

		}

		return super.IsValidMove(position, fromX, fromY, toX, toY);
	}

}
