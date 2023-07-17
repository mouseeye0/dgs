package me.mouseeye.dgs;

import com.netflix.graphql.dgs.context.DgsCustomContextBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyContextBuilder implements DgsCustomContextBuilder<MyContextBuilder.MyContext> {


    @Override
    public MyContextBuilder.MyContext build() {
        return new MyContextBuilder.MyContext();
    }

    public class MyContext {
        private final String customState = "Custom state!";

        public String getCustomState() {
            return customState;
        }
    }
}
