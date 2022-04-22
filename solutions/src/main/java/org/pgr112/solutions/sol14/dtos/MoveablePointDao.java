package org.pgr112.solutions.sol14.dtos;

import org.pgr112.solutions.sol14.shapes.MovablePoint;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class MoveablePointDao extends ShapeDao<MovablePoint> {

    public MoveablePointDao(Properties properties) {
        super(properties);
    }

    public MoveablePointDao() {
        super();
    }

    public MovablePoint retrieve(int id) {
        String preparedSelect = "SELECT * FROM points WHERE id = ?";
        try (Connection connection = getConnection()){
            connection.setAutoCommit(false);

            PreparedStatement stmt = connection.prepareStatement(preparedSelect);

            stmt.setString(1, ""+id);
            ResultSet resultSet = stmt.executeQuery();

            if(resultSet.next()) {
                return mapFromResultSet(resultSet);
            }
            else return null;

        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

        return null;
    }

    @Override
    protected MovablePoint mapFromResultSet(ResultSet rs) throws SQLException {
        int mpId = rs.getInt("id");
        MovablePoint mp = new MovablePoint();
        mp.setX(rs.getInt("x"));
        mp.setY(rs.getInt("y"));
        return mp;
    }

    @Override
    public void save(MovablePoint mp) throws SQLException {
        String preparedInsert = "INSERT INTO points VALUES (?, ?, ?)";
        try (Connection connection = getConnection()){
            connection.setAutoCommit(false);

            PreparedStatement stmt = connection.prepareStatement(preparedInsert);

            stmt.setInt(1, mp.getId());
            stmt.setDouble(2, mp.getX());
            stmt.setDouble(3, mp.getY());

            stmt.executeUpdate();
            connection.commit();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    @Override
    public ArrayList<MovablePoint> listAll() throws SQLException {
        ArrayList<MovablePoint> result = new ArrayList<>();
        String preparedAll = "SELECT * FROM points";

        try (Connection connection = getConnection()){
            PreparedStatement stmt = connection.prepareStatement(preparedAll);

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
        String preparedDelete = "DELETE FROM points WHERE id = ?";
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
