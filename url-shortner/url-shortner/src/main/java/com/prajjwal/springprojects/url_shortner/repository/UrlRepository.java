package com.prajjwal.springprojects.url_shortner.repository;

import com.prajjwal.springprojects.url_shortner.modals.UrlModal;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UrlRepository extends JpaRepository<UrlModal,Integer> {

    Optional<UrlModal> findByShortUrl(String shortUrl);
}
