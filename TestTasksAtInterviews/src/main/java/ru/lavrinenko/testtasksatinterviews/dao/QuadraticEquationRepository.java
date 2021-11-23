package ru.lavrinenko.testtasksatinterviews.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lavrinenko.testtasksatinterviews.model.QuadraticEquation;

@Repository
public interface QuadraticEquationRepository extends JpaRepository<QuadraticEquation, Long> {
}
