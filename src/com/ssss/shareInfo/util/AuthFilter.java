package com.ssss.shareInfo.util;

import java.io.IOException;  
import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
/** 
 * ���������鿴�û��Ƿ��¼����δ��¼��ֹ����ҳ�� 
 *  
 */  
public class AuthFilter implements Filter {  
    public void destroy() {  
    }  
  
    public void doFilter(ServletRequest servletRequest,  
            ServletResponse servletResponse, FilterChain filterChain)  
            throws IOException, ServletException {  
        /** 
         * 1,doFilter�����ĵ�һ������ΪServletRequest���󡣴˶�����������ṩ�˶Խ������Ϣ������* 
         * �����ݡ�cookie��HTTP����ͷ������ȫ���ʡ��ڶ�������ΪServletResponse��ͨ���ڼ򵥵Ĺ�* 
         * �����к��Դ˲��������һ������ΪFilterChain���˲�����������servlet��JSPҳ�� 
         */  
        HttpServletRequest request = (HttpServletRequest) servletRequest;  
        /** 
         * �������HTTP���󣬲�����Ҫ��������getHeader��getCookies����ServletRequest��* 
         * �޷��õ��ķ�������Ҫ�Ѵ�request�������HttpServletRequest 
         */  
        HttpServletResponse response = (HttpServletResponse) servletResponse;  
        String currentURL = request.getRequestURI();  
        // ȡ�ø�Ŀ¼����Ӧ�ľ���·��:  
        String targetURL = currentURL.substring(currentURL.indexOf("/", 1),  
                currentURL.length()); 
        
        System.out.println("###########2###########"+targetURL);
        
        
        // ��ȡ����ǰ�ļ������ڱȽ�  
        HttpSession session = request.getSession(false);  
        if (!"/login.jsp".equals(targetURL) && !"/validatecode.jsp".equals(targetURL)) {// �жϵ�ǰҳ�Ƿ����ض����Ժ�ĵ�¼ҳ��ҳ�棬����ǾͲ���session���жϣ���ֹ������ѭ��  
            if (session == null || session.getAttribute("username") == null) {  
                // *�û���¼�Ժ����ֶ����session  
                System.out.println("request.getContextPath()="  
                        + request.getContextPath());  
                response.sendRedirect(request.getContextPath() + "/login.jsp");  
                // ���sessionΪ�ձ�ʾ�û�û�е�¼���ض���login.jspҳ��  
                return;  
            }  
        }  
        // ����filter����������ִ��  
        filterChain.doFilter(request, response);  
        /** 
         * ����FilterChain�����doFilter������Filter�ӿڵ�doFilter����ȡһ��FilterChain������* Ϊ�� 
         * ��һ���������ڵ��ô˶����doFilter����ʱ��������һ����صĹ����������û����* 
         * һ����������servlet��JSPҳ���������servlet��JSPҳ�汻��� 
         */  
    }  
  
    public void init(FilterConfig filterConfig) throws ServletException {  
    }  
}  
