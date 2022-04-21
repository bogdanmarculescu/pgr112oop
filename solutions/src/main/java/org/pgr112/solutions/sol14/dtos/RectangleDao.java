package org.pgr112.solutions.sol14.dtos;


import org.pgr112.solutions.sol14.shapes.MovablePoint;
import org.pgr112.solutions.sol14.shapes.Rectangle;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class RectangleDao extends ShapeDao<Rectangle> {
    public RectangleDao(Properties properties){
        super(properties);
    }
    public RectangleDao(){
        super();
    }

    @Override
    public void save(Rectangle rectangle) throws SQLException {

        String preparedInsert = "INSERT INTO rectangles (filled, color, width, length, topLeft, bottomRight) VALUES(?, ?, ?, ?, ?, ?)";

        try (Connection connection = getConnection()){
            connection.setAutoCommit(false);
            PreparedStatement stmt = connection.prepareStatement(preparedInsert);

            stmt.setBoolean(1, rectangle.isFilled());
            stmt.setString(2, rectangle.getColor());

            stmt.setDouble(3, rectangle.getWidth());
            stmt.setDouble(4, rectangle.getLength());

            stmt.setInt(5, rectangle.getTopLeft().getId());
            stmt.setInt(6, rectangle.getBottomRight().getId());

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                rectangle.setId(rs.getInt("id"));
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    @Override
    public ArrayList<Rectangle> listAll() throws SQLException {
        ArrayList<Rectangle> result = new ArrayList<Rectangle>();
        try (Connection connection = getConnection()){
            Statement stmt = connection.createStatement();

            String selectSql = "SELECT * FROM rectangles";

            ResultSet resultSet = stmt.executeQuery(selectSql);
            while(resultSet.next()){
                result.add(mapFromResultSet(resultSet));
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        try (Connection connection = getConnection()){
            Statement stmt = connection.createStatement();

            String deleteSql = "DELETE FROM rectangles WHERE id = " + id;
            int key = stmt.executeUpdate(deleteSql, Statement.RETURN_GENERATED_KEYS);
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    @Override
    protected Rectangle mapFromResultSet(ResultSet rs) throws SQLException {
        int topLeftId = rs.getInt("topLeft");
        int botRightId = rs.getInt("bottomRight");

        MoveablePointDao mpd = new MoveablePointDao(this.properties);
        MovablePoint topLeft = mpd.retrieve(topLeftId);
        MovablePoint bottomRight = mpd.retrieve(botRightId);

        Rectangle rectangle = new Rectangle();
        rectangle.setId(rs.getInt("id"));
        rectangle.setColor(rs.getString("color"));
        rectangle.setFilled(rs.getBoolean("filled"));
        rectangle.setLength(rs.getDouble("length"));
        rectangle.setWidth(rs.getDouble("width"));
        rectangle.setTopLeft(topLeft);
        rectangle.setBottomRight(bottomRight);

        return rectangle;
    }

    @Override
    public Rectangle retrieve(int id) throws SQLException {
        //return super.retrieve(id, "SELECT * from \"points\" WHERE id = ?");
        try (Connection connection = getConnection()){
            Statement stmt = connection.createStatement();

            String selectSql = "SELECT * FROM rectangles WHERE id = " + id;
            ResultSet resultSet = stmt.executeQuery(selectSql);

            return mapFromResultSet(resultSet);

        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

        return null;
    }
}
