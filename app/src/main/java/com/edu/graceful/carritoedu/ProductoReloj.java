package com.edu.graceful.carritoedu;

public class ProductoReloj {

    private String Descripcion;
    private String Marca;
    private String Stock;
    private String Uso;
    private String Valor;



    public ProductoReloj() {
    }


    public String getDescripcion() {
        return Descripcion;
    }
    public String getCodigo(){
        String codigo =Stock.toLowerCase();
        return codigo;
    }


    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }

    public String getMarca() {
        return Marca;
    }


    public void setMarca(String marca) {
        this.Marca = marca;
    }

    public  String getStock() {
        return Stock;
    }

    public void setStock(String stock) {
        this.Stock = stock;
    }

    public String getUso() {
        return Uso;
    }

    public void setUso(String uso) {
        this.Uso= uso;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        this.Valor = valor;
    }

    public ProductoReloj(String descripcion, String marca, String stock, String uso,String valor) {
        this.Descripcion = descripcion;
        this.Marca = marca;
        this.Stock = stock;
        this.Uso = uso;
        this.Valor = valor;
    }
}