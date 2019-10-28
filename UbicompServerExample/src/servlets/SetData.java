package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import logic.LCon;
import logic.Logic;
import logic.Measurement;

/**
 * Servlet implementation class GetData
 */
@WebServlet("/SetData")
public class SetData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LCon.log.info("--Get values from the DB--");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try 
		{
			int value = Integer.parseInt(request.getParameter("value"));
			Logic.setDataToDB(value);
		} catch (NumberFormatException nfe) 
		{
			out.println("-1");
			LCon.log.error("Number Format Exception: " + nfe);
		} catch (IndexOutOfBoundsException iobe) 
		{
			out.println("-1");
			LCon.log.error("Index out of bounds Exception: " + iobe);
		} catch (Exception e) 
		{
			out.println("-1");
			LCon.log.error("Exception: " + e);
		} finally 
		{
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
