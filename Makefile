.PHONY: stop
stop:
	./gradlew --stop

.PHONY: daemon
daemon:
	./gradlew --daemon

.PHONY: clean
clean:
	./gradlew clean

.PHONY: build
build:
	./gradlew build

.PHONY: test
test:
	./gradlew test

.PHONY: deploy
deploy:
	./gradlew publishMavenJavaPublicationToMavenRepository