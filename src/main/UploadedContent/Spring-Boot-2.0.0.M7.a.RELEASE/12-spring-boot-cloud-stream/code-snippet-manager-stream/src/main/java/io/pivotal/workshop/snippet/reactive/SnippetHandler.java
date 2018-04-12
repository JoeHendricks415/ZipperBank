package io.pivotal.workshop.snippet.reactive;

import io.pivotal.workshop.snippet.domain.Language;
import io.pivotal.workshop.snippet.domain.Snippet;
import io.pivotal.workshop.snippet.repository.LanguageRepository;
import io.pivotal.workshop.snippet.repository.SnippetRepository;
import io.pivotal.workshop.snippet.service.SnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class SnippetHandler {

    private SnippetService snippetService;

    public SnippetHandler(SnippetService snippetService) {
        this.snippetService = snippetService;
    }

    public Mono<ServerResponse> findAll(ServerRequest request){
        return ok().body(BodyInserters.fromPublisher(Flux.fromStream(this.snippetService.findAll()),Snippet.class));
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        String snippetId = request.pathVariable("id");
        Optional<Snippet> result = this.snippetService.findById(snippetId);
        if(result.isPresent())
            return ok().body(BodyInserters.fromPublisher(Mono.just(result.get()),Snippet.class));
        else
            return notFound().build();
    }

    public Mono<ServerResponse> createSnippet(ServerRequest request) {
        Mono<Snippet> snippetMono = request.bodyToMono(Snippet.class);
        return ok().build(snippetMono.doOnNext(snippetConsumer -> {
            this.snippetService.save(snippetConsumer);
        }).then());
    }


}
