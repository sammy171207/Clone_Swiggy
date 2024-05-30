package spicestory.spicestory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spicestory.spicestory.model.Address;

public interface AddressRespository extends JpaRepository<Address,Long> {


}
