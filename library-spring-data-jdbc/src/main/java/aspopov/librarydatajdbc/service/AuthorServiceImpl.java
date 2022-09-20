package aspopov.librarydatajdbc.service;

import aspopov.librarydatajdbc.repository.AuthorRepository;
import aspopov.librarydatajdbc.service.converter.AuthorConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorConverter authorConverter;

    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorConverter authorConverter) {
        this.authorRepository = authorRepository;
        this.authorConverter = authorConverter;
    }

    @Override
    @Transactional(readOnly = true)
    public String findAll() {
         var authors = authorRepository.findAll();
         return authors.stream().map(author -> authorConverter.convertToString(author)).collect(Collectors.joining(System.lineSeparator()));
    }
}
