package org.pgr112.lesson13;

import org.pgr112.lesson13.equipment.Ball;
import org.pgr112.lesson13.equipment.Locker;

import java.sql.*;
import java.util.ArrayList;

public class JDBCIntro {
    public static void main(String[] args) {
        JDBCOps operations = new JDBCOps();
        //init(operations);
        ArrayList<Locker> lockers = operations.getAllLockers();
        ArrayList<Ball> balls = operations.getAllBalls();

        for(Ball b : balls){
            System.out.println(b.getEquipId() + " - " + b.getType());
        }

        System.out.println(lockers.size());

    }

    public static void init(JDBCOps ops){
        generateAndInsertLockers(ops);
        ArrayList<Locker> lockers = ops.getAllLockers();
        generateAndInsertBalls(ops, lockers);
    }

    public static void generateAndInsertLockers(JDBCOps ops){
        for (int i = 0; i < 10; i++){
            Locker lock = new Locker();
            lock.setLocation("Locker " + i);
            ops.insertLocker(lock);
        }
    }

    public static void generateAndInsertBalls(JDBCOps ops, ArrayList<Locker> lock){
        int lockerIndex = 0;

       for (int i = 200; i < 220; i++){
            Ball ball = new Ball();
            ball.setType(Ball.getRandomType());
            ball.setNeedsAir(false);
            ball.setLocation(lock.get(lockerIndex));
            if(lockerIndex >= 9) lockerIndex = 0;
            else lockerIndex++;

            ops.insertBall(ball);
        }
    }

    public static void dbGames(String[] args) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException exception){
            exception.printStackTrace();
        }
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?useSSL=false", "root", "adminroot")) {
            // use con here

            Statement stmt = con.createStatement();


            String insertSql = "INSERT INTO lockers(location)"
                    + " VALUES('Locker 1')";
            stmt.executeUpdate(insertSql);

            String selectSql = "SELECT * FROM lockers";

            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next()){
                System.out.println(resultSet.getString("location"));
            }


        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }

}
