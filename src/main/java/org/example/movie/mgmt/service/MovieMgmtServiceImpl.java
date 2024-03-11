package org.example.movie.mgmt.service;

import org.example.movie.mgmt.dto.request.CreateMovieRequestDTO;
import org.example.movie.mgmt.dto.request.PatchMovieRequest;
import org.example.movie.mgmt.dto.response.CreateMovieResponseDTO;
import org.example.movie.mgmt.dto.response.GetMovieResponseDTO;
import org.example.movie.mgmt.dto.response.ListMoviesResponseDTO;
import org.example.movie.mgmt.dto.response.PatchMovieResponseDTO;
import org.example.movie.mgmt.model.Movie;
import org.example.movie.mgmt.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieMgmtServiceImpl implements MovieMgmtService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public CreateMovieResponseDTO createMovie(CreateMovieRequestDTO request) {
        Movie movie = Movie.builder()
                .title(request.getTitle())
                .director(request.getDirector())
                .genre(request.getGenre())
                .releaseYear(request.getReleaseYear())
                .ratings(request.getRatings())
                .build();
        Movie savedMovie = movieRepository.save(movie);
        return new CreateMovieResponseDTO(savedMovie.getId(), "Movie saved successfully");
    }

    @Override
    public PatchMovieResponseDTO updateMovie(PatchMovieRequest request) {
        Optional<Movie> movieOptional = movieRepository.findById(request.getId());
        if (movieOptional.isPresent()) {
            Movie currentMovieData = movieOptional.get();
            Movie updatedMovieData = currentMovieData.toBuilder()
                    .title(request.getTitle())
                    .director(request.getDirector())
                    .genre(request.getGenre())
                    .releaseYear(request.getReleaseYear())
                    .ratings(request.getRatings())
                    .build();
            Movie updatedMovie = movieRepository.save(updatedMovieData);
            return new PatchMovieResponseDTO(updatedMovie.getId(), "Movie updated successfully");
        } else {
            return null;
        }
    }

    @Override
    public ListMoviesResponseDTO getAllMovies() {
        List<Movie> allMovies = movieRepository.findAll();
        return new ListMoviesResponseDTO(allMovies.stream()
                .map(movie -> new ListMoviesResponseDTO.MovieResponse(movie.getId(),
                        movie.getTitle(),
                        movie.getGenre(),
                        movie.getReleaseYear(),
                        movie.getDirector(),
                        movie.getRatings()))
                .collect(Collectors.toList()));
    }

    @Override
    public GetMovieResponseDTO getMovieById(Long id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie != null) {
            return new GetMovieResponseDTO(movie.getId(), movie.getTitle(), movie.getGenre(),
                    movie.getReleaseYear(), movie.getDirector(), movie.getRatings()) ;
        } else {
            return null;
        }
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
