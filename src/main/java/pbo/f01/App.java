package pbo.f01;

import jakarta.persistence.*;
import pbo.f01.model.ParkingArea;
import pbo.f01.model.Vehicle;
import java.util.*;
import java.util.logging.*;

public class App {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void main(String[] args) {
        // Matikan semua log Hibernate
        LogManager.getLogManager().reset();
        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(Level.OFF);

        emf = Persistence.createEntityManagerFactory("parkit-pu");
        em = emf.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split("#");
            String command = parts[0];
            switch (command) {
                case "area-add":
                    handleAreaAdd(parts);
                    break;
                case "vehicle-add":
                    handleVehicleAdd(parts);
                    break;
                case "park":
                    handlePark(parts);
                    break;
                case "display-all":
                    handleDisplayAll();
                    break;
            }
        }

        em.close();
        emf.close();
    }

    private static void handleAreaAdd(String[] parts) {
        String name = parts[1];
        int capacity = Integer.parseInt(parts[2]);
        String allowedType = parts[3];
        em.getTransaction().begin();
        ParkingArea area = new ParkingArea(name, capacity, allowedType);
        em.persist(area);
        em.getTransaction().commit();
    }

    private static void handleVehicleAdd(String[] parts) {
        String plateNumber = parts[1];
        String owner = parts[2];
        String type = parts[3];
        em.getTransaction().begin();
        Vehicle vehicle = new Vehicle(plateNumber, owner, type);
        em.persist(vehicle);
        em.getTransaction().commit();
    }

    private static void handlePark(String[] parts) {
        String plateNumber = parts[1];
        String areaName = parts[2];
        Vehicle vehicle = em.find(Vehicle.class, plateNumber);
        if (vehicle == null) return;
        ParkingArea area = em.find(ParkingArea.class, areaName);
        if (area == null) return;
        if (!vehicle.getType().equals(area.getAllowedType())) return;
        long count = em.createQuery(
            "SELECT COUNT(v) FROM Vehicle v WHERE v.parkingArea = :area", Long.class)
            .setParameter("area", area)
            .getSingleResult();
        if (count >= area.getCapacity()) return;
        em.getTransaction().begin();
        vehicle.setParkingArea(area);
        em.merge(vehicle);
        em.getTransaction().commit();
    }

    private static void handleDisplayAll() {
        List<ParkingArea> areas = em.createQuery(
            "SELECT a FROM ParkingArea a ORDER BY a.name ASC", ParkingArea.class)
            .getResultList();
        for (ParkingArea area : areas) {
            List<Vehicle> vehicles = em.createQuery(
                "SELECT v FROM Vehicle v WHERE v.parkingArea = :area ORDER BY v.plateNumber ASC",
                Vehicle.class)
                .setParameter("area", area)
                .getResultList();
            System.out.println(area.getName() + " " + area.getAllowedType() + " "
                + area.getCapacity() + "|" + vehicles.size());
            for (Vehicle v : vehicles) {
                System.out.println(v.getPlateNumber() + " " + v.getOwner() + " " + v.getType());
            }
        }
    }
}
