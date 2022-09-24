package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {
	
	// eliminar un usuario
	public static void main(String[] args) {
		// conexion
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
				
		// proceso -> registrar, actualizar, eliminar --> transacciones
		em.getTransaction().begin();
		
		// objeto de usuario a eliminar
		Usuario u = new Usuario();
		u.setCodigo(20);
		em.remove(u); // busca --> solo lo elimina si encuentra el objeto!!
		
		System.out.println("Usuario Eliminado");
		
		em.getTransaction().commit();
		
		em.close();
	}

}
