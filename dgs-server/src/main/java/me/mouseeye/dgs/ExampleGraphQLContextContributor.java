package me.mouseeye.dgs;

import com.netflix.graphql.dgs.context.GraphQLContextContributor;
import com.netflix.graphql.dgs.internal.DgsRequestData;
import graphql.GraphQLContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ExampleGraphQLContextContributor implements GraphQLContextContributor {

    @Override
    public void contribute(@NotNull GraphQLContext.Builder builder, @Nullable Map<String, ?> extensions, @Nullable DgsRequestData dgsRequestData) {
        if (dgsRequestData != null && dgsRequestData.getHeaders() != null) {
            String contributedContextHeader = dgsRequestData.getHeaders().getFirst("x-context-contributor-header");
            builder.put("exampleContributorEnabled", "true");
        }
    }
}