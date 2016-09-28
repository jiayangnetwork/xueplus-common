package net.xueplus.common.request;

/**
 * <h1>分页请求信息</h1>
 * <p>
 *     用于进行接口调用的分页信息, 其中包含page, pageSize属性.
 * </p>
 * Created by zhangtao on 16/8/16.
 */
public class PageRequest extends CommonRequest {
    /**
     * 默认页码
     */
    public static final int DEFAULT_PAGE = 1;
    /**
     * 默认页大小
     */
    public static final int DEFAULT_PAGE_SIZE = 10;
    /**
     * 当前页码
     */
    private int page = DEFAULT_PAGE;
    /**
     * 默认页大小
     */
    private int pageSize = DEFAULT_PAGE_SIZE;

    public PageRequest() {
    }

    /**
     * 单页分页
     */
    public static PageRequest SINGLE_PAGE = new PageRequest() {
        @Override
        public int getPage() {
            return DEFAULT_PAGE;
        }

        @Override
        public int getPageSize() {
            return Integer.MAX_VALUE;
        }
    };

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

    /**
     * 获取起始记录行号
     * @return 起始记录行号
     */
    public int getStart() {
        if (page <= 1) {
            return 0;
        }
        return (page - 1) * pageSize;
    }
}
