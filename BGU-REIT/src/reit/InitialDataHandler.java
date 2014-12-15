package reit;

import java.io.CharArrayWriter;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import test.Warehouse;

public class InitialDataHandler extends DefaultHandler {

	private CharArrayWriter fWriter;
	private Warehouse fWarehouse;
	private Management fManagement;

	InitialDataHandler(Management management) {
		fManagement = management;
		fWriter = new CharArrayWriter();
		fWarehouse = new Warehouse();
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		fWriter.write(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (localName == "name"{
			inAssetContent = true;
			contentName = fWriter.toString().trim();
		}

		else if (localName == "location") {
			name = fWriter.toString().trim();
		}
		if (localName == "quantity") {
			quantity = Integer.parseInt(fWriter.toString().trim());
		}
		if (localName == "Tool") {
			toolList.add(new RepairToolInformation(name, quantity));
		}
		if (localName == "Material") {
			materialList.add(new RepairMaterialInformation(name, quantity));
		}

		if (localName == "AssetContent") {
			fManagement.addItemRepairTool(contentName, toolList);
			fManagement.addItemRepairMaterial(contentName, materialList);
			inAssetContent = false;
		}
		
		if (localName == "NumberOfMaintenancePersons") {
	
		}
		
		if (localName == "TotalNumberOfRentalRequests") {
			
		}
		fWriter.reset();
	}
}
