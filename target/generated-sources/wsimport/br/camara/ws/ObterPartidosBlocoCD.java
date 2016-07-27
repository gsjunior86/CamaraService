
package br.camara.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idBloco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numLegislatura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idBloco",
    "numLegislatura"
})
@XmlRootElement(name = "ObterPartidosBlocoCD")
public class ObterPartidosBlocoCD {

    protected String idBloco;
    protected String numLegislatura;

    /**
     * Obt�m o valor da propriedade idBloco.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdBloco() {
        return idBloco;
    }

    /**
     * Define o valor da propriedade idBloco.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdBloco(String value) {
        this.idBloco = value;
    }

    /**
     * Obt�m o valor da propriedade numLegislatura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumLegislatura() {
        return numLegislatura;
    }

    /**
     * Define o valor da propriedade numLegislatura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumLegislatura(String value) {
        this.numLegislatura = value;
    }

}
