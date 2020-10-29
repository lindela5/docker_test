package com.innowise.darya.service;

import com.innowise.darya.dto.AuthorDTO;
import com.innowise.darya.dto.SupplyDTO;
import com.innowise.darya.entity.Author;
import com.innowise.darya.entity.Supply;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.AuthorRepository;
import com.innowise.darya.transformer.AuthorDTOTransformer;
import com.innowise.darya.transformer.SupplyDTOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public AuthorDTO getAuthorById(long id) {
        Optional<Author> authorOptional = Optional.ofNullable(authorRepository.findByAuthorId(id));
        if (!authorOptional.isPresent()) {
            return null;
        }
        Author author = authorOptional.get();
        AuthorDTO authorDTO = AuthorDTOTransformer.AUTHOR_DTO_TRANSFORMER.authorToAuthorDTO(author);
        return authorDTO;
    }
}
