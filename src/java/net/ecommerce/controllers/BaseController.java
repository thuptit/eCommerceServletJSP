/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ecommerce.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.ResponseDto;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.ecommerce.daos.BookDao;
import net.ecommerce.daos.CustomerDao;
import net.ecommerce.models.Account;
import net.ecommerce.models.Author;
import net.ecommerce.models.Customer;
import net.ecommerce.utils.HibernateProxyTypeAdapter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thunv
 */
public class BaseController extends HttpServlet {

    private BookDao bookDao;
    private CustomerDao customerDao;
    private Gson gson;

    @Override
    public void init() {
        bookDao = new BookDao();
        customerDao = new CustomerDao();
        gson = new Gson();
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        if (action.contains("admin")) {
            switch (action) {
                case "/admin":
                    loginAdmin(request, response);
                    break;
                case "/admin/dashboard":
                    dashboardAdmin(request, response);
                    break;
                default:
                    home(request, response);
                    break;
            }
        } else {
            switch (action) {
                case "/detailbook":
                    detailBook(request, response);
                    break;
                case "/login":
                    login(request, response);
                    break;
                default:
                    home(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        if (action.contains("admin")) {
            switch (action) {
                case "/admin/checkLogin":
            {
                try {
                    checkLogin(request, response, 1);
                } catch (JSONException ex) {
                    Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    break;
                default:
                    home(request, response);
                    break;
            }
        } else {
            System.out.println(action);
            switch (action) {
                case "/checkLogin":
                    System.out.println("login");
            {
                try {
                    checkLogin(request, response, 2);
                } catch (JSONException ex) {
                    Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    break;
                default:
                    home(request, response);
                    break;
            }
        }
    }

    //start customer page
    private void home(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("views/home.jsp").forward(request, response);
    }

    private void detailBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("views/detailBook.jsp").forward(request, response);
    }
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("views/login.jsp").forward(request, response);
    }
    // end customer page

    // start admin page
    private void loginAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("views/admin/login.jsp").forward(request, response);
    }

    private void checkLogin(HttpServletRequest request, HttpServletResponse response, int type) throws IOException, ServletException, JSONException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List data = (ArrayList<Account>) customerDao.checkLogin(username, password);
        String result;
        ResponseDto res = null;
        if(data != null){
            res = new ResponseDto(true, "Đăng nhập thành công", data);
            System.out.println(res.message);
            HttpSession session = request.getSession(true);
            Account cus = (Account) data.get(0);
            if(type == 1){
                session.setAttribute("customerAdminId", cus.getId());
                session.setAttribute("accountAdmin", cus.getUsername());
            }
            else{
                session.setAttribute("customerId", cus.getId());
                session.setAttribute("account", cus.getUsername());
            }
        }
        else 
            res = new ResponseDto(false, "Sai tài khoản mật khẩu", new ArrayList<Account>());
        ObjectMapper Obj = new ObjectMapper(); 
        String jsonStr = Obj.writeValueAsString(res);  
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.write(jsonStr);
        out.flush();
    }

    private void dashboardAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/views/admin/dashboard.jsp").forward(request, response);
    }
    // end admin page
}
