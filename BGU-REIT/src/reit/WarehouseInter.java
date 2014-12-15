package reit;

import java.util.ArrayList;

public interface WarehouseInter {

	public void AcquireTool(ArrayList<RepairTool> tool);

	public void ReleaseTool(ArrayList<RepairTool> tool);

	public void AcquireMaterial(ArrayList<RepairMaterial> material);

	public void addTool(RepairTool tool);

	public void addMaterial(RepairMaterial material);
}
