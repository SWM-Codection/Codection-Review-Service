package swm.virtuoso.reviewservice.common.enums

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter(autoApply = true)
class ReactionTypeEnumConverter : AttributeConverter<ReactionTypeEnum, String> {

    override fun convertToDatabaseColumn(attribute: ReactionTypeEnum): String {
        return attribute.value
    }

    override fun convertToEntityAttribute(dbData: String): ReactionTypeEnum {
        return ReactionTypeEnum.values().first { it.value == dbData }
    }
}