package porcuppy;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/iterfibo")
public class IterativeFiboServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/plain");
		try{
			String q = req.getParameter("q");
			Integer i = Integer.parseInt(q);
			BigInteger fibo = fibo(i);
			resp.getWriter().println(fibo);
		}catch(Exception ex){
			ex.printStackTrace(resp.getWriter());
		}
	}

	private static BigInteger fibo(int x) {
		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ONE;
		BigInteger c = BigInteger.ZERO;
		while (x-- > 0) {
			c = a.add(b);
			a = b;
			b = c;
		}
		return a;
	}
	
	public static void main(String[] args) {
		System.out.println(fibo(10));
	}
}
