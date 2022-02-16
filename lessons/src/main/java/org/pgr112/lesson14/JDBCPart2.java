package org.pgr112.lesson14;

import org.pgr112.lesson14.equipment.Ball;
import org.pgr112.lesson14.equipment.Locker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBCPart2 {
}

class TransactionRollback{
    public static void main(String[] args) {

        //JDBCOps operations = new JDBCOps();
        //TrickyInjection.init(operations);

        TransactionRollback trb = new TransactionRollback();

        trb.buyNewBallInNewLocker();
        trb.buyNewBallInExistingLocker();
    }

    public void buyNewBallInExistingLocker(){
        Locker l1 = JDBCOps.getLocker(2);

        Ball b1 = new Ball();
        b1.setType("Ball With Locker");
        b1.setNeedsAir(false);
        b1.setReplace(false);
        b1.setLocation(l1);

        this.buyNewBall(b1);
    }

    public void buyNewBallInNewLocker(){
        Locker l1 = new Locker();
        l1.setAddress("New Address");
        l1.setLocation("new Location");

        Ball b1 = new Ball();
        b1.setType("Ball Without Locker");
        b1.setNeedsAir(false);
        b1.setReplace(false);
        b1.setLocation(l1);

        this.buyNewBall(b1);
    }

    public boolean buyNewBall(Ball ball){
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?useSSL=false",
                        "root",
                        "adminroot")) {
            // Let's handle commits on our own
            con.setAutoCommit(false);
            Statement stmt = con.createStatement();

            if(ball.getLocation().getId() != -1) {
                // If the locker does not have an id, let's insert it in the DB
                String insertLocker = "INSERT INTO lockers(location, address)"
                        + " VALUES('" +
                        ball.getLocation().getLocation() + "', '" +
                        ball.getLocation().getAddress() +
                        "')";

                stmt.executeUpdate(insertLocker);
            }

            int needsAir = (ball.needsAir()) ? 1 : 0;

            String insertBall = "INSERT INTO equipmentBall(type, needsAir, location)"
                    + " VALUES('" +
                    ball.getType() + "', '" +
                    needsAir + "', '" +
                    ball.getLocation().getId() +
                    "')";

            int result = stmt.executeUpdate(insertBall);

            if(ball.getLocation().getId() == -1){
                // well, coach can't just build lockers.
                con.rollback();
            }
            else{
                con.commit();
            }

        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }

        return false;
    }
}


class TrickyInjection{
    public static void main(String[] args) {
        TrickyInjection tricky = new TrickyInjection();
        JDBCOps operations = new JDBCOps();

        // Initialize (if needed only)
        //tricky.init();
        tricky.trickyInjection(operations);
    }
    public void trickyInjection(JDBCOps operations) {
        ArrayList<Locker> lockers = operations.getAllLockers();
        ArrayList<Ball> balls = operations.getAllBalls();

        for(Ball b : balls){
            System.out.println(b.getEquipId() + " - " + b.getType());
        }

        //Getting past checks
        ArrayList<Locker> lockersAtAddress = operations.getLockersWithAddress("Address0' or '1' = '1");
        System.out.println("I'm expecting one or Two lockers, with the same address");
        for(Locker l : lockersAtAddress){
            System.out.println(l.getId() + " ->" + l.getAddress());
        }

        // Potentially dropping tables
        ArrayList<Locker> lockersAtAddress2 = operations.getLockersWithAddress("Address0'; DROP TABLE equipmentBall ; -- 'just commenting, yeah");
        trickyOperation(operations);
        System.out.println(lockers.size());

    }

    public static void trickyOperation(JDBCOps operations){
        Locker trickyLocker = new Locker();
        trickyLocker.setLocation("'; DROP TABLE equipmentBall -- comments");
        trickyLocker.setAddress("Modified address");
        Locker success = operations.updateAddressByLocation(trickyLocker);
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
            lock.setAddress("Address " + i);
            boolean result = ops.insertLocker(lock);
            if(result) System.out.println("successfully inserted :" + lock.getLocation());
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
}
