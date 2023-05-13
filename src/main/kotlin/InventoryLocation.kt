data class InventoryLocation(
    val InventoryLocationID : Long = 0,
    val InventoryLocationAbbreviation : String,
    val InventoryLocationName : String,
    val InventoryLocationAddress : String
)

// I needed this class to retrieve the inventories locations that are in a list in response to my get method
data class InventoryLocations(
    val mvInventoryLocations: List<InventoryLocation>
)

// This class is for update the inventory location stock with my post method
data class InventoryLocationStock(
    val ProductSKU : String,
    val ProductQuantity : Double,
    val ProductUnitCost : Double,
    val InventoryLocationID : Int
)