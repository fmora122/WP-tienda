/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author admin
 */

@Data // implementa getters y setters automaticamente
@Entity
@Table(name = "producto")
public class Producto implements Serializable { /* es necesario crear un id para la serializacion, cuando un valor se guarda 
    en la DB, se escribe un numero de version, cuando los datos se extraen su integridad e revisa contra su codigo de version */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto; // automaticamente se cambia a id_categoria a la hora de comunicarse con la DB
    //private Long idCategoria; // automaticamente se cambia a id_categoria a la hora de comunicarse con la DB
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String rutaImagen; // se cambia a ruta_imagen
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name="id_categoria")
    private Categoria categoria;

    public Producto() {
    }

    public Producto(String descripcion, String detalle, double precio, int existencias, String rutaImagen, boolean activo) {
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
    }
    
    


    
    
    
}