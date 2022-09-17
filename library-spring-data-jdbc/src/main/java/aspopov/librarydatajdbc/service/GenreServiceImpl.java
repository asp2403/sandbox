package aspopov.librarydatajdbc.service;

import aspopov.librarydatajdbc.repository.GenreRepository;
import aspopov.librarydatajdbc.service.converter.GenreConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;
    private final GenreConverter genreConverter;

    public GenreServiceImpl(GenreRepository genreRepository, GenreConverter genreConverter) {
        this.genreRepository = genreRepository;
        this.genreConverter = genreConverter;
    }

    @Override
    @Transactional(readOnly = true)
    public String findAll() {
        var genres = genreRepository.findAll();
        return genres.stream().map(genre -> genreConverter.convertToString(genre)).collect(Collectors.joining(System.lineSeparator()));
    }
}
