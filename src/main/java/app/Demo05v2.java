package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05v2 {
	
	// "eliminar logicamente" --> cambiando el estado
	public static void main(String[] args) {
		// conexion
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
				EntityManager em = fabrica.createEntityManager();
				
				// proceso --> consulta --> select * from tb_xx where xxx -> objeto de usuario
				Usuario u = em.find(Usuario.class, 10);
						
				if (u == null) {
					System.out.println("Usuario no encontrado");
				} else {
					// proceso -> cambiar el estado
					u.setEstado(2);
					em.getTransaction().begin();
					em.merge(u);
					System.out.println("Usuario Deshabilitado");
					em.getTransaction().commit();
				}
						
				em.close();
	}

}
