# Stop & remove container if it exists
docker stop db-test-container 2>/dev/null || true
docker rm db-test-container 2>/dev/null || true

# Remove old image if exists
docker rmi db-test-app 2>/dev/null || true

# Build new image
docker build -t db-test-app .

# Run fresh container
docker run -d -p 8080:8080 --name db-test-container db-test-app
