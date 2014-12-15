package test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnitTest {
	private Warehouse house;
	private HashMap<String, impelRepairMaterial> materials;
	private HashMap<String, impelRepairTool> tools;
	@Before
	public void setUp() throws Exception {

		house = new Warehouse();
		tools=new HashMap<String, impelRepairTool>();
		materials = new HashMap<String, impelRepairMaterial>();

		impelRepairTool newTool1 = new impelRepairTool("Hammer", 5);
		house.addTool(newTool1);
		tools.put("Hammer", newTool1);
		impelRepairTool newTool2 = new impelRepairTool("Screwdriver", 2);
		house.addTool(newTool2);
		tools.put("Screwdriver", newTool2);
		impelRepairTool newTool3 = new impelRepairTool("Saw", 3);
		tools.put("Saw", newTool3);
		house.addTool(newTool3);



		impelRepairMaterial newMaterial1 = new impelRepairMaterial("Sand", 5);
		house.addMaterial(newMaterial1);
		materials.put("Sand", newMaterial1);
		impelRepairMaterial newMaterial2 = new impelRepairMaterial("Water", 4);
		house.addMaterial(newMaterial2);
		materials.put("Water", newMaterial2);
		impelRepairMaterial newMaterial3 = new impelRepairMaterial("Ink", 3);
		house.addMaterial(newMaterial3);
		materials.put("Ink", newMaterial3);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAcquireTool() {

		ArrayList<RepairTool> toolList = new ArrayList<RepairTool>();
		impelRepairTool seekTool = new impelRepairTool("Hammer",2);
		toolList.add(seekTool);
		house.AcquireTool(toolList);
		assertTrue(tools.get("Hammer").getCount() == 3);
	}

	@Test
	public void testReleaseTool() {
		ArrayList<RepairTool> toolList = new ArrayList<RepairTool>();
		impelRepairTool seekTool = new impelRepairTool("Screwdriver", 1);
		toolList.add(seekTool);
		house.ReleaseTool(toolList);
		assertTrue(tools.get("Screwdriver").getCount() == 3);
	}

	@Test
	public void testAcquireMaterial() {
		ArrayList<RepairMaterial> materialsList = new ArrayList<RepairMaterial>();
		impelRepairMaterial seekTool = new impelRepairMaterial("Sand", 5);
		materialsList.add(seekTool);
		house.AcquireMaterial(materialsList);
		assertTrue(materials.get("Sand").getCount() == 0);
	}

}
