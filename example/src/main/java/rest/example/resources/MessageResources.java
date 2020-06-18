package rest.example.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import rest.example.model.Message;
import rest.example.service.MessageFilterBean;
import rest.example.service.MessageService;

@Path("messages")
public class MessageResources {

	MessageService messageservice = new MessageService();
	

	
	@GET
	@Path("getallmessages")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessages(@BeanParam MessageFilterBean messageFilter){
		if (messageFilter.getYear() > 0)
			return messageservice.getAllMessagesForYear(messageFilter.getYear());
		if (messageFilter.getStart() >= 0 && messageFilter.getSize() > 0)
			return messageservice.getAllMessagesForPagination(messageFilter.getStart(), messageFilter.getSize());
		return messageservice.getAllMessages();
	}
	
	
	@GET
	@Path("{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long messageId){
		return messageservice.getMessage(messageId);
	}
	
	@POST
	@Path("addmessage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response addMessage(Message message){
		Message newMessage = messageservice.addMessage(message);
		return javax.ws.rs.core.Response.status(Status.CREATED).entity(newMessage).build();
	}
	
	@PUT
	@Path("updatemessage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage( Message message){
		return messageservice.updateMessage(message);
	}
	
}
