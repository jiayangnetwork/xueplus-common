package net.xueplus.common.request;

import java.io.Serializable;

/**
 * <h1>公共请求信息</h1>
 * <p>
 *     通用请求信息包装, 包括用户基本信息, 条件信息等.
 * </p>
 * Created by zhangtao on 16/8/12.
 */
public class CommonRequest<T> implements Serializable {
    /**
     * 请求数据
     */
    private T data;

    public CommonRequest() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
