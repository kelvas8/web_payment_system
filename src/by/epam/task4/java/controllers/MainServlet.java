package by.epam.task4.java.controllers;

import by.epam.task4.java.model.dao.factory.DAOFactory;
import by.epam.task4.java.model.dao.interfaces.IClientsDAO;
import by.epam.task4.java.model.entity.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

@WebServlet(name = "MainServlet")
public class MainServlet extends HttpServlet {
    public static final String delete = "delete";
    public static final String insert = "insert";
    public static final String edit = "edit";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        IClientsDAO clientDAO = mysqlFactory.getClientDAO();
        request.setCharacterEncoding("UTF-8");
        String act = request.getParameter("type");
        try {
            if(act.equals(delete)) {
                int id = parseInt(request.getParameter("id"));
                clientDAO.deleteClient(id); }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            if(act.equals(insert)) {
                ArrayList<Client> list = new ArrayList<Client>() {
                    {
                        add(new Client(request.getParameter("name"),request.getParameter("patronymic"),request.getParameter("surname"),
                                request.getParameter("birthday")));
                    }
                };
                for (Client client : list) { clientDAO.insertClient(client); }
            } } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if(act.equals(edit)) {
                clientDAO.updateClient( new Client(parseInt(request.getParameter("id")), request.getParameter("name"),request.getParameter("patronymic"),request.getParameter("surname"),
                        request.getParameter("birthday")));            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        ArrayList<Client> get = clientDAO.getClients();
        System.out.println(get+"wfqwfHUY");
        request.setAttribute("clients", get);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("main.jsp");
        requestDispatcher.forward(request, response);
    }
}
