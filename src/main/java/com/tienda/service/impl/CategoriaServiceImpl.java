/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service.impl;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
// Define la logica de los metodos de la interfaz que implementa
@Service
public class CategoriaServiceImpl implements CategoriaService {

    //inyeccion
    @Autowired // a pesar de que no se uso "new" para inicializar el objeto, "autowired" automaticamente crea una instancia
    private CategoriaDao categoriaDao;
            
    @Override
    public List<Categoria> getCategorias(boolean activos) {
        List<Categoria> lista = categoriaDao.findAll();
        // Filtrar solo los activos 
        if(activos) {
            lista.removeIf(cat -> !cat.isActivo()); // esto es un predicado o expresion lambda segun otros lenguajes.
        }
        return lista;
    }
    
}
