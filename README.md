# WiChat-server: Chat server

WiChat is a pet project aim to practice building a Apache Kafka Topic Message Java application

## Tentative technologies and frameworks

- Java 17
- Spring boot 2.7
- Kafka
- K8s
- Github Actions

## Getting Started

### Prerequisites

- Redpanda or any Kafka deployment (v1.0.0+) compatible
- Docker runtime (single binary builds will be provided in the future)

### Installing
#### Redpanda Console Quick Start
We offer pre built docker images for RP Console, a Helm chart and a Terraform module to make the installation as comfortable as possible for you. Please take a look at our dedicated [Installation documentation](https://docs.redpanda.com/docs/console/installation/).

### Quick Start
1. Get the latest source code
1. Have your Docker desktop with Kubernetes enabled
1. Run `docker-compose up -d`