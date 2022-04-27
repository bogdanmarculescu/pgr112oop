package org.pgr112.solutions.sol13.dtos;

import org.pgr112.solutions.sol13.shapes.Circle;
import org.pgr112.solutions.sol13.shapes.MovablePoint;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class CircleDao extends ShapeDao<Circle> {
    public CircleDao(Properties properties) {
        super(properties);
    }
    public CircleDao() {super();}

    @Override
    protected Circle mapFromResultSet(ResultSet rs) throws SQLException {
        int centerId = rs.getInt("center");
        MoveablePointDao mp = new MoveablePointDao(this.properties);
        MovablePoint center = mp.retrieve(centerId);

        Circle circle = new Circle();
        circle.setId(rs.getInt("id"));
        circle.setColor(rs.getString("color"));
        circle.setFilled(rs.getBoolean("filled"));
        circle.setRadius(rs.getDouble("radius"));
        circle.setCenter(center);

        return circle;
    }

    public Circle retrieve(int id) {
        //return super.retrieve(id, "SELECT * from \"points\" WHERE id = ?");
        try (Connection connection = getConnection()){
            Statement stmt = connection.createStatement();

            String selectSql = "SELECT * FROM circles WHERE id = " + id;
            ResultSet resultSet = stmt.executeQuery(selectSql);

            return mapFromResultSet(resultSet);

        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

        return null;
    }
    @Override
    public void save(Circle circle) throws SQLException {
        try (Connection connection = getConnection()){
            Statement stmt = connection.createStatement();

            int filled = circle.isFilled() ? 1 : 0;
            MovablePoint center;

            MoveablePointDao mpd = new MoveablePointDao();
            center = mpd.retrieve(circle.getCenter().getId());

            if(center==null){
                mpd.save(circle.getCenter());
                center = circle.getCenter();
            }

            String insertSql = "INSERT INTO circles (filled, color, radius, center) " +
                    "VALUES('" +
                     filled + "', '" +
                    circle.getColor() + "', '" +
                    circle.getRadius() + "', '" +
                    center.getId()  +
                    "')";
            int key = stmt.executeUpdate(insertSql, Statement.RETURN_GENERATED_KEYS);
            circle.setId(key);
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    @Override
    public ArrayList<Circle> listAll() throws SQLException {
        ArrayList<Circle> result = new ArrayList<Circle>();
        try (Connection connection = getConnection()){
            Statement stmt = connection.createStatement();

            String selectSql = "SELECT * FROM circles";

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

            String deleteSql = "DELETE FROM circles WHERE id = " + id;
            int key = stmt.executeUpdate(deleteSql, Statement.RETURN_GENERATED_KEYS);
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
