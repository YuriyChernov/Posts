package notes

data class GetById(
    val noteId: Int = 0,
    val ownerId: Int = 0,
    val needWiki: String = "",
)
