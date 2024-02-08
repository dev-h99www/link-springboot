package h9w.me.link.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;

@Configuration
@EntityScan(basePackages = "h9w.me.link")
@EnableJpaRepositories(basePackages = "h9w.me.link", queryLookupStrategy = QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND)
public class JPAConfiguration {
}
