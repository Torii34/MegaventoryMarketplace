
fun main(args: Array<String>) {

    //Step 2: Use your application to insert the following entities into your account:
    val nike = Product(
        ProductID = 30,
        ProductSKU =  "1112256",
        ProductDescription =  "Nike shoes",
        ProductSellingPrice =  99.99,
        ProductPurchasePrice =  44.99)

    val adidas = Product(
        ProductID = 29,
        ProductSKU = "1112248" ,
        ProductDescription = "Adidas shoes",
        ProductSellingPrice =  99.99,
        ProductPurchasePrice =  44.99)

//    ApiClient.insertProduct(nike)
//    ApiClient.insertProduct(adidas)

    val babis = SupplierClient(
        SupplierClientID = 11,
        SupplierClientType = "Client",
        SupplierClientName = "Babis5",
        SupplierClientEmail = "babis@exampletest.com",
        SupplierClientPhone1 = 1235698967,
        SupplierClientShippingAddress1 = "Example 8, Athens")

    val odysseus = SupplierClient(
        SupplierClientID = 10,
        SupplierClientType = "Supplier",
        SupplierClientName = "Odysseus5",
        SupplierClientEmail = "odysseus@exampletest.com",
        SupplierClientPhone1 = 1235698988,
        SupplierClientShippingAddress1 = "Example 10, Athens")

//    ApiClient.insertSupplierClient(babis)
//    ApiClient.insertSupplierClient(odysseus)

    val test = InventoryLocation(
        InventoryLocationID = 3,
        InventoryLocationAbbreviation =  "Test",
        InventoryLocationName = "Test Project Location",
        InventoryLocationAddress = "Example 20, Athens")

//    ApiClient.insertInventoryLocation(test)

    // Step 3: Create a relationship between Nike shoes and the client babis.
    val productClient = ProductClient(30, 11,  99.99)
//    ApiClient.insertProductClient(productClient)

    // Step 4: Create a relationship between Adidas shoes and the supplier odysseus.
    val productSupplier = ProductSupplier(29, 10, 44.99)
//    ApiClient.insertProductSupplier(productSupplier)

    //Step 5: Update the availability of products in 5 units in the warehouse you added at a cost of 44.99 each.
    val inventoryLocationStock1 = InventoryLocationStock("1112256", 5.0, 44.99, 3 )
    val inventoryLocationStock2 = InventoryLocationStock("1112248", 5.0, 44.99,3 )

    //I don't know why but updating the product unit cost doesn't work, even in the API documentation
    val inventoryLocationStockList = listOf(inventoryLocationStock1, inventoryLocationStock2)
//    ApiClient.insertInventoryLocationStock(inventoryLocationStockList)

    // Example of use of my get methods
    for(product : Product in ApiClient.getProduct()){
        println("Product description: ${product.ProductDescription}")
    }

}
