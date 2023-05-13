data class SupplierClient(
    val SupplierClientID : Long = 0,
    val SupplierClientType : String,
    val SupplierClientName : String,
    val SupplierClientShippingAddress1 : String,
    val SupplierClientPhone1 : Long,
    val SupplierClientEmail: String
)

// I needed this class to retrieve the suppliers and clients that are in a list in response to my get method
data class SupplierClients(
    val mvSupplierClients: List<SupplierClient>
)
