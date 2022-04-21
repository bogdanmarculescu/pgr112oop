package org.pgr112.solutions.sol14.dtos;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/***
 * The purpose of this class is to make adding other DTOs easier
 * should this be needed in future
 */
public abstract class ShapeDao<T> {

    protected Properties properties;

    public ShapeDao() {
        this.properties = new Properties();
        try(FileReader reader = new FileReader("solutions/src/main/resources/sol13/pgr112.properties")) {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ShapeDao(Properties properties) {
        this.properties = properties;
    }

    public abstract void save(T t) throws SQLException;

    public abstract ArrayList<T> listAll() throws SQLException;

    public abstract void delete(int id) throws SQLException;

    protected abstract T mapFromResultSet(ResultSet rs) throws SQLException;

    public abstract T retrieve(int id) throws SQLException;

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sol13?useSSL=false",
                "root",
                "adminroot"
        );
    }
}
