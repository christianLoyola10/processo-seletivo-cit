Feature: Search for Flights

  Scenario: Search for flights by Round trip
	Given a user access the Azul website
	And Departure field was filled with 'São Paulo - Todos os Aeroportos (SAO)'
	And Departure Date field was filled with '07/15/2018'
	And Destination field was filled with 'Florianópolis (FLN)'
	And Return Date field was filled with '10/15/2018'
	And Adult field was filled with '2'
	And Child field was filled with '1'
	And Infant field was filled with '1'
	When the Search and Buy button be pushed
	Then the site shall redirect and show available flights with Departure as 'São Paulo - Todos os Aeroportos (SAO)'
	And departure date as '07/15/2018'
	And Arrival as 'Florianópolis (FLN)'
	And Arrival Date as '10/15/2018'
	
  