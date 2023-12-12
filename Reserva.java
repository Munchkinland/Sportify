public class Reserva {
    private String deporte;
    private String localidad;
    private String turno;
    private double precio;

    public Reserva(String deporte, String localidad, String turno, double precio) {
        this.deporte = deporte;
        this.localidad = localidad;
        this.turno = turno;
        this.precio = precio;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "deporte='" + deporte + '\'' +
                ", localidad='" + localidad + '\'' +
                ", turno='" + turno + '\'' +
                ", precio=" + precio +
                '}';
    }
}
