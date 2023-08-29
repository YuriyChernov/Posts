data class PhotoAttachments(
    val photo: Photo = Photo(),
) : Attachments {
    val type = "photo"
}
