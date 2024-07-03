/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Nico
 * Created: 2 jul 2024
 */

CREATE TABLE IF NOT EXISTS Producto (
    ID INT PRIMARY KEY,
    PRECIO_UNITARIO DECIMAL(10,2),
    DESCRIPCION VARCHAR(100),
    TITULO VARCHAR(100),
    CODIGO VARCHAR(100) UNIQUE,
    PROVEEDOR VARCHAR(100),
    CATEGORIA VARCHAR(100),
    HABILITADO BOOLEAN
)