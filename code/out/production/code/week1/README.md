APPLICATION: Run a Monte Carlo simulation
- Initialize a NXN whole grid to be blocked
- Declare random sites open until top connected to bottom
- Vacancy percentage estimates p*

Run the experiment millions of times so long as the calculation can be done efficiently, then we can compute p*

Q: How to check whether an NXN system percolates?
- Create an object for each site and name them 0 to n**2 - 1
- Sites are in same component if connected by open sites
- Percolates if and only if any site on bottom row is connected to site on top row
	- This is BRUTE FORCE and is quadratic -- too expensive!
- Instead introduce 2 virtual sites (and connections to top and bottom):
	- Percolates if and only if virtual top site is connected to virtual bottom site; PERMITS ONLY 1 CALL TO CONNECTED

Q: How to model opening a new site?
A: Connect newly open site to all of its adjacent open sites - UNION CALLS

Once code done, run the simulation many times!