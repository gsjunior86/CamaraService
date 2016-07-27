package br.camara.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.camara.entity.Deputado;
import br.camara.entity.Partido;
import br.camara.servico.ObterDeputados;
import br.camara.servico.ObterPartidos;

public class SalvaDados {
	
	public static void main(String[] args) {
		List<Deputado> listaDeputados = new ObterDeputados().obterDeputados();
		List<Partido> listaPartidos = new ObterPartidos().obterPartidos();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("camara");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		for(Deputado deputado: listaDeputados){
			
			manager.persist(deputado);
		}
		
		for(Partido partido : listaPartidos){
			manager.persist(partido);
		}
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		
	}

}
