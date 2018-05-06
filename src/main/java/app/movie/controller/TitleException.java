package app.movie.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "title need to have 3-50 characters")
public class TitleException extends RuntimeException {
}
