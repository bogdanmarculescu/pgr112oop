package org.pgr112.solutions.sol13.dtos;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.pgr112.solutions.sol13.shapes.MovablePoint;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MoveablePointDao extends ShapeDao<MovablePoint> {

    public MoveablePointDao(Properties properties) {
        super(properties);
    }

    public MoveablePointDao() {
        super();
    }

    public MovablePoint retrieve(int id) {
        //return super.retrieve(id, "SELECT * from \"points\" WHERE id = ?");
        try (Connection connection = getConnection()){
            Statement stmt = connection.createStatement();

            String selectSql = "SELECT * FROM points WHERE id = " + id;
            ResultSet resultSet = stmt.executeQuery(selectSql);

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
        try (Connection connection = getConnection()){
            Statement stmt = connection.createStatement();

            String insertSql = "INSERT INTO points (id, x, y) " +
                    "VALUES('" +
                    mp.getId() + "', '" +
                    mp.getX() + "', '" +
                    mp.getY() +
                    "')";
            stmt.executeUpdate(insertSql);
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    @Override
    public ArrayList<MovablePoint> listAll() throws SQLException {
        ArrayList<MovablePoint> result = new ArrayList<>();
        try (Connection connection = getConnection()){
            Statement stmt = connection.createStatement();

            String selectSql = "SELECT * FROM points";

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

            String deleteSql = "DELETE FROM points WHERE id = " + id;
            int key = stmt.executeUpdate(deleteSql, Statement.RETURN_GENERATED_KEYS);
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
