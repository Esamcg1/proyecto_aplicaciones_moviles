package network

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val httpCode: String
)