package org.example.movie.mgmt.controller;

import io.swagger.annotations.ApiOperation;
import org.example.movie.mgmt.dto.request.CreateMovieRequestDTO;
import org.example.movie.mgmt.dto.request.PatchMovieRequest;
import org.example.movie.mgmt.dto.response.CreateMovieResponseDTO;
import org.example.movie.mgmt.dto.response.GetMovieResponseDTO;
import org.example.movie.mgmt.dto.response.ListMoviesResponseDTO;
import org.example.movie.mgmt.dto.response.PatchMovieResponseDTO;
import org.example.movie.mgmt.service.MovieMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
@RequestMapping("/api/v1/movies")
public class MovieMgmtController {

    @Autowired
    private MovieMgmtService movieMgmtService;

    @PostMapping
    @ApiOperation(value = "Add a new movie")
    public ResponseEntity<CreateMovieResponseDTO> createMovie(@RequestBody CreateMovieRequestDTO request) {
        CreateMovieResponseDTO movieCreateResponse = movieMgmtService.createMovie(request);
        return new ResponseEntity<>(movieCreateResponse, HttpStatus.CREATED);
    }

    @PatchMapping
    @ApiOperation(value = "Update a movie")
    public ResponseEntity<PatchMovieResponseDTO> patchMovie(@RequestBody PatchMovieRequest request) {
        PatchMovieResponseDTO patchMovieResponseDTO = movieMgmtService.updateMovie(request);
        return new ResponseEntity<>(patchMovieResponseDTO, patchMovieResponseDTO != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping
    @ApiOperation(value = "Get all movies")
    public ResponseEntity<ListMoviesResponseDTO> getAllMovies() {
        ListMoviesResponseDTO allMovies = movieMgmtService.getAllMovies();
        return new ResponseEntity<>(allMovies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get movie by id")
    public ResponseEntity<GetMovieResponseDTO> getMovieById(@PathVariable Long id) {
        GetMovieResponseDTO getMovieResponseDTO = movieMgmtService.getMovieById(id);
        return new ResponseEntity<>(getMovieResponseDTO, getMovieResponseDTO != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete movie")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieMgmtService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
