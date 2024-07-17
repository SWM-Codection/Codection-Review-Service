package swm.virtuoso.reviewservice.common.config

import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import swm.virtuoso.reviewservice.adapter.out.persistence.DiscussionMapper

@Configuration
class MapperConfig {
    @Bean
    fun discussionMapper(): DiscussionMapper {
        return Mappers.getMapper(DiscussionMapper::class.java)
    }
}
