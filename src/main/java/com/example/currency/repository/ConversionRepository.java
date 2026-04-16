package com.example.currency.repository;

import com.example.currency.entity.ConversionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversionRepository extends JpaRepository<ConversionHistory, Long> {
}