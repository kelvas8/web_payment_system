package by.epam.task4.java.controllers;

import by.epam.task4.java.model.dao.factory.DAOFactory;
import by.epam.task4.java.model.dao.interfaces.IClientsDAO;
import by.epam.task4.java.model.entity.Client;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        IClientsDAO clientDAO = mysqlFactory.getClientDAO();
        String json = "";
        if(br !=null) {
            json = br.readLine();
        }

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Client client = gson.fromJson(json, Client.class);
        int id = client.getId();
        clientDAO.deleteClient(id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
