package swm.virtuoso.reviewservice.common.enums

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer

class ReactionTypeEnumDeserializer : JsonDeserializer<ReactionTypeEnum>() {
    override fun deserialize(parser: JsonParser, context: DeserializationContext): ReactionTypeEnum {
        parser.text?.let { text ->
            return ReactionTypeEnum.entries.first { it.toString() == text }
        }
        throw IllegalArgumentException("Cannot parse given string to ReactionTypeEnum")
    }
}
