package io.pivotal.workshop.snippet.reactive;

import io.pivotal.workshop.snippet.domain.Snippet;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

@RestController
public class SnippetController {

    private EmitterProcessor snippetStream;

    public SnippetController(EmitterProcessor snippetStream) {  ////<1>
        this.snippetStream = snippetStream;
    }

    @GetMapping(path = "/logs", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Snippet> snippetLog(){                          ////<2>
        return snippetStream.doOnSubscribe(subscription -> { snippetStream.next().subscribe(); });

    }
}
