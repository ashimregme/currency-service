package pl.assecods.dbservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.assecods.dbservice.domain.ExchangeRate;

@Repository
public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, String> {
}
