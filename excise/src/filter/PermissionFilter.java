package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class PermissionFilter
 */
@WebFilter("/PermissionFilter")
public class PermissionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PermissionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
    @Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		//chain.doFilter(request, response);
		HttpServletRequest request = (HttpServletRequest)req;
		String path = request.getServletPath();
		System.out.println("请求地址url-pattern："+path);
		if(notCheckPath.indexOf(path)==-1) {
			HttpSession session = request.getSession();
			if(session.getAttribute("currentUser")==null) {
				request.setAttribute("info", "没有访问权限");
				request.getRequestDispatcher("/error.jsp").forward(request, resp);
			}else {
				chain.doFilter(req, resp);
			}
		}else {
			chain.doFilter(req, resp);
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		notCheckUri = config.getInitParameter("notCheckUri");
		// TODO Auto-generated method stub
	}

}
