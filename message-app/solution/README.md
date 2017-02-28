# Todo
### Spring application name
Decide upon a spring application name, check the properties files in the resources folder and change the name.
This will be the name you will give others that will communicate with your application.

### Consul Agent Client name
Set the "start_join" and "node_name" parameters inside the consul/client folder. 
"start_join" should be set to Markus IP that he will provide you with.
"node_name" has little impact but should be something unique.

### Implement a message service
Extend the AbstractMessageService and implement the required methods.
There are a 3 helper methods inside the AbstractMessageService
- Getting a RestTemplate
- Getting url based on to
- Getting a form data entity
If you get completely stuck ask for help, or you can look in the cheat implementation. 

### Create a bean of your message service
Once you are done with the message service implementation and want to test it out, create a bean inside the ServiceConfig class for it.
