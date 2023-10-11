package notes

data class EditComment(
    val commentId: Int = 0,
    val ownerId: Int = 0,
    val message: String = "",
)
