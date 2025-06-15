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
@Table(name = "categoria")
public class Categoria implements Serializable { /* es necesario crear un id para la serializacion, cuando un valor se guarda 
    en la DB, se escribe un numero de version, cuando los datos se extraen su integridad e revisa contra su codigo de version */
    private static long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria; // automaticamente se cambia a id_categoria a la hora de comunicarse con la DB
    private String descripcion;
    private String rutaImagen; // se cambia a ruta_imagen
    private boolean activo;

    public Categoria() {
    }

    public Categoria(String descripcion, String rutaImagen, boolean activo) {
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
    }
    
    
    
}