package notes

data class Add(
    val title: String = "",
    val text: String = "",
    val privacy: Int = 0,
    val commentPrivacy: Int = 0,
    val privacyView: String = "",
    val privacyComment: String = "",
)
