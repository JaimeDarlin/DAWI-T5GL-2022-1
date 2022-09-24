package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {
	
	// actualizar los datos del usuario ingresado
	public static void main(String[] args) {
		// conexion
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		// proceso -> registrar, actualizar, eliminar --> transacciones
		em.getTransaction().begin();
		
		// objeto a actualizar
		// Usuario u = new Usuario(10, "Juan", "Perez", "jperez", "123", "2000/10/05", 1, 1);
		Usuario u = new Usuario(10, "Juan Carlos", "Perez Lopez", "jperezlo", "j789", "2000/10/05", 2, 1, null);
		em.merge(u); // busca ID --> actualiza si existe / registra si no existe!!!
		
		System.out.println("Usuario actualizado");
		
		em.getTransaction().commit();
		
		em.close();
		
	}

}
