package swm.virtuoso.reviewservice.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DiscussionSortTypeTest {
    @DisplayName("빈 문자열로부터 DiscussionSortType.fromSortString()이 LATEST 리턴")
    @Test
    fun `빈 문자열로부터 DiscussionSortType_fromSortString()이 LATEST 리턴`() {
        val actual = DiscussionSortType.fromSortString("")
        val expected = DiscussionSortType.LATEST
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("유효하지 않은 문자열로부터 DiscussionSortType_fromSortString()이 LATEST 리턴")
    @Test
    fun `유효하지 않은 문자열로부터 DiscussionSortType_fromSortString()이 LATEST 리턴`() {
        val actual = DiscussionSortType.fromSortString("asdf")
        val expected = DiscussionSortType.LATEST
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("'latest' 로부터 DiscussionSortType.fromSortString()이 LATEST 리턴")
    @Test
    fun `'latest'로부터 DiscussionSortType_fromSortString()이 LATEST 리턴`() {
        val actual = DiscussionSortType.fromSortString("latest")
        val expected = DiscussionSortType.LATEST
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("'oldest'로부터 DiscussionSortType.fromSortString() 이 OLDEST 리턴")
    @Test
    fun `'oldest'로부터 DiscussionSortType_fromSortString()이 OLDEST 리턴`() {
        val actual = DiscussionSortType.fromSortString("oldest")
        val expected = DiscussionSortType.OLDEST
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("'recentupdate'로부터 DiscussionSortType.fromSortString() 이 RECENT_UPDATE 리턴")
    @Test
    fun `'recentupdate'로부터 DiscussionSortType_fromSortString() 이 RECENT_UPDATE 리턴`() {
        val actual = DiscussionSortType.fromSortString("recentupdate")
        val expected = DiscussionSortType.RECENT_UPDATE
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("'leastupdate'로부터 DiscussionSortType.fromSortString() 이 LEAST_UPDATE 리턴")
    @Test
    fun `'leastupdate'로부터 DiscussionSortType_fromSortString()이 LEAST_UPDATE 리턴`() {
        val actual = DiscussionSortType.fromSortString("leastupdate")
        val expected = DiscussionSortType.LEAST_UPDATE
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("'mostcomment'로부터 DiscussionSortType.fromSortString() 이 MOST_COMMENT 리턴")
    @Test
    fun `'mostcomment'로부터 DiscussionSortType_fromSortString()이 MOST_COMMENT 리턴`() {
        val actual = DiscussionSortType.fromSortString("mostcomment")
        val expected = DiscussionSortType.MOST_COMMENT
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("'leastcomment'로부터 DiscussionSortType.fromSortString() 이 LEAST_COMMENT 리턴")
    @Test
    fun `'leastcomment'로부터 DiscussionSortType_fromSortString() 이 LEAST_COMMENT 리턴`() {
        val actual = DiscussionSortType.fromSortString("leastcomment")
        val expected = DiscussionSortType.LEAST_COMMENT
        assertThat(actual).isEqualTo(expected)
    }
}
