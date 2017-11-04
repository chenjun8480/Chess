package cn.cj.study.chinesechess;

/**
 * 返回结果
 * 
 * @author jun.chen
 *
 */
public class ResultObject {
	/** 结果情况 */
	private boolean isTrue;
	/** 错误信息 */
	private String errorStr;

	public boolean isTrue() {
		return isTrue;
	}

	public void setTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}

	public String getErrorStr() {
		return errorStr;
	}

	public void setErrorStr(String errorStr) {
		this.errorStr = errorStr;
	}

	public ResultObject(boolean isTrue, String errorStr) {
		this.isTrue = isTrue;
		this.errorStr = errorStr;
	}

}
