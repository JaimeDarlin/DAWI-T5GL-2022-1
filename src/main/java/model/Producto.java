package model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "tb_productos")
@Data
public class Producto {

	@Id
	@Column(name = "id_prod")
	private String codigo;				// id_prod char(5) not null,
	
	@Column(name = "des_prod")
	private String descripcion;		// des_prod varchar(45) not null,
	
	@Column(name = "stk_prod")
	private int stock;				// stk_prod int,
	
	@Column(name = "pre_prod")
	private double precio;			// pre_prod decimal(8,2) not null,
	
	@Column(name = "idcategoria")
	private int categogia;			// idcategoria int,
	
	@Column(name = "est_prod")
	private int estado;				// est_prod boolean, --> True = 1  /  False = 2
	
	@Column(name = "idproveedor")
	private int proveedor;			// idprovedor int,

	
	@ManyToOne
	@JoinColumn(name = "idcategoria", insertable = false, updatable = false)
	private Categoria objCategoria;
	
	@ManyToOne
	@JoinColumn(name = "idproveedor", insertable = false, updatable = false)
	private Proveedor objProveedor;
}


