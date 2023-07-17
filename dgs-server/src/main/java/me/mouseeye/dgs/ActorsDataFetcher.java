package me.mouseeye.dgs;

import com.example.packagename.DgsConstants;
import com.example.packagename.types.Actor;
import com.example.packagename.types.Show;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import me.mouseeye.dgs.loader.ActorLoader;
import org.dataloader.DataLoader;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@DgsComponent
public class ActorsDataFetcher {

    @DgsData(parentType = DgsConstants.SHOW.TYPE_NAME)
    public Mono<List<Actor>> actors(DgsDataFetchingEnvironment dfe) {
        Show show = dfe.getSource();
        DataLoader<Integer, List<Actor>> dataLoader = dfe.getDataLoader(ActorLoader.class);
        return Mono.fromFuture(dataLoader.load(show.getReleaseYear(), show));
    }
}
