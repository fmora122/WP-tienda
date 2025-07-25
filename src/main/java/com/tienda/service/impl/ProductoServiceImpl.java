/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service.impl;

import com.tienda.dao.ProductoDao;
import com.tienda.domain.Producto;
import com.tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */
// Define la logica de los metodos de la interfaz que implementa
@Service
public class ProductoServiceImpl implements ProductoService {

    //inyeccion
    @Autowired // a pesar de que no se uso "new" para inicializar el objeto, "autowired" automaticamente crea una instancia
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        List<Producto> lista = productoDao.findAll();
        // Filtrar solo los activos 
        if (activos) {
            lista.removeIf(cat -> !cat.isActivo()); // esto es un predicado o expresion lambda segun otros lenguajes.
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null); // el ".orElse" use usa para determinal que accion tomar si el primer metodo no logra retornar un id
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.deleteById(producto.getIdProducto());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup) {
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }

    @Override
    public List<Producto> buscarPorParteDescripcion(String termino) {
        return productoDao.findByDescripcionContainingIgnoreCase(termino);
    }
    
    @Override
    @Transactional(readOnly=true)    
    public List<Producto> metodoJPQL(double precioInf, double precioSup) {
        return productoDao.metodoJPQL(precioInf, precioSup);
    }
    
    @Override
    @Transactional(readOnly=true)    
    public List<Producto> metodoNativo(double precioInf, double precioSup) {
        return productoDao.metodoNativo(precioInf, precioSup);
    }
    
    // Tarea
    @Override
    @Transactional(readOnly=true) 
    public List<Producto> findByExistenciasGreaterThanEqual (int num){
        return productoDao.findByExistenciasGreaterThanEqual(num);
    }

}
