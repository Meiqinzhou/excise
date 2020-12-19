package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class QueryProvinceCity extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
			String provinceCode = request.getParameter("provinceCode");
			String jsonStr = "";
			ProvinceCityDao dao = new ProvinceCityDao();
			if(provinceCode == null) {
				ArrayList<Province> list = dao.queryProvince();
				jsonStr = new Gson().toJson(list);
				
			}else {
				ArrayList<City> list = dao.queryCity(provinceCode);
				jsonStr = new Gson().toJson(list);
			}
		response.setContentType("text/html;charset-utf-8");
		PrintWriter out = response.getWriter();
		System.out.println(jsonStr);
		out.print(jsonStr);
		out.flush();
		out.close();
	}
}
