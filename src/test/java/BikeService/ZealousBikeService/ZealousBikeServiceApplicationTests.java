package BikeService.ZealousBikeService;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class) // access repos method
class ZealousBikeServiceApplicationTests {
	
	@MockBean	// give duplicate values for testing
	BikeDetailsRepository repos;

	@Autowired
	BikeDetailsService service;
	
	@Test	// for testing
	public void testcase1()
	{
		Date date = new Date(2023,10,10);
		
		BikeDetails bike1 = new BikeDetails(1, "TN1234", 9786575465L, "Vishwa", "shajayvi@gmail.com", date, null);
		when(repos.findAll()).thenReturn(Stream.of(bike1).collect(Collectors.toList()));
		assertNotNull(service.MakeFetchAll());
		
	}
	
	@Test
	public void testread()
	{
		Date date = new Date(2022,12,12);
		Optional<BikeDetails> bike1 = Optional.of(new BikeDetails(1,"TN345667",32456765432L,"vishnu","shajvi@gmail.com",date,null));
		Optional<BikeDetails> bike2 = Optional.of(new BikeDetails(2,"TN345667",32456765432L,"vishnu","shajvi@gmail.com",date,null));

		when(repos.findById(1)).thenReturn(bike1);
		when(repos.findById(2)).thenReturn(bike2);
		
		assertSame(bike1, service.makefetchone(1));
		assertEquals(bike2,service.makefetchone(2));
	}
}
