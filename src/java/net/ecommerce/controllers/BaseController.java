/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ecommerce.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.ecommerce.models.Book;
import net.ecommerce.models.BookItem;
import net.ecommerce.models.FileDb;
import net.ecommerce.models.Publisher;

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
                //start route of author
                case "/admin/author":
                    authorAdmin(request, response);
                    break;
                case "/admin/getListAuthor": {
                    try {
                        getListAuthors(request, response);
                    } catch (JSONException ex) {
                        Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "/admin/getDropdownAuthor": {
                    try {
                        getDropdownAuthor(request, response);
                    } catch (JSONException ex) {
                        Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "/admin/getByIdAuthor": {
                    try {
                        getByIdAuthor(request, response);
                    } catch (JSONException ex) {
                        Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                //end route author

                //start route category
                case "/admin/category":
                    categoryAdmin(request, response);
                    break;
                //end route category

                //start route book
                case "/admin/book":
                    bookdAdmin(request, response);
                    break;
                case "/admin/add-or-edit-book":
                    addEditViewBookAdmin(request, response);
                    break;
                //end route book

                //start route publisher   
                case "/admin/publisher":
                    publisherAdmin(request, response);
                    break;
                case "/admin/getListPublisher": {
                    try {
                        getListPublisher(request, response);
                    } catch (JSONException ex) {
                        Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "/admin/getDropdownPublisher": {
                    try {
                        getDropdownPublisher(request, response);
                    } catch (JSONException ex) {
                        Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "/admin/getByIdPublisher": {
                    try {
                        getByIdPublisher(request, response);
                    } catch (JSONException ex) {
                        Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                //end route category
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
                case "/admin/checkLogin": {
                    try {
                        checkLogin(request, response, 1);
                    } catch (JSONException ex) {
                        Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "/admin/saveAuthor": {
                    try {
                        saveAuthor(request, response);
                    } catch (JSONException ex) {
                        Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "/admin/saveBook": {
                    try {
                        saveBook(request, response);
                    } catch (JSONException ex) {
                        Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "/admin/deleteAuthor": {
                    try {
                        deleteAuthor(request, response);
                    } catch (JSONException ex) {
                        Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "/admin/savePublisher": {
                    try {
                        savePublisher(request, response);
                    } catch (JSONException ex) {
                        Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "/admin/deletePublisher": {
                    try {
                        deletePublisher(request, response);
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

    //start views customer page
    private void home(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("views/home.jsp").forward(request, response);
    }

    private void detailBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("views/detailBook.jsp").forward(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("views/login.jsp").forward(request, response);
    }
    // end views customer page

    //start handle customer page
    //end handle customer page
    // start views admin page
    private void loginAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("views/admin/login.jsp").forward(request, response);
    }

    private void dashboardAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/views/admin/dashboard.jsp").forward(request, response);
    }

    private void categoryAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/views/admin/category.jsp").forward(request, response);
    }

    private void bookdAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/views/admin/book.jsp").forward(request, response);
    }

    private void publisherAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/views/admin/publisher.jsp").forward(request, response);
    }

    private void authorAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/views/admin/author.jsp").forward(request, response);
    }

    private void addEditViewBookAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/views/admin/addOrEditBook.jsp").forward(request, response);
    }
    //end views admin page

    //start handle admin page
    private void checkLogin(HttpServletRequest request, HttpServletResponse response, int type) throws IOException, ServletException, JSONException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List data = (ArrayList<Account>) customerDao.checkLogin(username, password);
        String result;
        ResponseDto res = null;
        if (data != null) {
            res = new ResponseDto(true, "Đăng nhập thành công", data);
            System.out.println(res.message);
            HttpSession session = request.getSession(true);
            Account cus = (Account) data.get(0);
            if (type == 1) {
                session.setAttribute("customerAdminId", cus.getId());
                session.setAttribute("accountAdmin", cus.getUsername());
            } else {
                session.setAttribute("customerId", cus.getId());
                session.setAttribute("account", cus.getUsername());
            }
        } else {
            res = new ResponseDto(false, "Sai tài khoản mật khẩu", new ArrayList<Account>());
        }
        responseClient(res, response);
    }

    private void getListAuthors(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        String name = request.getParameter("name");
        List listAuhor = bookDao.getListAuthors(name);
        ResponseDto res = new ResponseDto(true, "Thành công", listAuhor);
        responseClient(res, response);
    }

    private void saveAuthor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        String name = request.getParameter("name");
        String biography = request.getParameter("biography");
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isCheckSave = bookDao.saveAuthor(new Author(id, name, biography));
        ResponseDto res = null;
        if (isCheckSave) {
            res = new ResponseDto(isCheckSave, "Cập nhật thành công", null);
        } else {
            res = new ResponseDto(isCheckSave, "Có lỗi xảy ra", null);
        }
        responseClient(res, response);
    }

    private void getByIdAuthor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        int id = Integer.parseInt(request.getParameter("id"));
        List author = bookDao.getByIdAuthor(id);
        ResponseDto res = new ResponseDto(true, "Thành công", author);
        responseClient(res, response);
    }

    private void deleteAuthor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        String name = request.getParameter("name");
        String biography = request.getParameter("biography");
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isCheckDelete = bookDao.deleteAuthor(new Author(id, name, biography));
        ResponseDto res = new ResponseDto(true, "Success", null);
        responseClient(res, response);
    }

    private void getListPublisher(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        String name = request.getParameter("name");
        List listAuhor = bookDao.getListPublisher(name);
        ResponseDto res = new ResponseDto(true, "Thành công", listAuhor);
        responseClient(res, response);
    }

    private void savePublisher(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isCheckSave = bookDao.savePublisher(new Publisher(id, name, address));
        ResponseDto res = null;
        if (isCheckSave) {
            res = new ResponseDto(isCheckSave, "Cập nhật thành công", null);
        } else {
            res = new ResponseDto(isCheckSave, "Có lỗi xảy ra", null);
        }
        responseClient(res, response);
    }

    private void getByIdPublisher(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        int id = Integer.parseInt(request.getParameter("id"));
        List author = bookDao.getByIdPublisher(id);
        ResponseDto res = new ResponseDto(true, "Thành công", author);
        responseClient(res, response);
    }

    private void deletePublisher(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        String name = request.getParameter("name");
        String address = request.getParameter("biography");
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isCheckDelete = bookDao.deletePublisher(new Publisher(id, name, address));
        ResponseDto res = new ResponseDto(true, "Success", null);
        responseClient(res, response);
    }

    private void getDropdownPublisher(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        List publishers = bookDao.getDropdownPublisher();
        ResponseDto res = new ResponseDto(true, "Thành công", publishers);
        responseClient(res, response);
    }

    private void getDropdownAuthor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        List authors = bookDao.getDropdownAuthor();
        ResponseDto res = new ResponseDto(true, "Thành công", authors);
        responseClient(res, response);
    }

    private void saveBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        String isbn = request.getParameter("isbn");
        String language = request.getParameter("language");
        String numberOfPage = request.getParameter("numberOfPage");
        String summary = request.getParameter("summary");
        String title = request.getParameter("name");
        int authorId = Integer.parseInt(request.getParameter("author"));
        int publisherId = Integer.parseInt(request.getParameter("publisher"));
        String barcode = request.getParameter("barcode");
        String discount = request.getParameter("discount");
        int price = Integer.parseInt(request.getParameter("price"));
        String url = request.getParameter("url");
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isSuccess = false;
        if (id < 1) {
            isSuccess = bookDao.insertBook(new Book(id, isbn, title, summary, id, language, new Author(authorId), new Publisher(publisherId)), new BookItem(barcode, discount, price, new Book(), new HashSet<>()), url);
        } else {
            isSuccess = bookDao.updateBook(new Book(id, isbn, title, summary, id, language, new Author(authorId), new Publisher(authorId)), new BookItem(barcode, discount, id, new Book(), new HashSet<>()));
        }
        ResponseDto res = isSuccess ? new ResponseDto(true, "Thành công", null) : new ResponseDto(true, "Có lỗi xảy ra", null);
        responseClient(res, response);
    }
    //end handle admin page

    public void responseClient(ResponseDto res, HttpServletResponse response) throws JsonProcessingException, IOException {
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = Obj.writeValueAsString(res);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.write(jsonStr);
        out.flush();
    }
}
