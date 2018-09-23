
all: build

build:
	@echo "Running the build phase"
	@./scripts/build.sh

run:
	@echo "Running container"
	@./scripts/run.sh
