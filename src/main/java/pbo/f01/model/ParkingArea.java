package pbo.f01.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parking_area")
public class ParkingArea {

    @Id
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "allowed_type", nullable = false)
    private String allowedType;

    @OneToMany(mappedBy = "parkingArea", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vehicle> vehicles = new ArrayList<>();

    public ParkingArea() {}

    public ParkingArea(String name, int capacity, String allowedType) {
        this.name = name;
        this.capacity = capacity;
        this.allowedType = allowedType;
    }

    public String getName() { return name; }
    public int getCapacity() { return capacity; }
    public String getAllowedType() { return allowedType; }
    public List<Vehicle> getVehicles() { return vehicles; }
    public void setName(String name) { this.name = name; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setAllowedType(String allowedType) { this.allowedType = allowedType; }
    public void setVehicles(List<Vehicle> vehicles) { this.vehicles = vehicles; }
}