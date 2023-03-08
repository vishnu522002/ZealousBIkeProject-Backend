package BikeService.ZealousBikeService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDetailsService{

	@Autowired
	ServiceDetailsRepository srepo;
	
	public ServiceDetails newservice(ServiceDetails service)
	{
		return srepo.save(service);
	}

	public List<ServiceDetails> Exactcusidwithservicedetails(BikeDetails bike)
	{
		return srepo.findAllByBikedetails(bike);
	}
	public Optional<ServiceDetails> Exactoneservice(int jobcard)
	{
		return srepo.findById(jobcard);
	}

	public List<ServiceDetails> Exacttypeofservice(String typeofservice)
	{
		return srepo.findAllByTypeofservice(typeofservice);
	}
	
	public List<ServiceDetails> betweendates(String d1,String d2)
	{
		return srepo.findAllBybikeDateofservice(d1, d2);
	}
	
	
}
