package swm.virtuoso.reviewservice.common.enums

enum class ReactionTypeEnum(val value: String) {
    PLUS_ONE("+1"),
    MINUS_ONE("-1"),
    LAUGH("laugh"),
    HOORAY("hooray"),
    CONFUSED("confused"),
    HEART("heart"),
    ROCKET("rocket"),
    EYES("eyes");

    override fun toString(): String {
        return value
    }
}