package com.tanklab.bean;

import javax.persistence.*;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "device_id")
    int device_id;
    @Column(name = "device_name")
    String device_name;
    @Column(name = "device_description")
    String device_description;
    @Column(name = "price")
    double price;
    @Column(name = "lng")
    double lng;
    @Column(name = "lat")
    double lat;
    @Column(name = "owner_id")
    int owner_id;
    @Column(name = "current_status")
    int current_status;

    public Device() { }

    public Device(int device_id, String device_name, String device_description, double price, double lng, double lat, int owner_id, int current_status) {
        this.device_id = device_id;
        this.device_name = device_name;
        this.device_description = device_description;
        this.price = price;
        this.lng = lng;
        this.lat = lat;
        this.owner_id = owner_id;
        this.current_status = current_status;
    }

    public Device(int id, int device_id, String device_name, String device_description, double price, double lng, double lat, int owner_id, int current_status) {
        this(device_id, device_name, device_description, price, lng, lat, owner_id, current_status);
        this.id = id;
    }

    public int getDevice_id() {
        return device_id;
    }

    public void setDevice_id(int device_id) {
        this.device_id = device_id;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getDevice_description() {
        return device_description;
    }

    public void setDevice_description(String device_description) {
        this.device_description = device_description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public int getCurrent_status() {
        return current_status;
    }

    public void setCurrent_status(int current_status) {
        this.current_status = current_status;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", device_id=" + device_id +
                ", device_name='" + device_name + '\'' +
                ", device_description='" + device_description + '\'' +
                ", price=" + price +
                ", lng=" + lng +
                ", lat=" + lat +
                ", owner_id=" + owner_id +
                ", current_status=" + current_status +
                '}';
    }

    public String toJsonString() {
        return "{" +
                "\"device_id\":" + device_id +
                ", \"device_name\":\"" + device_name + '\"' +
                ", \"device_description\":\"" + device_description + '\"' +
                ", \"price\":" + price +
                ", \"lng\":" + lng +
                ", \"lat\":" + lat +
                ", \"owner_id\":" + owner_id +
                ", \"current_status\":" + current_status +
                '}';
    }
}
