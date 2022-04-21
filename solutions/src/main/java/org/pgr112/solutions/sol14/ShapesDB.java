package org.pgr112.solutions.sol14;

import org.pgr112.solutions.sol14.shapes.Circle;
import org.pgr112.solutions.sol14.shapes.MovablePoint;

import java.sql.*;
import java.util.ArrayList;

public class ShapesDB {

    public static void main(String[] args) {
        ShapesDB db = new ShapesDB();

    }

    public ShapesDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }

    public MovablePoint getPointById(int id) {
        MovablePoint result = null;

        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/shapeSol?useSSL=false", "root", "adminroot")) {
            Statement stmt = con.createStatement();
            String selectSql = "SELECT * FROM points";
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while(resultSet.next()){
                result = new MovablePoint();
                result.setId(resultSet.getInt("id"));
                result.setX(resultSet.getDouble("x"));
                result.setY(resultSet.getDouble("y"));
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return result;
    }

    public ArrayList<Circle> getAllCircles(){
        ArrayList<Circle> results = new ArrayList<>();

        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/shapeSol?useSSL=false", "root", "adminroot")) {

            Statement stmt = con.createStatement();
            String selectSql = "SELECT * FROM circles";
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while(resultSet.next()){
                Circle temp = new Circle();
                temp.setId(resultSet.getInt("id"));
                temp.setFilled(resultSet.getBoolean("filled"));
                temp.setColor(resultSet.getString("color"));
                temp.setRadius(resultSet.getDouble("radius"));

                MovablePoint mp = getPointById(resultSet.getInt("center"));
                temp.setCenter(mp);

                results.add(temp);
            }

        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return results;
    }

}
