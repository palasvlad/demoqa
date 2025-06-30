package configFile.configNode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class WindowSizeNode {
    @XmlElement(name = "Width")
    public int width;

    @XmlElement(name = "Height")
    public int height;
}