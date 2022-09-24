package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {

	// obtener toda la informacion de un usuario segun su codigo
	public static void main(String[] args) {
		// conexion
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		// proceso --> consulta --> select * from tb_xx where xxx -> objeto de usuario
		Usuario u = em.find(Usuario.class, 20);
		
		if (u == null) {
			System.out.println("Usuario no encontrado");
		} else {
			System.out.println("Usuario encontrado");
			System.out.println(u);
		}
		
		em.close();
	}
}
