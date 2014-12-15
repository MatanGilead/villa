package reit;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Drive {
	public static void main(String[] args) {
		Management management = new Management();
		createAssetContentsReqpairDetails(management);

		management.start();
	}

	private static void createAssetContentsReqpairDetails(Management management) {
		returnObject("AssetContentsRepairDetails.xml","AssetContentsRepairDetails.class");
	}

	// Create an object of the required class;
	public static Object returnObject(String fileName, String className) {
		try {
			File file = new File(fileName);
			JAXBContext jaxbContext = JAXBContext.newInstance(className);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Object myObj = jaxbUnmarshaller.unmarshal(file);
			return myObj;


		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}



}