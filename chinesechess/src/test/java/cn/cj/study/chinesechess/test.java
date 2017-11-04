package cn.cj.study.chinesechess;

import org.junit.Test;

import cn.cj.study.chinesechess.api.InMoveGenerator;
import cn.cj.study.chinesechess.basebean.ChessManPos;
import cn.cj.study.chinesechess.impl.MoveGenerator;
import junit.framework.Assert;

public class test {
	private InMoveGenerator moveGenerator = new MoveGenerator();

	@Test
	public void baseTestValid() {
		Byte[][] default_b = BaseDefine.getDefault();
		ChessManPos from = new ChessManPos(1, 2);
		ChessManPos to = new ChessManPos(1, 7);
		ResultObject resultObject = moveGenerator.IsValidMove(default_b, from, to);
		Assert.assertEquals(resultObject.isTrue(), false);
		System.out.println(resultObject.getErrorStr());
	}

	@Test
	public void addMove() {
		ChessManPos from = new ChessManPos(1, 2);
		ChessManPos to = new ChessManPos(1, 7);
		int count = moveGenerator.AddMove(from, to, 0);
		 count = moveGenerator.AddMove(from, to, 0);
		System.out.println(count);
	}
}
