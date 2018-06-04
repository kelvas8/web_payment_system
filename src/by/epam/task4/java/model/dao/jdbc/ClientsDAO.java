package by.epam.task4.java.model.dao.jdbc;


import by.epam.task4.java.model.dao.connection.PoolConnection;
import by.epam.task4.java.model.dao.interfaces.IClientsDAO;
import by.epam.task4.java.model.entity.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientsDAO implements IClientsDAO {
    private ArrayList<Client> resultList;
    protected Connection connect;
    private final static String SQL_INSERT = "INSERT INTO clients (name, patronymic, surname, birthday) VALUES (?,?,?,?)";
    private final static String SQL_SELECT_ALL = "SELECT * FROM payment_system.clients";
    private final static String SQL_DELETE = "DELETE FROM clients WHERE id = (?)";
    private final static String SQL_UPDATE = "UPDATE clients SET name=(?), patronymic=(?), surname=(?), birthday=(?)  WHERE id=(?)";


    public ClientsDAO() {
        connect = (Connection) PoolConnection.getConnection();
        //System.out.println("successful"+connect);
    }


    @Override
    public boolean insertClient(Client client) {
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(SQL_INSERT);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        boolean flag = false;
        try {
            ps.setString(1, client.getName());
            ps.setString(2, client.getPatronymic());
            ps.setString(3, client.getSurname());
            ps.setDate(4, java.sql.Date.valueOf(client.getBirthday()));
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    System.out.println("cannot close statement");
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException e) {
                    System.out.println("cannot close connection");
                }
            }
        }
        return flag;
    }

    @Override
    public ArrayList<Client> getClients() {
        resultList = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(SQL_SELECT_ALL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                Client cl = new Client( rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), String.valueOf(rs.getDate(5)));
                resultList.add(cl);
            }
            rs.close();
            return resultList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    System.out.println("cannot close statement");
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException e) {
                    System.out.println("cannot close connection");
                }
            }
        }
        return null;    }

    @Override
    public boolean deleteClient(int id) {
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(SQL_DELETE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ps.setLong(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    System.out.println("cannot close statement");
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException e) {
                    System.out.println("cannot close connection");
                }
            }
        }
        return false;
    }

    @Override
    public Client findClient() {
        return null;
    }

    @Override
    public boolean updateClient(Client client) {
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(SQL_UPDATE);
            ps.setString(1, client.getName());
            ps.setString(2, client.getPatronymic());
            ps.setString(3, client.getSurname());
            ps.setDate(4, java.sql.Date.valueOf(client.getBirthday()));
            ps.setInt(5, client.getId());
            return (ps.executeUpdate() != 0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    System.out.println("cannot close statement");
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException e) {
                    System.out.println("cannot close connection");
                }
            }
        }
        return false;
    }


}
