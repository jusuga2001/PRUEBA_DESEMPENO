package entity;

public class Vacante {

    private int id_vacante;
    private String titulo;
    private String descripcion;
    private String duracion;
    private String estado;
    private int id_empresa;
    private Empresa empresa;
    private String tecnologia;

    public Vacante() {
    }

    public Vacante(int id_vacante, String titulo, String descripcion, String duracion, String estado, int id_empresa, Empresa empresa, String tecnologia) {
        this.id_vacante = id_vacante;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.estado = estado;
        this.id_empresa = id_empresa;
        this.empresa = empresa;
        this.tecnologia = tecnologia;
    }

    public int getId_vacante() {
        return id_vacante;
    }

    public void setId_vacante(int id_vacante) {
        this.id_vacante = id_vacante;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    @Override
    public String toString() {
        return "Vacante{" +
                "id_vacante=" + id_vacante +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", duracion='" + duracion + '\'' +
                ", estado='" + estado + '\'' +
                ", id_empresa=" + id_empresa +
                ", empresa=" + empresa +
                ", tecnologia='" + tecnologia + '\'' +
                '}';
    }
}
