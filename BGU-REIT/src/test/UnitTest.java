package test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnitTest {
	private Warehouse house;
	private HashMap<String, RepairMaterial> materials;
	private HashMap<String, RepairTool> tools;
	@Before
	public void setUp() throws Exception {

		house = new Warehouse();
		tools=new HashMap<String, RepairTool>();
		materials = new HashMap<String, RepairMaterial>();

		RepairTool newTool1 = new RepairTool("Hammer", 5);
		house.addTool(newTool1);
		tools.put("Hammer", newTool1);
		RepairTool newTool2 = new RepairTool("Screwdriver", 2);
		house.addTool(newTool2);
		tools.put("Screwdriver", newTool2);
		RepairTool newTool3 = new RepairTool("Saw", 3);
		tools.put("Saw", newTool3);
		house.addTool(newTool3);



		RepairMaterial newMaterial1 = new RepairMaterial("Sand", 5);
		house.addMaterial(newMaterial1);
		materials.put("Sand", newMaterial1);
		RepairMaterial newMaterial2 = new RepairMaterial("Water", 4);
		house.addMaterial(newMaterial2);
		materials.put("Water", newMaterial2);
		RepairMaterial newMaterial3 = new RepairMaterial("Ink", 3);
		house.addMaterial(newMaterial3);
		materials.put("Ink", newMaterial3);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAcquireTool() {

		ArrayList<RepairTool> toolList = new ArrayList<RepairTool>();
		RepairTool seekTool = new RepairTool("Hammer",2);
		toolList.add(seekTool);
		house.AcquireTool(toolList);
		assertTrue(tools.get("Hammer").getCount() == 3);
	}

	@Test
	public void testReleaseTool() {
		ArrayList<RepairTool> toolList = new ArrayList<RepairTool>();
		RepairTool seekTool = new RepairTool("Screwdriver", 1);
		toolList.add(seekTool);
		house.ReleaseTool(toolList);
		assertTrue(tools.get("Screwdriver").getCount() == 3);
	}

	@Test
	public void testAcquireMaterial() {
		ArrayList<RepairMaterial> materialsList = new ArrayList<RepairMaterial>();
		RepairMaterial seekTool = new RepairMaterial("Sand", 5);
		materialsList.add(seekTool);
		house.AcquireMaterial(materialsList);
		assertTrue(materials.get("Sand").getCount() == 0);
	}

}
