package Model.Entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class LogAcess {

    //Atributos
    private String name;
    private LocalDateTime hora;

    //Equals
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LogAcess logAcess = (LogAcess) o;
        return Objects.equals(name, logAcess.name);
    }

    //HashCode
    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    //Construtor
    public LogAcess(String name, LocalDateTime hora) {
        this.name = name;
        this.hora = hora;
    }

    //Getters e Setters
    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //ToString para exibir a coleção
    @Override
    public String toString() {
        return "LogAcess{" +
                "Name='" + name + '\'' +
                ", Data=" + hora +
                '}';
    }
}
