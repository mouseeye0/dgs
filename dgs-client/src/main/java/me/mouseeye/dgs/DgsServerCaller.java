package me.mouseeye.dgs;

import com.example.packagename.DgsConstants;
import com.example.packagename.client.ShowsGraphQLQuery;
import com.example.packagename.client.ShowsProjectionRoot;
import com.netflix.graphql.dgs.client.WebClientGraphQLClient;
import com.netflix.graphql.dgs.client.codegen.GraphQLQueryRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class DgsServerCaller {

    private final GraphQLQueryRequest graphQLQueryRequest = new GraphQLQueryRequest(
            new ShowsGraphQLQuery.Builder()
                    .queryName(DgsConstants.QUERY.Shows)
                    .titleFilter("hi")
                    .build(),
            new ShowsProjectionRoot<>()
                    .title()
                    .releaseYear()
    );

    private final WebClientGraphQLClient webClientGraphQLClient = new WebClientGraphQLClient(WebClient.create("localhost:8080/graphql"));


    public String queryServer() {
        return webClientGraphQLClient.reactiveExecuteQuery(
                graphQLQueryRequest.serialize()
        ).block().toString();
    }
}
