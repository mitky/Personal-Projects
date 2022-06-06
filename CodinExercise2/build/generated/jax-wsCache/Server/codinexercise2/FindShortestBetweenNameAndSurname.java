
package codinexercise2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for findShortestBetweenNameAndSurname complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findShortestBetweenNameAndSurname">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="p" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findShortestBetweenNameAndSurname", propOrder = {
    "p"
})
public class FindShortestBetweenNameAndSurname {

    protected Object p;

    /**
     * Gets the value of the p property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getP() {
        return p;
    }

    /**
     * Sets the value of the p property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setP(Object value) {
        this.p = value;
    }

}
