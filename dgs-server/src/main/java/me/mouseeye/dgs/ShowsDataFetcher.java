package me.mouseeye.dgs;

import com.example.packagename.DgsConstants;
import com.example.packagename.types.Actor;
import com.example.packagename.types.Show;
import com.netflix.graphql.dgs.*;

import java.util.List;

@DgsComponent
public class ShowsDataFetcher {

    private final List<Show> shows = List.of(
            new Show(1, "Stranger Things", 2016, null),
            new Show(2, "Ozark", 2017, null),
            new Show(3, "The Crown", 2016, null),
            new Show(4, "Dead to Me", 2019, null),
            new Show(5, "Orange is the New Black", 2013, null)
    );

    @DgsQuery
    public List<Show> shows(@InputArgument String titleFilter, DgsDataFetchingEnvironment dfe) {
        if (titleFilter == null) {
            return shows;
        }

        return shows.stream()
                .filter(show -> show.getTitle().contains(titleFilter))
                .toList();
    }
}
