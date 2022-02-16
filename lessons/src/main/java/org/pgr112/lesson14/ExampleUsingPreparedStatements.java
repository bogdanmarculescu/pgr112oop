package org.pgr112.lesson14;

import org.pgr112.lesson14.equipment.Ball;
import org.pgr112.lesson14.equipment.Locker;

import java.sql.*;
import java.util.ArrayList;

public class ExampleUsingPreparedStatements {
    public static void main(String[] args) {
        ExampleUsingPreparedStatements prep = new ExampleUsingPreparedStatements();
        prep.trickyInjection();

        prep.deflation();
    }

    public void deflation(){
        ArrayList<Ball> ball1 = getBalls();
        System.out.println("BEFORE DEFLATION");
        for (Ball b1 : ball1){
            System.out.println("-> " + b1.getEquipId() + " -> " + b1.getType() + " -> " + b1.needsAir() + " ; From: " + b1.getLocation().getId());
        }
        ArrayList<Integer> deflation = new ArrayList<>();
        deflation.add(1);
        deflation.add(3);
        deflateInLockers(deflation);

        ball1 = getBalls();
        System.out.println("After DEFLATION");
        for (Ball b1 : ball1){
            System.out.println("-> " + b1.getEquipId() + " -> " + b1.getType() + " -> " + b1.needsAir() + " ; From: " + b1.getLocation().getId());
        }
    }

    public void trickyInjection() {
        //Getting past checks
        ArrayList<Locker> lockersAtAddress = getLockersWithAddress("Address 0' or '1' = '1");
        System.out.println("I'm expecting one or Two lockers, with the same address");
        for(Locker l : lockersAtAddress){
            System.out.println(l.getId() + " ->" + l.getAddress());
        }

        // Potentially dropping tables
        ArrayList<Locker> lockersAtAddress2 = getLockersWithAddress("Address 0'; DROP TABLE equipmentBall ; -- 'just commenting, yeah");


        System.out.println("== But does the correct version work? - again expecting one or two lockers");
        ArrayList<Locker> lockersAtAddress3 = getLockersWithAddress("Address 0");
        for(Locker l : lockersAtAddress3){
            System.out.println(l.getId() + " ->" + l.getAddress());
        }
    }

    public ArrayList<Ball> getBalls(){
        ArrayList<Ball> result = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?useSSL=false", "root", "adminroot");
            Statement stms = con.createStatement();
            ResultSet rs = stms.executeQuery("SELECT * FROM equipmentBall");
            while (rs.next()){
                Ball b = new Ball();
                b.setType(rs.getString("type"));
                b.setNeedsAir(rs.getBoolean("needsAir"));
                b.setEquipId(rs.getInt("id"));
                Locker l = new Locker();
                l.setId(rs.getInt("location"));
                b.setLocation(l);

                result.add(b);
            }

        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return result;
    }

    public ArrayList<Locker> getLockersWithAddress(String address){
        ArrayList<Locker>  result = new ArrayList<>();
        String preparedSelect = "SELECT * FROM lockers WHERE address = ?";
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?useSSL=false", "root", "adminroot");
            con.setAutoCommit(false);

            PreparedStatement statement = con.prepareStatement(preparedSelect);
            statement.setString(1, address);

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Locker l1 = new Locker();
                l1.setId(resultSet.getInt("id"));
                l1.setAddress(resultSet.getString("address"));
                l1.setLocation(resultSet.getString("location"));
                result.add(l1);
            }
            con.commit();

        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return result;
    }


    public void deflateInLockers(ArrayList<Integer> lockers){
        String preparedUpdate = "UPDATE equipmentBall SET needsAir = ? WHERE location = ?";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?useSSL=false", "root", "adminroot");
            con.setAutoCommit(false);

            for(Integer lockerId : lockers){
                PreparedStatement statement = con.prepareStatement(preparedUpdate);
                statement.setInt(1, 1);
                statement.setInt(2, lockerId);

                statement.executeUpdate();
                con.commit();
            }

        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

    }

}
