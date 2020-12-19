package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import vo.User;

@WebServlet(urlPatterns = "/login.do")
public class LoginController extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	
	request.setCharacterEncoding("UTF-8");
	String userName = request.getParameter("username");
	String password = request.getParameter("password");
	String vcode = request.getParameter("vcode");
	HttpSession session = request.getSession();
	String saveVcode = (String) session.getAttribute("verifyCode");
	String forwardPath = "";
	
	if(!vcode.equalsIgnoreCase(saveVcode)){
		request.setAttribute("info", "验证码不正确！");
		forwardPath = "/error.jsp";
		
	}else {
		UserDao userDao = new UserDao();
		if(userDao.get(userName) == null) {
			request.setAttribute("info", "您输入的用户名不存在");
		}else {
			
			User currentUser = userDao.get(password);
			if(currentUser == null) {
				request.setAttribute("info", "您输入的密码不正确！");
				forwardPath = "/error.jsp";
			}else {
				session.setAttribute("currentUser", currentUser);
				forwardPath = "/main.jsp";
				
			}
		
		}
		
		
	}
	
	
	RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
	rd.forward(request, response);
	
	
	}
}
