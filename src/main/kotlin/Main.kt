
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

}
