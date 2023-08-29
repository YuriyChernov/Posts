data class PageAttachments(
    val page: Page = Page(),
) : Attachments {
    val type = "page"
}
