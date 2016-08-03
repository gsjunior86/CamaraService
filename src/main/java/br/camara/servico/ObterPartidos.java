package br.camara.servico;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.camara.entity.Partido;
import br.camara.ws.deputados.Deputados;
import br.camara.ws.deputados.DeputadosSoap;

public class ObterPartidos {
	
	public List<Partido> obterPartidos(){
		List<Partido> listaPartidos = new ArrayList<Partido>();
		
		Deputados deputados = new Deputados();
		DeputadosSoap soap = deputados.getDeputadosSoap();
		
		Element e = (Element) soap.obterPartidosCD().getContent().get(0);
		
		NodeList nList = e.getChildNodes();
		
		for (int i = 0; i < nList.getLength(); i++) {
			
			Node node = nList.item(i);
			
			if(node.getNodeType() == Node.ELEMENT_NODE){
				Element eElement = (Element) node;
				Partido partido = new Partido();
				
				partido.setIdPartido(eElement.getElementsByTagName("idPartido")
						.item(0).getTextContent());
				partido.setNomeDoPartido(eElement.getElementsByTagName("nomePartido")
						.item(0).getTextContent());
				partido.setDataCriacao(eElement.getElementsByTagName("dataCriacao")
						.item(0).getTextContent());
				partido.setDataExtincao(eElement.getElementsByTagName("dataExtincao")
						.item(0).getTextContent());
				
				listaPartidos.add(partido);
			}
		}
		
		
		return listaPartidos;
	}

}
