package com.IS17B.Restoranas.restoranas.Model;

public class Table {
    private Integer id;
    private Integer idEmployee;
    private Integer idClient;

    public Table(){

    }

    public Table(Integer id, Integer idEmployee, Integer idClient) {
        this.id = id;
        this.idEmployee = idEmployee;
        this.idClient = idClient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString(){
        return "Table id: " + id + " Employee id: " + idEmployee + " Client id: " + idClient;
    }
}
