package ru.geekbrains.hw3.service;

import ru.geekbrains.hw3.entites.Product;

import java.sql.*;

public class DbHandler {
    private static Connection connection;
    private static Statement stmt;
    private PreparedStatement preparedStatement;

    public DbHandler(){
        try{
            connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(Product product){
        try {
            if (!connection.isClosed()) {
                preparedStatement = connection.prepareStatement(
                        "insert into \"Products\"(price,title) values (?,?);"
                );
                preparedStatement.setInt(1, product.getPrice());
                preparedStatement.setString(2, product.getTitle());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getSize() {
        String result = null;
        try {
            if (!connection.isClosed()) {
                preparedStatement = connection.prepareStatement(
                        "select count(id) from \"Products\";"
                );
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    result = rs.getString("count(id)");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assert result != null;
        return Integer.parseInt(result);
    }

    public Product[] getProducts() {
        Product[] products = new Product[getSize()];
        int count = 0;
        try {
            if (!connection.isClosed()) {
                preparedStatement = connection.prepareStatement(
                        "select price, title from \"Products\";"
                );
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    String tmpTitle = rs.getString("title");
                    int tmpPrice = rs.getInt("price");
                    products[count] = new Product(tmpTitle,tmpPrice);
                    count++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    private void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resource/HW3ProductsRepos.db");
        stmt = connection.createStatement();
    }

}
