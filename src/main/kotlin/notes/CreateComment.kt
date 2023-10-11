package notes

data class CreateComment(
    val noteId: Int = 0,
    val ownerId: Int = 0,
    val replyTo: String = "",
    val message: String = "",
    val guid: String = "",
)
