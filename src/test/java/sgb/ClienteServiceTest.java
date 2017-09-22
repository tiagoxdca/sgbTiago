package sgb;

import models.Client;
import org.junit.Assert;
import org.junit.Test;
import services.ClienteService;

public class ClienteServiceTest {
	
	private ClienteService clienteService;
	
	@Test
	public void registerClient(){
		clienteService = new ClienteService();
		Client c = new Client();
		c.setName("cenas");
		
		Client c2 = new Client();
		c.setName("cenas");
		
		Client savedClient = clienteService.register(c);
		Client savedClient2 = clienteService.register(c2);
		Assert.assertEquals("cenas", savedClient.getName());
		Assert.assertNotNull(savedClient.getIndentifier());
		Assert.assertNotEquals(savedClient.getIndentifier(), savedClient2.getIndentifier());
		
	}
	
	@Test
	public void registerClient_returnWidthValidAccount(){
		clienteService = new ClienteService();
		Client c = new Client();
		c.setName("cenas");
		Client savedClient = clienteService.register(c);
		
		Assert.assertEquals("cenas", savedClient.getName());
		Assert.assertNotNull(savedClient.getIndentifier());
		Assert.assertFalse(savedClient.getAccounts().isEmpty());
		Assert.assertTrue(savedClient.getAccounts().size() >= 1);
		Assert.assertNotNull(savedClient.getAccounts().get(0).getIdentifier());
		
		
		
	}

}
