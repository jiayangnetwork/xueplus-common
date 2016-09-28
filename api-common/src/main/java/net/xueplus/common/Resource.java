package net.xueplus.common;

import java.io.Serializable;

/**
 * <h1>资源信息</h1>
 * Created by zhangtao on 16/9/18.
 */
public class Resource implements Serializable {
    private String key;
    private String value;

    public Resource() {
    }

    public Resource(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
