package BikeService.ZealousBikeService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bikeproject")
@CrossOrigin(origins = "http://localhost:3000/")
public class Controller {

	@Autowired
	BikeDetailsService service;
	@Autowired
	ServiceDetailsService sservice;

	@PostMapping("/createbikedetails")
	public String addDetails(@RequestBody BikeDetails bike)
	{
		return service.create(bike).getCusName()+" has added succesfully";
	}

	@PutMapping("/updatebikedetails")
	public String updateDetails(@RequestBody BikeDetails bike)
	{
		BikeDetails temp = service.create(bike);
		return temp + " has updated successfully.";
	}

	@GetMapping("/exactbikenumber/{bikeno}")
	public Optional<BikeDetails> findbikeno(@PathVariable("bikeno")String bikeno)
	{
		return service.exactbikeno(bikeno);
	}
	
	@GetMapping("/listallbikedetails")
	public List<BikeDetails> listallbikedetails()
	{
		return service.MakeFetchAll();
	}
	@GetMapping("/")
	public String smaple()
	{
		return "welcome everyone";
	}

	@GetMapping("/listonebikedetail/{id}")
	public Optional<BikeDetails> readonebikedetail(@PathVariable("id")int id)
	{
		return service.makefetchone(id);
	}

	@DeleteMapping("/deletebikedetails/{id}")
	public String deleteDetails(@PathVariable int id)
	{
		return service.deleteById(id);
	}
	
	@PostMapping("/createnewservice")
	public String newservicedetails(@RequestBody ServiceDetails serv)
	{
		BikeDetails temp=service.gettingexactone(serv.getBikedetails().getCusId());
		
		if(serv.getTypeofservice()=="free")
		{
			int total=serv.getNewproductcost()+(serv.getNewproductcost()*18/100);
			serv.setFinalamout(total);
		}
		else
		{
			int total=serv.getNewproductcost()+serv.getLabourcharge();
			total+=total*18/100;
			serv.setFinalamout(total);
		}
		temp.getServiceDetails().add(serv);
		serv.setBikedetails(temp);
		sservice.newservice(serv);
		return serv.getJobcardno()+" service details is added";
	}
	
	@PutMapping("/updateservicedetails")
	public String updateservice(@RequestBody ServiceDetails serv)
	{
		
		if(serv.getTypeofservice()=="free")
		{
			int total=serv.getNewproductcost()+(serv.getNewproductcost()*18/100);
			serv.setFinalamout(total);
		}
		else
		{
			int total=serv.getNewproductcost()+serv.getLabourcharge();//2500+900=3400
			total+=total*18/100;//3400+=(3400*18/100)
			serv.setFinalamout(total);
		}
		serv.getBikedetails().getServiceDetails().add(serv);
		ServiceDetails temp=sservice.newservice(serv); 
		return temp.getJobcardno()+" has been updated.";
	}
	
	@GetMapping("/exactcusidwithservicedetails/{cusid}")
	public List<ServiceDetails> gettingparticularall(@PathVariable("cusid") int cusid)
	{
		BikeDetails temp = service.gettingexactone(cusid);
		return sservice.Exactcusidwithservicedetails(temp);
	}
	
	@GetMapping("/exactoneservice/{jobcardno}")
	public Optional<ServiceDetails> findoneservice(@PathVariable("jobcardno")int jobcardno)
	{
		return sservice.Exactoneservice(jobcardno);
	}
	
	@GetMapping("gettingonefreeservice/{typeofservice}")
	public List<ServiceDetails> freeService(@PathVariable("typeofservice")String typeofservice)
	{
		return sservice.Exacttypeofservice(typeofservice);
	}
	
	@GetMapping("/exacttypeofservice/{typeofservice}")
	public List<ServiceDetails> findtypeofservice(@PathVariable("typeofservice")String typeofservice)
	{
		return sservice.Exacttypeofservice(typeofservice);

	}

	@GetMapping("/betweendates/{date1}/{date2}")
	public List<ServiceDetails> Implementdates(@PathVariable("date1")String date1,@PathVariable("date2")String date2)
	{
		return sservice.betweendates(date1, date2);
	}
	
	
	
}
