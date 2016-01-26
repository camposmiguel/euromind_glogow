package com.salesianostriana.dam.di.recycleview;

/**
 * Created by miguelcampos on 28/10/15.
 */
public class ItemStation {
    private String stationName;
    private String stationType;
    private int imagen;
    private int puntuacion;

    public ItemStation(String name, String type, int imagen, int puntuacion) {
        this.stationName = name;
        this.stationType = type;
        this.imagen = imagen;
        this.puntuacion = puntuacion;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationType() {
        return stationType;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
