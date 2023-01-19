package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/urltest")
public class EncodingFilter extends HttpFilter implements Filter {
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("FILTER 시작");
		//모든 서블릿 실행때마다(요청) 서블릿이름, 요청클라이언트IP 출력- 요청한 서블릿으로 가서 doGet/doPost 하나 호출
		String servletname = ((HttpServletRequest)request).getServletPath();
		String clientip = request.getRemoteAddr();
		System.out.println(clientip+" 컴퓨터가 "+servletname+"을 호출했습니다.");
		
		// 서블릿 요청 인코딩 변경(get(변화없다)/post())
		request.setCharacterEncoding("utf-8");
		
		// 요청 - 요청필터 - 처리 - 응답필터 - 응답
		long start = System.currentTimeMillis();
		chain.doFilter(request, response);//연결되어있는 다른 필터 실행하고 다른 필터 없으면 서블릿 실행해!!!!!!!!!!!
		long stop = System.currentTimeMillis();
		System.out.println((stop-start)+"실행 소요 시간(1/1000초)");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
