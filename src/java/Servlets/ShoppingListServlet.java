package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        if(action != null && action.equals("logout")){
                session.invalidate();
                request.setAttribute("logout", "Logged out");
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        
        if (session.getAttribute("username") == null){
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response);
            return;
        }
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String add = request.getParameter("add_item");
        String username = request.getParameter("username");
        String action = request.getParameter("action");
        String list = request.getParameter("list");
        
        if((action != null && action.equals("register")) && (username == null || username.equals(""))){
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response);
                return;
            }
            else{
                session.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request,response);
                return;
            }
        //if (action != null && action.equals("add")){
            
        //}
        }
        
        
    }


