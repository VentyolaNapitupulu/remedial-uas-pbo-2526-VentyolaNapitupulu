package pbo.f01.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @Column(name = "plate_number", nullable = false, unique = true)
    private String plateNumber;

    @Column(name = "owner", nullable = false)
    private String owner;

    @Column(name = "type", nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name = "parking_area_name")
    private ParkingArea parkingArea;

    public Vehicle() {}

    public Vehicle(String plateNumber, String owner, String type) {
        this.plateNumber = plateNumber;
        this.owner = owner;
        this.type = type;
    }

    public String getPlateNumber() { return plateNumber; }
    public String getOwner() { return owner; }
    public String getType() { return type; }
    public ParkingArea getParkingArea() { return parkingArea; }
    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }
    public void setOwner(String owner) { this.owner = owner; }
    public void setType(String type) { this.type = type; }
    public void setParkingArea(ParkingArea parkingArea) { this.parkingArea = parkingArea; }
}