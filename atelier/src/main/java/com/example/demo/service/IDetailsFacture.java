package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.detailsFacture;


public interface IDetailsFacture {
    detailsFacture add(detailsFacture detailsFacture);
    detailsFacture update(detailsFacture detailFacture, Long id);
    void delete(long id);
    List<detailsFacture> findAll();
    detailsFacture findById(Long id);
}

