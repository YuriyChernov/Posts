data class Photo(
    var id: Int,
    val ownerId: Int,
    val photo130: String? = null,
    val photo604: String? = null,
    val type: String = "photo"
) : Attachments