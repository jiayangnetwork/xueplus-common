package net.xueplus.common.response;

import java.io.Serializable;
import java.util.List;

/**
 * <h1>分页数据</h1>
 * <p>
 *     执行分页数据查询的操作结果.其中包括:
 * </p>
 * <ul>
 *     <li>本次查询的总数据条数(total)</li>
 *     <li>本次返回的页面数据(data)</li>
 *     <li>当前页码(page)</li>
 *     <li>当前页大小(pageSize)</li>
 * </ul>
 * Created by zhangtao on 16/8/12.
 */
public class PageDataResult<T> extends OptResult implements Serializable {
    /**
     * 分页数据
     */
    private List<T> data;
    /**
     * 总结果数
     */
    private long total;
    /**
     * 当前页码
     */
    private int page;
    /**
     * 分页大小
     */
    private int pageSize;

    public PageDataResult() {
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getRows() {
        return data;
    }
}
