package com.printec.cars;

import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {


    private CarService() {}

    public List<Car> loadAllCars()
    {
        List<Car> cars = new ArrayList<>();


        Connection pDB = null;

        try
        {
            pDB = DriverManager.getConnection(Config.connectionString, Config.connectionUsername,Config.connectionPassword);

            String sSql = "SELECT * FROM cars.car";



            PreparedStatement statement = pDB.prepareStatement(sSql);

            ResultSet set = statement.executeQuery();

            PreparedStatement statement2;
            ResultSet set2;
            String sql2;

            while(set.next())
            {
                sql2 = "SELECT * FROM cars.owner WHERE owner_id = " + set.getInt("car_owner_id");
                statement2 = pDB.prepareStatement(sql2);
                set2 = statement2.executeQuery();
                Owner owner = new Owner();
                if(set2.next()) {
                    owner.setFirstName(set2.getString("owner_first_name"));
                    owner.setLastName(set2.getString("owner_last_name"));
                }
                else continue;

                Car car = new Car(set.getInt("car_id"), owner,new Model(set.getString("car_model")), new Brand(set.getString("car_brand")),
                        set.getString("car_registration_number"), set.getDouble("car_engine_capacity"), set.getString("car_color"),
                        set.getDouble("car_horsepower"));

                cars.add(car);

            }
        }
        catch(Exception e)
        {
            System.out.println("ERROR SETTING CAR INFO" + e.getMessage());
            return null;
        }
        finally {
            try {
                pDB.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        
        
        return cars;
    }

    public Car loadCarById(int id)
    {
        Car car;
        Connection pDB = null;

        try
        {
            pDB = DriverManager.getConnection(Config.connectionString, Config.connectionUsername,Config.connectionPassword);

            String sSql = "SELECT * FROM cars.car WHERE car_id = " + id;



            PreparedStatement statement = pDB.prepareStatement(sSql);

            ResultSet set = statement.executeQuery();

            PreparedStatement statement2;
            ResultSet set2;
            String sql2;

            if(set.next())
            {
                sql2 = "SELECT * FROM cars.owner WHERE owner_id = " + set.getInt("car_owner_id");
                statement2 = pDB.prepareStatement(sql2);
                set2 = statement2.executeQuery();
                Owner owner = new Owner();
                if(set2.next()) {
                    owner.setFirstName(set2.getString("owner_first_name"));
                    owner.setLastName(set2.getString("owner_last_name"));
                }
                else
                {
                    return null;
                }

                car = new Car(id, owner,new Model(set.getString("car_model")), new Brand(set.getString("car_brand")),
                        set.getString("car_registration_number"), set.getDouble("car_engine_capacity"), set.getString("car_color"),
                        set.getDouble("car_horsepower"));

            }
            else
            {
                return null;
            }
        }
        catch(Exception e)
        {
            System.out.println("ERROR SETTING CAR INFO" + e.getMessage());
            return null;
        }
        finally {
            try {
                pDB.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return car;
    }

    public Car loadCarByBrand(String brand)
    {
        Car car;


        Connection pDB = null;

        try
        {
            pDB = DriverManager.getConnection(Config.connectionString, Config.connectionUsername,Config.connectionPassword);

            String sSql = "SELECT * FROM cars.car WHERE car_brand = '" + brand + "'";



            PreparedStatement statement = pDB.prepareStatement(sSql);

            ResultSet set = statement.executeQuery();

            PreparedStatement statement2;
            ResultSet set2;
            String sql2;

            if(set.next())
            {
                sql2 = "SELECT * FROM cars.owner WHERE owner_id = " + set.getInt("car_owner_id");
                statement2 = pDB.prepareStatement(sql2);
                set2 = statement2.executeQuery();
                Owner owner = new Owner();
                if(set2.next()) {
                    owner.setFirstName(set2.getString("owner_first_name"));
                    owner.setLastName(set2.getString("owner_last_name"));
                }
                else
                {
                    return null;
                }

                car = new Car(set.getInt("car_id"), owner,new Model(set.getString("car_model")), new Brand(brand),
                        set.getString("car_registration_number"), set.getDouble("car_engine_capacity"), set.getString("car_color"),
                        set.getDouble("car_horsepower"));

            }
            else
            {
                return null;
            }
        }
        catch(Exception e)
        {
            System.out.println("ERROR SETTING CAR INFO" + e.getMessage());
            return null;
        }
        finally {
            try {
                pDB.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return car;
    }

    public static boolean addCar(Car car)
    {
        Connection pDB = null;

        try
        {
            pDB = DriverManager.getConnection(Config.connectionString, Config.connectionUsername,Config.connectionPassword);

            String sql = "INSERT INTO cars.owner (owner_first_name, owner_last_name)" +
                    " VALUES ('" + car.getCarOwner().getFirstName() + "','" + car.getCarOwner().getLastName() + "') RETURNING owner_id";

            int ownerId = 0;
            PreparedStatement statement = pDB.prepareStatement(sql);

            ResultSet set = statement.executeQuery();

            if(set.next()) {
             ownerId = set.getInt("owner_id");
            }
            else
            {
                return false;
            }

            sql = "INSERT INTO cars.car (car_owner_id, car_model, car_brand,car_registration_number,car_engine_capacity,car_horsepower,car_color)" +
                    "VALUES (" + ownerId + ",'"+ car.getCarModel().getModelName() + "','" + car.getCarBrand().getBrandName() + "','" + car.getRegNumber()
                    + "'," +car.getEngineCapacity() + "," + car.getHorsepower() + ",'" + car.getColor() + "')";

            statement = pDB.prepareStatement(sql);

            statement.executeUpdate();


        }
        catch(Exception e)
        {
            System.out.println("ERROR SETTING CAR INFO" + e.getMessage());
            return false;
        }
        finally {
            try {
                pDB.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return true;
    }

    public static boolean deleteCar(int id)
    {
        Connection pDB = null;

        try
        {
            pDB = DriverManager.getConnection(Config.connectionString, Config.connectionUsername,Config.connectionPassword);

            String sql = "DELETE FROM cars.car WHERE car_id = " + id;

            PreparedStatement statement = pDB.prepareStatement(sql);

            statement.executeUpdate();


        }
        catch(Exception e)
        {
            System.out.println("ERROR SETTING CAR INFO" + e.getMessage());
            return false;
        }
        finally {
            try {
                pDB.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return true;
    }

}
