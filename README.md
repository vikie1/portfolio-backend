# About Portfolio-backend
This is the back-end to my portfolio, although I plan on using it as the backend to some of my other projects. <br>
It is a Spring Boot application that is based on Java 17 <br>
The live version is at <a href="https://web-production-2b5d.up.railway.app/">heroku</a>.<br>
The project has a swagger3 OpenAPI documentation, link is at the entry URL.<br>
The live version of the project currently serves <a href="https://victormwangi.netlify.app/">my portfolio</a> although there are plans to spring to life front ends of the projects under the 'io.github.vikie1.portfolio.projects' package.

# Setting it up
## Requirements
<ul>
<li>Java 17 -> check system.properties or build.gradle for changes</li>
<li>PostGreSQl database</li>
<li>An email and a mail server</li>
</ul>

Recommended:
<ul>
<li>IntellijIdea IDE</li>
</ul>

## Configuration
Follow the configuration format in the application.yml file under the src/main/resources/ directory to:<br>
=> provide the link, username and password of your postgresql database instance, my production details are hidden and will be injected during runtime after deployment.<br>
=> provide the configuration of your mail server. <br>
<strong>The application.yml file could contain sensitive files, so you have to cross-check before making it public</strong>

## Installation, packaging and execution
We shall use maven to carry out the build task.

->for local tests, use: <br>
`$ mvn spring-boot:run` -> (you can replace gradle with the ./mvnw for *nix/*nix-like systems or .\mvnw.bat for ms-windows)<br>
->Once you are done, then it's time to deploy<br>
`$ mvn clean package` -> this creates a portfolio-{version-number}.jar file under the build/libs directory.<br>
`$ java -jar target/portfolio-{version-number}.jar` -> to run the package. <br>
