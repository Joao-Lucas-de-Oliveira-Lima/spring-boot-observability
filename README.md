# API Monitoring with Grafana, Loki, Promtail, and Prometheus

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![Prometheus](https://img.shields.io/badge/Prometheus-E6522C?style=for-the-badge&logo=Prometheus&logoColor=white) ![Grafana](https://img.shields.io/badge/grafana-%23F46800.svg?style=for-the-badge&logo=grafana&logoColor=white) ![Docker](https://img.shields.io/badge/Docker-%232496ED.svg?style=for-the-badge&logo=docker&logoColor=white)

## Table of Contents

- [About](#about)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [How It Works](#how-it-works)
- [Usage](#usage)

---

## About

This project demonstrates how to monitor monolithic APIs using **Grafana**, **Loki**, **Promtail**, and **Prometheus**.

### Dashboard Previews

| ![Micrometer Example 1](img/micrometer_01.png) | ![Micrometer Example 2](img/micrometer_02.png) |
|:---------------------------------------------:|:---------------------------------------------:|
| ![Loki Example](img/loki_01.png)              | ![Spring Observability](img/spring_observability_01.png) |

**Dashboards Used**:  
- [JVM Micrometer](https://grafana.com/grafana/dashboards/4701-jvm-micrometer/)  
- [Spring Boot Observability](https://grafana.com/grafana/dashboards/17175-spring-boot-observability/)  

To use these dashboards, import them into Grafana and assign the required data sources (Prometheus/Loki).

---

## Getting Started

### Prerequisites

Ensure the following software is installed:

- **Docker Desktop**  

### Installation

1. Start all services using Docker Compose:
   ```bash
   docker compose up -d
   ```

---

## Usage

After starting the services, access them via these URLs:

- **API**: [http://localhost:8080](http://localhost:8080)  
- **Prometheus**: [http://localhost:9090](http://localhost:9090)  
- **Promtail**: [http://localhost:9080](http://localhost:9080)  
- **Grafana**: [http://localhost:3000](http://localhost:3000)

### API Log Endpoints

Test logging by triggering these endpoints:

- `GET /api/v1/logs/info` - Generates an **info** log  
- `GET /api/v1/logs/error` - Generates an **error** log  
- `GET /api/v1/logs/warning` - Generates a **warning** log  

Logs are sent to Loki and visualized in Grafana.

## How It Works

Spring Boot Actuator generates the required metrics and exposes them via endpoints using HATEOAS links. Micrometer acts as a facade for Prometheus, which collects these metrics. Grafana then visualizes them. Logs are sent to Loki via Promtail for further analysis.

---

