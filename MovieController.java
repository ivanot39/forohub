package com.foro.controller;

import com.foro.model.Movie;
import com.foro.model.Comment;
import com.foro.repository.MovieRepository;
import com.foro.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CommentRepository commentRepository;

    // Obtener la lista de películas
    @GetMapping
    public String listMovies(Model model) {
        model.addAttribute("movies", movieRepository.findAll());
        return "movie-list";
    }

    // Ver detalles de una película y sus comentarios
    @GetMapping("/{id}")
    public String movieDetails(@PathVariable Long id, Model model) {
        Movie movie = movieRepository.findById(id).orElseThrow();
        model.addAttribute("movie", movie);
        model.addAttribute("comments", movie.getComments());
        return "movie-detail";
    }

    // Agregar una nueva película
    @PostMapping("/add")
    public String addMovie(@RequestParam String title, @RequestParam String director, @RequestParam int year) {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setDirector(director);
        movie.setYear(year);
        movieRepository.save(movie);
        return "redirect:/movies";
    }

    // Agregar un comentario a una película
    @PostMapping("/{id}/comment")
    public String addComment(@PathVariable Long id, @RequestParam String content, @RequestParam String author) {
        Movie movie = movieRepository.findById(id).orElseThrow();
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setAuthor(author);
        comment.setMovie(movie);
        commentRepository.save(comment);
        return "redirect:/movies/" + id;
    }
}
