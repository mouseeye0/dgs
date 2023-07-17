package me.mouseeye.dgs.generator;

import com.example.packagename.types.Actor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@Component
public class ActorGenerator {

    private final Map<Integer, List<Actor>> actorMappingByYear = Map.of(
            2016, List.of(new Actor("Actor2016", 34)),
            2017, List.of(new Actor("Actor2017", 44)),
            2019, List.of(new Actor("Actor2019", 33)),
            2013, List.of(new Actor("Actor2013", 33))
    );

    public List<List<Actor>> getActors(List<Integer> years) {
        return years.stream()
                .map(actorMappingByYear::get)
                .toList();
//                .collect(Collectors.toMap(Function.identity(), actorMappingByYear::get, (a, b) -> a));
    }

    //여러개 오면 여러개 변형
    // 한개 오면 한개 변형



}
