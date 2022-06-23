package pl.assecods.dbservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.assecods.dbservice.domain.ExchangeRate;
import pl.assecods.dbservice.dto.ExchangeRateResponse;

import java.util.Optional;

@Repository
public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, String> {
    Optional<ExchangeRateResponse> getById(String id);
}
