package by.epam.task4.java.controllers;

import by.epam.task4.java.model.dao.factory.DAOFactory;
import by.epam.task4.java.model.dao.interfaces.IClientsDAO;
import by.epam.task4.java.model.entity.Client;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ClientsServlet")
public class ClientsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        IClientsDAO clientDAO = mysqlFactory.getClientDAO();
        ArrayList<Client> get = clientDAO.getClients();
        Gson gson = new Gson();
        String responses = gson.toJson(get);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responses);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
