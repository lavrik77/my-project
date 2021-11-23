package ru.lavrinenko.testtasksatinterviews.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lavrinenko.testtasksatinterviews.model.CompressString;

@Repository
public interface CompressStringRepository extends JpaRepository<CompressString, Long> {
}
