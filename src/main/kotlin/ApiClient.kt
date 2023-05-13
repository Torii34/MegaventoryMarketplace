import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

object ApiClient {
    private val client = OkHttpClient()
    private const val BASE_URL: String = "https://api.megaventory.com/v2017a/"

    data class RequestBody(
        val APIKEY : String = "a033feaf88a570a2@m140934",
        var mvProduct : Product?,
        val mvProductClientUpdate : SupplierClient? = null,
        val mvRecordAction : String= "Insert"
    )

    private fun request(url : String, requestBody : String) : Response{
        val requestBody = okhttp3.RequestBody.create("application/json".toMediaTypeOrNull(), requestBody)

        val request = Request.Builder()
            .url("$BASE_URL$url")
            .post(requestBody)
            .build()

        return client.newCall(request).execute()

    }

    fun updateProduct(product: Product) : Response?{
        val requestBody = RequestBody(mvProduct = product)

        return request("Product/ProductUpdate", Gson().toJson(requestBody))
    }


}

