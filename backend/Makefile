docker run:
	gradlew installDist
	docker build -t my-application .
	docker run -p 8080:8080 my-application
