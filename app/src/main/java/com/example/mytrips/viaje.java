package com.example.mytrips;

public class viaje {

    private String pais;
    private String ciudad;
    private String desplazamiento;
    private String fecha_ida;
    private String fecha_vuelta;
    private String tipo_alojamiento;
    private int imagenViaje;

    public viaje(int imagenViaje,String pais, String ciudad, String desplazamiento, String fecha_ida, String fecha_vuelta, String tipo_alojamiento) {
        this.imagenViaje= imagenViaje;
        this.pais = pais;
        this.ciudad = ciudad;
        this.desplazamiento = desplazamiento;
        this.fecha_ida = fecha_ida;
        this.fecha_vuelta = fecha_vuelta;
        this.tipo_alojamiento = tipo_alojamiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDesplazamiento() {
        return desplazamiento;
    }

    public void setDesplazamiento(String desplazamiento) {
        this.desplazamiento = desplazamiento;
    }

    public String getFecha_ida() {
        return fecha_ida;
    }

    public void setFecha_ida(String fecha_ida) {
        this.fecha_ida = fecha_ida;
    }

    public String getFecha_vuelta() {
        return fecha_vuelta;
    }

    public void setFecha_vuelta(String fecha_vuelta) {
        this.fecha_vuelta = fecha_vuelta;
    }

    public String getTipo_alojamiento() {
        return tipo_alojamiento;
    }

    public void setTipo_alojamiento(String tipo_alojamiento) {
        this.tipo_alojamiento = tipo_alojamiento;
    }

    public int getImagenViaje() {
        return imagenViaje;
    }

    public void setImagenViaje(int imagenViaje) {
        this.imagenViaje = imagenViaje;
    }
}
