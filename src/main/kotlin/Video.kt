data class Video(
    var id: Int,
    val ownerId: Int,
    val title: String,
    val duration: Int,
    val type: String = "video"
) : Attachments