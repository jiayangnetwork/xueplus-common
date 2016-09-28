package net.xueplus.common.response;

import java.io.Serializable;

/**
 * <h1>操作结果</h1>
 * <p>
 *     表示系统内一次动作执行的结果, 其数据项包括:
 * </p>
 * <ul>
 *     <li>是否成功(success)</li>
 *     <li>错误码(code)</li>
 *     <li>错误消息(message)</li>
 * </ul>
 * <p>
 *     错误码及错误消息可以在error-code.properties中定义, 以支持国际化.
 * </p>
 * Created by zhangtao on 16/8/12.
 */
public class OptResult implements Serializable {
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 错误码
     */
    private String code;
    /**
     * 错误消息
     */
    private String message;

    public OptResult() {
    }
    /**
     * <h1>获取成功的数据结果</h1>
     * @return 数据结果
     */
    public static OptResult success() {
        OptResult result = new OptResult();
        result.setSuccess(true);
        return result;
    }

    /**
     * <h1>获取失败结果</h1>
     * @param code 错误码
     * @return 数据结果
     */
    public static OptResult failure(String code) {
        OptResult result = new OptResult();
        result.setSuccess(false);
        result.setCode(code);
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
