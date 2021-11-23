package ru.lavrinenko.testtasksatinterviews.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lavrinenko.testtasksatinterviews.model.DeleteDuplicates;

@Repository
public interface DeleteDuplicatesRepository extends JpaRepository<DeleteDuplicates, Long> {
}
