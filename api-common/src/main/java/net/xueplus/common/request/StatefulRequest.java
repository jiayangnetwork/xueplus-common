package net.xueplus.common.request;

/**
 * <h1>有状态的请求信息</h1>
 * <p>
 *     表示请求需要含状态信息(登录用户)
 * </p>
 * Created by zhangtao on 16/8/12.
 */
public class StatefulRequest<T> extends CommonRequest {
    private Long userId;

    public StatefulRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
