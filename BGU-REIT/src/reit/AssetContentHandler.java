package reit;

import java.io.CharArrayWriter;
import java.util.ArrayList;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AssetContentHandler extends DefaultHandler {

	private CharArrayWriter writer;
	private boolean inAssetContent;
	private String contentName;
	private String name;
	private int quantity;
	private ArrayList<RepairMaterialInformation> materialList;
	private ArrayList<RepairToolInformation> toolList;
	private Management fManagement;
	
	AssetContentHandler(Management management){
		fManagement=management;
		writer = new CharArrayWriter();
		toolList = new ArrayList<RepairToolInformation>();
		materialList = new ArrayList<RepairMaterialInformation>();
		inAssetContent = false;

	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		writer.write(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (localName == "Name" && !(inAssetContent)) {
			inAssetContent = true;
			contentName = writer.toString().trim();
		}
		
		else if (localName == "Name" && inAssetContent) {
			name = writer.toString().trim();
		}
		if (localName == "Quantity") {
			quantity = Integer.parseInt(writer.toString().trim());
		}
		if (localName == "Tool") {
			toolList.add(new RepairToolInformation(name,quantity));
		}
		if (localName == "Material") {
			materialList.add(new RepairMaterialInformation(name,quantity));
		}

		if (localName == "AssetContent") {
			fManagement.addItemRepairTool(contentName, toolList);
			fManagement.addItemRepairMaterial(contentName, materialList);
			inAssetContent = false;
		}
		writer.reset();
	}
}
