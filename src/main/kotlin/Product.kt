data class Product(
    val ProductID : Long = 0,
    val ProductSKU : String,
    val ProductDescription : String,
    val ProductSellingPrice : Double,
    val ProductPurchasePrice : Double
)

// I needed this class to retrieve the products that are in a list in response to my get method
data class Products(
    val mvProducts: List<Product>
)

// This class allows me to update the product client with my post method
data class ProductClient(
    val ProductID : Int,
    val ProductClientID : Int,
    val ProductClientPrice : Double
)

// I use this class to update the product supplier with my post method
data class ProductSupplier(
    val ProductID : Int,
    val ProductSupplierID : Int,
    val ProductSupplierPrice : Double
)