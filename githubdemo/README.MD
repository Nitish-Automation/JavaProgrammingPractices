For pull requests below are the use cases identified to be covered in test framework
 - As a user I want to get all open pull req
 - As a user I want to get information of a given pull req.
 - As a user I want to check if a given pull req id is merged
 - As a user I want to know information on the the commits for a given pull req 
 - As a user I want to know information on files changed in a specific pull req
 
Cases not covered (Non idempotent in nature)
 - Merging a pull req 
 - Update a pull req
 
Tests are configurable:
 
 1. Add Proerty file '/githubdemo/src/main/resources/com/github/getpull' with all repos from an owner you want to run tests on
 2. Update '/githubdemo/src/main/java/com/github/operations/RepoConstants.java' for added property file and repos to keep all values at one place
 3. Make sure to have added repo's condition is updated in /githubdemo/src/main/java/com/github/utils/PropertyFileLoader.java
4. You are GOOD TO GO...!!!


***TO RUN TESTS FROM COMMAND LINE***

1. Switch to root directory from command line
2. Run tests using below commands
 2a) mvn clean install
 2b) mvn test -Dtest=GetPullOperations
