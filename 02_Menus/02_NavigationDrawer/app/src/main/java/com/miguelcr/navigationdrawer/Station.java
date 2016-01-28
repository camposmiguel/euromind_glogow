package com.miguelcr.navigationdrawer;

/**
 * Created by miguelcampos on 26/1/16.
 */
public class Station {
    String name;
    boolean trainConnection;
    boolean trampConnection;
    boolean busConnection;
    boolean parking;
    int zone;
    int icon;
    double lat, lon;

    public Station(String name, boolean trampConnection, boolean busConnection, boolean parking, boolean trainConnection, int zone, int icon, double lat, double lon) {
        this.name = name;
        this.trainConnection = trainConnection;
        this.trampConnection = trampConnection;
        this.busConnection = busConnection;
        this.parking = parking;
        this.zone = zone;
        this.icon = icon;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTrainConnection() {
        return trainConnection;
    }

    public void setTrainConnection(boolean trainConnection) {
        this.trainConnection = trainConnection;
    }

    public boolean isTrampConnection() {
        return trampConnection;
    }

    public void setTrampConnection(boolean trampConnection) {
        this.trampConnection = trampConnection;
    }

    public boolean isBusConnection() {
        return busConnection;
    }

    public void setBusConnection(boolean busConnection) {
        this.busConnection = busConnection;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
