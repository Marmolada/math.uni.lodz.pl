#Sample Boundary-Equivalence tables 

## Phone number variable

Variable 		| Valid case EC 	| Invalid case EC 	 | Boundary and special cases 	 | Notes
--------------- | ----------------- | -----------------  | ----------------------------- | -------
Phone number 	| #characters 9     |                    | 000000000                     |
				| [0-9]				|					 |                               | 
				|					|					 | 999999999                     |
				|					|					 |                               |
				|     				| #char <9           | 54325324                      |
				|					|					 |                               |
				|					| #char >9           | 8567585574                    |
				|                   |                    |                               |
				|                   | ^[0-9]             | /                             | before [0]
            	|                   |                    | :                             | after [9]
				|                   | empty              |                               | 
				

## Email variable

Variable 		| Valid case EC 	     | Invalid case EC 	  | Boundary and special cases 	 | Notes
--------------- | ---------------------- | ------------------ | ---------------------------- | -------
Email 			| #characters			 |					  | a@d							 | minimal
				| local - 1-64 			 |  				  | a..e@w..vv                   | maximal (..) - rest chars
				| @ symbol               |                    | 
			    | domain - 1-255 		 |  				  | 
				| [a-z,A-Z,0-9,          |                    |                                
				| #-_~!$'()*+,;=:]       |                    |
				|                        |                    |
				|                        | #chars >64+255+1   | a..e@w..vvv
				|                        |                    |
				|                        | local part empty   | @wre
				|                        |                    |			
				|                        | domain part empty  | wre@
				|                        |                    |
				|                        | domain&local empty | @
				|                        |                    |
				|                        | ^[a-z,A-Z,0-9,     | wre<<@>>pl
				|                        | #-_~!$'()*+,;=:]   |
				|                        | 				      |
				|                        | lacking @ symbol   | wrewer.rewee
				|                        | 				      |
				|                        | empty			  |

## Username, Phone and Email variable test cases created using PICT

ALL SINGLES:

phone number	email
000000000	a@d
999999999	a@d
000000000	~wre<<@>>pl
~:	a@d
999999999	~@
999999999	~wre@
000000000	~a..e@w..vvv
999999999	~wrewer.rewee
~54325324	a@d
000000000	~a..e@w..vv
~/	a@d
999999999	~@wre
~8567585574	a@d

#

ALL PAIRS:

phone number	email
000000000	a@d
999999999	a@d
000000000	~wrewer.rewee
~:	a@d
999999999	~wre<<@>>pl
999999999	~a..e@w..vv
999999999	~a..e@w..vvv
000000000	~@wre
999999999	~@wre
000000000	~a..e@w..vvv
000000000	~wre<<@>>pl
999999999	~wrewer.rewee
~8567585574	a@d
~54325324	a@d
000000000	~@
999999999	~@
~/	a@d
000000000	~a..e@w..vv
999999999	~wre@
000000000	~wre@