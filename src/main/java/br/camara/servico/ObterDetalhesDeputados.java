package br.camara.servico;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.camara.entity.DetalheDeputado;
import br.camara.entity.DetalheDeputado_ID;
import br.camara.ws.Deputados;
import br.camara.ws.DeputadosSoap;

public class ObterDetalhesDeputados {
	
	public List<DetalheDeputado> obterDetalhesDeputados(String idCadastro){
		List<DetalheDeputado> listaDetalhes = new ArrayList<DetalheDeputado>();
		
		Deputados deputados = new Deputados();
		DeputadosSoap soap = deputados.getDeputadosSoap();
		
		Element e = (Element) soap.obterDetalhesDeputado(idCadastro, "").getContent().get(0);
		
		NodeList nList = e.getChildNodes();
		
		for (int i = 0; i < nList.getLength(); i++) {
			
			Node node = nList.item(i);
			System.out.println("Consultando Detalhes...");
			
			if(node.getNodeType() == Node.ELEMENT_NODE){
				DetalheDeputado detalheDeputado = new DetalheDeputado();
				DetalheDeputado_ID detalheDeputado_ID = new DetalheDeputado_ID();
				
				Element eElement = (Element) node;
				
				detalheDeputado_ID.setIdCadastro(Integer.parseInt(eElement.getElementsByTagName("ideCadastro")
						.item(0).getTextContent()));
				detalheDeputado_ID.setNumLegislatura(Integer.parseInt(eElement.getElementsByTagName("numLegislatura")
						.item(0).getTextContent()));
				
				detalheDeputado.setDataNascimento(eElement.getElementsByTagName("dataNascimento")
						.item(0).getTextContent());
				detalheDeputado.setNomeProfissao(eElement.getElementsByTagName("nomeProfissao")
						.item(0).getTextContent());
				
				detalheDeputado.setId(detalheDeputado_ID);
				
				listaDetalhes.add(detalheDeputado);
			}
			
		}
		
		return listaDetalhes;
	}

}
