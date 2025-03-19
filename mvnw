#!/bin/sh
set -e

MAVEN_OPTS="-Xmx1024m -XX:MaxPermSize=256m"

# Execute Maven with the provided options
exec ./mvnw "$@"