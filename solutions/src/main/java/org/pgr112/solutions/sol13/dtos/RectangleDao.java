package org.pgr112.solutions.sol13.dtos;


import com.mysql.cj.jdbc.MysqlDataSource;
import org.pgr112.solutions.sol13.shapes.Circle;
import org.pgr112.solutions.sol13.shapes.MovablePoint;
import org.pgr112.solutions.sol13.shapes.Rectangle;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
        try (Connection connection = getConnection()){
            Statement stmt = connection.createStatement();

            int filled = rectangle.isFilled() ? 1 : 0;
            MovablePoint topLeft;
            MovablePoint bottomRight;
            MoveablePointDao mpd = new MoveablePointDao();

            topLeft = mpd.retrieve(rectangle.getTopLeft().getId());
            bottomRight = mpd.retrieve(rectangle.getBottomRight().getId());

            if(topLeft==null){
                mpd.save(rectangle.getTopLeft());
                topLeft = rectangle.getTopLeft();
            }
            if(bottomRight==null){
                mpd.save(rectangle.getBottomRight());
                bottomRight = rectangle.getBottomRight();
            }

            String insertSql = "INSERT INTO rectangles (filled, color, width, length, topLeft, bottomRight) " +
                    "VALUES('" +
                    filled + "', '" +
                    rectangle.getColor() + "', '" +
                    rectangle.getWidth() + "', '" +
                    rectangle.getLength() + "', '" +
                    topLeft.getId() + "', '" +
                    bottomRight.getId() +
                    "')";
            int key = stmt.executeUpdate(insertSql, Statement.RETURN_GENERATED_KEYS);
            rectangle.setId(key);
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
