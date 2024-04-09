package entity;

public class Contratacion {
    private int id_contratacion;
    private String fecha_aplicacion;
    private String estado;
    private double salario;
    private int id_vacante;
    private int id_coder;
    private Vacante vacante;
    private Coder coder;

    public Contratacion() {
    }

    public Contratacion(int id_contratacion, String fecha_aplicacion, String estado, double salario, int id_vacante, int id_coder, Vacante vacante, Coder coder) {
        this.id_contratacion = id_contratacion;
        this.fecha_aplicacion = fecha_aplicacion;
        this.estado = estado;
        this.salario = salario;
        this.id_vacante = id_vacante;
        this.id_coder = id_coder;
        this.vacante = vacante;
        this.coder = coder;
    }

    public int getId_contratacion() {
        return id_contratacion;
    }

    public void setId_contratacion(int id_contratacion) {
        this.id_contratacion = id_contratacion;
    }

    public String getFecha_aplicacion() {
        return fecha_aplicacion;
    }

    public void setFecha_aplicacion(String fecha_aplicacion) {
        this.fecha_aplicacion = fecha_aplicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getId_vacante() {
        return id_vacante;
    }

    public void setId_vacante(int id_vacante) {
        this.id_vacante = id_vacante;
    }

    public int getId_coder() {
        return id_coder;
    }

    public void setId_coder(int id_coder) {
        this.id_coder = id_coder;
    }

    public Vacante getVacante() {
        return vacante;
    }

    public void setVacante(Vacante vacante) {
        this.vacante = vacante;
    }

    public Coder getCoder() {
        return coder;
    }

    public void setCoder(Coder coder) {
        this.coder = coder;
    }

    @Override
    public String toString() {
        return "Contratacion{" +
                "id_contratacion=" + id_contratacion +
                ", fecha_aplicacion='" + fecha_aplicacion + '\'' +
                ", estado='" + estado + '\'' +
                ", salario=" + salario +
                ", id_vacante=" + id_vacante +
                ", id_coder=" + id_coder +
                ", vacante=" + vacante +
                ", coder=" + coder +
                '}';
    }
}
