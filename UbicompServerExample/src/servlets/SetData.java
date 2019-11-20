package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.LCon;
import logic.Logic;

@WebServlet("/SetData")
public class SetData extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public SetData(){
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		LCon.log.info("--Get values from the DB--");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			int value = Integer.parseInt(request.getParameter("value"));
			Logic.setDataToDB(value);
		} catch (NumberFormatException nfe){
			out.println("-1");
			LCon.log.error("Number Format Exception: " + nfe);
		} catch (IndexOutOfBoundsException iobe) {
			out.println("-1");
			LCon.log.error("Index out of bounds Exception: " + iobe);
		} catch (Exception e){
			out.println("-1");
			LCon.log.error("Exception: " + e);
		} finally{
			out.close();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
