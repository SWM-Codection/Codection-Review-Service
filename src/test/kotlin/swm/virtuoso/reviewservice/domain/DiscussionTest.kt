package swm.virtuoso.reviewservice.domain

class DiscussionTest {

    /*@Test
    fun `calculateDeletedCodes returns correct deleted codes`() {
        // Given
        val discussionCode1 = DiscussionCode(1L, "file1", 1, 10)
        val discussionCode2 = DiscussionCode(2L, "file2", 20, 30)
        val discussionCode3 = DiscussionCode(3L, "file3", 40, 50)

        val initialCodes = listOf(discussionCode1, discussionCode2, discussionCode3)
        val modifiedCodes = listOf(discussionCode1, discussionCode3)

        val discussion = Discussion(
            id = 1L,
            name = "Discussion 1",
            content = "Some content",
            repoId = 101L,
            posterId = 201L,
            commitHash = "commitHash123",
            codes = initialCodes
        )

        // When
        val deletedCodes = discussion.calculateDeletedCodes(modifiedCodes)

        // Then
        val expectedDeletedCodes = listOf(discussionCode2)
        assertThat(deletedCodes).containsExactlyElementsOf(expectedDeletedCodes)
    }

    @Test
    fun `calculateDeletedCodes with empty modified codes returns all initial codes`() {
        // Given
        val discussionCode1 = DiscussionCode(1L, "file1", 1, 10)
        val discussionCode2 = DiscussionCode(2L, "file2", 20, 30)
        val discussionCode3 = DiscussionCode(3L, "file3", 40, 50)

        val initialCodes = listOf(discussionCode1, discussionCode2, discussionCode3)
        val modifiedCodes = emptyList<DiscussionCode>()

        val discussion = Discussion(
            id = 1L,
            name = "Discussion 1",
            content = "Some content",
            repoId = 101L,
            posterId = 201L,
            commitHash = "commitHash123",
            codes = initialCodes
        )

        // When
        val deletedCodes = discussion.calculateDeletedCodes(modifiedCodes)

        // Then
        assertThat(deletedCodes).containsExactlyElementsOf(initialCodes)
    }

    @Test
    fun `calculateDeletedCodes with identical modified codes returns empty list`() {
        // Given
        val discussionCode1 = DiscussionCode(1L, "file1", 1, 10)
        val discussionCode2 = DiscussionCode(2L, "file2", 20, 30)
        val discussionCode3 = DiscussionCode(3L, "file3", 40, 50)

        val initialCodes = listOf(discussionCode1, discussionCode2, discussionCode3)
        val modifiedCodes = listOf(discussionCode1, discussionCode2, discussionCode3)

        val discussion = Discussion(
            id = 1L,
            name = "Discussion 1",
            content = "Some content",
            repoId = 101L,
            posterId = 201L,
            commitHash = "commitHash123",
            codes = initialCodes
        )

        // When
        val deletedCodes = discussion.calculateDeletedCodes(modifiedCodes)

        // Then
        assertThat(deletedCodes).isEmpty()
    }

    @Test
    fun `test calculateDeletedCodes with modified codes having mixed null and non-null ids returns correct deleted codes`() {
        // Given
        val discussionCode1 = DiscussionCode(1L, "file1", 1, 10)
        val discussionCode2 = DiscussionCode(2L, "file2", 20, 30)
        val discussionCode3 = DiscussionCode(3L, "file3", 40, 50)
        val discussionCode4 = DiscussionCode(4L, "file4", 60, 70)

        val initialCodes = listOf(discussionCode1, discussionCode2, discussionCode3, discussionCode4)
        val modifiedCodes = listOf(
            DiscussionCode(null, "file1", 1, 10),
            DiscussionCode(2L, "file2", 20, 30),
            DiscussionCode(null, "file3", 40, 50)
        )

        val discussion = Discussion(
            id = 1L,
            name = "Discussion 1",
            content = "Some content",
            repoId = 101L,
            posterId = 201L,
            commitHash = "commitHash123",
            codes = initialCodes
        )

        // When
        val deletedCodes = discussion.calculateDeletedCodes(modifiedCodes)

        // Then
        val expectedDeletedCodes = listOf(discussionCode1, discussionCode3, discussionCode4)
        assertThat(deletedCodes).containsExactlyElementsOf(expectedDeletedCodes)
    }*/
}
