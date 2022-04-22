package org.pgr112.solutions.sol14.dtos;

import org.pgr112.solutions.sol14.shapes.Circle;
import org.pgr112.solutions.sol14.shapes.MovablePoint;

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
        String preparedSelect = "SELECT * FROM points WHERE id = ?";
        try (Connection connection = getConnection()){
            PreparedStatement stmt = connection.prepareStatement(preparedSelect);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();

            return mapFromResultSet(resultSet);

        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

        return null;
    }
    @Override
    public void save(Circle circle) throws SQLException {
        String preparedSave = "INSERT INTO circles (filled, color, radius, center) VALUES(?, ?, ?, ?)";
        try (Connection connection = getConnection()){
            connection.setAutoCommit(false);

            MovablePoint centerP;

            MoveablePointDao mpd = new MoveablePointDao();
            centerP = mpd.retrieve(circle.getCenter().getId());

            if(centerP==null){
                mpd.save(circle.getCenter());
                centerP = circle.getCenter();
            }

            PreparedStatement stmt = connection.prepareStatement(preparedSave, PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setBoolean(1, circle.isFilled());
            stmt.setString(2, circle.getColor());
            stmt.setDouble(3, circle.getRadius());
            stmt.setInt(4, centerP.getId());

            stmt.executeUpdate();

            connection.commit();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                circle.setId(rs.getInt(1));
            }

        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    @Override
    public ArrayList<Circle> listAll() throws SQLException {
        ArrayList<Circle> result = new ArrayList<Circle>();
        String selectSql = "SELECT * FROM circles";

        try (Connection connection = getConnection()){
            connection.setAutoCommit(false);
            PreparedStatement stmt = connection.prepareStatement(selectSql);

            ResultSet resultSet = stmt.executeQuery();
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
        String preparedDelete = "DELETE FROM circles WHERE id = ?";

        try (Connection connection = getConnection()){
            connection.setAutoCommit(false);
            PreparedStatement stmt = connection.prepareStatement(preparedDelete);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
