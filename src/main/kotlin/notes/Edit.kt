package notes

data class Edit(
    val ownerId: Int = 0,
    val title: String = "",
    val text: String = "",
    val privacy: Int = 0,
    val commentPrivacy: Int = 0,
    val privacyView: String = "",
    val privacyComment: String = "",
)
