package wang.ronnie.financial.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by ronniewang on 17/7/20.
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        request.getAttributeNames();
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
