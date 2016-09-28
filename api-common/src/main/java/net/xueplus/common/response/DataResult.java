package net.xueplus.common.response;

/**
 * <h1>数据结果</h1>
 * <p>
 *     执行某一操作时, 需要返回数据项作为当前操作的结果.
 * </p>
 * Created by zhangtao on 16/8/12.
 */
public class DataResult extends OptResult {
    /**
     * 数据对象
     */
    private Object data;

    public DataResult() {
    }

    /**
     * <h1>获取成功的数据结果</h1>
     * @param data 数据项
     * @return 数据结果
     */
    public static DataResult success(Object data) {
        DataResult dataResult = new DataResult();
        dataResult.setSuccess(true);
        dataResult.setData(data);
        return dataResult;
    }

    /**
     * <h1>获取失败结果</h1>
     * @param code 错误码
     * @return 数据结果
     */
    public static DataResult failure(String code) {
        DataResult dataResult = new DataResult();
        dataResult.setSuccess(false);
        dataResult.setCode(code);
        return dataResult;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataResult{" +
                "data=" + data +
                '}';
    }
}
