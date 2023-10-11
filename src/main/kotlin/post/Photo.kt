package post

data class Photo(
    var id: Int = 0,
    val ownerId: Int = 0,
    val photo130: String? = null,
    val photo604: String? = null,
    val type: String = "photo"
)