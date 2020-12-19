package controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import dao.CreateImage;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateVerifylmageController extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	CreateImage createImage = new CreateImage();
	String vCode = createImage.createCode();
	HttpSession session = request.getSession();
	session.setAttribute("verifyCode", vCode);
	
	response.setContentType("img/jpeg");
	BufferedImage image = createImage.CreateImage(vCode);
	ServletOutputStream out = response.getOutputStream();
	ImageIO.write(image, "JPEG", out);
	out.flush();
	out.close();
		
		
	}
	
	
	

}
