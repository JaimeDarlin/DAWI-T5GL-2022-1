package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {
	
	// eliminar un usuario pero obteniendo su informacion segun el codigo
	public static void main(String[] args) {
		// conexion
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		// proceso --> consulta --> select * from tb_xx where xxx -> objeto de usuario
		Usuario u = em.find(Usuario.class, 20);
				
		if (u == null) {
			System.out.println("Usuario no encontrado");
		} else {
			// proceso -> registrar, actualizar, eliminar --> transacciones
			em.getTransaction().begin();
			em.remove(u); // busca --> solo lo elimina si encuentra el objeto!!
			System.out.println("Usuario Eliminado");
			em.getTransaction().commit();
		}
				
		em.close();
	}

}
