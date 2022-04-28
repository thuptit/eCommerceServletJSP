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
import dto.RequestOrderDto;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.ecommerce.daos.AuthorDao;
import net.ecommerce.daos.OrderDao;
import net.ecommerce.daos.PublisherDao;
import net.ecommerce.models.Book;
import net.ecommerce.models.BookItem;
import net.ecommerce.models.Cart;
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
    private OrderDao orderDao;
    private AuthorDao authorDao;
    private PublisherDao publisherDao;

    @Override
    public void init() {
        bookDao = new BookDao();
        customerDao = new CustomerDao();
        gson = new Gson();
        orderDao = new OrderDao();
        authorDao = new AuthorDao();
        publisherDao = new PublisherDao();
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
                case "/admin/getListBook": {
                    try {
                        getListBook(request, response);
                    } catch (JSONException ex) {
                        Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
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
                case "/cart":
                    cartView(request, response);
                    break;
                case "/history-order":
                    orderView(request, response);
                    break;
                case "/getOrder":
                    getListOrder(request, response);
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
                case "/order":
                    order(request, response);
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

    private void cartView(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("views/cart.jsp").forward(request, response);
    }
    private void orderView(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("views/orderDetail.jsp").forward(request, response);
    }
    // end views customer page
    
    //start handle customer page
    private void order(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ids = request.getParameter("ids");
        int amount = Integer.parseInt(request.getParameter("amount"));
        int status = Integer.parseInt(request.getParameter("status"));
        float totalPrice = Float.parseFloat(request.getParameter("totalPrice"));
        String address = request.getParameter("address");
        String typeShip = request.getParameter("typeShip");
        int typePayment = Integer.parseInt(request.getParameter("typePayment"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String bankid = request.getParameter("bankid");
        String bankName = request.getParameter("bankName");
        String expDate = request.getParameter("expDate");
        String typeCard = request.getParameter("typeCard");
        String number = request.getParameter("numberAccount");
        RequestOrderDto rqOrder = new RequestOrderDto(ids, amount, status, totalPrice, address, typeShip, typePayment, customerId, bankid, bankName, expDate, typeCard, number);
        orderDao.order(rqOrder);
        ResponseDto res = new ResponseDto(true, "Successed", null);
        responseClient(res, response);
    }
    
    private void getListOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int customerId = Integer.parseInt(request.getParameter("id"));
        List orders = orderDao.getListOrder(customerId);
        ResponseDto res = new ResponseDto(true, "Successed", orders);
        responseClient(res, response);
    }
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
        List listAuhor = authorDao.getListAuthors(name);
        ResponseDto res = new ResponseDto(true, "Thành công", listAuhor);
        responseClient(res, response);
    }

    private void saveAuthor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        String name = request.getParameter("name");
        String biography = request.getParameter("biography");
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isCheckSave = authorDao.saveAuthor(new Author(id, name, biography));
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
        List author = authorDao.getByIdAuthor(id);
        ResponseDto res = new ResponseDto(true, "Thành công", author);
        responseClient(res, response);
    }

    private void deleteAuthor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        String name = request.getParameter("name");
        String biography = request.getParameter("biography");
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isCheckDelete = authorDao.deleteAuthor(new Author(id, name, biography));
        ResponseDto res = new ResponseDto(true, "Success", null);
        responseClient(res, response);
    }

    private void getListPublisher(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        String name = request.getParameter("name");
        List listAuhor = publisherDao.getListPublishers(name);
        ResponseDto res = new ResponseDto(true, "Thành công", listAuhor);
        responseClient(res, response);
    }

    private void savePublisher(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isCheckSave = publisherDao.savePublisher(new Publisher(id, name, address));
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
        List author = publisherDao.getByIdPublisher(id);
        ResponseDto res = new ResponseDto(true, "Thành công", author);
        responseClient(res, response);
    }

    private void deletePublisher(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        String name = request.getParameter("name");
        String address = request.getParameter("biography");
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isCheckDelete = publisherDao.deletePublisher(new Publisher(id, name, address));
        ResponseDto res = new ResponseDto(true, "Success", null);
        responseClient(res, response);
    }

    private void getDropdownPublisher(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        List publishers = publisherDao.getDropdownPublisher();
        ResponseDto res = new ResponseDto(true, "Thành công", publishers);
        responseClient(res, response);
    }

    private void getDropdownAuthor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        List authors = authorDao.getDropdownAuthor();
        ResponseDto res = new ResponseDto(true, "Thành công", authors);
        responseClient(res, response);
    }

    private void saveBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        String isbn = request.getParameter("isbn");
        String language = request.getParameter("language");
        int numberOfPage = Integer.parseInt(request.getParameter("numberOfPage"));
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
            isSuccess = bookDao.insertBook(new Book(id, isbn, title, summary, numberOfPage, language, new Author(authorId), new Publisher(publisherId)), new BookItem(barcode, discount, price, new Book(), new HashSet<>()), url);
        } else {
            isSuccess = bookDao.updateBook(new Book(id, isbn, title, summary, numberOfPage, language, new Author(authorId), new Publisher(authorId)), new BookItem(barcode, discount, id, new Book(), new HashSet<>()));
        }
        ResponseDto res = isSuccess ? new ResponseDto(true, "Thành công", null) : new ResponseDto(true, "Có lỗi xảy ra", null);
        responseClient(res, response);
    }

    private void getListBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        String name = request.getParameter("name");
        List books = bookDao.getListBook(name);
        ResponseDto res = new ResponseDto(true, "Successed", books);
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
