package br.camara.servico;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.camara.entity.Deputado;
import br.camara.entity.DetalheDeputado;
import br.camara.ws.Deputados;
import br.camara.ws.DeputadosSoap;

public class ObterDeputados {
	
	public List<Deputado> obterDeputados() {
		
		Deputados deputados = new Deputados();
		DeputadosSoap soap = deputados.getDeputadosSoap();
		
		List<Deputado> listaDeputados = new ArrayList<Deputado>();
		
		Element e = (Element) soap.obterDeputados().getContent().get(0);
		
		NodeList nList = e.getChildNodes();
		
		for (int i = 0; i < 1; i++) {
			
			Node node = nList.item(i);
			
			if(node.getNodeType() == Node.ELEMENT_NODE){
				Element eElement = (Element) node;
				
				Deputado deputado = new Deputado();
				
				deputado.setIdCadastro(Integer.parseInt(eElement.getElementsByTagName("ideCadastro")
						.item(0).getTextContent()));
				deputado.setCondicao(eElement.getElementsByTagName("condicao")
						.item(0).getTextContent());
				deputado.setNome(eElement.getElementsByTagName("nome")
						.item(0).getTextContent());
				deputado.setNomeParlamentar(eElement.getElementsByTagName("nomeParlamentar")
						.item(0).getTextContent());
				deputado.setUrlFoto(eElement.getElementsByTagName("urlFoto")
						.item(0).getTextContent());
				deputado.setSexo(eElement.getElementsByTagName("sexo")
						.item(0).getTextContent());
				deputado.setUf(eElement.getElementsByTagName("uf")
						.item(0).getTextContent());
				deputado.setPartido(eElement.getElementsByTagName("partido")
						.item(0).getTextContent());
				deputado.setGabinete(eElement.getElementsByTagName("gabinete")
						.item(0).getTextContent());
				deputado.setAnexo(eElement.getElementsByTagName("anexo")
						.item(0).getTextContent());
				deputado.setFone(eElement.getElementsByTagName("fone")
						.item(0).getTextContent());
				deputado.setEmail(eElement.getElementsByTagName("email")
						.item(0).getTextContent());
				
				List<DetalheDeputado> listaDetalhes = new ObterDetalhesDeputados().obterDetalhesDeputados(eElement.getElementsByTagName("ideCadastro")
						.item(0).getTextContent());
				
				
				deputado.setDetalheDeputado(listaDetalhes);
			
				listaDeputados.add(deputado);
			}
			
		}
		
		return listaDeputados;
	}

}
