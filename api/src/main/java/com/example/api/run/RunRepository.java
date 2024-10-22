package com.example.api.run;

import java.util.Optional;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.annotation.PostConstruct;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.temporal.ChronoUnit;

@Repository
public class RunRepository {

    private static final Logger logger = LoggerFactory.getLogger(RunRepository.class);
    private final JdbcClient jdbcClient;

    public RunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    List<Run> findAll() {
        return jdbcClient.sql("select * from run")
        .query(Run.class)
        .list();

    }

    // following code are for storing data in memory and in records.
    // private List<Run> runs = new ArrayList<>();

    // List<Run> findAll() {
    //     return runs;
    // }

    // Optional<Run> findById(Integer id) {
    //     return runs.stream()
    //         .filter(run -> run.id().equals(id))
    //         .findFirst();
    // }

    // void create(Run run) {
    //     runs.add(run);
    // }

    // void update(Run run, Integer id) {
    //     Optional<Run> existingRun = findById(id);
    //     if(existingRun.isPresent()){
    //         runs.set(runs.indexOf(existingRun.get()), run);
    //     }
    // }

    // void delete(Integer id) {
    //     runs.removeIf(run -> run.id().equals(id));
    // }

    // @PostConstruct
    // private void init() {
    //     runs.add(new Run(
    //         1, 
    //         "Morning Run", 
    //         LocalDateTime.now(), 
    //         LocalDateTime.now().plus(30,ChronoUnit.MINUTES), 
    //         5, 
    //         Location.INDOOR));

    //     runs.add(new Run(
    //         2, 
    //         "Evening Run", 
    //         LocalDateTime.now(), 
    //         LocalDateTime.now().plus(1,ChronoUnit.HOURS), 
    //         10, 
    //         Location.OUTDOOR));
    // }

}
