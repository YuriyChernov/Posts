data class VideoAttachments(
    val video: Video = Video(),
) : Attachments {
    val type = "video"
}
