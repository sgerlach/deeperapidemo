package hawk.repos;

import hawk.entity.Item;
import org.springframework.data.repository.Repository;

import java.math.BigDecimal;
import java.util.List;

public interface ItemsRepo extends Repository<Item, Long> {
    List<Item> findByNameContainingOrDescriptionContaining(String name, String description);
}
