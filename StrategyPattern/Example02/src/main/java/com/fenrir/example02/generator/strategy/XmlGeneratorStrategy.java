package com.fenrir.example02.generator.strategy;

import com.fenrir.example02.generator.model.DataModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.OutputStream;

class XmlGeneratorStrategy implements GeneratorStrategy {

    @Override
    public void generate(DataModel model, OutputStream outputStream) throws Exception {
        Document document = createDocument();
        writeDocumentContent(model, document);
        writeXml(document, outputStream);
    }

    private Document createDocument() throws ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        return documentBuilder.newDocument();
    }

    private void writeDocumentContent(DataModel model, Document document) {
        Element rootElement = document.createElement("header");
        rootElement.setTextContent(model.getHeader());
        document.appendChild(rootElement);
    }

    private void writeXml(Document document, OutputStream outputStream) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(outputStream);

        transformer.transform(source, result);
    }

    @Override
    public String extension() {
        return "xml";
    }
}
