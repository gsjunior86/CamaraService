package br.camara.servico;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.camara.entity.CargoComissoes;
import br.camara.entity.DetalheDeputado;
import br.camara.entity.DetalheDeputado_ID;
import br.camara.entity.Partido;
import br.camara.ws.Deputados;
import br.camara.ws.DeputadosSoap;

public class ObterDetalhesDeputados {
	
	public List<DetalheDeputado> obterDetalhesDeputados(String idCadastro){
		List<DetalheDeputado> listaDetalhes = new ArrayList<DetalheDeputado>();
		
		Deputados deputados = null;
		DeputadosSoap soap = null;
		Element e = null;
		
		boolean b = true;
		while(b){
			try{
				deputados = new Deputados();
				soap = deputados.getDeputadosSoap();
				e = (Element) soap.obterDetalhesDeputado(idCadastro, "").getContent().get(0);
				b= false;
			}catch(Exception ex){
				System.out.println("Erro: " + ex.getMessage() + " || Tentando de novo...");
				b= true;
			}
		}
		
		
		NodeList nList = e.getChildNodes();
		
		for (int i = 0; i < nList.getLength(); i++) {
			
			Node node = nList.item(i);
			System.out.println("-- Consultando Detalhes...");
			
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
				
				
				Partido partido = new Partido();
				partido.setIdPartido(eElement.getElementsByTagName("idPartido")
						.item(0).getTextContent());
				
				detalheDeputado.setPartido(partido);
				
				detalheDeputado.setId(detalheDeputado_ID);
				
				List<CargoComissoes> listaCargoComissao = new ArrayList<CargoComissoes>();
				
				NodeList nListCargoComissao = eElement.getElementsByTagName("cargosComissoes");	
				
				for(int x = 0; x < nListCargoComissao.getLength(); x++){
					CargoComissoes cc = new CargoComissoes();
					Node n = nListCargoComissao.item(x);
					if(node.getNodeType() == Node.ELEMENT_NODE){
						Element el = (Element) n;
						
						if(el.getFirstChild() != null){
							cc.setIdComissao(Integer.parseInt(el.getElementsByTagName("idOrgaoLegislativoCD")
									.item(0).getTextContent()));
							cc.setNomeComissao(el.getElementsByTagName("nomeComissao")
									.item(0).getTextContent());
							cc.setSiglaComissao(el.getElementsByTagName("siglaComissao")
									.item(0).getTextContent());
							cc.setNomeCargo(el.getElementsByTagName("siglaComissao")
									.item(0).getTextContent());
							cc.setDataEntrada(el.getElementsByTagName("dataEntrada")
									.item(0).getTextContent());
							cc.setDataSaida(el.getElementsByTagName("dataSaida")
									.item(0).getTextContent());
							
							cc.setId(detalheDeputado_ID);
							
							listaCargoComissao.add(cc);
						}
					}
					
				}
				
				detalheDeputado.setCargoComissoes(listaCargoComissao);
				
				listaDetalhes.add(detalheDeputado);
			}
			
		}
		
		return listaDetalhes;
	}

}
