package me.mouseeye.dgs.loader;

import com.example.packagename.types.Actor;
import com.example.packagename.types.Show;
import com.netflix.graphql.dgs.DgsDataLoader;
import lombok.RequiredArgsConstructor;
import me.mouseeye.dgs.generator.ActorGenerator;
import org.dataloader.BatchLoader;
import org.dataloader.BatchLoaderEnvironment;
import org.dataloader.BatchLoaderWithContext;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@RequiredArgsConstructor
@DgsDataLoader
public class ActorLoader implements BatchLoaderWithContext<Integer, List<Actor>> {

    private final ActorGenerator actorGenerator;

    @Override
    public CompletionStage<List<List<Actor>>> load(List<Integer> keys, BatchLoaderEnvironment environment) {
        Object context = environment.getContext();
        Map keyContexts = environment.getKeyContexts();
        Show o = (Show) keyContexts.get(1);
        return CompletableFuture.supplyAsync(
                () -> actorGenerator.getActors(keys)
        );
    }
}
