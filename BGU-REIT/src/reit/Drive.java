package reit;

import java.io.FileReader;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Drive {
	public Drive(Management management) {
		try {
			XMLReader xmlReader = XMLReaderFactory.createXMLReader();
			xmlReader.setContentHandler(new AssetContentHandler(management));
			xmlReader
					.parse(new InputSource(
							new FileReader(
									"/home/matan/workspace/BGU-REIT/src/reit/AssetContentsRepairDetails.xml")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
