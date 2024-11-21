# Base image
FROM ubuntu:22.04

# Install dependencies
RUN apt-get update && DEBIAN_FRONTEND=noninteractive apt-get install -y \
    git \
    make \
    openjdk-8-jdk \
    imagemagick \
    sox \
    inkscape \
    expect \
    grep \
    sed \
    rename \
    python3-lxml && \
    apt-get clean

# Set Java environment
ENV JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
ENV PATH="$JAVA_HOME/bin:$PATH"

# Set working directory
WORKDIR /app

# Default command
CMD ["make", "test"]
