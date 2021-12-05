# About Portfolio-backend
This is the back-end to my portfolio although I plan on using it as the backend to some of my other projects. <br>
It is a Spring Boot application that is based on Java 17 <br>
The live version is at <a href="https://pbvictor.herokuapp.com/">heroku</a>.<br>
The first run might take sometime compared to subsequent runs because <a href="https://www.heroku.com/">Heroku service</a> takes the webapp to 'sleep' if it's unaccessed in 30 minutes.<br>
The project has a documentation(work in progress) at the entry URL.<br>
The live version of the project currently serves <a href="https://victormwangi.netlify.app/">my portfolio</a> although there are plans to spring to life front ends of the projects under the 'io.github.vikie1.portfolio.projects' package.

# Setting it up
## Requirements
<ul>
<li>Java 17 -> check system.properties or pom.xml for changes</li>
<li>Gradle >= 7.3 - for Java 17 support</li>
<li>PostGresQl database</li>
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
<strong>The application.properties file could contain sensitive files so you have to cross-check before making it public</strong>

## Installation, packaging and execution
We shall use maven to cary out the build task.

->for local tests, use: <br>
`$ gradle bootRun` -> (you can relace gradle with the .gradlew for *nix/*nix-like systems or .gradlew.cmd for ms-windows)<br>
->if that works then it's time to deploy<br>
`$ gradle bootJar` -> this creates a portfolio-{version-number}.jar file under the build/libs directory.<br>
`$ java -jar build/libs/portfolio-{version-number}.jar` -> to run locally<br>
`$ heroku deploy:jar build/libs/portfolio-{version-number}.jar` -> to deploy to your heroku instance.<br>
`$ heroku java:visualvm` -> can also be used to monitor the application locally using VisualVM
