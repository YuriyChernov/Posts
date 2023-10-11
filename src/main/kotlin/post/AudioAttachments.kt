package post

data class AudioAttachments(
    val audio: Audio = Audio(),
) : Attachments {
    val type = "audio"
}
