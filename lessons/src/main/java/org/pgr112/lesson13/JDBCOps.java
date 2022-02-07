package org.pgr112.lesson13;

import org.pgr112.lesson13.equipment.Ball;
import org.pgr112.lesson13.equipment.Locker;

import java.sql.*;
import java.util.ArrayList;

public class JDBCOps {

    public JDBCOps(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }

    public boolean insertLocker(Locker locker) {
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?useSSL=false", "root", "adminroot")) {

            Statement stmt = con.createStatement();

            String insertSql = "INSERT INTO lockers(location)"
                    + " VALUES('" +
                    locker.getLocation() +
                    "')";
            stmt.executeUpdate(insertSql);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertBall(Ball ball){
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?useSSL=false",
                        "root",
                        "adminroot")) {

            Statement stmt = con.createStatement();
            int needsAir = (ball.needsAir()) ? 1 : 0;

            String insertSql = "INSERT INTO equipmentBall(type, needsAir, location)"
                    + " VALUES('" +
                    ball.getType() + "', '" +
                    needsAir + "', '" +
                    ball.getLocation().getId() +
                    "')";

            stmt.executeUpdate(insertSql);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<Locker> getAllLockers(){
        ArrayList<Locker> results = new ArrayList<>();

        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?useSSL=false", "root", "adminroot")) {

            Statement stmt = con.createStatement();

            String selectSql = "SELECT * FROM lockers";

            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next()){
                System.out.println(resultSet.getString("location"));
                Locker lock = new Locker();
                lock.setId(resultSet.getInt("id"));
                lock.setLocation(resultSet.getString("location"));
                results.add(lock);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return results;
    }

    public Locker getLocker(int id){
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?useSSL=false", "root", "adminroot")) {

            Statement stmt = con.createStatement();
            String selectLocker = "SELECT * FROM lockers " +
                    "WHERE id='" +
                    id +
                    "'" ;

            ResultSet resultSet = stmt.executeQuery(selectLocker);
            while(resultSet.next()){
                Locker l1 = new Locker();
                l1.setId(resultSet.getInt("id"));
                l1.setLocation(resultSet.getString("location"));
                return l1;
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }

    public ArrayList<Ball> getAllBallsJoin(){
        ArrayList<Ball> results = new ArrayList<>();

        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?useSSL=false", "root", "adminroot")) {

            Statement stmt = con.createStatement();
            String joinSql = "SELECT ball.id, locker.id " +
                    "FROM equipmentBall ball " +
                    "INNER JOIN lockers locker " +
                    "ON ball.location=locker.id";

            ResultSet resultSet = stmt.executeQuery(joinSql);
            while(resultSet.next()){
                int ballId = resultSet.getInt("id");
                Ball b = new Ball(ballId);
                b.setType(resultSet.getString("type"));
                b.setNeedsAir(resultSet.getBoolean("needsAir"));
                Locker l = getLocker(resultSet.getInt("location"));
                b.setLocation(l);
                results.add(b);
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return results;
    }

    public ArrayList<Ball> getAllBalls(){
        ArrayList<Ball> results = new ArrayList<>();
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?useSSL=false", "root", "adminroot")) {
            Statement stmt = con.createStatement();

            String selectSql = "SELECT * FROM equipmentBall";
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next()){
                System.out.println(resultSet.getString("location"));
                int ballId = resultSet.getInt("id");
                Ball ball = new Ball(ballId);
                ball.setType(resultSet.getString("type"));
                ball.setNeedsAir(resultSet.getBoolean("needsAir"));

                Locker l1 = this.getLocker(resultSet.getInt("location"));
                ball.setLocation(l1); // we need to search the appropriate locker.

                results.add(ball);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return results;
    }
}
