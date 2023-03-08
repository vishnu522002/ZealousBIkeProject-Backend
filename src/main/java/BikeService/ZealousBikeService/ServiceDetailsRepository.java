package BikeService.ZealousBikeService;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDetailsRepository extends JpaRepository<ServiceDetails, Integer>{
	
	public List<ServiceDetails> findAllByBikedetails(BikeDetails bike);
	public List<ServiceDetails> findAllByTypeofservice(String typeofservice);


	@Query(value = "select * from service_details where dateofservice between :startDate and :endDate",nativeQuery = true)
	public List<ServiceDetails> findAllBybikeDateofservice(String startDate,String endDate);
}
