# exercise1
Company has a requirement to create a microservice to serve all the drivers and assistants as roles of a given organization and that implementation should fulfill the following criteria.
1. Roles should be saved in a MongoDB collection called “role”.
Note: If you are not familiar with MongoDB, then you can choose a relational database approach as well. In that case, those roles should be saved in a ROLE table.
2. In the system you are implementing, there are two roles; DRIVER, ASSISTANT
3. The given role should have the following attributes Organization,
First name,
Last name,
NIC no,
Role Type → eg: Driver, Assistant
4. The following rest APIs should be exposed to the public.
  ○ Basic CRUD operations for a given role.
  ○ Retrieve a role from the NIC no.
  ○ A list of roles should be able to retrieve by the organization and the role type.
Note: This API should only expose a list of first name, last name, and NIC no of a given role.
5. The microservice should be implemented in Sprint boot 2.0 or higher version in Java 8.
Plus points

  ● Expose the swagger documentation of the APIs.
  ● Automated tests should be added to make sure the implementation is correct.
  ● Need to add the created date and last modified date of a given document or table

entry.
