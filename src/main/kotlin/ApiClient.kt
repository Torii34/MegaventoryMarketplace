import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response

object ApiClient {
    private val client = OkHttpClient()
    private const val BASE_URL: String = "https://api.megaventory.com/v2017a/"

    /* Created this class to easily do a request knowing that APIKEY and mvRecordAction are in each postRequest
    * It's the base for my post requests
    * The others attribute allow me to insert and update the fields I need for this project
    * When the fields are null they are not include in the JSON request body*/
    data class RequestBody(
        val APIKEY : String = "a033feaf88a570a2@m140934",
        var mvProduct : Product? = null,
        val mvSupplierClient : SupplierClient? = null,
        val mvInventoryLocation : InventoryLocation? = null,
        val mvProductClientUpdate : ProductClient? = null,
        val mvRecordAction : String= "Insert"
    )

    // This method is the base for the post request
    private fun postRequest(url : String, requestBody : String) : Response{

        val post = requestBody.toRequestBody("application/json".toMediaTypeOrNull())

        val request = Request.Builder()
            .url("$BASE_URL$url")
            .post(post)
            .build()

        return client.newCall(request).execute()
    }

    // This method is the base for the get request
    private fun getRequest(url : String) : Response{

        val request = Request.Builder()
            .url("$BASE_URL$url?APIKEY=a033feaf88a570a2@m140934")
            .build()

        return client.newCall(request).execute()

    }

    // I needed this get methods to get the ID of my entities
    fun getProduct() : List<Product>{

        val jsonResponse = getRequest("json/reply/ProductGet").body?.string()

        val products = Gson().fromJson(jsonResponse, Products::class.java)

        return products.mvProducts
    }

    fun getSupplierClient() : List<SupplierClient>{
        val jsonResponse = getRequest("json/reply/SupplierClientGet").body?.string()

        val supplierClients = Gson().fromJson(jsonResponse, SupplierClients::class.java)

        return supplierClients.mvSupplierClients
    }

    fun insertProduct(product: Product) : Response{
        val requestBody = RequestBody(mvProduct = product)

        return postRequest("Product/ProductUpdate", Gson().toJson(requestBody))
    }

    fun insertSupplierClient(supplierClient: SupplierClient) : Response{
        val requestBody = RequestBody(mvSupplierClient = supplierClient)

        return postRequest("SupplierClient/SupplierClientUpdate", Gson().toJson(requestBody))
    }

    fun insertInventoryLocation(inventoryLocation: InventoryLocation) : Response{
        val requestBody = RequestBody(mvInventoryLocation = inventoryLocation)

        return postRequest("InventoryLocation/InventoryLocationUpdate", Gson().toJson(requestBody))
    }

    fun insertProductClient(productClient: ProductClient) : Response{
        val requestBody = RequestBody(mvProductClientUpdate = productClient)

        return postRequest("ProductClient/ProductClientUpdate", Gson().toJson(requestBody))
    }
}

