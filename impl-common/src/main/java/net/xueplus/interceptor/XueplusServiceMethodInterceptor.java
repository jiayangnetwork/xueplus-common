package net.xueplus.interceptor;

import net.xueplus.common.response.DataResult;
import net.xueplus.common.response.OptResult;
import net.xueplus.common.response.PageDataResult;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * <h1>Spring AOP代理</h1>
 * Created by zhangtao on 16/9/9.
 */
public class XueplusServiceMethodInterceptor implements MethodInterceptor {
    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * message source
     */
    @Autowired
    private MessageSource messageSource;

    public Object invoke(MethodInvocation invocation) throws Throwable {
        // 获取返回类型
        Class<?> returnType = invocation.getMethod().getReturnType();
        try {
            return invocation.proceed();
        } catch (Exception e) {
            logger.error("调用业务方法[" + invocation.getMethod().getDeclaringClass().getName() + "." + invocation.getMethod().getName() + "]失败!", e);
            return resolveDefaultResult(returnType, e);
        }
    }

    /**
     * 根据异常类型及返回类型, 获取默认的结果数据
     * @param returnType 返回类型
     * @param e 异常消息
     * @return 对应的默认结果
     */
    private Object resolveDefaultResult(Class<?> returnType, Exception e) {
        if (returnType.isAssignableFrom(PageDataResult.class)) {// 分页查询
            PageDataResult<?> result = new PageDataResult<>();
            result.setSuccess(false);
            result.setCode("common.invoke.error");
            result.setMessage(messageSource.getMessage("common.invoke.error", null, "common.invoke.error", Locale.getDefault()));
            return result;
        } else if (returnType.isAssignableFrom(DataResult.class)) {// 数据结果
            DataResult result = DataResult.failure("common.invoke.error");
            result.setMessage(messageSource.getMessage("common.invoke.error", null, "common.invoke.error", Locale.getDefault()));
            return result;
        } else if (returnType.isAssignableFrom(OptResult.class)) {
            OptResult result = new OptResult();
            result.setSuccess(false);
            result.setCode("common.invoke.error");
            result.setMessage(messageSource.getMessage("common.invoke.error", null, "common.invoke.error", Locale.getDefault()));
            return result;
        } else {
            return null;
        }
    }
}
