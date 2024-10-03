package swm.virtuoso.reviewservice.common.enums

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider

class ReactionTypeEnumSerializer : JsonSerializer<ReactionTypeEnum>() {
    override fun serialize(value: ReactionTypeEnum, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeString(value.toString())
    }
}
